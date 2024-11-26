<template>
    <div class="kanban-board">
      <div class="board-header">
        <h2>May 2024</h2>
        <button @click="changeDate">날짜 변경</button>
      </div>
      <div class="board-columns">
        <div v-for="(column, index) in columns" :key="index" class="column">
          <div class="column-header">
            <h3>{{ column.title }} <span>{{ column.tasks.length }}</span></h3>
            <button @click="openModal(index)" class="settings-btn">⚙️</button>
          </div>
          <div class="tasks">
            <div v-for="(task, taskIndex) in column.tasks" :key="taskIndex" class="task-card">
              <p>{{ task.name }}</p>
            </div>
            <button class="add-task-btn" @click="addTask(index)">Add task</button>
          </div>
        </div>
      </div>
  
      <!-- 통합 모달 창 -->
      <div v-if="isModalOpen" class="modal">
        <div class="modal-content">
          <h3>카테고리 및 작업 카드 관리</h3>
  
          <!-- 카테고리 관리 -->
          <div class="category-management">
            <h4>카테고리 이름 수정</h4>
            <input v-model="editTitle" placeholder="카테고리 이름 수정" />
            <button @click="updateCategory">수정</button>
            <button @click="deleteCategory">삭제</button>
          </div>
  
          <!-- 작업 카드 목록 관리 -->
          <div class="task-management">
            <h4>작업 카드 목록</h4>
            <div v-for="(task, taskIndex) in columns[currentColumnIndex].tasks" :key="taskIndex" class="task-item">
              <input v-model="columns[currentColumnIndex].tasks[taskIndex].name" />
              <button @click="deleteTask(taskIndex)">삭제</button>
            </div>
          </div>
  
          <button @click="closeModal">닫기</button>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        columns: [
          {
            title: 'Get Started',
            tasks: [
              { name: 'Welcome to your board' },
              { name: 'Find your files' },
              { name: 'Branding & Assets' },
              { name: 'Manage your subscription' },
            ],
          },
          {
            title: 'Requests Backlog',
            tasks: [
              { name: 'Pricing page' },
              { name: 'Contact us page' },
              { name: 'Google Chrome Extension Redesign' },
              { name: 'X/Twitter Cover' },
            ],
          },
          {
            title: 'In Progress',
            tasks: [{ name: 'Home page' }, { name: 'Schedule custom reporting' }],
          },
          {
            title: 'Approved',
            tasks: [
              { name: 'Search history for Backlinks and Keywords tool' },
              { name: 'Billing and Checkout' },
              { name: 'Backlinks chart' },
              { name: 'Onboarding process' },
            ],
          },
        ],
        isModalOpen: false,
        currentColumnIndex: null,
        editTitle: '',
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
      addTask(columnIndex) {
        const newTaskName = prompt('Enter task name:');
        if (newTaskName) {
          this.columns[columnIndex].tasks.push({ name: newTaskName });
        }
      },
    },
  };
  </script>
  
  <!-- CSS 파일을 외부에서 가져옵니다.. -->
  <style scoped src="./TodoPage.css"></style>
  