<template>
    <div style="text-align: center;width: 90%;margin-left: 5%">
      <div style="font-size: 20px;margin: 20px 0px">药品详情（编号：{{productId}}）</div>
      <!--<div style="margin-left: 2%;width: 100%;">-->
        <!--<span class="ordsum">编号：</span>-->
        <!--<span style="font-weight:bold;"><el-input  style="width:10%;text-align: left" v-html="productId"></el-input></span>-->
      <!--</div>-->
      <el-row style="margin-top: 2%">
        <el-col :span="12">
          <span class="ordsum">药品名称：</span>
          <span style="font-weight:bold;"><el-input  style="width:70%;":disabled="true" v-model="name"></el-input></span>
        </el-col>
        <el-col :span="12">
          <span class="ordsum">药品性状：</span>
          <span style="font-weight:bold;"><el-input  style="width:70%;"  v-model="description"></el-input></span>
        </el-col>
      </el-row>
      <el-row style="margin-top: 2%">
        <el-col :span="12">
          <span class="ordsum">禁忌：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
          <span style="font-weight:bold;"><el-input  style="width:70%;" v-model="contraindications"></el-input></span>
        </el-col>
        <el-col :span="12">
          <span class="ordsum">类型：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
          <span style="font-weight:bold;">
            <el-select v-model="type"  style="width: 70%;">
              <el-option label="药品" value="1"></el-option>
              <el-option label="保健品" value="2"></el-option>
            </el-select>
          </span>
        </el-col>
      </el-row>
      <el-row style="margin-top: 2%">
        <el-col :span="12">
          <span class="ordsum">包装：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
          <span style="font-weight:bold;"><el-input  style="width:70%;" v-model="pack"></el-input></span>
        </el-col>
        <el-col :span="12">
          <span class="ordsum">贮存：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
          <span style="font-weight:bold;"><el-input  style="width:70%;"  v-model="storage"></el-input></span>
        </el-col>
      </el-row>
      <el-row style="margin-top: 2%">
        <el-col :span="12">
          <span class="ordsum">主治功能：</span>
          <span style="font-weight:bold;"><el-input  style="width:70%;" type="textarea" v-model="indications"></el-input></span>
        </el-col>
        <el-col :span="12">
          <span class="ordsum">药品成分：</span>
          <span style="font-weight:bold;"><el-input  style="width:70%;" type="textarea" v-model="component"></el-input></span>
        </el-col>
      </el-row>
      <el-row style="margin-top: 2%">
        <el-col :span="12">
          <span class="ordsum">不良反应：</span>
          <span style="font-weight:bold;"><el-input  style="width:70%;" type="textarea" v-model="adverseReactions"></el-input></span>
        </el-col>
        <el-col :span="12">
          <span class="ordsum">用法用量：</span>
          <span style="font-weight:bold;"><el-input  style="width:70%;" type="textarea" v-model="dosageAdministration"></el-input></span>
        </el-col>
      </el-row>
      <el-row style="margin-top: 2%">
        <el-col :span="12">
          <span class="ordsum">注意事项：</span>
          <span style="font-weight:bold;"><el-input  style="width:70%;" type="textarea" v-model="precautions"></el-input></span>
        </el-col>
        <el-col :span="12">
          <span class="ordsum">是否处方药：</span>
          <span style="font-weight:bold;">
            <el-select v-model="otc"  style="width: 70%;">
              <el-option label="是" value="是"></el-option>
              <el-option label="否" value="否"></el-option>
            </el-select>
          </span>
        </el-col>
      </el-row>
      <el-row style="margin-top: 20px;text-align: center" >
        <span><el-button type="primary"  @click="back" >返回</el-button></span>
        <span><el-button type="primary"  @click="updataDrugs" style="margin-left:30px;">修改</el-button></span>
      </el-row>
    </div>
</template>
<script>
  import axios from 'axios';
  import Message from "element-ui/packages/message/src/main";
    export default {
        data() {
            return {
              productId:'',
              name:'',
              component:'',
              description:'',
              type:'',
              adverseReactions:'',
              indications:'',
              dosageAdministration:'',
              contraindications:'',
              precautions:'',
              pack:'',
              storage:'',
              otc:''
            }
        },
      created:function() {
        this.handleClick();
      },
      methods:{
        back(){
          this.$router.go(-1);//路由跳转返回上一页
        },

        updataDrugs(){
          var _this=this;
          axios.put("http://localhost:8087/product",{
            productId:_this.productId,
            name: _this.name,
            component: _this.component,
            description: _this.description,
            type: _this.type,
            adverseReactions: _this.adverseReactions,
            indications: _this.indications,
            dosageAdministration: _this.dosageAdministration,
            contraindications: _this.contraindications,
            precautions: _this.precautions,
            pack: _this.pack,
            storage: _this.storage,
            otc:_this.otc
          }).then(function(res){
            if (res.data.code == 0) {
              Message({
                showClose: true,
                message: "修改成功",
                type: "success"
              });
              _this.handleClick();
            } else {
              Message({
                showClose: true,
                message: "失败:" + res.data.data,
                type: "error"
              });
            }
          });
        },
        handleClick() {
          var productId = this.$route.query.productId;
          console.log(productId);
          axios.get("http://localhost:8087/product/"+ productId)
            .then((response) => {
              const resDate = response.data;
              if (resDate.code == '0') {
                this.productId=resDate.data.productId;
                this.name=resDate.data.name;
                this.component=resDate.data.component;
                this.description=resDate.data.description;
                this.type=resDate.data.type;
                // var type=resDate.data.type;
                // if(type=="1"){
                //   this.type="药品"
                // }else if(type=="2"){
                //   this.type="保健品"
                // }
                this.adverseReactions=resDate.data.adverseReactions;
                this.indications=resDate.data.indications;
                this.dosageAdministration=resDate.data.dosageAdministration;
                this.contraindications=resDate.data.contraindications;
                this.precautions=resDate.data.precautions;
                this.pack=resDate.data.pack;
                this.storage=resDate.data.storage;
                this.otc=resDate.data.otc;
              } else {
                this.$message({
                  showClose: true,
                  message: "失败：" + resDate.data,
                  type: 'error'
                });
              }
            })
        },
      }

    }
</script>
<style scoped>
  .ordsum{
    font-size: 14px;
  }
</style>
