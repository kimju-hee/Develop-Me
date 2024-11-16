<template>
    <header>
        <div class = "maintitle">
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
        <div class = "myinfo">
            <button @click = logout_function class = "logout_button">로그아웃</button>
            <div class = "welcome_me">{{ 사용자명 }}님 환영합니다.</div>
        </div>
    </header>
    <div class ="container">
        <div class = "sidebar">
            <form id="sidebarsearch">
                <input type="text" id="search" placeholder="검색">
                <button type="button" @click="searchFunction()">검색</button>
            </form>
            <div class = "sidebar_menu">
                <span id = "sidebar_span">메뉴</span>
                <ul>
                    <li>
                        <button class="sidebar_button" :class="{ active: activeButton === 'full_recruitment_post' }" @click="toggleButton('full_recruitment_post')" id="full_recruitment_post">
                        전체 모집글 보기
                        </button>
                    </li>
                    <li>
                        <button class="sidebar_button" :class="{ active: activeButton === 'my_recruitment_post' }" @click="toggleButton('my_recruitment_post')" id="my_recruitment_post">
                        내가 쓴 모집글
                        </button>
                    </li>
                    <li>
                        <button class="sidebar_button" :class="{ active: activeButton === 'my_application_post' }" @click="toggleButton('my_application_post')" id="my_application_post">
                        내가 지원한 모집글
                        </button>
                    </li>
                </ul>
            </div>
        </div>


        <div class = "contents">
            <div class = "contents_head">
                <div class = "post_state_button">
                    <button v-for="(label, index) in ['New', 'Top', 'Hot', 'Closed']" :key="index" class="post_state" :class="{ active: activePostState === index }" @click="togglePostState(index)">
                        {{ label }}
                    </button>
                </div>
                <button id = "write_post_button" @click="writePost" >글 작성하기</button>
            </div>
            <div class = "contents_body"></div>
        </div>
    </div>
</template>




<script>
export default {
    data() {
        return {
            activeButton: null,
            activePostState: null
        };
    },
    methods: {
        logout_function() {
            fetch('/api/users/logout', { method: 'POST' })
                .then(response => {
                    if (response.ok) {
                        this.$router.push('/logout');
                    } else {
                        alert('로그아웃에 실패했습니다.');
                    }
                })
                .catch(error => {
                    console.error('로그아웃 오류:', error);
                    alert('로그아웃 중 오류가 발생했습니다.');
                });
        },
        searchFunction() {
            const query = document.getElementById('search').value;
            console.log("검색어:", query);
        },
        toggleButton(buttonId) {
            if (this.activeButton === buttonId) {
                this.activeButton = null;
            } else {
                this.activeButton = buttonId;
            }

            const url = `/api/button-status?buttonId=${this.activeButton}`;

            fetch(url, {
                method: 'GET'
            })
            .then(response => response.json())
            .then(data => {
                console.log('서버 응답:', data);
            })
            .catch(error => {
                console.error('서버 요청 오류:', error);
            });
        },
        togglePostState(buttonIndex) {
            if (this.activePostState === buttonIndex) {
                this.activePostState = null;
            } else {
                this.activePostState = buttonIndex;
            }
        },
        writePost() {
            // API 요청
            fetch('/api/community/posts', {
                method: 'GET'
            })
            .then(response => {
                if (response.ok) {
                    // 페이지 전환
                    this.$router.push('/write-post'); // 글 작성 페이지로 이동
                } else {
                    alert('페이지로 전환하는데 문제가 발생했습니다.');
                }
            })
            .catch(error => {
                console.error('API 요청 오류:', error);
                alert('요청 중 오류가 발생했습니다.');
            });
        }
    }
};
</script>





<style scoped src="./CommunityPage.css"></style>