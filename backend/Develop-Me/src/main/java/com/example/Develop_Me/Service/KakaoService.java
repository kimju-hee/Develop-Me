package com.example.Develop_Me.Service;

import com.example.Develop_Me.dto.KakaoTokenResponseDto;
import com.example.Develop_Me.dto.KakaoUserInfoResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class KakaoService {

    private final String clientId;
    private final String KAUTH_TOKEN_URL_HOST;
    private final String KAUTH_USER_URL_HOST;
    private final WebClient webClient;

    /**
     * KakaoService 생성자: 필요한 설정 값을 주입받고 WebClient 인스턴스를 초기화합니다.
     *
     * @param webClientBuilder WebClient.Builder 인스턴스
     * @param clientId         카카오 API의 클라이언트 ID
     * @param tokenUrl         카카오 토큰 URL
     * @param userUrl          카카오 사용자 정보 URL
     */

    @Autowired
    public KakaoService(WebClient.Builder webClientBuilder,
                        @Value("${kakao.client_id}") String clientId,
                        @Value("${kakao.token_url}") String tokenUrl,
                        @Value("${kakao.user_url}") String userUrl) {
        this.clientId = clientId;
        this.KAUTH_TOKEN_URL_HOST = tokenUrl;
        this.KAUTH_USER_URL_HOST = userUrl;
        this.webClient = webClientBuilder.build();
    }

    /**
     * 카카오로부터 Access Token을 가져옵니다.
     *
     * @param code 인증 코드
     * @return Access Token
     */
    public String getAccessTokenFromKakao(String code) {
        KakaoTokenResponseDto kakaoTokenResponseDto = webClient.post()
                .uri(KAUTH_TOKEN_URL_HOST + "/oauth/token", uriBuilder ->
                        uriBuilder.queryParam("grant_type", "authorization_code")
                                .queryParam("client_id", clientId)
                                .queryParam("code", code)
                                .build())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse ->
                        Mono.error(new RuntimeException("Invalid Parameter")))
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse ->
                        Mono.error(new RuntimeException("Internal Server Error")))
                .bodyToMono(KakaoTokenResponseDto.class)
                .block();

        log.info(" [Kakao Service] Access Token ------> {}", kakaoTokenResponseDto.getAccessToken());
        log.info(" [Kakao Service] Refresh Token ------> {}", kakaoTokenResponseDto.getRefreshToken());
        log.info(" [Kakao Service] Id Token ------> {}", kakaoTokenResponseDto.getIdToken());
        log.info(" [Kakao Service] Scope ------> {}", kakaoTokenResponseDto.getScope());

        return kakaoTokenResponseDto.getAccessToken();
    }

    /**
     * Access Token을 사용하여 카카오 사용자 정보를 가져옵니다.
     *
     * @param accessToken 카카오에서 발급받은 Access Token
     * @return 사용자 정보
     */
    public KakaoUserInfoResponseDto getUserInfo(String accessToken) {
        KakaoUserInfoResponseDto userInfo = webClient.get()
                .uri(KAUTH_USER_URL_HOST + "/v2/user/me")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse ->
                        Mono.error(new RuntimeException("Invalid Parameter")))
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse ->
                        Mono.error(new RuntimeException("Internal Server Error")))
                .bodyToMono(KakaoUserInfoResponseDto.class)
                .block();

        log.info("[Kakao Service] Auth ID ---> {} ", userInfo.getId());
        log.info("[Kakao Service] NickName ---> {} ", userInfo.getKakaoAccount().getProfile().getNickName());
        log.info("[Kakao Service] ProfileImageUrl ---> {} ", userInfo.getKakaoAccount().getProfile().getProfileImageUrl());

        return userInfo;
    }
}
