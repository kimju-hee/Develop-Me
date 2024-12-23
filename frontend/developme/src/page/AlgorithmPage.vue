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
            <div class="welcome_me"><!--{{ users.nickname }}-->님 환영합니다.</div>
        </div>
    </header>

    <div class="container">
        <aside v-if="isSidebarVisible" class="ranking">
            <button @click="toggleSidebar">
                {{ isSidebarVisible ? '메뉴로 전환' : '랭킹으로 전환' }}
            </button>
            <h2>랭킹</h2>
            <ul>
                <li>
                    <img src="../assets/images/임시사용이미지.png" class="medal_image" />
                    1. 사용자 A
                </li>
                <li>
                    <img src="../assets/images/임시사용이미지.png" class="medal_image" />
                    2. 사용자 B
                </li>
                <li>
                    <img src="../assets/images/임시사용이미지.png" class="medal_image" />
                    3. 사용자 C
                </li>
            </ul>
        </aside>
        <aside v-else class="menu">
            <button @click="toggleSidebar">
                {{ isSidebarVisible ? '메뉴로 전환' : '랭킹으로 전환' }}
            </button>
            <h2>메뉴</h2>
            <ul>
                <li><a href="#">메뉴 1</a></li>
                <li><a href="#">메뉴 2</a></li>
                <li><a href="#">메뉴 3</a></li>
            </ul>
        </aside>

        <section class="content">
            <div class="tree-container">
                <img id="tree" src="../assets/images/Algorythm_tree.png" alt="나무 이미지">
                <div class="grid">
                    <div 
                        v-for="(day, index) in stampedDays" 
                        :key="index" 
                        class="cell"
                        :style="`left: ${day.x}%; top: ${day.y}%;`"
                    >
                        <span v-if="!day.isStamped" class="day_number">{{ index + 1 }}</span>
                        <img 
                            v-if="day.isStamped" 
                            src="../assets/images/임시사용이미지.png" 
                            alt="Stamped" 
                            class="stamp"
                        />
                    </div>
                </div>
            </div>
        </section>
    </div>
</template>




<script>
export default {
    data() {
        return {
            isSidebarVisible: true,
            days: [
                { x: 12, y: 57 }, // 1
                { x: 23, y: 59 },
                { x: 35, y: 62 },
                { x: 48, y: 55 },
                { x: 60, y: 59 }, // 5
                { x: 74, y: 60 },
                { x: 88, y: 55 },
                { x: 11, y: 44 },
                { x: 27, y: 46 },
                { x: 43, y: 43 }, // 10
                { x: 56, y: 48 },
                { x: 72, y: 46 },
                { x: 84, y: 43 },
                { x: 23, y: 34 },
                { x: 36, y: 30 }, // 15
                { x: 54, y: 34 },
                { x: 68, y: 30 },
                { x: 44, y: 23 },
                { x: 60, y: 20 },
                { x: 50, y: 13 }, // 20
            ],
            attendanceData: [
                false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            ]
        };
    },
    methods: {
        toggleSidebar() {
            this.isSidebarVisible = !this.isSidebarVisible;
        }
    },
    computed: {
        stampedDays() {
            return this.days.map((day, index) => ({
                ...day,
                isStamped: this.attendanceData[index] || false
            }));
        }
    }
};
</script>







<style scoped src="./AlgorithmPage.css"></style>