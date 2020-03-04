<template>
  <div>
    <el-container>
      <span id = "showInfo" style="display:none;background: #ffffff; position: absolute; left: 1045px; top: 49px;z-index:10000;" class="titleOrgBg11">
        <template>
          <div>
              <div  style="float:left;">
                <div style = "margin-top:30px;margin-left: 30px;font-size: 5px;">
                  <span class="ordsum">用户名：</span>
                  <span style="font-weight:bold;"><el-input  style="width:170px;height: 1px;" v-html="sysuserName"></el-input></span>
                </div>
                <div style = "margin-top:30px;margin-left: 30px;font-size: 5px;">
                  <span class="ordsum">姓名：&nbsp;&nbsp;&nbsp;</span>
                  <span style="font-weight:bold;"><el-input  style="width:170px;height: 10px;" v-html="sysName"></el-input></span>
                </div>
                <div style = "margin-top:30px;margin-left: 30px;font-size: 5px;">
                  <span class="ordsum">电话：&nbsp;&nbsp;&nbsp;</span>
                  <span style="font-weight:bold;"><el-input  style="width:170px;height: 10px;" v-html="sysuserPhone"></el-input></span>
                </div>
                <div style = "margin-top:30px;margin-left: 30px;font-size: 5px;">
                  <span class="ordsum">邮箱：&nbsp;&nbsp;&nbsp;</span>
                  <span style="font-weight:bold;"><el-input  style="width:170px;height: 10px;" v-html="sysuserEmail"></el-input></span>
                </div>
                <!--<div style="clear:both; padding-top:20px;padding-left:50px;">-->
                <!--<span><el-button type="primary"  @click="saveSysInfo()" style="width: 120px;margin-left:15px;">修改</el-button></span>-->
                <!--</div>-->
          </div>
          </div>
        </template>
        </span>
    <el-header class = header height="10%">
      <div style="height: 5%;width: 20%;margin-left: -17%">
        <span style="color:#FFFFFF;;font-weight: bold">{{systemName}}</span>
      </div>

      <template style="margin-right: -50%">
        <a>
          <i class="el-icon-news" ></i>
          <!--<span  style="color:#FFFFFF" @mouseenter="enter()" @mouseleave="leave()">{{this.Name}}</span>-->
        </a>
      </template>
      <el-button   @click="toLogin()" round="10"style="width:6%;margin-right: -80%;text-align: center;">退出</el-button>
    </el-header>
    <el-container class="container">
      <el-aside width="" >
        <el-row class="tac">
          <el-button type="primary" @click="changmenu" style="margin-top: 10px;margin-bottom: 10px;"><i class="el-icon-menu"></i></el-button>
      <!--<el-radio-group v-model="isCollapse" style="margin-top: 10px;margin-bottom: 10px;">-->
        <!--<el-radio-button :label="false" v-if="zhakai" @click="zhankai">展开</el-radio-button>-->
        <!--<el-radio-button :label="true" v-if="shouqi" @click="shouqi">收起</el-radio-button>-->
      <!--</el-radio-group>-->
      <el-menu default-active="1-4-1" class="el-menu-vertical-demo"
               @open="handleOpen" @close="handleClose" :collapse="isCollapse"
               @select="handleSelect"background-color="#545c64"
               text-color="#fff"
               active-text-color="#ffd04b"
               router="true">
        <el-menu-item index="/Index">
          <i class="el-icon-bell"></i>
          <span slot="title">首页</span>
        </el-menu-item>
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span slot="title">药品管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="/drugs/addDrugs">新增药品</el-menu-item>
            <el-menu-item index="/drugs/drugsList">药品列表</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-menu"></i>
            <span slot="title">医疗器材</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="/medicalEquipment/addME">新增医疗器材</el-menu-item>
            <el-menu-item index="/medicalEquipment/queryME">医疗器材</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-submenu index="3">
          <template slot="title">
            <i class="el-icon-document"></i>
            <span slot="title">就诊记录</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="/record/addRecord">新增就诊</el-menu-item>
            <el-menu-item index="/record/recordList">就诊记录</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-menu-item index="/pneumonia/pneumonia">
          <i class="el-icon-view"></i>
          <span slot="title">疫情状况</span>
        </el-menu-item>
        <el-menu-item index="/tockPurchase/sellList">
          <i class="el-icon-goods"></i>
          <span slot="title">进货管理</span>
        </el-menu-item>
        <el-menu-item index="/user/userList">
          <i class="el-icon-news"></i>
          <span slot="title">用户管理</span>
        </el-menu-item>
      </el-menu>
        </el-row>
      </el-aside>
      <el-main class = main>
        <!--<el-row :span="6"><span v-if="trueAndFalse" class="el-dropdown-link userinfo-inner font2">{{userName}}</span></el-row>-->
        <!--<information ref="information" :visible.sync="informationCheck"></information>-->
        <transition name="fade" mode="out-in">
          <router-view></router-view>
        </transition>
      </el-main>
    </el-container>
    </el-container>
  </div>

</template>
<script>
  var a=0;
    export default {
      data () {
        return {
          isCollapse: true,
          userName:'111111',
          sysuserName:'',
          sysName:'',
          sysuserPhone:'',
          sysuserEmail:'',
          systemName:'',
          userName:'',
          Name:''
        }
      },
      created:function() {
      },
      mounted:function(){
        var aa= document.getElementById('showInfo');
        aa.style.display="none";
      },
      methods:{
        changmenu(){//菜单栏的展开和折叠
          if(a==1) {
            this.isCollapse = true
            a = 0;
          }else if(a==0){
            this.isCollapse = false
            a = 1;
          }
        },
        handleSelect(key, keyPath) {
          console.log(key, keyPath);
        },
        handleOpen(key, keyPath) {
          console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
          console.log(key, keyPath);
        }
      }
    }
</script>
<style scoped>
  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 400px;
  }
  .titleOrgBg11{
    width:260px;
    height: 220px;
    margin: 15px 5px 10px 0;
    border-radius:8px 8px 8px 8px;
  }
  .container {
    position: absolute;
    top: 10%;
    bottom: 0;
    width: 99%;
    left: 1%;
    /*background-color:#ebe4d2;*/
  }
  .header{
    background-color:#545c64;
    color: #fff;
    text-align: center;
    line-height: 60px;
    padding: 0;

  }
  aside{
     /*background-color: #545c64;*/
     /*width: 300px;*/
  }

  .routerLink{
    text-decoration: none;
    color: white;
    font-weight: bold;
  }
</style>
