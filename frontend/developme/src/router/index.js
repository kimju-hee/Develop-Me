import { createWebHistory, createRouter } from 'vue-router'
import MainTest from '@/page/MainTest.vue'
import LoginPage from '@/page/LoginPage.vue'
import MyPage from '@/page/MyPage.vue'

const routes = [
    {
        path: '/',
        name: 'Home',
        component: MainTest
    },
    {
        path: '/LoginPage',
        name: 'LoginPage',
        component: LoginPage
    },
    {
        path: '/MyPage',
        name: 'MyPage',
        component: MyPage
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes
})


export default router