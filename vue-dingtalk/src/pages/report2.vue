<template>
    <div class="page-group" style="margin-top: 195px;">
      <div class="xinfuli-logo">
        <ve-histogram :data="chartData" :settings="chartSettings"></ve-histogram>
        <mt-button @click.native="handleClick">查询</mt-button>
      </div>
  </div>
</template>

<script>
  import { MessageBox } from 'mint-ui'

  export default {
    name: 'page-field',
    data () {
      this.chartSettings = {
//        axisSite: { right: ['下单率'] },
//        yAxisType: ['KMB', 'percent'],
//        yAxisName: ['数值', '比率']
      }
      return {
        chartData: {
          columns: ['月份', '销售额'],
          rows: [
          ]
        }
      }
    },
    methods: {
      login() {
        let _this=this;

      },
      handleClick(){
        let _this=this;
        this.api({
          url: "/reportTest/test2",
          method: "get",
          data:{}
        }).then(data => {
          console.log(data);
          this.chartData.rows=data;
        })
      }
    }
  };
</script>
<style>


</style>
