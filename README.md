#    项目模块 博客地址 https://blog.csdn.net/shrek11/article/details/102531220
##  项目引用了我之前的项目，只是整合了钉钉模块的东西
 一共分3个项目
 * dingtalk                 项目后端接口  
      主要框架技术用了我之前的框架  技术栈  springboot+mybatis+shire  采用RESTFULL风格
 * dingtalk-backpage        项目管理后台页面
      技术栈   vue+element      从git上找的开源VEU后台页面改的
 * vue-dingtalk             项目钉钉端页面
      技术栈   vue        

##  项目搭建
 1，前端开发需要 nodejs 框架，先安装node <br/>
 2，cnpm安装 镜像指向阿里，自己百度 <br/>
 3，下载源码如下<br/>
      ![](https://github.com/wushu0725/dingtalk-demo/blob/master/doc/img/211.png)
 4，新建数据库，并执行dingtalk项目下resource/database下的SQL文件 <br/>
 5，钉钉下新建应用，并把相关配置参数设置到com.shrek.example.util.constants.DingTalkConstant文件中 <br/>
![](https://github.com/wushu0725/dingtalk-demo/blob/master/doc/img/1234.png)<br/>
![](https://github.com/wushu0725/dingtalk-demo/blob/master/doc/img/4323.png)<br/>
 6, 启动后端<br/>
 7，启动后端页面 http://127.0.0.1:9520
   * cnpm install
   * npm run dev
   * npm run build<br/>
 8，钉钉端    http://127.0.0.1:8088
   * cnpm install
   * npm run dev
   * npm run build
    打包放服务器，即前面H5微应用配置的域名服务器。<br/>
 9，开发时用Nodejs代理，上生产服务器用nginx代理<br/>
 ![](https://github.com/wushu0725/dingtalk-demo/blob/master/doc/img/3321.png)<br/>
 ![](https://github.com/wushu0725/dingtalk-demo/blob/master/doc/img/5555.png)<br/>

最后效果如下：
![](https://github.com/wushu0725/dingtalk-demo/blob/master/doc/img/1212.jpg)<br/>
![](https://github.com/wushu0725/dingtalk-demo/blob/master/doc/img/6666.png)<br/>
