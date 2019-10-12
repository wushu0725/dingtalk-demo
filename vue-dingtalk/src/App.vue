<template>
  <div id="app">
    <div>
      <banner v-bind:banner-metas="meta.bannerMetas" v-bind:corp-id="corpId"></banner>
      <admin v-bind:admin="meta.admin" v-bind:user-info="meta.userInfo" v-bind:corp-id="corpId"></admin>
    </div>
    <transition :name="transitionName">
      <router-view class="Router"></router-view>
    </transition>
  </div>
</template>

<script>
  import banner from './pages/components/index-banner.vue';
  import admin from './pages/components/index-admin.vue';

  import * as dd from 'dingtalk-jsapi';
  import {
    parseCorpId
  } from './lib/util';

export default {
  name: 'App',
  components: {
    admin: admin,
    banner: banner
  },
  mounted:  function(){
    const self = this;
    const originalUrl = location.href;
    this.corpId = parseCorpId(originalUrl, 'corpId');
    //监听userId的变化，如果有变化，立即获取用户信息
    try {
      dd.ready(function () {
        // dd.ready参数为回调函数，在环境准备就绪时触发，jsapi的调用需要保证在该回调函数触发后调用，否则无效。
        try {
          dd.runtime.permission.requestAuthCode({
            corpId: self.corpId,
            onSuccess: function (result) {
              self.getUserInfo(self.corpId,result.code);
            },
            onFail: function (err) {
              alert(JSON.stringify(err));
            }

          });
        } catch (e) {
          alert(e);
        }

      });
    }catch (e) {
      alert(e);
    }
  },
  data() {
    return {
      transitionName: '',
      corpId:'',
      meta: {
        admin: false,

        bannerMetas: {
          homeBannerModels: [{
            "linkUrl": "https://alimarket.m.taobao.com/markets/dingtalk/cydd?lwfrom=20161118115327653",
            "imgUrl": "https://gw.alicdn.com/tps/TB1o8BqOpXXXXanXVXXXXXXXXXX-750-300.png"
          }],
          isHomeBannerModels: true
        },
      userInfo: {
          "name":"",
          "mobile":"",
          "userId":""
      }
      }
    }
  },
  methods: {
    getUserInfo(varCorpid,varCode){
      let _this=this;
      this.api({
        url: "/user/getUserInfo",
        method: "get",
        params:{"code":varCode,
          "corpId":varCorpid}
      }).then(data => {
        _this.meta.userInfo=data;
      })
    }
  },
  watch: {
    $route() {
      if (this.$router.isleft) {
        this.transitionName = 'slideleft'
      }
      if (this.$router.isright) {
        this.transitionName = 'slideright'
      }
    }
  }
}
</script>

<style lang="less">
@import "~styles/variable.less";
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -webkit-tap-highlight-color:rgba(0,0,0,0);
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
.Router {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  width: 100%;
  height: 100%;
  background-color: @body-bg-color;;
  transition: all .5s ease;
  -webkit-transition: all .5s ease;
  -moz-transition: all .5s ease;
}
.slideleft-enter,
 .slideright-leave-active {
  opacity: 1;
  transform: translate3d(90% 0, 0);
  -webkit-transform: translate3d(90%, 0, 0);
  -moz-transform: translate3d(90%, 0, 0);
}
.slideleft-leave-active,
.slideright-enter {
 opacity: 1;
 transform: translate3d(-90% 0, 0);
 -webkit-transform: translate3d(-90%, 0, 0);
 -moz-transform: translate3d(-90%, 0, 0);
}
</style>
