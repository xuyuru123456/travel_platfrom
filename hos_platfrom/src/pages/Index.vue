<template>
  <div>
    <img :src="url" style="width: 100%;height: 100%">
    <!--<div  style="background: #ffffff;margin-left:13%;margin-top:40px;" class="titleOrgBg1">-->
      <!--<div style="font-family: 'Adobe 黑体 Std R';font-size: 25px;margin-top: 30px;">-->
        <!--<span>当前系统时间是：</span>-->
        <!--<span id="show"></span>-->
        <!--<div style="margin-top:80px;">欢迎使用闽游通后台管理系统</div>-->
      <!--</div>-->
    <!--</div>-->
    <!--<div style="clear:both;padding-top:144px;">-->
      <!--@版权所有，请勿盗版，违者必究-->
    <!--</div>-->
    <el-row>
      <el-col :span="12">
        <div class="bt">新冠肺炎疫情防疫知识</div>
        <el-tabs v-model="activeName" type="card" @tab-click="handleClick" >
          <el-tab-pane label="全部" name="first" style="text-align: left">
            <div v-for="(item,index) in all" :key="index" style="padding-left: 20px">
              <div style="padding: 10px 0px"><span style="color:#000;">●</span>{{item.name}}</div>
              <el-button size="small" @click="openWin(item.url)" :class="item.clas">{{item.type}}</el-button>
            </div>
          </el-tab-pane>
          <el-tab-pane label="症状表现" name="second"style="text-align: left">
            <div v-for="(item,index) in zz" :key="index" style="padding-left: 20px">
              <div style="padding: 10px 0px">{{item.name}}</div>
              <el-button size="small" @click="openWin(item.url)":class="item.clas">{{item.type}}</el-button>
            </div>
          </el-tab-pane>
          <el-tab-pane label="如何预防" name="third"style="text-align: left">
            <div v-for="(item,index) in yf" :key="index" style="padding-left: 20px">
              <div style="padding: 10px 0px">{{item.name}}</div>
              <el-button size="small" @click="openWin(item.url)":class="item.clas">{{item.type}}</el-button>
            </div>
          </el-tab-pane>
          <el-tab-pane label="防疫焦点" name="fourth"style="text-align: left">
            <div v-for="(item,index) in jd" :key="index" style="padding-left: 20px">
              <div style="padding: 10px 0px">{{item.name}}</div>
              <el-button size="small" @click="openWin(item.url)":class="item.clas">{{item.type}}</el-button>
            </div>
          </el-tab-pane>
        </el-tabs>
      </el-col>
      <el-col :span="12" style="padding: 20px">
        <div class="wk">
          <div style=";font-size: 20px;margin: 20px 0px">新闻资讯</div>
          <div style="text-align: left" v-for="(item,index) in zx" :key="index">
            <el-button type="text"@click="openWin(item.url)" style="padding: 10px 0px 0px 10px;color: #17c2ff">
              <span style="color:#17C2FF;">●</span>{{item.title}}</el-button><br>
          </div>
          <div style=";font-size: 20px;margin-top: 30px;">
            <span>当前系统时间是：</span>
            <span id="show"></span>
            <div style="margin:20px 0px;">欢迎使用XX社区诊所系统</div>
          </div>
        </div>
        <div style="padding-top: 20px">
          <img :src="url1" style="width: 100%;height: 100%">
        </div>
      </el-col>
    </el-row>

  </div>

