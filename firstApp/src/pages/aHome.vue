<template>
  <div>
    <el-container class="container">
      <el-aside class=aside width="15%">
        <el-row class="tac">
          <el-menu
            default-active="2"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            background-color="#674a2d"
            text-color="#fff"
            active-text-color="#fff"
            router="true">
            <el-menu-item>
              <span  @click="changeTrueOrFalse('0')"><router-link class="routerLink" to="/aIndex" style="font-size:22px;margin-left:26px;">首页</router-link></span>
            </el-menu-item>
            <el-menu-item>
              <span  @click="changeTrueOrFalse('0')"><router-link class="routerLink" to="/Index" style="font-size:18px;margin-left:26px;">返回网站</router-link></span>
            </el-menu-item>
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>景点管理</span>
              </template>
              <el-menu-item-group>
                <!--<div id="dishsAdd">-->
                  <el-menu-item>
                    <span  @click="changeTrueOrFalse('0')"><router-link class="routerLink" to="/scenicSpot/addScencSpot" >景点添加</router-link></span>
                  </el-menu-item>
                <!--</div>-->
                <el-menu-item>
                  <span  @click="changeTrueOrFalse('0')"><router-link class="routerLink" to="/Dishs/queryDishs" >景点列表</router-link></span>
                </el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-menu"></i>
                <span >美食管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item>
                <span  @click="changeTrueOrFalse('0')"><router-link class="routerLink" to="/Dishs/addDishs" >美食添加</router-link></span>
                </el-menu-item>
                <el-menu-item>
                  <span  @click="changeTrueOrFalse('0')"><router-link class="routerLink" to="/Menu/queryMenu" >美食列表</router-link></span>
                </el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="3">
              <template slot="title">
                <i class="el-icon-document"></i>
                <span>特产管理</span>
              </template>
              <el-menu-item-group index="3">
                <!--<div id="deskAdd">-->
                  <el-menu-item>
                    <span  @click="changeTrueOrFalse('0')"><router-link class="routerLink" to="/Desk/addDesk" >添加特产</router-link></span>
                  </el-menu-item>
                <!--</div>-->
                <el-menu-item>
                  <span  @click="changeTrueOrFalse('0')"><router-link class="routerLink" to="/Desk/queryDesk" >特产列表</router-link></span>
                </el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="4">
              <template slot="title">
                <i class="el-icon-edit-outline"></i>
                <span>攻略管理</span>
              </template>
              <el-menu-item-group index="3">
                <el-menu-item>
                  <span  @click="changeTrueOrFalse('0')"><router-link class="routerLink" to="/History/queryHistory" >添加攻略</router-link></span>
                </el-menu-item>
                <el-menu-item>
                  <span  @click="changeTrueOrFalse('0')"><router-link class="routerLink" to="/History/queryHistory" >攻略列表</router-link></span>
                </el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <!--<div id ="isRoot">-->
              <el-submenu index="5">
                <template slot="title">
                  <i class="el-icon-setting"></i>
                  <span>用户管理</span>
                </template>
                <el-menu-item-group index="3">
                  <el-menu-item>
                    <span  @click="changeTrueOrFalse('0')"><router-link class="routerLink" to="/User/addUser" >用户添加</router-link></span>
                  </el-menu-item>
                  <el-menu-item>
                    <span  @click="changeTrueOrFalse('0')"><router-link class="routerLink" to="/User/queryUser" >用户列表</router-link></span>
                  </el-menu-item>
                </el-menu-item-group>
              </el-submenu>
            <!--</div>-->
          </el-menu>
        </el-row>
      </el-aside>
      <el-container>
        <span id = "showInfo" style="background: #ffffff; position: absolute; left: 1045px; top: 49px;z-index:10000;" class="titleOrgBg11">
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
              <span  style="color:#FFFFFF" @mouseenter="enter()" @mouseleave="leave()">{{this.Name}}</span>
            </a>
          </template>
          <el-button   @click="toLogin()" round="10"style="width:6%;margin-right: -80%;text-align: center;">退出</el-button>
        </el-header>
        <el-main class = main>
          <el-row :span="6"><span v-if="trueAndFalse" class="el-dropdown-link userinfo-inner font2">{{userName}}</span></el-row>
          <information ref="information" :visible.sync="informationCheck"></information>
          <transition name="fade" mode="out-in">
            <router-view></router-view>
          </transition>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script>
  import axios from 'axios'
  import Message from "element-ui/packages/message/src/main";
  export default {
    data() {
      return {
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
      this.Name =sessionStorage.getItem("LoginName");
      this.systemName =sessionStorage.getItem("userRoot");
    },
    mounted:function(){
      var aa= document.getElementById('showInfo');
      aa.style.display="none";
      this.loadUserInfo();

      if( this.Name == 'manager'){
      }else{
        var aa= document.getElementById('isRoot');
        aa.style.display= "none";
        var bb= document.getElementById('dishsAdd');
        bb.style.display= "none";
        var cc= document.getElementById('deskAdd');
        cc.style.display= "none";
      }
    },
    methods: {
      saveSysInfo(){
        let form = new FormData();
        form.append("name", this.sysName);
        form.append("phone", this.sysuserPhone);
        form.append("email", this.sysuserEmail);
        alert(this.sysName)
        alert(this.sysuserPhone)
        alert(this.sysuserEmail)
        // axios.put("http://localhost:8084/dishs",form ,{
        //   "Content-Type": "multipart/form-data"
        // }).then(function(res){
        //   if (res.data.code == 0) {
        //     Message({
        //       showClose: true,
        //       message: "修改成功",
        //       type: "success"
        //     });
        //   } else {
        //     Message({
        //       showClose: true,
        //       message: "失败:" + res.data.data,
        //       type: "error"
        //     });
        //   }
        // });
      },
      loadUserInfo(){
        var account = this.Name;
        console.log('1111')
        axios.get("http://localhost:8084/user/info/" + account)
          .then((response) => {
            const resDate = response.data;
            console.log(resDate.data)
            if (resDate.code == '0') {
              this.sysuserName=resDate.data.account;
              this.sysName=resDate.data.name;
              this.sysuserPhone=resDate.data.phone;
              this.sysuserEmail=resDate.data.email;
            } else {
              this.$message({
                showClose: true,
                message: "删除失败",
                type: 'error'
              });
            }
          })
      },
      enter(){
        var aa= document.getElementById('showInfo');
        aa.style.display="block";
      },
      leave(){
        var aa= document.getElementById('showInfo');
        aa.style.display="none";
      },
      toLogin(){
        this.$confirm('是否注销?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          sessionStorage.removeItem('LoginName');
          sessionStorage.removeItem('userRoot');
          this.$router.push({ path: '/login' });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '取消此操作'
          });
        });
      },
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      changeTrueOrFalse(index){
        if(index == '1'){
          this.trueAndFalse = true;
        }else{
          this.trueAndFalse = false;
        }
      }
    }
  }
