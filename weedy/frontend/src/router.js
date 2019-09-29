import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    },
    {
      path: '/main',
      name: 'main',
      component: () => import('./views/main/Main.vue')
    },
    {
      path: '/register_admin',
      name: 'register_admin',
      component: () => import('./views/register/RegisterAdmin.vue')
    },
    {
      path: '/register_user',
      name: 'register_user',
      component: () => import('./views/register/RegisterUser.vue')
    },
    {
      path: '/qna_list',
      name: 'qna_list',
      component: () => import('./views/qna/QnaList')
    },
    {
      path: '/qna_write',
      name: 'qna_write',
      component: () => import('./views/qna/QnaWrite.vue')
    },
    {
      path: '/qna_admin',
      name: 'qna_admin',
      component: () => import('./views/qna/QnaAdmin.vue')
    },
    {
      path: '/qna_user',
      name: 'qna_user',
      component: () => import('./views/qna/QnaUser.vue')
    }
  ]
})
