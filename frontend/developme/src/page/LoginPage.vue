<template>
    <div class = "page">
        <div class = "cover_image"><img id = "site_logo" src="../assets/images/site-logo3.png" alt="이미지" /></div>
        <div class = "divider"></div>
        <div class = "section">
            <div id = "display_signup"><span class = "span_basis">계정이 없어요! <button id = "signup_button">회원가입!</button></span></div>
            <h1 id = "display_main_message">로그인하기</h1>
            <div class="oauth_section">
                <!-- Kakao OAuth 버튼 -->
                <button id="oauth_kakao_login" @click="loginWithKakao">
                <img src="../assets/images/임시사용이미지.png" alt="Kakao OAuth로 로그인" />
                </button>
                <!-- GitHub OAuth 버튼 -->
                <button id="oauth_github_login" @click="loginWithGitHub">
                <img src="../assets/images/임시사용이미지.png" alt="GitHub OAuth로 로그인" />
                </button>
                <!-- Google OAuth 버튼 -->
                <button id="oauth_google_login" @click="loginWithGoogle">
                <img src="../assets/images/임시사용이미지.png" alt="Google OAuth로 로그인" />
                </button>
            </div>
            <span class = "span_basis">또는 이메일과 비밀번호로 로그인</span>

            <form @submit.prevent="handleLogin">
                <div id="input_box">
                <div class="input_group">
                    <label class="noti_input" for="usermail">이메일</label>
                    <input class="input_bar" type="text" id="usermail" v-model="email" placeholder="Type here" required />
                </div>
                <div class="input_group">
                    <label class="noti_input" for="password">비밀번호</label>
                    <input class="input_bar" type="password" id="password" v-model="password" placeholder="Type here" required />
                </div>
                </div>

                <button id="login_button" type="submit">로그인</button>
            </form>
            
        </div>


    </div>

</template>




<script>
export default {
data() {
    return {
    email: '',
    password: ''
    };
},
methods: {
    loginWithKakao() {
        const kakaoAuthUrl = 'https://kauth.kakao.com/oauth/authorize?client_id=YOUR_CLIENT_ID&redirect_uri=YOUR_REDIRECT_URI&response_type=code';
        window.location.href = kakaoAuthUrl;
    },
    loginWithGitHub() {
        const githubAuthUrl = 'https://github.com/login/oauth/authorize?client_id=YOUR_CLIENT_ID&redirect_uri=YOUR_REDIRECT_URI&scope=SCOPE';
        window.location.href = githubAuthUrl;
    },
    loginWithGoogle() {
        const googleAuthUrl = 'https://accounts.google.com/o/oauth2/auth?client_id=YOUR_CLIENT_ID&redirect_uri=YOUR_REDIRECT_URI&response_type=code&scope=SCOPE';
        window.location.href = googleAuthUrl;
    },
    handleLogin() {
    // API 요청 보내기
    fetch('/api/users/login', {
        method: 'POST',
        headers: {
        'Content-Type': 'application/json'
        },
        body: JSON.stringify({ email: this.email, password: this.password })
    })
    .then(response => {
        if (response.ok) {
        return response.json();
        } else {
        throw new Error('로그인에 실패했습니다.');
        }
    })
    .then(data => {
        console.log('로그인 성공:', data);
    })
    .catch(error => {
        console.error('오류:', error);
        alert('로그인 중 오류가 발생했습니다.');
    });
    }
}
};
</script>



<style scoped src="./LoginPage.css"></style>
