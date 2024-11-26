<template>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">로고</a>
        <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarNav"
        aria-controls="navbarNav"
        aria-expanded="false"
        aria-label="Toggle navigation"
        >
        <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">홈</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="#">문서</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="#">예시</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="#">아이콘</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="#">테마</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="#">블로그</a>
            </li>
        </ul>
        <form class="d-flex">
            <input class="form-control me-2" type="search" placeholder="문서 검색..." aria-label="Search">
            <button class="btn btn-outline-light" type="submit">검색</button>
        </form>
        </div>
    </div>
    </nav>
</template>

<script>
export default {
    name: 'NavBar',
};
</script>

<style scoped>
.navbar-brand {
    font-weight: bold;
}
</style>
