<template>
    <header>
        <div class="maintitle">
            <h1>Develop Me!</h1>
        </div>
        <nav>
            <ul>
                <li><a href="#">투두 리스트</a></li>
                <li><a href="#">캘린더</a></li>
                <li><a href="comunitypage">커뮤니티</a></li>
                <li><a href="#">로드맵</a></li>
                <li><a href="#">알고리즘</a></li>
                <li><a href="mypage">마이페이지</a></li>
            </ul>
        </nav>
        <div class="myinfo">
            <button @click="logout_function" class="logout_button">로그아웃</button>
            <div class="welcome_me">{{ 사용자명 }}님 환영합니다.</div>
        </div>
    </header>

    <div class="container">
        <div class="contents">
            <h2 id="modify_personal_info">정보수정</h2>
            <div class="info_column">
                <div class="my_info_box1">
                    <a class="personal_info_a">내 정보</a>
                    <div class="user_info">
                        <div class="nickname_field">
                            <div class="form_group">
                                <label for="nickname">닉네임</label>
                                <p id="nickname">{{ userInfo.nickname }}</p>
                            </div>
                            <div class="form_group">
                                <label for="field">분야</label>
                                <p id="field">{{ userInfo.field }}</p>
                            </div>
                        </div>
                        <div class="form_group">
                            <label for="tech">기술 스택</label>
                            <p id="tech">{{ userInfo.tech }}</p>
                        </div>
                    </div>
                </div>

                <div class="my_info_box2">
                    <a class="personal_info_a">내 정보</a>
                    <form class="update_info">
                        <div class="nickname_field">
                            <div class="form_group">
                                <label for="new_nickname">닉네임</label>
                                <input type="text" id="new_nickname" v-model="newNickname">
                            </div>
                            <div class="form_group">
                                <label for="new_field">분야</label>
                                <select id="new_field" v-model="newField">
                                    <option value="backend">백엔드 개발자</option>
                                    <option value="frontend">프론트엔드 개발자</option>
                                </select>
                            </div>
                        </div>

                        <div class="form_group">
                            <label for="new_tech">기술 스택</label>
                            <textarea id="new_tech" v-model="newTech" rows="4"></textarea>
                        </div>
                        <div class="nickname_field">
                            <div class="form-group">
                                <label for="new_password">변경 비밀번호</label>
                                <input type="password" id="new_password" v-model="newPassword">
                            </div>
                            <div class="form-group">
                                <label for="confirm_password">비밀번호 확인</label>
                                <input type="password" id="confirm_password" v-model="confirmPassword">
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <form id="button_form" @submit.prevent="updateUserInfo">
                <button id="submit_button">수정하기</button>
            </form>
        </div>
    </div>
</template>




<script>
export default {
    data() {
        return {
            userInfo: {
                nickname: '',
                field: '',
                tech: '',
            },
            newNickname: '',
            newField: 'backend',
            newTech: '',
            newPassword: '',
            confirmPassword: '',
        };
    },
    created() {
        this.fetchUserInfo();
    },
    methods: {
        // 사용자 정보를 불러오는 함수
        fetchUserInfo() {
            fetch('/api/mypage')
                .then(response => response.json())
                .then(data => {
                    this.userInfo = data;
                    this.newNickname = data.nickname;
                    this.newField = data.field;
                    this.newTech = data.tech;
                })
                .catch(error => {
                    console.error('정보 불러오기 오류:', error);
                    alert('사용자 정보를 불러오는 중 오류 발생');
                });
        },
        // 정보 수정 함수
        updateUserInfo() {
            if (this.newPassword !== this.confirmPassword) {
                alert('비밀번호가 일치하지 않습니다.');
                return;
            }

            const updatedInfo = {
                nickname: this.newNickname,
                field: this.newField,
                tech: this.newTech,
                password: this.newPassword || undefined, // 비밀번호가 있을 때만 보내기
            };

            fetch('/api/mypage/update', {
                method: 'PATCH',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(updatedInfo),
            })
                .then(response => {
                    if (response.ok) {
                        alert('정보가 성공적으로 수정 완료');
                        this.fetchUserInfo(); // 업데이트된 정보 다시 불러오기
                    } else {
                        alert('정보 수정에 실패');
                    }
                })
                .catch(error => {
                    console.error('정보 수정 오류:', error);
                    alert('정보 수정 중 오류가 발생했습니다.');
                });
        },
        logout_function() {
            fetch('/api/users/logout', { method: 'POST' })
                .then(response => {
                    if (response.ok) {
                        this.$router.push('/logout');
                    } else {
                        alert('로그아웃 실패');
                    }
                })
                .catch(error => {
                    console.error('로그아웃 오류:', error);
                    alert('로그아웃 중 오류 발생');
                });
        }
    }
};
</script>





<style scoped src="./MyPage.css"></style>