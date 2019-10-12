import Vue from 'vue'
import Vuex from 'vuex'
import user from './modules/user'
import busstop from './modules/busstop'
import getters from './getters'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    user,
    busstop
  },
  getters
})

export default store
