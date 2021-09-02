import { createRouter, createWebHistory } from 'vue-router'
import App from './App.vue'
import User from './components/User'
import Root from './components/Root'
import UserAuth from './components/UserAuth'
import NewUser from './components/NewUser'
import Products from './components/Products'
import Car from './components/Car'
import Order from './components/Order'
import Account from './components/Account'

const routes = [{
        path: '/',
        name: 'root',
        component: Root
    },
    {
        path: '/user/auth',
        name: "user_auth",
        component: UserAuth
    },
    {
        path: '/newuser',
        name: "newuser",
        component: NewUser
    },
    {
        path: '/user/:username',
        name: "user",
        component: User
    },
    {
        path: '/products',
        name: "products",
        component: Products
    },
    {
        path: '/car/:username',
        name: "car",
        component: Car
    },
    {
        path: '/account/:username',
        name: "account",
        component: Account
    },
    {
        path: '/order/:username',
        name: "order",
        component: Order
    }   
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router