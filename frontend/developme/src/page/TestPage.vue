<template>
    <div>
        <input
        type="text"
        v-model="inputData"
        @blur="sendData"
        placeholder="입력 후 다른 곳을 클릭하세요"
        />
    </div>
</template>

<script>
export default {
data() {
    return {
    inputData: "", // 입력 데이터를 저장
    };
},
methods: {
    sendData() {
        // 입력값이 비어있으면 전송하지 않음
        if (!this.inputData.trim()) {
            console.log("입력 값이 비어 있어 전송하지 않습니다.");
            return;
        }
        // 서버로 데이터 전송
        fetch("https://example.com/api/data", {
            method: "POST",
            headers: {
            "Content-Type": "application/json",
            },
            body: JSON.stringify({ data: this.inputData }),
        })
            .then((response) => response.json())
            .then((data) => {
            console.log("서버 응답:", data);
            })
            .catch((error) => {
            console.error("전송 실패:", error);
            });
        },
    },
};
</script>