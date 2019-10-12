<template>
  <div class="app-container" style="margin-top: 195px;">
    <userlist v-bind:userlist-metas="meta.userlistMetas" v-bind:corp-id="corpId"></userlist>
  </div>
</template>

<script>
  import banner from './components/index-banner.vue';
  import applist from './components/index-applist.vue';
  import item from './components/index-item.vue';
  import admin from './components/index-admin.vue';
  import userlist from './components/index-userlist.vue';
  import appmanager from './components/index-appManager.vue';



  export default {
    name: 'home',
    components: {
      banner: banner,
      applist: applist,
      item: item,
      admin: admin,
      userlist: userlist,
      appmanager: appmanager
    },
    data: function () {
      return {
        openAppManager: false,
        corpId: '',
        userId: '',
        meta: {
          admin: false,
          bannerMetas: {
            homeBannerModels: [{
              "linkUrl": "https://alimarket.m.taobao.com/markets/dingtalk/cydd?lwfrom=20161118115327653",
              "imgUrl": "https://gw.alicdn.com/tps/TB1o8BqOpXXXXanXVXXXXXXXXXX-750-300.png"
            }],
            isHomeBannerModels: true
          },
          itemMetas: {
            act: '',
            isAdminOrBoos: false,
            attendanceUrl: '',
            myTasksUrl: '',
            checkinsUrl: '',
            notReadReportUrl: '',
            isHomeHeaderModel: true
          },
          userlistMetas: {
            homeGroups: [
              {
                "id": 50,
                "groupName": "门店运营",
                "homeGroupDetail": [
                  {
                    "id": 151,
                    "url": "https://landray.dingtalkapps.com/alid/app/report/createReport_new.html?showmenu=false&dd_share=false&swfrom=work_homepage&id=158b457eea778023c59114c439eb80e9&corpid=ding68942498a5cd785e35c2f4657eb6378f",
                    "imgPath": "https://landray.dingtalkapps.com/alid/app/report/images/ico-png/25.png",
                    "nativeid": 2,
                    "appType": 1,
                    "title": "营业日报"
                  },
                  {
                    "id": 152,
                    "url": "https://landray.dingtalkapps.com/alid/app/report/createReport_new.html?showmenu=false&dd_share=false&swfrom=work_homepage&id=158b457eea778023c59114c439eb80e9&corpid=ding68942498a5cd785e35c2f4657eb6378f",
                    "imgPath": "https://landray.dingtalkapps.com/alid/app/report/images/ico-png/25.png",
                    "nativeid": 2,
                    "appType": 1,
                    "title": "海典报表"
                  }
                ],
                "departmentIds": [],
                "staffIds": []
              }
            ],
            renderLine: 0,
            isHomeGroups: true
          },
          userInfo: {

          }
        }
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
  .app-container{
    width: 100%;
    height: 100%;
    overflow: hidden;
    overflow-y: scroll;
  }
</style>
