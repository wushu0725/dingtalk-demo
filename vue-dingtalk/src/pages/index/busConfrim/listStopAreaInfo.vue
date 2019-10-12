<template>
  <div>
<br>
<br>
<br>
<mt-cell v-for="item in busStopAreaInfolist" :key="item.id" :title="item.buscode +'   '+item.buslicence" is-link>
  <mt-button type="danger" @click="removeBusInfo(item.id)" :disabled="isDisable">移出</mt-button>
</mt-cell>
    <mt-popup class="sharePopup" v-model="popupVisible" style="width: 100%" position="middle">
      <div class="page-part">
        <mt-field label="自编号" v-model="busStopAreaInfo.buscode" @blur.native.capture="getBusBybusid" style="width: 100%;height: 2rem" placeholder="请输入自编号" type="tel"></mt-field>
        <mt-field label="大牌号" v-model="busStopAreaInfo.buslicence" style="width: 100%;height: 2rem" placeholder="请输入大牌号" type="tel"></mt-field>
      </div>
      <div class="shareFooter">
        <mt-button size="large" @click="insertBusAreaInfo">增加</mt-button>
        <br>
        <mt-button size="large" @click="hiddenShare">取消</mt-button>
      </div>
    </mt-popup>
<div class="scan-add">
    <button @click="testsaoma"><div class="iconfont icon-saoyisao scan-icon"></div>{{buttonlable}}</button>
    <br>
    <button @click="showAdd">手动增加</button>
  </div>
</div>
</template>

<script>
import {mapMutations, mapGetters, mapState} from 'vuex'


import { MessageBox } from 'mint-ui'


