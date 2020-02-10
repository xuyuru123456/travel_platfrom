<template>
  <div>
    <el-container>
      <el-header class="header">
        <!--首页菜单栏-->
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect"
                 router="true" background-color="#fff"text-color="#000" active-text-color="#009944" >
          <!--ffd04b-->
          <el-menu-item index="/index" class="routerLink">首页
          </el-menu-item>
          <el-menu-item index="2">
            <span><router-link class="routerLink" to="/index" style="">美食</router-link></span>
          </el-menu-item>

          <el-menu-item index="3">
            <span><router-link class="routerLink" to="/index" style="">旅游攻略</router-link></span>
          </el-menu-item>
          <el-menu-item index="/scenicSpot/scenicSpot" class="routerLink">热门景点
          </el-menu-item>
          <el-menu-item index="5">
            <span><router-link class="routerLink" to="/index" style="">各地特产</router-link></span>
          </el-menu-item>
          <el-submenu index="6" style="float: right">
            <template slot="title">
            <span ><router-link class="routerLink1" to="/index" style="">
                   <el-image style="width: 30px; height:30px;border-radius: 30px":src="url"></el-image>
            </router-link></span>
            </template>
            <el-menu-item index="6-1" >
              <span><router-link class="routerLink1" to="/index" style="">写攻略</router-link></span>
              </el-menu-item>
            <el-menu-item index="6-2">
              <span><router-link class="routerLink1" to="/index" style="">我的收藏</router-link></span>
              </el-menu-item>
            <el-menu-item index="6-3">
              <span><router-link class="routerLink1" to="/index" style="">退出</router-link></span>
              </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-header>
      <el-main class = main>
        <!--<el-row :span="6"><span v-if="trueAndFalse" class="el-dropdown-link userinfo-inner font2">{{userName}}</span></el-row>-->
        <!--<information ref="information" :visible.sync="informationCheck"></information>-->
        <transition name="fade" mode="out-in">
          <router-view></router-view>
        </transition>
      </el-main>
    </el-container>

  </div>

</template>
<script>

    export default {
      data () {
        return {
          activeIndex: '1',
          trueAndFalse:'',
          url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
        }
      },
      mounted:function(){

      },
      methods:{
        handleSelect(key, keyPath) {
          console.log(key, keyPath);
        },

      }
    }
</script>
<style>
  .routerLink{
    text-decoration: none;
    color: white;
    font-weight: bold;
    font-size: 15px;
    margin:5px;
  }
  .routerLink1{
    text-decoration: none;
    color: darkgray!important;
    font-size: 10px;
    margin:10px;
  }
  .header {
    padding: 0;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    -ms-flex-negative: 0;
    flex-shrink: 0;
    height: 60px!important;
  }
  .el-menu--horizontal>.el-menu-item.is-active {
    border-bottom: 5px solid #409EFF;
    color: #303133;
    height: 60px;
  }

  .main {
    display: block;
    -webkit-box-flex: 1;
    -ms-flex: 1;
    flex: 1;
    -ms-flex-preferred-size: auto;
    flex-basis: auto;
    overflow: auto;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    padding: 20px 0px 20px 0px;
  }
</style>
