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

    <div id="content">
        <div class="calendar_container">
            <div class="calendar_header">
                <div class="header_title">
                    <span>{{ monthNames[month] }} {{ year }}</span>
                </div>
                <div class="header_controls">
                    <button @click="previousMonth">이전</button>
                    <button @click="nextMonth">다음</button>
                </div>
            </div>
            <div class="calendar_grid">
                <div class="day_name" v-for="day in dayNames" :key="day">{{ day }}</div>
                <div class="calendar_day" 
                    v-for="(day, index) in calendarDays" 
                    :key="index" 
                    :class="{ 'today': isToday(day), 'empty': day === null }"
                    @click="selectDate(day)">
                    <div v-if="day" class="day_number">{{ day }}</div>
                    <!-- 일정 개수 표시 -->
                    <div v-if="day && schedules[`${year}-${String(month + 1).padStart(2, '0')}-${String(day).padStart(2, '0')}`]">
                        <span class="schedule_count">
                            {{ schedules[`${year}-${String(month + 1).padStart(2, '0')}-${String(day).padStart(2, '0')}`].length }} 일정
                        </span>
                    </div>
                </div>
            </div>
        </div>
        <div id="calender_setting">
            <div id="monthly_plan">
                <div id="shape_monthly_plan">
                    <span id="font_monthly_plan">나의 한달 계획</span>
                </div>
                <div id="inshape_monthly_plan">
                    <div class="monthly_plan_category">
                        <div id="shape_category">
                            <div id="font_category">CATEGORY</div>
                        </div>
                        <div id="monthly_plan_category_list">
                            <div class="category_list" v-for="catego in category" :key="catego">{{ catego }}</div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="set_plan">
                <span id="set_plan_focus_day">{{ selectedDate || "날짜를 선택하세요" }}</span>
                <!-- 일정 추가하기 버튼 -->
                <button v-if="selectedDate" @click="openModal">일정 추가하기</button>

                <!-- 선택된 날짜의 일정 표시 -->
                <div v-if="selectedDate && getSchedules(selectedDate).length > 0" id="schedule_list">
                    <h3>선택된 날짜의 일정</h3>
                    <ul>
                        <li v-for="(item, index) in getSchedules(selectedDate)" :key="index">
                            {{ item.category }}: {{ item.name }}
                        </li>
                    </ul>
                </div>
                <div v-else-if="selectedDate">
                    <p>일정이 없습니다.</p>
                </div>
            </div>

            <!-- 모달 팝업 -->
            <div v-if="showModal" class="modal">
                <div class="modal-content">
                    <h3>일정 추가하기</h3>
                    <label>카테고리 선택:</label>
                    <select v-model="newCategory">
                        <option v-for="catego in category" :key="catego" :value="catego">{{ catego }}</option>
                    </select>
                    <label>일정 이름:</label>
                    <input v-model="newSchedule" placeholder="일정 이름 입력"/>
                    <button @click="addSchedule">추가</button>
                    <button @click="closeModal">닫기</button>
                </div>
            </div>
        </div>
    </div>
</template>



<script>
export default {
    data() {
        return {
            currentDate: new Date(),
            year: new Date().getFullYear(),
            month: new Date().getMonth(),
            dayNames: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
            monthNames: [
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
            ],
            category: ["약속", "학교", "프로젝트", "중요", "개인 공부"],
            selectedDate: null,
            schedules: {}, // 날짜별 일정 저장
            showModal: false, // 모달 표시 여부
            newSchedule: "", // 새로 추가할 일정 이름
            newCategory: "", // 새로 추가할 카테고리
        };
    },
    computed: {
        calendarDays() {
            const firstDay = new Date(this.year, this.month, 1).getDay();
            const daysInMonth = new Date(this.year, this.month + 1, 0).getDate();
            const daysArray = Array(firstDay).fill(null).concat(
                new Array(daysInMonth).fill().map((_, index) => index + 1)
            );
            return daysArray;
        },
    },
    methods: {
        previousMonth() {
            if (this.month === 0) {
                this.month = 11;
                this.year--;
            } else {
                this.month--;
            }
        },
        nextMonth() {
            if (this.month === 11) {
                this.month = 0;
                this.year++;
            } else {
                this.month++;
            }
        },
        isToday(day) {
            const today = new Date();
            return (
                day === today.getDate() &&
                this.month === today.getMonth() &&
                this.year === today.getFullYear()
            );
        },
        selectDate(day) {
            if (day) {
                this.selectedDate = `${this.year}-${String(this.month + 1).padStart(2, '0')}-${String(day).padStart(2, '0')}`;
            }
        },
        getSchedules(date) {
            return this.schedules[date] || [];
        },
        openModal() {
            this.showModal = true;
            this.newCategory = this.category[0] || ""; // 기본 카테고리 선택
            this.newSchedule = ""; // 입력 필드 초기화
        },
        closeModal() {
            this.showModal = false;
        },
        addSchedule() {
            if (this.newSchedule.trim() === "") return; // 빈 값 방지
            if (!this.schedules[this.selectedDate]) {
                this.schedules[this.selectedDate] = []; // 새 배열 생성
            }
            this.schedules[this.selectedDate].push({
                name: this.newSchedule.trim(),
                category: this.newCategory,
            }); // 카테고리와 함께 일정 추가
            this.newSchedule = ""; // 입력창 초기화
            this.showModal = false; // 모달 닫기
        },
    },
};
</script>









<style scoped src="./CalendarPage.css"></style>