export default {
  data () {
    return {
      num: 0,
      busStopAreaInfolist:[],
      busStopAreaInfo:{
        id: '',
        buscode:'',
        buslicence:'',
        busStopAreaId:''
      },
      isDisable:false,
      busStopAreaInfo2:{
        id: this.$store.state.busstop.busStopAreaId,
        name: this.$store.state.busstop.busStopAreaName
      },
      buttonlable:'扫描增加',
      canAdd:false,
      popupVisible: false,
      busid:''
    }
  },
  activated() {
      this.busStopAreaInfo2.id = this.$store.state.busstop.busStopAreaId;
      this.busStopAreaInfo2.name = this.$store.state.busstop.busStopAreaName;
      this.getBusStopList()
      this.getBusStopAreaInfo()
  },
  components: {
    commonHeader
  },
  methods: {
    removeBusInfo(val){
      this.isDisable=true
      this.api({
        url: "/busstopareainfo/updateBusStopAreaInfo",
        method: "post",
        data: {
          id:val,
          busStopAreaId:this.$store.state.busstop.busStopAreaId
        }
      }).then(data => {
        console.log(data);
        this.getBusStopList()
        this.getBusStopAreaInfo()
        this.canAdd=false;
      })
    },
    todetail() {
      this.$router.togo('/paiZhao')
    },

    getBusBybusid() {
      let _this= this;
      this.api({
        url: "/busmanager/getBusBybusid",
        method: "post",
        data: {
          busid:_this.busStopAreaInfo.buscode
        }
      }).then(data => {
          console.log(data)

        _this.busStopAreaInfo.buslicence=data.buslicensenum;
        _this.busStopAreaInfo.busStopAreaId=_this.$store.state.busstop.busStopAreaId
      })
    },
    showAdd() {
      if(this.canAdd){
        return;
      }
      this.busStopAreaInfo.id=''
      this.busStopAreaInfo.buslicence=''
      this.busStopAreaInfo.buscode=''
      this.popupVisible = true;
    },
    hiddenShare(){
      this.popupVisible = false;
    },
    getBusStopList(){
      this.api({
        url: "/busstopareainfo/listBusStopAreaInfoWeb",
        method: "get",
        params:{
          busStopAreaId:this.$store.state.busstop.busStopAreaId
        }
      }).then(data => {
        console.log(data);
        this.busStopAreaInfolist=data;
      })
    },
    //获取区域停车信息
    getBusStopAreaInfo(){
      let _this=this
      this.api({
        url: "/busstoparea/getBusStopAreaById",
        method: "get",
        params:{
          busStopAreaId:this.$store.state.busstop.busStopAreaId
        }
      }).then(data => {
        console.log(data);
        this.buttonlable='扫描增加('+data.remainStop+'/'+data.canStop+')'
        if(data.remainStop>=data.canStop){
            this.canAdd=true;
        }
        this.isDisable=false;
      })
    },

    insertBusAreaInfo(){
      let _this =this;
      if(this.busStopAreaInfo.buslicence){
        this.api({
          url: "/busstopareainfo/insertBusStopAreaInfo",
          method: "post",
          data:this.busStopAreaInfo
        }).then(data => {
          console.log(data);
          if(data){
            MessageBox.confirm('改车已停靠在其它区域，是否前往?').then(action => {
              _this.busStopAreaInfo2.busStopAreaId=data.busStopAreaId;
              _this.busStopAreaInfo2.busStopAreaName=data.busStopAreaName;
              _this.$store.commit("setBusStopAreaInfo",_this.busStopAreaInfo2);
              _this.hiddenShare()
              _this.getBusStopList();
              _this.getBusStopAreaInfo();

            });
          }
          _this.getBusStopList()
          _this.getBusStopAreaInfo()
          _this.hiddenShare()
        })
      }

    },
    testsaoma(){
      if(this.canAdd){
        return;
      }

      let _this=this;
      this.api({
        url: "/webchat/getSign",
        method: "get",
        params:{
          url:window.location.href.split('#')[0]
        }
      }).then(data => {
        console.log(data)
      })
    }
  },
  computed: {

  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
@import "~styles/index.less";
@import "~styles/variable.less";



.icon-tingchechang:before { content: "\e6ca"; }

.icon-chexing:before { content: "\e699"; }

.icon-qiche:before { content: "\e608"; }

.icon-you:before { content: "\e62f"; }

.icon-saoyisao:before { content: "\e604"; }

*{ margin: 0; padding: 0px;}
a{ text-decoration: none;}
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
  margin: 0 auto;
  margin-top: 1rem;
}


.scan-add{
  width:100%;
  margin: 0 auto;
  padding-top: 1rem;
  position: fixed;
  background: #fff;
  bottom: 0rem;
  padding-bottom: 23px;
}
.scan-add button{
  width: 100%;
  height: 2.5rem;
  background: #00a3ff;
  display: block;
  text-align: center;
  line-height: 2.5rem;
  border:none;
  border-radius: 5px;
  color: #fff;
  outline: medium;
  box-shadow: 0px 1px 8px 1px #8bcff5;
  font-size: 0.8rem;
  cursor: pointer;
}
.scan-add button:hover{
  background: #0c96e4;
  cursor: pointer;

}

.scan-icon{
  display: inline-block;
  color: #fff;
  font-size:0.9rem;
  margin-right: 0.4rem;
}
.parking-list{
  width: 100%;
  height:2.8rem;
  background: #fff;
  box-shadow:0px 0px 14px -2px #d5dff1;
  border:1px solid #eeeeee;
  border-radius: 8px;
  margin-bottom:0.5rem;
}
.parking-list-icon{
  float: left;
  width: 3rem;
  height: 3rem;
  display: inline-block;
  margin-right: 0.2rem;
  background-size: 96% 96%;
}
.parking-title{
  color: #000;
  font-size: 0.8rem;
  margin-top: 1rem;
  float: left;

}
.check-link-a{
  display: inline-block;
  width: 100%;
  height: 100%;
  outline: medium;
  float: left;
}
.comein-go{
  float: right;
  position: relative;
  right: 0.8rem;
  top:1.1rem;
}
.comein-go span{
  display: inline-block;
  float: left;
  font-size: 0.7rem;
  color: #256fd4;
}
.icon-you-right{
  float: right;
  color: #256fd4;
}

</style>
