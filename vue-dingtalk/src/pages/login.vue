<template>
    <div class="page-group" style="margin-top: 195px;">
      <div class="xinfuli-logo">
        <ve-histogram :data="chartData" :settings="chartSettings"></ve-histogram>
        <mt-button @click.native="handleClick">按钮</mt-button>
      </div>
  </div>
</template>

<script>
  import { MessageBox } from 'mint-ui'

  export default {
    name: 'page-field',
    data () {
      this.chartSettings = {
        axisSite: { right: ['下单率'] },
        yAxisType: ['KMB', 'percent'],
        yAxisName: ['数值', '比率']
      }
      return {
        loginForm:{
          username:'',
          password:'loginByWorkNo'
        },
        chartData: {
          columns: ['日期', '访问用户', '下单用户', '下单率'],
          rows: [
            { '日期': '1/1', '访问用户': 1393, '下单用户': 1093, '下单率': 0.32 },
            { '日期': '1/2', '访问用户': 3530, '下单用户': 3230, '下单率': 0.26 },
            { '日期': '1/3', '访问用户': 2923, '下单用户': 2623, '下单率': 0.76 },
            { '日期': '1/4', '访问用户': 1723, '下单用户': 1423, '下单率': 0.49 },
            { '日期': '1/5', '访问用户': 3792, '下单用户': 3492, '下单率': 0.323 },
            { '日期': '1/6', '访问用户': 4593, '下单用户': 4293, '下单率': 0.78 }
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
          url: "/reportTest/test",
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
