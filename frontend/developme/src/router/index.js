import { createWebHistory, createRouter } from 'vue-router'
import LoginPage from '@/page/LoginPage.vue'
import MainTest from '@/page/MainTest.vue'

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
]

const router = createRouter({
    history: createWebHistory(),
    routes
})


export default router