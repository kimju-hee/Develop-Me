<template>
    <header>
        <div class="maintitle">
            <h1>Develop Me!</h1>
        </div>
        <nav>
            <ul>
                <li><a href="todopage">투두 리스트</a></li>
                <li><a href="calendarpage">캘린더</a></li>
                <li><a href="comunitypage">커뮤니티</a></li>
                <li><a href="#">로드맵</a></li>
                <li><a href="algorithmpage">알고리즘</a></li>
                <li><a href="mypage">마이페이지</a></li>
            </ul>
        </nav>
        <div class="myinfo">
            <button @click="logout_function" class="logout_button">로그아웃</button>
            <div class="welcome_me"><!--{{ users.nickname }}-->님 환영합니다.</div>
        </div>
    </header>

    <div class="container">
        <section class="content">
            <div class = "todo_main">
                <div class = "date">
                    <button>left</button> <a> f{{ date }} </a> <button>right</button>
                </div>

                <div class = "todo">
                    <div v-for="(column, index) in columns" :key="index" class="column">
                        <div class="column-header">
                            <span class = "column_title">{{ column.title }} <span id = "cnt_column">{{ column.tasks.length }}</span></span>
                            <button @click="openModal(index)" class="settings-btn">⚙️</button>
                        </div>
                        <div class = "color_bar"></div>
                        
                        <div class="tasks">
                            <div v-for="(task, taskIndex) in column.tasks" :key="taskIndex" class="task-card">
                                <p>{{ task.name }}</p>
                            </div>
                            <div>
                                <input
                                class="add_task_input"
                                type="text"
                                v-model="inputData[index]"
                                @blur="addTask(index)"
                                placeholder="Add task"
                                />
                            </div>
                        </div>
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
        columns: [
            {
            title: "Get Started",
            tasks: [
                { name: "Welcome to your board" },
                { name: "Find your files" },
                { name: "Branding & Assets" },
                { name: "Manage your subscription" },
            ],
            },
            {
            title: "Requests Backlog",
            tasks: [
                { name: "Pricing page" },
                { name: "Contact us page" },
                { name: "Google Chrome Extension Redesign" },
                { name: "X/Twitter Cover" },
            ],
            },
            {
            title: "In Progress",
            tasks: [{ name: "Home page" }, { name: "Schedule custom reporting" }],
            },
            {
            title: "Approved",
            tasks: [
                { name: "Search history for Backlinks and Keywords tool" },
                { name: "Billing and Checkout" },
                { name: "Backlinks chart" },
                { name: "Onboarding process" },
            ],
            },
        ],
        inputData: {}, // 카테고리별 임시 입력 데이터 저장
        };
    },
    methods: {
    changeDate() {
        // 날짜 변경 로직
    },
    openModal(columnIndex) {
        this.currentColumnIndex = columnIndex;
        this.editTitle = this.columns[columnIndex].title;
        this.isModalOpen = true;
    },
    closeModal() {
        this.isModalOpen = false;
    },
    updateCategory() {
        if (this.editTitle) {
        this.columns[this.currentColumnIndex].title = this.editTitle;
        }
        this.closeModal();
    },
    deleteCategory() {
        if (confirm('이 카테고리를 삭제하시겠습니까?')) {
        this.columns.splice(this.currentColumnIndex, 1);
        this.closeModal();
        }
    },
    deleteTask(taskIndex) {
        if (confirm('이 작업을 삭제하시겠습니까?')) {
        this.columns[this.currentColumnIndex].tasks.splice(taskIndex, 1);
        }
    },
    addTask(index) {
        const newTaskName = this.inputData[index];
        if (newTaskName && newTaskName.trim() !== "") {
            this.columns[index].tasks.push({ name: newTaskName });
            this.inputData[index] = "";
        }
    },
    },
};
</script>







<style scoped src="./MainTest.css"></style>