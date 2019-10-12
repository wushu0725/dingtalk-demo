// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
/*eslint-disable*/
import Vue from 'vue'
import App from './App'
import Vuex from 'vuex'
import store from './store'
import router from './router'
import Mint from 'mint-ui'
import 'mint-ui/lib/style.css'
import FastClick from 'fastclick'
import {default as api} from './api/api'
import VCharts from 'v-charts'



/**
*监听浏览器点击返回前进操作动画
*浏览器端使用需要注意路由path的创建，二级应该在一级的基础上添加
*如一级/Home，则二级为/Home/Detail，依次往后加，如果是app的话可忽略以下代码
*/
let init = 0
let args,items,item,len


Vue.use(Mint)
Vue.use(Vuex)
Vue.use(VCharts)
Vue.prototype.api = api
Vue.config.productionTip = false
FastClick.attach(document.body)

new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
