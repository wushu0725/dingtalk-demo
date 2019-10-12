<template>
  <div class="page-group">
    <div class="page-group1">
    <div class="bar-name-br">
      <div class="bar-name-br-left"><img :src="acatar"></div>
      <div class="bar-name-br-text">
        <h1>{{nickname}}</h1>
      </div>
      <a href="javascript:void(0);" @click="logout"  class="bar-name-br-link">退出</a>
    </div>
  </div>
    <div class="page-group2">
        <div class="check-box1">
          <a href="javascript:void(0);" @click="busOutCheck" class="check-link">
           <div class="icon-a1"></div>
           <h1>回场检查</h1>
          </a>
        </div>

        <div class="check-box2">
           <a href="javascript:void(0);" @click="busConfrim" class="check-link">
           <div class="icon-a2"></div>
           <h1>位置确定</h1>
          </a>
        </div>
    <mt-cell v-for="item in busStopArealist" :key="item.shows" :title="item.shows">
    </mt-cell>
  </div>
  </div>
</template>

<script>
import {mapMutations, mapGetters, mapState} from 'vuex'

export default {
  data () {
    return {
      tittle: '钉钉企业定制首页',
      busStopArealist:[],
      nickname:'',
      acatar : ''
    }
  },
  components: {

  },
  activated() {
    this.getCheckInfo()
    this.initLogin()
  },
  methods: {
    busConfrim() {
      this.$router.push('busConfrim')
    },
    busOutCheck(){
      this.$router.push('checkbus')
    },
    initLogin(){
      if(localStorage.getItem("userInfo")){
        let userinfo = JSON.parse(localStorage.getItem("userInfo"));
        this.nickname=userinfo.nickname;
        if(userinfo.acatar){
          this.acatar = userinfo.acatar;
        }else{
          this.acatar ='https://www.gravatar.com/avatar/6560ed55e62396e40b34aac1e5041028'
        }
      }
    },
    logout(){
      localStorage.clear();
      this.$router.push('login')
    },

    getCheckInfo(){
      this.api({
        url: "/buscheckinfo/listBuscheckinfoweb",
        method: "post",
        data:{}
      }).then(data => {
        console.log(data);
        this.busStopArealist=data;
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">

@import "~styles/index.less";
@import "~styles/variable.less";
.hello{
  h1{
    color: red;
    .fs(38);
  }
}
img{ border: none;}

ul li{ list-style: none;}
ol li{ list-style: none;}
h1,h2,h3,h4,h5,h6{margin: 0;padding: 0;font-weight: normal;}
html {
    font-size : 20px;
    background: #fff
}
@media only screen and (min-width: 401px){
    html {
        font-size: 25px !important;
    }
}
@media only screen and (min-width: 428px){
    html {
        font-size: 26.75px !important;
    }
}
@media only screen and (min-width: 481px){
    html {
        font-size: 30px !important;
    }
}
@media only screen and (min-width: 569px){
    html {
        font-size: 35px !important;
    }
}
@media only screen and (min-width: 641px){
    html {
        font-size: 40px !important;
    }
}
body{ font-family: "STHeiti" ;  margin:0 auto;  background-color: #ffffff !important;}

/*index*/
.page-group{
  width: 100%;

}
.page-group2{
  width: 95%;
  margin: 0 auto;
}
.check-box1{
  width: 100%;
  height: 3.5rem;
  background: url(../../assets/images/bj-b1.png) no-repeat;
  display:block;
  background-size: 100% 100%;
  margin-bottom: 0.2rem;
}
.check-box2{
  width: 100%;
  height: 3.5rem;
  background: url(../../assets/images/bj-b2.png) no-repeat;
  display:block;
  margin-bottom: 0.2rem;
  background-size: 100% 100%;


}
.check-box3{
  width: 100%;
  height: 3.5rem;
  background: url(../../assets/images/bj-b3.png) no-repeat;
  display:block;
  background-size: 100% 100%;
}
.check-link{
  display: inline-block;
  width: 100%;
  height: 100%;
  outline: medium;
}
.icon-a1{
  width: 2.2rem;
  height: 2.2rem;
  background: url(../../assets/images/bj-b1-icon.png) no-repeat;
  background-size: 100% 100%;
  display: inline-block;
  float: left;
  margin: 0.57rem 0.5rem 0 0.7rem;
}
.icon-a2{
  width: 2.2rem;
  height: 2.2rem;
  background: url(../../assets/images/bj-b2-icon.png) no-repeat;
  background-size: 100% 100%;
  display: inline-block;
  float: left;
  margin: 0.57rem 0.5rem 0 0.7rem;
}
.icon-a3{
  width: 2.2rem;
  height: 2.2rem;
  background: url(../../assets/images/bj-b3-icon.png) no-repeat;
  background-size: 100% 100%;
  display: inline-block;
  float: left;
  margin: 0.57rem 0.5rem 0 0.7rem;
}
.check-link h1{
  font-size: 0.8rem;
  color: #fff;
  margin-top: 1.2rem;
  float:left;
}
.bar-name-br{
  height: 2.3rem;
  background: #fff;
  margin-bottom: 0.5rem;
  /* margin-top: 1.8rem; */
  padding: 0.3rem 0.4rem 0.2rem;
  box-shadow:0px 5px 14px 2px #ececec;

}
.bar-name-br-left{
  border: 1px solid #ede9e9;
  float: left;
  border-radius: 5px;
  margin-right: 0.5rem;
  margin-top: 0.2rem;

}
.bar-name-br-left img{
  width:1.9rem;
  height:1.7rem;
  background-size: 100% 100%;

}
.bar-name-br-text h1{
  font-size: 0.7rem;
  margin-bottom: 0.2rem;
  margin-top: 0.3rem;
  text-align: left;
}

.bar-name-br-text p{
  font-size: 0.5rem;
  color: #989898;
}
.bar-name-br-text{
  float: left;

}
.bar-name-br-link{
  float: right;
  width: 1.8rem;
  height: 1.1rem;
  background: #f8f6f6;
  border: 1px solid #ddd;
  color: #295cd4;
  font-size: 0.5rem;
  text-align: center;
  line-height: 1.2rem;
  border-radius: 0.1rem;
  margin-top: 0.65rem
}
</style>
