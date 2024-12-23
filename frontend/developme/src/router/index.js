import { createWebHistory, createRouter } from 'vue-router'
import MainTest from '@/page/MainTest.vue'
import CommunityPage from '@/page/CommunityPage.vue'
import LoginPage from '@/page/LoginPage.vue'
import MyPage from '@/page/MyPage.vue'
import CommuBoard from '@/page/CommuBoard.vue'
import WritePost from '@/page/WritePost.vue'
import CalendarPage from '@/page/CalendarPage.vue'
import TodoPage from '@/page/TodoPage.vue'
import TestPage from '@/page/TestPage.vue'
import AlgorithmPage from '@/page/AlgorithmPage.vue'

const routes = [
    {
        path: '/',
        name: 'Home',
        component: MainTest
    },
    {
        path: '/CommunityPage',
        name: 'ComumnityPage',
        component: CommunityPage
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
    {
        path: '/CommuBoard',
        name: 'CommuBoard',
        component: CommuBoard
    },
    {
        path: '/WritePost',
        name: 'WritePost',
        component: WritePost
    },
    {
        path: '/CalendarPage',
        name: 'CalendarPage',
        component: CalendarPage
    },
    {
        path: '/TodoPage',
        name: 'TodoPage',
        component: TodoPage
    },
    {
        path: '/TestPage',
        name: 'TestPage',
        component: TestPage
    },
    {
        path: '/AlgorithmPage',
        name: 'AlgorithmPage',
        component: AlgorithmPage
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})


export default router