import App from './App.vue';
import { createApp } from "vue"
import {createRouter,createWebHashHistory} from 'vue-router' // 모듈형으로 사용하기위해서

import Layout from './components/Layout.vue';
import Index from './components/Index.vue';
import Login from './components/Login.vue';
import Signup from './components/Signup.vue';
import Stuff from './components/Stuff.vue';
import List from './components/List.vue';
import Reg from './components/Reg.vue';
import Detail from './components/Detail.vue';

const routes = [  //중첩 만들기 , 자식으로 대입된다.
    { path: '/', component: Layout, children:[
        {path: 'index', component: Index},
        {path: 'login', component: Login},
        {path: 'login', component: Login},
        {path: 'signup', component: Signup},
    ]},
    { path: '/stuff', component: Stuff, children:[
        {path:'list', component: List},
        {path:'reg', component: Reg},
        {path:'detail', component: Detail},
    ]},
]
  

const router = createRouter({
    history: createWebHashHistory(),
    routes,
})

createApp(App)
.use(router)
.mount("#app")
