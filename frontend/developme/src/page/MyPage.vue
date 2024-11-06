<template>
    <div id="app">
        <header class="header">
            <div class = logo>
                <h1>Develop Me!</h1>
            </div>
            <nav class="nav">
                <ul>
                    <li><a href="#">투두 리스트</a></li>
                    <li><a href="#">캘린더</a></li>
                    <li><a href="#">커뮤니티</a></li>
                    <li><a href="#">로드맵</a></li>
                    <li><a href="#">알고리즘</a></li>
                    <li><a href="mypage">마이페이지</a></li>
                </ul>
            </nav>
            <div class = myinfo>
                <button class = logout_button>로그아웃</button>
                <div class = welcome_me>{}님 환영합니다.</div>
            </div>
        </header>
    </div>
    <div class = mypage_content>
        <a>아아</a>
    </div>
</template>



<script>
export default {
    name: "App",
};
</script>

<style src="./MyPage.css"></style>