</template>
<script>
  export default {
    data(){
      return {
        time:'',
        activeName: 'first',
        url:require('@/assets/st.png'),
        url1:require('@/assets/sm.jpg'),
        all:[{
          name:'北京卫健委：新型肺炎症状自我评估办法',
          type:'症状表现',
          clas:'one',
          url:'https://mdeer.taobao.com/guide/h5/science/article/168116?pos=16&acm=202002125.1003.2.7340021&scm=1003.2.202002125.OTHER_1580737215104_7340021&popup=true&spm=null.prevent.0&isextonly=1'
        },{
          name:'出现这五类症状，应高度警惕新型肺炎',
          type:'症状表现',
          clas:'one',
          url:'https://mdeer.taobao.com/guide/h5/science/article/168110?pos=11&acm=202002124.1003.2.7340026&scm=1003.2.202002124.OTHER_1582033173502_7340026&popup=true&spm=null.symptom.2&isextonly=1'
        }, {
          name: '中国疾控中心：公共场所预防指南',
          type: '如何预防',
          clas: 'two',
          url: 'https://mdeer.taobao.com/guide/h5/science/article/168099?pos=13&acm=202002125.1003.2.7340021&scm=1003.2.202002125.OTHER_1581793896988_7340021&popup=true&spm=null.prevent.3&isextonly=1'
        },{
          name:'全国发热门诊一览表',
          type:'防疫焦点',
          clas:'three',
          url:'https://alihealth.taobao.com/medicalhealth/feverclinic?pos=7&acm=202002126.1003.2.7340028&scm=1003.2.202002126.OTHER_1584247316930_7340028&popup=true&spm=null.focus.0&isextonly=1'
        },{
          name:'中国疾控中心成功分离首株新型冠状病毒',
          type:'症状表现',
          clas:'one',
          url:'https://mdeer.taobao.com/guide/h5/science/article/168107?pos=12&acm=202002124.1003.2.7340026&scm=1003.2.202002124.OTHER_1581036112564_7340026&popup=true&spm=null.symptom.3&isextonly=1'
        },{
          name:'中国疾控中心：新冠肺炎家庭预防指南',
          type:'如何预防',
          clas:'two',
          url:'https://mdeer.taobao.com/guide/h5/science/article/168101?pos=12&acm=202002125.1003.2.7340021&scm=1003.2.202002125.OTHER_1582583383084_7340021&popup=true&spm=null.prevent.2&isextonly=1'
        },{
          name:'记住3句就医建议',
          type:'症状表现',
          clas:'one',
          url:'https://mdeer.taobao.com/guide/h5/science/article/167752?pos=13&acm=202002124.1003.2.7340026&scm=1003.2.202002124.OTHER_1583633965773_7340026&popup=true&spm=null.symptom.4&isextonly=1'
        },{
          name:'防范新型冠状病毒48字守则',
          type:'如何预防',
          clas:'two',
          url:'https://mdeer.taobao.com/guide/h5/science/article/168111?pos=14&acm=202002125.1003.2.7340021&scm=1003.2.202002125.OTHER_1581916855104_7340021&popup=true&spm=null.prevent.4&isextonly=1'
        },{
          name:'科学辟谣安心防疫 ，转发给你关心的人',
          type:'防疫焦点',
          clas:'three',
          url:'https://alihealth.taobao.com/msearch/rumorlist?pos=6&acm=202002126.1003.2.7340028&scm=1003.2.202002126.OTHER_1583133448047_7340028&popup=true&spm=null.focus.1&isextonly=1'
        },{
          name:'中国疾控中心：做到这六条预防冠状病毒',
          type:'如何预防',
          clas:'two',
          url:'https://mdeer.taobao.com/guide/h5/science/article/168105?pos=10&acm=202002125.1003.2.7340021&scm=1003.2.202002125.OTHER_1581487807756_7340021&popup=true&spm=null.prevent.0&isextonly=1'
        },{
          name:'中国疾控中心：新型肺炎个人防控指南',
          type:'如何预防',
          clas:'two',
          url:'https://mdeer.taobao.com/guide/h5/science/article/168106?pos=11&acm=202002125.1003.2.7340021&scm=1003.2.202002125.OTHER_1583010292740_7340021&popup=true&spm=null.prevent.1&isextonly=1'
        },{
          name:'如何正确挑选口罩',
          type:'如何预防',
          clas:'two',
          url:'https://mdeer.taobao.com/guide/h5/science/article/167748?pos=15&acm=202002125.1003.2.7340021&scm=1003.2.202002125.OTHER_1582254264741_7340021&popup=true&spm=null.prevent.5&isextonly=1'
        },{
          name:'预防肺炎戴过的口罩该怎么处理？',
          type:'如何预防',
          clas:'two',
          url:'https://mdeer.taobao.com/guide/h5/science/article/168116?pos=16&acm=202002125.1003.2.7340021&scm=1003.2.202002125.OTHER_1580737215104_7340021&popup=true&spm=null.prevent.6&isextonly=1'
        }],
        zz:[{
          name:'北京卫健委：新型肺炎症状自我评估办法',
          type:'症状表现',
          clas:'one',
          url:'https://mdeer.taobao.com/guide/h5/science/article/168116?pos=16&acm=202002125.1003.2.7340021&scm=1003.2.202002125.OTHER_1580737215104_7340021&popup=true&spm=null.prevent.0&isextonly=1'
        },{
          name:'出现这五类症状，应高度警惕新型肺炎',
          type:'症状表现',
          clas:'one',
          url:'https://mdeer.taobao.com/guide/h5/science/article/168110?pos=11&acm=202002124.1003.2.7340026&scm=1003.2.202002124.OTHER_1582033173502_7340026&popup=true&spm=null.symptom.2&isextonly=1'
        }, {
          name:'中国疾控中心成功分离首株新型冠状病毒',
          type:'症状表现',
          clas:'one',
          url:'https://mdeer.taobao.com/guide/h5/science/article/168107?pos=12&acm=202002124.1003.2.7340026&scm=1003.2.202002124.OTHER_1581036112564_7340026&popup=true&spm=null.symptom.3&isextonly=1'
        },{
          name:'记住3句就医建议',
          type:'症状表现',
          clas:'one',
          url:'https://mdeer.taobao.com/guide/h5/science/article/167752?pos=13&acm=202002124.1003.2.7340026&scm=1003.2.202002124.OTHER_1583633965773_7340026&popup=true&spm=null.symptom.4&isextonly=1'
        }],
        yf:[{
          name:'中国疾控中心：做到这六条预防冠状病毒',
          type:'如何预防',
          clas:'two',
          url:'https://mdeer.taobao.com/guide/h5/science/article/168105?pos=10&acm=202002125.1003.2.7340021&scm=1003.2.202002125.OTHER_1581487807756_7340021&popup=true&spm=null.prevent.0&isextonly=1'
        },{
          name:'中国疾控中心：新型肺炎个人防控指南',
          type:'如何预防',
          clas:'two',
          url:'https://mdeer.taobao.com/guide/h5/science/article/168106?pos=11&acm=202002125.1003.2.7340021&scm=1003.2.202002125.OTHER_1583010292740_7340021&popup=true&spm=null.prevent.1&isextonly=1'
        },{
          name:'中国疾控中心：新冠肺炎家庭预防指南',
          type:'如何预防',
          clas:'two',
          url:'https://mdeer.taobao.com/guide/h5/science/article/168101?pos=12&acm=202002125.1003.2.7340021&scm=1003.2.202002125.OTHER_1582583383084_7340021&popup=true&spm=null.prevent.2&isextonly=1'
        },{
          name:'中国疾控中心：公共场所预防指南',
          type:'如何预防',
          clas:'two',
          url:'https://mdeer.taobao.com/guide/h5/science/article/168099?pos=13&acm=202002125.1003.2.7340021&scm=1003.2.202002125.OTHER_1581793896988_7340021&popup=true&spm=null.prevent.3&isextonly=1'
        },{
          name:'防范新型冠状病毒48字守则',
          type:'如何预防',
          clas:'two',
          url:'https://mdeer.taobao.com/guide/h5/science/article/168111?pos=14&acm=202002125.1003.2.7340021&scm=1003.2.202002125.OTHER_1581916855104_7340021&popup=true&spm=null.prevent.4&isextonly=1'
        },{
          name:'如何正确挑选口罩',
          type:'如何预防',
          clas:'two',
          url:'https://mdeer.taobao.com/guide/h5/science/article/167748?pos=15&acm=202002125.1003.2.7340021&scm=1003.2.202002125.OTHER_1582254264741_7340021&popup=true&spm=null.prevent.5&isextonly=1'
        },{
          name:'预防肺炎戴过的口罩该怎么处理？',
          type:'如何预防',
          clas:'two',
          url:'https://mdeer.taobao.com/guide/h5/science/article/168116?pos=16&acm=202002125.1003.2.7340021&scm=1003.2.202002125.OTHER_1580737215104_7340021&popup=true&spm=null.prevent.6&isextonly=1'
        }],
        jd:[{
          name:'全国发热门诊一览表',
          type:'防疫焦点',
          clas:'three',
          url:'https://alihealth.taobao.com/medicalhealth/feverclinic?pos=7&acm=202002126.1003.2.7340028&scm=1003.2.202002126.OTHER_1584247316930_7340028&popup=true&spm=null.focus.0&isextonly=1'
        },{
          name:'科学辟谣安心防疫 ，转发给你关心的人',
          type:'防疫焦点',
          clas:'three',
          url:'https://alihealth.taobao.com/msearch/rumorlist?pos=6&acm=202002126.1003.2.7340028&scm=1003.2.202002126.OTHER_1583133448047_7340028&popup=true&spm=null.focus.1&isextonly=1'
        }],
        zx:[{
          title:'福建省人民政府官网→疫情动态',
          url:'http://www.fujian.gov.cn/xw/ztzl/ydxxfy/yqqk/'
        },{
            title:'习近平给比尔·盖茨回信 感谢盖茨基金会支持中国抗击新冠肺炎疫情',
            url:'http://tv.cctv.com/2020/02/22/VIDEMgrhkpH5nKM1dIdet8He200222.shtml'
          },{
          title:'战“疫”27天，中央指导组“金句”背后的那些事',
          url:'http://news.cctv.com/2020/02/22/ARTIQpsTIkuKKEASxT9pCG6z200222.shtml'
        }]
      }
    },
    created:function() {
      this.loadTime();
    },
    methods: {
      openWin(url){
        window.open(url,'_blank');
        // window.location.href=url;
      },
      handleClick(tab, event) {
        console.log(tab, event);
      },
      loadTime(){
        setInterval(function() {
          var show = document.getElementById("show");
          var d = new Date();
          var year = d.getFullYear();
          var month = d.getMonth()+1;
          var date = d.getDate();
          var hours = d.getHours();
          var minutes = d.getMinutes();
          var seconds = d.getSeconds();
          var curDateTime= year;
          if(month>9){
            curDateTime = curDateTime +"-"+month;
          }else{
            curDateTime = curDateTime +"-0"+month;
          }
          if(date>9){
            curDateTime = curDateTime +"-"+date;
          }else{
            curDateTime = curDateTime +"-0"+date;
          }
          if(hours>9){
            curDateTime = curDateTime +" "+hours;
          }else{
            curDateTime = curDateTime +" 0"+hours;
          }
          if(minutes>9){
            curDateTime = curDateTime +":"+minutes;
          }else{
            curDateTime = curDateTime +":0"+minutes;
          }
          if(seconds>9){
            curDateTime = curDateTime +":"+seconds;
          }else{
            curDateTime = curDateTime +":0"+seconds;
          }
          show.innerHTML = curDateTime;
        }, 1000);
      }
    }
  }
</script>
<style>
  .titleOrgBg1{
    width:600px;
    height: 300px;
    display: block;
    margin: 15px 5px 10px 0;
    /*float: left;*/
    border-radius:8px 8px 8px 8px;
  }
  .bt{
    font-size: 20px;
    color: #000;
    font-weight: bold;
    padding: 10px 0px;
  }
  .one{
    color: #fff;
    background: linear-gradient(135deg,#0ca,#00bf9f);;
  }
  .two{
    color: #fff;
    background: linear-gradient(135deg,#3bf,#0af);
  }
  .three{
    color: #fff;
    background: linear-gradient(135deg,#ffd500,#fa3);;
  }
  .wk{
    border: 2px solid #d0d2d3;;
  }
</style>
