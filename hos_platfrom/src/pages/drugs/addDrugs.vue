<template>
  <div>
    <div style="font-size: 30px;font-weight: bold">新增药品</div>
    <el-form ref="drugs" :model="drugs"   label-width="30%" style="margin-top: 30px">
      <el-row>
        <el-col :span="12">
          <div class="grid-content bg-purple">
            <el-form-item label="药品名称" prop="name" style="width: 100%">
              <el-input v-model="drugs.name" placeholder="请输入药品名称"style="width: 90%;margin-left: -10%"></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12">
          <div class="grid-content bg-purple-light">
            <el-form-item label="药品性状" prop="description" style="width: 100%">
              <el-input v-model="drugs.description"placeholder="请输入药品性状" style="width: 90%;margin-left: -10%"></el-input>
            </el-form-item>
          </div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <div class="grid-content bg-purple">
            <el-form-item label="禁忌" prop="contraindications" style="width: 100%">
              <el-input v-model="drugs.contraindications"placeholder="请输入"  style="width: 90%;margin-left: -10%"></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12">
          <el-form-item label="类型" prop="type" style="width: 100%">
            <el-select v-model="drugs.type" placeholder="请选择" style="width: 90%;margin-left: -10%">
              <el-option label="药品" value="1"></el-option>
              <el-option label="保健品" value="2"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <div class="grid-content bg-purple">
            <el-form-item label="包装" prop="pack" style="width: 100%">
              <el-input v-model="drugs.pack"placeholder="请输入"  style="width: 90%;margin-left: -10%"></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12">
          <el-form-item label="贮存" prop="storage" style="width: 100%">
            <el-input v-model="drugs.storage"placeholder="请输入"  style="width: 90%;margin-left: -10%"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <div class="grid-content bg-purple">
            <el-form-item label="主治功能" prop="indications" style="width: 100%">
              <el-input v-model="drugs.indications"placeholder="请输入主治功能" type="textarea" style="width: 90%;margin-left: -10%"></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12">
          <div class="grid-content bg-purple">
            <el-form-item label="药品成分" prop="component"style="width: 100%">
              <el-input v-model="drugs.component"placeholder="请输入药品成分" type="textarea" style="width: 90%;margin-left: -10%"></el-input>
            </el-form-item>
          </div>

        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <div class="grid-content bg-purple">
            <el-form-item label="不良反应" prop="adverseReactions" style="width: 100%">
              <el-input v-model="drugs.adverseReactions"placeholder="请输入" type="textarea" style="width: 90%;margin-left: -10%"></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12">
          <div class="grid-content bg-purple">
            <el-form-item label="用法用量" prop="dosageAdministration" style="width: 100%">
              <el-input v-model="drugs.dosageAdministration"placeholder="请输入" type="textarea" style="width: 90%;margin-left: -10%"></el-input>
            </el-form-item>
          </div>

        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <div class="grid-content bg-purple">
            <el-form-item label="注意事项" prop="precautions" style="width: 100%">
              <el-input v-model="drugs.precautions"placeholder="请输入" type="textarea" style="width: 90%;margin-left: -10%"></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否处方药" prop="isotc" style="width: 100%">
            <el-input v-model="drugs.isotc"placeholder="请输入"  style="width: 90%;margin-left: -10%"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <div class="grid-content bg-purple-light">
            <el-form-item style="margin-left: -25%;margin-top: 5%">
              <el-button type="primary" @click="addDrugs">立即创建</el-button>
              <!--<el-button @click="back">取消</el-button>-->
            </el-form-item>
          </div>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
  import axios from 'axios';
  import Message from "element-ui/packages/message/src/main";
    export default {
        data() {
            return {
              drugs:{
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
                isotc:''
              },
              rules:[]

            }
        },
      created:function() {

      },
      methods:{
        clear(){
            this.drugs.name="";
            this.drugs.component="";
            this.drugs.description="";
            this.drugs.type="";
            this.drugs.adverseReactions="";
            this.drugs.indications="";
            this.drugs.dosageAdministration="";
            this.drugs.contraindications="";
            this.drugs.precautions="";
            this.drugs.pack="";
            this.drugs.storage="";
            this.drugs.isotc="";
        },
        addDrugs(){
          if (this.drugs.name=="") {
            Message({
              showClose: true,
              message: "请输入药品名称!" ,
              type: "error"
            });
          }else if (this.drugs.component=="") {
            Message({
              showClose: true,
              message: "请输入药品成分!" ,
              type: "error"
            });
          }else if (this.drugs.description=="") {
            Message({
              showClose: true,
              message: "请输入药品性状!" ,
              type: "error"
            });
          }else if (this.drugs.type=="") {
            Message({
              showClose: true,
              message: "请选择药品类型!" ,
              type: "error"
            });
          }else if (this.drugs.adverseReactions=="") {
            Message({
              showClose: true,
              message: "请输入不良反应!" ,
              type: "error"
            });
          }else if (this.drugs.indications=="") {
            Message({
              showClose: true,
              message: "主治功能" ,
              type: "error"
            });
          }else if (this.drugs.dosageAdministration=="") {
            Message({
              showClose: true,
              message: "请输入用法用量!" ,
              type: "error"
            });
          }else if (this.drugs.contraindications=="") {
            Message({
              showClose: true,
              message: "请输入禁忌!" ,
              type: "error"
            });
          }else if (this.drugs.precautions=="") {
            Message({
              showClose: true,
              message: "请输入注意事项!" ,
              type: "error"
            });
          }else if (this.drugs.pack=="") {
            Message({
              showClose: true,
              message: "请输入药品包装!" ,
              type: "error"
            });
          }else if (this.drugs.storage=="") {
            Message({
              showClose: true,
              message: "请输入贮存方式" ,
              type: "error"
            });
          }else if (this.drugs.isotc=="") {
            Message({
              showClose: true,
              message: "请输入是否处方药!" ,
              type: "error"
            });
            console.log(this.drugs.isotc);
          }else {
            var _this = this;
            axios.post("http://localhost:8087/product", {
              name: _this.drugs.name,
              component: _this.drugs.component,
              description: _this.drugs.description,
              type: _this.drugs.type,
              adverseReactions: _this.drugs.adverseReactions,
              indications: _this.drugs.indications,
              dosageAdministration: _this.drugs.dosageAdministration,
              contraindications: _this.drugs.contraindications,
              precautions: _this.drugs.precautions,
              pack: _this.drugs.pack,
              storage: _this.drugs.storage,
              otc: _this.drugs.isotc,
              brand:'',
              origin:''
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
<style>

</style>
