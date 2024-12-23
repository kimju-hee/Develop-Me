<template>
    <header>
        <div class="maintitle">
            <h1>Develop Me!</h1>
        </div>
        <nav>
            <ul>
                <li><a href="todopage">투두 리스트</a></li>
                <li><a href="calendarpage">캘린더</a></li>
                <li><a href="communitypage">커뮤니티</a></li>
                <li><a href="#">로드맵</a></li>
                <li><a href="algorithmpage">알고리즘</a></li>
                <li><a href="mypage">마이페이지</a></li>
            </ul>
        </nav>
        <div class="myinfo">
            <button @click="logout_function" class="logout_button">로그아웃</button>
            <div class="welcome_me">{{ 사용자명 }}님 환영합니다.</div>
        </div>
    </header>

    
    <div id = "content">
        <div id = "sidebar">
            <form id = "search_form">
                <input id = "search_input" placeholder="검색">
            </form>
            <div id = "sidebar_menu">
                <ul id = "ul_menu">메뉴</ul>
                <li class="sidebar_li" 
                    :class="{ active: selectedMenu === 0 }" 
                    @click="selectMenu(0)">전체 글 보기</li>
                <li class="sidebar_li" 
                    :class="{ active: selectedMenu === 1 }" 
                    @click="selectMenu(1)">내가 쓴 모집글</li>
                <li class="sidebar_li" 
                    :class="{ active: selectedMenu === 2 }" 
                    @click="selectMenu(2)">내가 지원한 글</li>
            </div>
        </div>
        <div id = "main_content">
            <div class = "top_bar">
                <div class = "top_bar_buttons">
                    <button class = "topbarbutton" :class="{ active: selectedTopbarbutton === 1 }" @click="selectTopbarbutton(1)">New</button>
                    <button class = "topbarbutton" :class="{ active: selectedTopbarbutton === 2 }" @click="selectTopbarbutton(2)">Top</button>
                    <button class = "topbarbutton" :class="{ active: selectedTopbarbutton === 3 }" @click="selectTopbarbutton(3)">Hot</button>
                    <button class = "topbarbutton" :class="{ active: selectedTopbarbutton === 4 }" @click="selectTopbarbutton(4)">Closed</button>
                </div>
                <button class = "write_post_button">글 작성하기</button>
            </div>
            <div class = "bulletin_list">
                <div class = "bulletin">
                    <div class = "bulletin_top">
                        <div class = "bulletin_info">
                            <span class= "bulletin_writer">작성자 이름</span>
                            <span class= "bulletin_writing_time">게시글 작성 시간</span>
                        </div>
                        <div class = ""></div>
                    </div>
                </div>
            </div>
        </div>
        <div id = "right_side_bar">

        </div>
    </div>
</template>




<script>
export default {
    data() {
        return {
            selectedMenu: null, // 선택된 메뉴 항목의 인덱스를 저장
            selectedTopbarbutton: null
        };
    },
    methods: {
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
        },
        selectMenu(index) {
            if (this.selectedMenu === index) {
                this.selectedMenu = null;
            } else {
                this.selectedMenu = index;
            }
        },
        selectTopbarbutton(index) {
            if (this.selectedTopbarbutton === index) {
                this.selectedTopbarbutton = null;
            } else {
                this.selectedTopbarbutton = index;
            }
        }
    }
};
</script>





<style scoped src="./CommunityPage.css"></style>