</script>

<style>

  /*body{*/
  /*background: url('../assets/homeImage.jpg')  no-repeat ;*/
  /**/
  /*width: 70%;*/
  /*height:90%;*/
  /*}*/
  .titleOrgBg11{
    width:260px;
    height: 220px;
    margin: 15px 5px 10px 0;
    border-radius:8px 8px 8px 8px;
  }
  .introa{
    display: none;
  }
  a{
    text-decoration:none;
    cursor: pointer;
  }
  .container {
    position: absolute;
    top: 0;
    bottom: 0;
    width: 100%;
    left: 0px;
    background-color:#ebe4d2;
  }
  .headerMain{

    background-color:maroon;
    color: #fff;
    text-align: center;
    line-height: 60px;
    padding: 0;
  }
  .header{
    background-color:#bfab78;
    color: #fff;
    text-align: center;
    line-height: 60px;
    padding: 0;

  }
  .userinfo-inner{
    color: red;
    cursor: pointer;
  }
  .system-name{

    font-size: large;
    font-weight: bold;
  }
  .icon{
    font-size: 20px;
  }

  .routerLink{
    text-decoration: none;
    color: white;
    font-weight: bold;
  }
  .aside{
    background-color: #bfab78;
    width: 600px;
  }
  .header-title{
    text-align: left;
  }
  .tac{
    top: 10%;
  }
</style>
