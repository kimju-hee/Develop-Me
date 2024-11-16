import { createWebHistory, createRouter } from 'vue-router'
import MainTest from '@/page/MainTest.vue'
import CommunityPage from '@/page/CommunityPage.vue'
import LoginPage from '@/page/LoginPage.vue'
import MyPage from '@/page/MyPage.vue'
import CommuBoard from '@/page/CommuBoard.vue'
import WritePost from '@/page/WritePost.vue'

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
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})


export default router