<template>
  <div>
    <el-form ref="spot" :model="spot" :rules="rules"  label-width="30%" style="">
        <el-row>
          <el-col :span="12">
            <div class="grid-content bg-purple">
              <el-form-item label="景点名称" prop="name" style="width: 100%">
                <el-input v-model="spot.name" placeholder="请输入景点名称"style="width: 70%;margin-left: -30%"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="grid-content bg-purple-light">
              <el-form-item label="门票价格" prop="price" style="width: 100%">
                <el-input v-model="spot.price"placeholder="请输入价格" style="width: 70%;margin-left: -30%"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>
      <el-row>
        <el-col :span="12">
          <div class="grid-content bg-purple">
            <el-form-item label="开放时间" prop="kTime"style="width: 100%">
              <el-input v-model="spot.kTime"placeholder="请输入价格" style="width: 70%;margin-left: -30%"></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12">
          <div class="grid-content bg-purple-light">
            <el-form-item label="景点类型" prop="type" style="width: 100%">
              <el-input v-model="spot.type"placeholder="请输入景点类型" style="width: 70%;margin-left: -30%"></el-input>
            </el-form-item>
          </div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <div class="grid-content bg-purple">
            <el-form-item label="景点电话" prop="type" style="width: 100%">
              <el-input v-model="spot.phone"placeholder="请输入景点电话" style="width: 70%;margin-left: -30%"></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12">
          <div class="grid-content bg-purple-light">
            <el-form-item label="景点级别" prop="level" style="width: 100%;">
              <!--<el-input v-model="spot.level"placeholder="请输入景点级别" type="number" style="width: 70%;margin-left: -30%"></el-input>-->

              <el-select v-model="spot.level" placeholder="请选择" style="width: 70%;margin-left: -30%">
                <el-option label="A" value="A"></el-option>
                <el-option label="AA" value="AA"></el-option>
                <el-option label="AAA" value="AAA"></el-option>
                <el-option label="AAAA" value="AAAA"></el-option>
                <el-option label="AAAAA" value="AAAAA"></el-option>
              </el-select>
            </el-form-item>
          </div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <div class="grid-content bg-purple">
            <el-form-item label="景点所在地" prop="location" style="width: 100%;">
              <el-select v-model="spot.location" placeholder="请选择" style="width: 70%;margin-left: -30%">
                <el-option label="福州市" value="福州市"></el-option>
                <el-option label="厦门市" value="厦门市"></el-option>
                <el-option label="泉州市" value="泉州市"></el-option>
                <el-option label="三明市" value="三明市"></el-option>
              </el-select>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12">
          <div class="grid-content bg-purple-light">
            <el-form-item label="景区详细地址" prop="address" style="width: 100%">
              <el-input v-model="spot.address"placeholder="请景区详细地址" style="width: 70%;margin-left: -30%"></el-input>
            </el-form-item>
          </div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <div class="grid-content bg-purple">
            <el-form-item label="景点交通" prop="introduce" style="width: 100%">
              <el-input type="textarea"placeholder="如：1. 南后街、杨桥巷（路）：乘坐5、18、22 、27、55、61、66、80、128路到“双抛桥”站下车可到。2. 光禄坊：乘坐16、18、27、61、109、105路到“省电影公司”（白马路光禄坊口）站下车可到。" v-model="spot.introduce1" style="width: 70%;height:80px;margin-left: -30%"></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12">
          <div class="grid-content bg-purple-light">
            <el-form-item label="简介" prop="introduce" style="width: 100%">
              <el-input type="textarea"placeholder="请输入景点简介" v-model="spot.introduce" style="width: 70%;height:80px;margin-left: -30%"></el-input>
            </el-form-item>
          </div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <div class="grid-content bg-purple">
            <el-form-item  prop="fileList" style="width: 80%;margin-top: 5%;">
              <el-upload action="" drag multiple :file-list="spot.fileList" :on-change="onChange" :auto-upload="false" >
                <i class="el-icon-upload"></i>
                <div class="el-upload__text">将文件拖到此处，或
                  <em>点击上传</em>
                  <div slot="tip" class="el-upload__tip" style="color:red;">只能上传jpg/png文件</div>
                </div>
              </el-upload>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12">
          <div class="grid-content bg-purple-light">
            <el-form-item style="margin-left: -25%;margin-top: 20%">
              <el-button type="primary" @click="upload">立即创建</el-button>
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
              spot: {
                name:'',
                kTime:'',
                price:'',
                phone:'',
                level:'',
                type:'',
                introduce:'',
                address:'',
                fileList:[]
              },
              // image: '',
              rules: {
                name: [
                  {required: true, message: '请输入景点名称', trigger: 'blur'},
                  {min: 3, max:8, message: '长度在 3 到5 个字符', trigger: 'blur'}
                ],
                type: [
                  {required: true, message: '请输入景点类别', trigger: 'blur'}
                ],
                kTime: [
                  {required: true, message: '请输入开放时间', trigger: 'blur'},
                  {min: 3, max:8, message: '长度在 3 到 20 个字符', trigger: 'blur'}
                ],
                phone: [
                  {required: true, message: '请输入景点电话', trigger: 'blur'},
                  {min: 0, max:11, message: '长度在 0 到 11 个字符', trigger: 'blur'}
                ],
                price: [
                  {required: true, message: '请输入门票价格', trigger: 'blur'}
                ],
                introduce: [
                  {required: true, message: '请输入景点简介', trigger: 'blur'}
                ],
                address: [
                  {required: true, message: '请输入景点详细地址', trigger: 'blur'},
                  {min: 3, max:8, message: '长度在 3 到 20 个字符', trigger: 'blur'}
                ],
                fileList: [
                  { required: true, message: '请上传景点图片', trigger: 'blur' }
                ]
              },
            }
        },methods:{
        onChange(file, image) {
          this.spot.fileList=image;
        },
        clear() {
          this.spot.name='',
          this.spot.kTime='',
          this.spot.price='',
          this.spot.level='',
          this.spot.location='',
          this.spot.phone='',
          this.spot.type='',
          this.spot.introduce='',
          this.spot.address='',
          this.spot.fileList=[]
        },
        upload(){
          var _this = this;
          let form = new FormData();
           if (this.spot.name=="") {
            Message({
              showClose: true,
              message: "请输入景点名称!" ,
              type: "error"
            });
          }else if (this.spot.kTime=="") {
             Message({
               showClose: true,
               message: "请输入开放时间!" ,
               type: "error"
             });
          }else if (this.spot.price=="") {
             Message({
               showClose: true,
               message: "请输入门票价格!" ,
               type: "error"
             });
           }else if (this.spot.level=="") {
             Message({
               showClose: true,
               message: "请选择景区级别!" ,
               type: "error"
             });
           }else if (this.spot.phone=="") {
             Message({
               showClose: true,
               message: "请输入景区电话!" ,
               type: "error"
             });
           }else if (this.spot.location=="") {
             Message({
               showClose: true,
               message: "请选择景区所在地!" ,
               type: "error"
             });
           }else if (this.spot.type=="") {
             Message({
               showClose: true,
               message: "请输入景点类型!" ,
               type: "error"
             });
           }else if (this.spot.address=="") {
             Message({
               showClose: true,
               message: "请输入景点详细地址!" ,
               type: "error"
             });
           }else if (this.spot.introduce=="") {
             Message({
               showClose: true,
               message: "请输入景点简介!" ,
               type: "error"
             });
           }else if (this.spot.fileList.length<1) {
            Message({
              showClose: true,
              message: "请选择文件!" ,
              type: "error"
            });
          }else{
            for (var i = 0; i < this.spot.fileList.length; i++) {
              form.append(
                "fileList",
                document.querySelector("input[type=file]").files[i]
              );
            }
            form.append("entityId", "111111");
            form.append("type", "222");
            //景点新增，提交表单数据
            axios.post("http://localhost:8086/picture/picture", form, {
              "Content-Type": "application/x-www-form-urlencoded"
            }).then(function(res){
              console.log(res)
              if (res.data.code == 0) {
                _this.addScencSpot();
              } else {
                Message({
                  showClose: true,
                  message: "失败:" + res.data.data,
                  type: "error"
                });
              }
            });
          }

        },
        addScencSpot(){
          var _this = this;
          let form = new FormData();
          console.log(_this.spot.price)
          var price1=parseInt(_this.spot.price);
          console.log(price1)
          form.append("name", _this.spot.name);
          // form.append("kTime", _this.spot.kTime);
          form.append("location", _this.spot.location);
          form.append("level", _this.spot.level);
          form.append("type", _this.spot.type);
          form.append("introduce", _this.spot.introduce);
          // form.append("address", _this.spot.address);
          axios.post("http://localhost:8086/scenery", {
            name:_this.spot.name,
            ticketPrice:price1,
            openingTime:_this.spot.kTime,
            location:_this.spot.location,
            level:_this.spot.level,
            type:_this.spot.type,
            introduce:_this.spot.introduce,
            phone:_this.spot.phone,
            address:_this.spot.address
          }).then(function(res){
            console.log(res)
            if (res.data.code == 0) {
              Message({
                showClose: true,
                message: "添加成功",
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
</script>
<style>
  .el-textarea__inner {
    display: block;
    resize: vertical;
    padding: 5px 15px;
    line-height: 1.5;
    height: 120px;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    width: 100%;
    font-size: inherit;
    color: #606266;
    background-color: #FFF;
    background-image: none;
    border: 1px solid #DCDFE6;
    border-radius: 4px;
    -webkit-transition: border-color .2s cubic-bezier(.645,.045,.355,1);
    transition: border-color .2s cubic-bezier(.645,.045,.355,1);
  }
</style>
