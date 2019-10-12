<template>
  <div>
    <br>
    <br>
    <br>
    <br>
        <mt-cell v-for="item in busStoplist" :key="item.id" :title="item.name+'('+item.remainStopSum+'/'+item.canStopSum+')'" is-link>
          <mt-button type="danger" @click="busConfrim(item.id,item.name)">进入</mt-button>
        </mt-cell>
  </div>
</template>

<script>
import {mapMutations, mapGetters, mapState} from 'vuex'



export default {
  data () {
    return {
      tittle: '停车确认(在停/可停)',
      num: 0,
      busStoplist:[],
      busStopInfo:{
        busStopId: '',
        busStopName: ''
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
    ...mapMutations({
      setNum: 'SET_NUM'
    }),
    busConfrim(val,stopname){
      this.busStopInfo.busStopId=val;
      this.busStopInfo.busStopName=stopname;
      this.$store.commit("setBusStopInfo",this.busStopInfo);
      this.$router.push('busConfrimArea')

    },
    todetail() {
      this.$router.togo('/paiZhao')
    },
    getBusStopList(){
      this.api({
        url: "/busstop/listBusStopWeb",
        method: "get"
      }).then(data => {
        console.log(data);
        this.busStoplist=data;
      })
    }
  },
  computed: {
    ...mapGetters([
      'number'
    ]),
    ...mapState({
      number: state => state.home.number
    })
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
