<template>
    <div>
    <h1>게시판</h1>
    <button @click="goToWritePage">글 작성하기</button>
    <ul>
        <li v-for="(post, index) in posts" :key="index">
        <h2>{{ post.title }}</h2>
        <p>{{ post.content }}</p>
        </li>
    </ul>
    </div>
</template>

<script>
export default {
    data() {
    return {
        posts: [],
    };
    },
    methods: {
    goToWritePage() {
        this.$router.push('/writepost'); // 글 작성 페이지로 이동
    },
    fetchPosts() {
        fetch('/api/community/posts') // API로부터 게시글 리스트를 불러옴
        .then(response => response.json())
        .then(data => {
            this.posts = data; // 데이터를 posts에 저장
        })
        .catch(error => {
            console.error('게시글 불러오기 오류:', error);
        });
    },
    },
    created() {
    this.fetchPosts(); // 컴포넌트가 생성될 때 게시글을 불러옴
    },
};
</script>



<style scoped src="./CommuBoard.css"></style>