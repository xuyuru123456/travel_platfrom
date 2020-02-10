<template>
  <div class="bj">
    <!--轮播图-->
    <div  class="block">
      <el-carousel  height="500px" >
         <el-carousel-item v-for="item in imagesbox" :key="item.id">
           <img :src="item.idView" class="image1">
         </el-carousel-item>
        <div style="position: absolute;right:20px;bottom: 80px">
          <el-input placeholder="找什么？输入关键词试试" style="width: 400px;z-index: 2" >
            <el-button slot="append" icon="el-icon-search"></el-button>
          </el-input>
        </div>
      </el-carousel>


    </div>
    <!--探秘福建-->
    <div style="padding: 20px">
      <div style="padding-bottom: 20px">
        <img src="../assets/index/fj_title.png" class="food_title">
      </div>
      <div style="text-align: left;font-size: 26px;margin: 0px 20px">
        <p>&nbsp;&nbsp;&nbsp;&nbsp;福建省，简称“闽”，是中华人民共和国省级行政区。省会福州，位于中国东南沿海，东北与浙江省毗邻，西北与江西省接界，西南与广东省相连，东南隔台湾海峡与台湾省相望，福建省陆地总面积12.14万平方千米。
          福建地势呈“依山傍海”态势，地势西北高，东南低，境内山地、丘陵面积约占全省总面积的90%；地跨闽江、晋江、九龙江、汀江四大水系，属亚热带海洋性季风气候。
          福建省下辖福州、厦门、泉州、漳州、莆田、龙岩、三明、南平...<span style="color:#ffd04b ">[查看详细]</span></p>
      </div>
      <el-row>
        <el-col :span="5" v-for="(item, index) in fj" :key="index" :offset="item.jl">
            <img :src="item.icon" class="image">
            <div class="hz">
              {{item.city}}
            </div>
        </el-col>
      </el-row>
    </div>
    <!--推荐美食-->
    <div style="padding: 20px">
      <div style="padding-bottom: 20px">
        <img src="../assets/index/food_title.png" class="food_title">
      </div>
      <el-row>
        <el-col :span="5" v-for="(item, index) in food" :key="index" :offset="item.jl">
          <el-card :body-style="{ padding: '0px'}" style="border-radius: 20px;">
            <img :src="item.icon" class="image">
            <div style="padding: 14px;">
              <span style="font-weight: 700">{{item.text}}</span>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </div>
    <!--热门景点-->
    <div style="padding: 20px">
      <div style="padding-bottom: 20px">
        <img src="../assets/index/beauty_title.png" class="food_title">
      </div>
    </div>
      <div style="margin-top: 500px">111</div>

  </div>

</template>
<script>
  export default {
    data(){
      return {
        imagesbox:[{
          id:0,
          idView:require("../assets/luobo/1.png")},
          {
            id:1,
            idView:require("../assets/luobo/2.png")},
          {
            id:2,
            idView:require("../assets/luobo/4.png")},
          ],
        fj:[{
          jl:'0',
          icon:require("../assets/index/qz.jpeg"),
          city:'泉州市'
        },{
          jl:'1',
          icon:require("../assets/index/fz.jpeg"),
          city:'福州市'
        },{
          jl:'2',
          icon:require("../assets/index/xm.jpeg"),
          city:'厦门市'
        },{
          jl:'1',
          icon:require("../assets/index/yd.jpeg"),
          city:'永定市'
        }],
        food:[{
          jl:'0',
          icon:require("../assets/index/yhyw.jpeg"),
          text:'永和鱼丸（福州南后街店）'
        },{
          jl:'1',
          icon:require("../assets/index/rw.jpeg"),
          text:'木金肉丸老铺(福州南后街店)'
        },{
          jl:'2',
          icon:require("../assets/index/hst.jpeg"),
          text:'黄则和花生汤店(厦门中山路店)'
        },{
          jl:'1',
          icon:require("../assets/index/qtf.jpeg"),
          text:'龙岩老大众清汤粉(中山路步行街)'
        }],
          currentDate: new Date(),
      }
    },
    created:function() {

    },
    methods: {

    }
  }
</script>
<style>
  .image1{
    background-size:100%;
    /*height: 100%;*/
    width: 100%;
  }
  .food_title{
    background-size:100%;
    /*height: 100%;*/
    width: 100%;
  }
  .bj{
    /*background: url('../assets/bj.jpg')  no-repeat ;*/
    background: aliceblue;
    /*background-size:100% 100%;*/
    /*width: 98%;*/
    /*height:100%;*/
  }
  .image {
    width: 100%;
    display: block;
  }
  .hz{
    width: 130px;
    height: 65px;
    line-height: 55px;
    background: url('../assets/index/di.png')  no-repeat ;
    background-size: 100%;
    position: absolute;
    bottom: 20px;
    text-align: center;
    font-size: 20px;
  }
</style>
