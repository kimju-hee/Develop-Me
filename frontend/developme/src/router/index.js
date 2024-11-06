import { createWebHistory, createRouter } from 'vue-router'
import LoginPage from '@/page/LoginPage.vue'
import MainTest from '@/page/MainTest.vue'
import SignupPage from '@/page/SignupPage.vue'
import MyPage from '@/page/MyPage.vue'
import TestPage from '@/page/TestPage.vue'

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
        path: '/SignupPage',
        name: 'SignupPage',
        component: SignupPage
    },
    {
        path: '/MyPage',
        name: 'MyPage',
        component: MyPage
    },
    {
        path: '/TestPage',
        name: 'TestPage',
        component: TestPage
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})


export default router