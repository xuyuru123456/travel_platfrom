<template>
  <div style="background: aliceblue!important; ">
    <el-row style="padding: 10px 60px 0px 60px">
      <el-col :span="5"  :offset="1">
        <el-input placeholder="请输入关键词"v-model="input"clearable></el-input>
      </el-col>
      <el-col :span="5"  :offset="1">
        <el-select v-model="value" placeholder="请选择地区">
          <el-option
            v-for="item in options":key="item.value":label="item.label":value="item.value">
          </el-option>
        </el-select>
      </el-col>
    </el-row>
    <div style="padding-top: 50px;z-index: 2">
      <el-row style="background: #fff;margin: 10px 100px" v-for="(item,index) in list" :key="index" >
        <el-col :span="10"  :offset="0"  >
          <div style="padding: 20px 20px">
            <img :src="item.url"height="300px">
          </div>
        </el-col>
        <el-col :span="10" :offset="1"  >
          <div style="text-align: left; padding: 40px 0px;">
            <div class="fg">{{item.name}}</div>
            <div class="fg_1">景区等级：<span>{{item.level}}</span></div>
            <div class="fg_1">门票价格：<span>{{item.price}}</span></div>
            <div class="fg_1">开放时间:<span>{{item.time}}</span></div>
            <div class="fg_1">景区电话：<span>{{item.phone}}</span></div>
            <div class="fg_1">景区地址：<span>{{item.address}}</span></div>
          </div>
        </el-col>
        <el-col :span="6" :offset="1">

        </el-col>
      </el-row>
    </div>
    <div>1111111</div>
  </div>
</template>
<script>
    export default {
        data() {
            return {
              options: [{
                value: '选项1',
                label: '黄金糕'
              }, {
                value: '选项2',
                label: '双皮奶'
              }, {
                value: '选项3',
                label: '蚵仔煎'
              }, {
                value: '选项4',
                label: '龙须面'
              }, {
                value: '选项5',
                label: '北京烤鸭'
              }],
              value: '',

              list:[{
                name:'三坊七巷',
                level:'AAAAA',
                price:'水榭戏台、小黄楼:20人民币；严复故居、刘家大院:15人民币；谢家祠:5人民币',
                time:'全天(区域内小景点开放时间为8:30-17:00)',
                phone:'0591-87880350',
                address:'福建省福州市鼓楼区道山路附近',
                url:require('@/assets/scenicSpot/sfqx.jpeg')
              },
                {
                  name:'福州国家森林公园',
                  level:'AAAAA',
                  price:'公园门票免费，鸟语林门票25元/人',
                  time:'06:00-17:30 (1月1日-12月31日 周一-周日)',
                  phone:'0591-87951648',
                  address:'福建省福州市晋安区新店上赤桥',
                  url:require('@/assets/scenicSpot/slgy.jpeg')
                }]
            }
        }

    }
</script>
<style >
  .fg{
    font-size: 30px;
    color: #00a853;
    font-weight: 500;


  }
  .fg_1{
    font-size: 14px;
    color: #333333;
    padding-top: 20px;
  }
</style>
