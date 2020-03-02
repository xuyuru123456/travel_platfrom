<template>
  <div >
    <div style="font-size: 30px;font-weight: bold">新增医疗器材</div>
    <el-form ref="equipment" :model="equipment" :rules="rules"  label-width="30%" style="width:60%;margin-left:22%;margin-top: 30px">
          <div class="grid-content bg-purple">
            <el-form-item label="器材名称:" prop="name" style="width: 100%;text-align: left">
              <el-input v-model="equipment.name" placeholder="请输入"style="width:50%;"></el-input>
            </el-form-item>
          </div>
          <div class="grid-content bg-purple-light">
            <el-form-item label="产地:" prop="origin" style="width: 100%;text-align: left">
              <el-input v-model="equipment.origin"placeholder="请输入" style="width:50%;"></el-input>
            </el-form-item>
          </div>
          <div class="grid-content bg-purple">
            <el-form-item label="品牌:" prop="brand" style="width: 100%;text-align: left">
              <el-input v-model="equipment.brand"placeholder="请输入"  style="width:50%;"></el-input>
            </el-form-item>
          </div>
          <div class="grid-content bg-purple-light">
            <el-form-item style="margin-left: -50%;margin-top: 5%">
              <el-button type="primary" @click="addEquipment">立即创建</el-button>
              <!--<el-button @click="back">取消</el-button>-->
            </el-form-item>
          </div>
    </el-form>


  </div>
</template>
<script>
  import axios from 'axios';
  import Message from "element-ui/packages/message/src/main";
    export default {
        data() {
            return {
              equipment:{
                name:'',
                brand:'',
                origin:''
              },

            }
        },
      methods: {
        clear() {
          this.equipment.name = "";
          this.equipment.brand = "";
          this.equipment.origin = "";
        },
        addEquipment(){
          var _this=this;
          if (this.equipment.name=="") {
            Message({
              showClose: true,
              message: "请输入名称!" ,
              type: "error"
            });
          }else if (this.equipment.brand=="") {
            Message({
              showClose: true,
              message: "请输入品牌" ,
              type: "error"
            });
          }else if (this.equipment.origin=="") {
            Message({
              showClose: true,
              message: "请输入产地!" ,
              type: "error"
            });
          }else {
            var _this = this;
            axios.post("http://localhost:8087/product", {
              name: _this.equipment.name,
              brand:_this.equipment.brand,
              origin:_this.equipment.origin,
              component: '',
              description:'',
              type: '3',
              adverseReactions: '',
              indications:'',
              dosageAdministration: '',
              contraindications: '',
              precautions: '',
              pack: '',
              storage:'',
              otc: '',
            }).then(function (res) {
              console.log(res)
              if (res.data.code == 0) {
                Message({
                  showClose: true,
                  message: "添加成功:",
                  type: "success"
                });
                _this.clear();
              } else {
                Message({
                  showClose: true,
                  message: "失败:" + res.data.data,
                  type: "error"
                });
              }
            });
          }
        }
      }

    }
</script>
<style  scoped>

</style>
