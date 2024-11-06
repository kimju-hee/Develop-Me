<template>
<div class="container">
        <!-- 사이트 로고 이미지 -->
        <div class="image-section">
            <img src="../assets/images/site-logo3.png" alt="이미지" />
        </div>


        <!-- 회원가입 & 로그인 섹션 -->
        <div class="divider"></div>
        <div class="form-section">
            <h1>회원 가입</h1>
            
            <!-- 회원가입 폼 -->
            <form class="signup-form">
                <div class="form-row">
                    <div class="input-group">
                    <label for="usermail">이메일</label>
                    <input type="text" id="usermail" name="usermail" placeholder="Type here" required />
                    </div>
                    <div class="input-group">
                    <label for="password">비밀번호</label>
                    <input type="password" id="password" name="password" placeholder="**********" required />
                    </div>
                </div>

                <div class="form-row">
                    <div class="input-group">
                        <label for="nickname">닉네임</label>
                        <input type="text" id="nickname" name="nickname" placeholder="Type here" required />
                    </div>
                    <div class="input-group">
                        <label for="repassword">비밀번호 확인</label>
                        <input type="password" id="repassword" name="repassword" placeholder="**********" required />
                    </div>
                </div>

                <div class="form-row">
                    <div class="input-group">
                        <label for="skills">기술 스택</label>
                        <input type="text" id="skills" name="skills" placeholder="Type here" />
                    </div>
                    <div class="dropdown">
                        <label for="skills">기술 스택</label>
                        <button class="dropdown-button" @click.stop="toggleDropdown">
                            {{ selectedItem }}
                        </button>
                        <div v-if="isDropdownOpen" class="dropdown-content">
                            <button @click="selectItem('프론트엔드 개발자')">프론트엔드 개발자</button>
                            <button @click="selectItem('백엔드 개발자')">백엔드 개발자</button>
                            <button @click="selectItem('보안')">보안</button>
                            <button @click="selectItem('머신러닝 개발자')">머신러닝 개발자</button>
                        </div>
                    </div>
                </div>

                <div class="submit-button">
                    <button class="button-gradient" type="submit">제출</button>
                </div>
            </form>

            <!-- Oauth 섹션 -->
            <div class="oauth">
                <img src="../assets/images/임시사용이미지.png" class = "oauth-image" alt="OAuth로 로그인" @click="loginWithOAuth" style="cursor: pointer;"/>
                <img src="../assets/images/임시사용이미지.png" class = "oauth-image" alt="OAuth로 로그인" @click="loginWithOAuth" style="cursor: pointer;"/>
                <img src="../assets/images/임시사용이미지.png" class = "oauth-image" alt="OAuth로 로그인" @click="loginWithOAuth" style="cursor: pointer;"/>
            </div>
        </div>
        
        
    </div>


</template>






<script>
export default {
    data() {
        return {
        isDropdownOpen: false,
        selectedItem: '선택하세요',
        };
    },
    methods: {
        toggleDropdown() {
        this.isDropdownOpen = !this.isDropdownOpen;
        },
        selectItem(item) {
        this.selectedItem = item;
        this.isDropdownOpen = false;
        },
    },
};
</script>






<style src="./SignupPage.css"></style>
