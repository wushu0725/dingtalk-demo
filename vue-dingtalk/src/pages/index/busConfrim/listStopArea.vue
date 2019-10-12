<template>
  <div>
  <br>
    <br>
    <br>
    <br>
        <mt-cell v-for="item in busStopArealist" :key="item.id" :title="item.name+'('+item.remainStop+'/'+item.canStop+')'" is-link>
          <mt-button type="danger" @click="busConfrimArea(item.id,item.name)">进入</mt-button>
        </mt-cell>
  </div>
</template>

<script>
import {mapMutations, mapGetters, mapState} from 'vuex'



export default {
  data () {
    return {
      busStopArealist:[],
      busStopAreaInfo:{
        busStopAreaId: '',
        busStopAreaName: ''
      }
    }
  },
  activated() {
      this.getBusStopList()
  },
  components: {
    commonHeader
  },
  methods: {
    busConfrimArea(val,name){
      this.busStopAreaInfo.busStopAreaId=val;
      this.busStopAreaInfo.busStopAreaName=name;
      this.$store.commit("setBusStopAreaInfo",this.busStopAreaInfo);
      this.$router.push('busConfrimAreaInfo');
    },
    getBusStopList(){
      this.api({
        url: "/busstoparea/listBusStopAreaWeb",
        method: "get",
        params:{
          busStopId:this.$store.state.busstop.busStopId
        }
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
</style>
