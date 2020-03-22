import Vue from 'vue'
import VueRouter from 'vue-router'
import Context from '../components/Context'
import Main from '../components/Main'
import Kai from '../components/Kai'

//安装路由
Vue.use(VueRouter)

//配置导出路由
export  default new VueRouter({
  routes:[
    {
      //配置路径
      path:'/context',

      name:'context',
      //跳转的组件
      component:Context
    },
    {
      //配置路径
      path:'/main',

      name:'main',
      //跳转的组件
      component:Main
    },
    {
      //配置路径
      path:'/kai',

      name:'kai',
      //跳转的组件
      component:Kai
    }
  ]
})
