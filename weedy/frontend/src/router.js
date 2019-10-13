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
      props: true,
      component: () => import('./views/main/Main.vue')
    },
    {
      path: '/registerAdmin',
      name: 'registerAdmin',
      component: () => import('./views/register/RegisterAdmin.vue')
    },
    {
      path: '/registerUser',
      name: 'registerUser',
      component: () => import('./views/register/RegisterUser.vue')
    },
    {
      path: '/searchList',
      name: 'searchList',
      props: true,
      component: () => import('./views/search/SearchList.vue')
    },
    {
      path: '/searchDetail',
      name: 'searchDetail',
      props: true,
      component: () => import('./views/search/SearchDetail.vue')
    },
    {
      path: '/qnaList',
      name: 'qnaList',
      component: () => import('./views/qna/QnaList')
    },
    {
      path: '/qnaWrite',
      name: 'qnaWrite',
      component: () => import('./views/qna/QnaWrite.vue')
    },
    {
      path: '/qnaDetailAdmin',
      name: 'qnaAdmin',
      component: () => import('./views/qna/QnaDetailAdmin.vue')
    },
    {
      path: '/qnaDetailUser',
      name: 'qnaUser',
      component: () => import('./views/qna/QnaDetailUser.vue')
    },
    {
      path: '/faq',
      name: 'faq',
      component: () => import('./views/qna/Faq.vue')
    }
  ]
})
