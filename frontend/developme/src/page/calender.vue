<template>
    <div class="calendar-container">
    <div class="calendar-header">
        <div class="header-title">
        <span>{{ monthNames[month] }} {{ year }}</span>
        </div>
        <div class="header-controls">
        <button @click="previousMonth">이전</button>
        <button @click="nextMonth">다음</button>
        </div>
    </div>
    <div class="calendar-grid">
        <div class="day-name" v-for="day in dayNames" :key="day">{{ day }}</div>
        <div
        class="calendar-day"
        v-for="(day, index) in calendarDays"
        :key="index"
        :class="{ 'today': isToday(day), 'empty': day === null }"
        >
        <div v-if="day" class="day-number">{{ day }}</div>
        <div v-if="day" class="day-notes">들어갈 부분</div>
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
    },
};
</script>


<style scoped src="./MainTest.css"></style>