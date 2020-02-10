<template>
  <div>
    <div  style="background: #ffffff;margin-left:13%;margin-top:40px;" class="titleOrgBg1">
      <div style="font-family: 'Adobe 黑体 Std R';font-size: 25px;margin-top: 30px;">
        <span>当前系统时间是：</span>
        <span id="show"></span>
        <div style="margin-top:80px;">欢迎使用闽游通后台管理系统</div>
      </div>
    </div>
    <div style="clear:both;padding-top:144px;">
      @谢版权所有，请勿盗版，违者必究
    </div>
  </div>

</template>
<script>
  export default {
    data(){
      return {
      }
    },
    created:function() {
      this.loadTime();
    },
    methods: {
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
    width:800px;
    height: 300px;
    display: block;
    margin: 15px 5px 10px 0;
    float: left;
    border-radius:8px 8px 8px 8px;
  }
</style>
