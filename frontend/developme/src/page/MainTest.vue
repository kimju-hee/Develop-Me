<template>


  <button class="dropdown-button" @click.stop="toggleDropdown">{{ selectedItem }}</button>
    <div v-if="isDropdownOpen" class="dropdown-content">
      <button @click="selectItem('항목 1')">항목 1</button>
      <button @click="selectItem('항목 2')">항목 2</button>
      <button @click="selectItem('항목 3')">항목 3</button>
    </div>
</template>


<script>
export default {
  data() {
    return {
      isDropdownOpen: false,
      selectedItem: '드롭다운 버튼'
    };
  },
  methods: {  
    toggleDropdown() {
      this.isDropdownOpen = !this.isDropdownOpen;
    },
    selectItem(item) {
      /*
      console.log(`${item}이(가) 선택되었습니다.`);
      */
      this.selectedItem = item;
      this.isDropdownOpen = false;
    },
    closeDropdown() {
      this.isDropdownOpen = false;
    }
  }
};
</script>

<style src="./MainTest.css"></style>
