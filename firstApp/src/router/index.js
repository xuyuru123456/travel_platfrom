import Vue from 'vue'
import Router from 'vue-router'
import Home from  '../pages/Home'
import aHome from  '../pages/aHome'
import Index from '../pages/Index'
import addScencSpot from '../pages/scenicSpot/addScencSpot'
import { Script } from 'vm';
import scenicSpot from "../pages/scenicSpot/scenicSpot";
import aIndex from "../pages/aIndex";
Vue.use(Router)

let router = new Router({
  routes: [

    // {
    //   path: '/',
    //   name: 'Login',
    //   component: Login
    // },
    // {
    //   path: '/login',
    //   name: 'Login1',
    //   component: Login
    // },
    // {
    //   path: '/register',
    //   name: 'Register',
    //   component: Register
    // },
    {
      path: '/',
      name: 'Home',
      component: Home
    },{
      path: '/Home',
      name: 'Home',
      component: Home,
      children: [
        {path: '/Index',   component: Index},
        {path: '/scenicSpot/scenicSpot',   component: scenicSpot},
      ]
    },{
      path: '/aHome',
      name: 'aHome',
      component: aHome
    },{
      path: '/aHome',
      name: 'aHome',
      component: aHome,
      children: [
        {path: '/aIndex',   component: aIndex},
        {path: '/scenicSpot/addScencSpot',   component: addScencSpot},
      ]
    }]
})
export default router;
// export default new Router({
//   mode:'history',
//   routes: [
//     {
//       path: '/',
//       name: 'Home',
//       component: Home,
//       children: [
//
//       ]
//     },
//   ]
// })
