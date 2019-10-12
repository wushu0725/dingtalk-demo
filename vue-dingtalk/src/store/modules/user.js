import {getToken, removeToken, setToken} from '@/api/auth'
import {default as api} from '@/api/api'
import store from '../../store'
import router from '../../router'

const user = {
  state: {
    nickname: '',
    userId: '',
    avatar: 'https://www.gravatar.com/avatar/6560ed55e62396e40b34aac1e5041028',
    role: '',
    menus: []
  },
  mutations: {
    SET_USER: (state, userInfo) => {

      state.nickname = userInfo.nickname;
      state.userId = userInfo.userId;
      state.role = userInfo.roleName;
      state.avatar = userInfo.acatar;
      console.log(state.avatar)

      localStorage.setItem("userInfo",JSON.stringify(userInfo));
    },
    RESET_USER: (state) => {
      state.nickname = ''
      state.userId = ''
      state.role = ''
      state.avatar = ''
    }
  },
  actions: {
    // 登录
    Login({commit, state}, loginForm) {
      return new Promise((resolve, reject) => {
        api({
          url: 'login/auth',
          method: 'post',
          data: loginForm
        }).then(data => {

          if (data.result === 'success') {
            setToken()
          }
          resolve(data);
        }).catch(err => {
          reject(err)
        })
      })
    },
    // 获取用户信息
    GetInfo({commit, state}) {
      return new Promise((resolve, reject) => {
        api({
          url: '/login/getInfo',
          method: 'post'
        }).then(data => {
          //储存用户信息
          console.log(data.userPermission)
          commit('SET_USER', data.userPermission);
          //cookie保存登录状态,仅靠vuex保存的话,页面刷新就会丢失登录状态
          setToken();
          //生成路由
          resolve(data)
        }).catch(error => {
          reject(error)
        })
      })
    },
    // 登出
    LogOut({commit}) {
      return new Promise((resolve) => {
        api({
          url: "login/logout",
          method: "post"
        }).then(data => {
          commit('RESET_USER')
          removeToken()
          resolve(data);
        }).catch(() => {
          commit('RESET_USER')
          removeToken()
        })
      })
    }
  }
}
export default user
