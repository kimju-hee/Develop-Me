<template>
    <div>
    <h1>글 작성하기</h1>
    <form @submit.prevent="submitPost">
        <input v-model="title" placeholder="제목" required />
        <textarea v-model="content" placeholder="내용" required></textarea>
        <button type="submit">제출하기</button>
    </form>
    </div>
</template>

<script>
export default {
    data() {
    return {
        title: '',
        content: '',
    };
    },
    methods: {
    submitPost() {
        const postData = {
        title: this.title,
        content: this.content,
        };

        fetch('/api/community/posts', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(postData),
        })
        .then(response => {
            if (response.ok) {
            this.$router.push('/'); // 성공하면 게시판 리스트 페이지로 이동
            } else {
            alert('게시글 저장에 실패했습니다.');
            }
        })
        .catch(error => {
            console.error('게시글 저장 오류:', error);
            alert('게시글 저장 중 오류가 발생했습니다.');
        });
    },
    },
};
</script>
