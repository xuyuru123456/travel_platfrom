import Vue from 'vue'
import Router from 'vue-router'
import Home from  '../pages/Home'
import { Script } from 'vm';
import Index from "../pages/Index";
import Login from "../pages/Login";
import register from "../pages/register";
import pneumonia from "../pages/pneumonia/pneumonia";
import addDrugs from "../pages/drugs/addDrugs";
import drugsList from "../pages/drugs/drugsList";
import drugsDetail from "../pages/drugs/drugsDetail";
import addME from "../pages/medicalEquipment/addME";
import addRecord from "../pages/record/addRecord";
import sellList from "../pages/tockPurchase/sellList";
import queryME from "../pages/medicalEquipment/queryME";
import userList from "../pages/user/userList";
import recordList from "../pages/record/recordList";
Vue.use(Router)
let router = new Router({
  routes: [

    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'register',
      component: register
    },{
      path: '/Home',
      name: 'Home',
      component: Home
    },{
      path: '/Home',
      name: 'Home',
      component: Home,
      children: [
        {path: '/Index',   component: Index},
        {path: '/drugs/addDrugs',   component: addDrugs},
        {path: '/drugs/drugsList',   component: drugsList},
        {path: '/drugs/drugsDetail',   component: drugsDetail},
        {path: '/tockPurchase/sellList',   component: sellList},

        {path: '/medicalEquipment/addME',   component: addME},
        {path: '/medicalEquipment/queryME',   component: queryME},

        {path: '/record/addRecord',   component: addRecord},
        {path: '/record/recordList',   component: recordList},
        {path: '/pneumonia/pneumonia',   component: pneumonia},
        {path: '/user/userList',   component: userList},
      ]
    }]
})
export default router;

// export default new Router({
//   routes: [
//     {
//       path: '/',
//       name: 'HelloWorld',
//       component: HelloWorld
//     }
//   ]
// })
