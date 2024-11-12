package com.example.Develop_Me.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.HashMap;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor //역직렬화를 위한 기본 생성자
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoUserInfoResponseDto {

    @JsonProperty("id")
    public Long id;

    @JsonProperty("has_signed_up")
    public Boolean hasSignedUp;


    @JsonProperty("connected_at")
    public Date connectedAt;


    @JsonProperty("properties")
    public HashMap<String, String> properties;


    @JsonProperty("kakao_account")
    public KakaoAccount kakaoAccount;


    @JsonProperty("for_partner")
    public Partner partner;

    @Getter
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class KakaoAccount {


        @JsonProperty("profile_needs_agreement")
        public Boolean isProfileAgree;


        @JsonProperty("profile_nickname_needs_agreement")
        public Boolean isNickNameAgree;


        @JsonProperty("profile_image_needs_agreement")
        public Boolean isProfileImageAgree;


        @JsonProperty("profile")
        public Profile profile;


        @JsonProperty("name_needs_agreement")
        public Boolean isNameAgree;


        @JsonProperty("name")
        public String name;


        @JsonProperty("email_needs_agreement")
        public Boolean isEmailAgree;


        @JsonProperty("is_email_valid")
        public Boolean isEmailValid;


        @JsonProperty("is_email_verified")
        public Boolean isEmailVerified;


        @JsonProperty("email")
        public String email;


        @JsonProperty("age_range_needs_agreement")
        public Boolean isAgeAgree;

        @JsonProperty("age_range")
        public String ageRange;


        @JsonProperty("birthyear_needs_agreement")
        public Boolean isBirthYearAgree;


        @JsonProperty("birthyear")
        public String birthYear;


        @JsonProperty("birthday_needs_agreement")
        public Boolean isBirthDayAgree;


        @JsonProperty("birthday")
        public String birthDay;


        @JsonProperty("birthday_type")
        public String birthDayType;


        @JsonProperty("gender_needs_agreement")
        public Boolean isGenderAgree;

        @JsonProperty("gender")
        public String gender;

        //전화번호 제공 동의 여부
        @JsonProperty("phone_number_needs_agreement")
        public Boolean isPhoneNumberAgree;

        //전화번호
        //국내 번호인 경우 +82 00-0000-0000 형식
        @JsonProperty("phone_number")
        public String phoneNumber;

        //CI 동의 여부
        @JsonProperty("ci_needs_agreement")
        public Boolean isCIAgree;

        //CI, 연계 정보
        @JsonProperty("ci")
        public String ci;

        //CI 발급 시각, UTC
        @JsonProperty("ci_authenticated_at")
        public Date ciCreatedAt;

        @Getter
        @NoArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public class Profile {

            //닉네임
            @JsonProperty("nickname")
            public String nickName;

            //프로필 미리보기 이미지 URL
            @JsonProperty("thumbnail_image_url")
            public String thumbnailImageUrl;

            //프로필 사진 URL
            @JsonProperty("profile_image_url")
            public String profileImageUrl;

            //프로필 사진 URL 기본 프로필인지 여부
            //true : 기본 프로필, false : 사용자 등록
            @JsonProperty("is_default_image")
            public String isDefaultImage;


            @JsonProperty("is_default_nickname")
            public Boolean isDefaultNickName;

        }
    }

    @Getter
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Partner {
        //고유 ID
        @JsonProperty("uuid")
        public String uuid;
    }

}