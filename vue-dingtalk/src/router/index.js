import Vue from 'vue'
import Router from 'vue-router'
Vue.use(Router)
export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: (resolve) => require(['@/pages/index'], resolve)
    },
    {
      path: '/login',
      name: 'login',
      component: (resolve) => require(['@/pages/login'], resolve)
    },
    {
      path: '/report2',
      name: 'report2',
      component: (resolve) => require(['@/pages/report2'], resolve)
    }
  ]
})
