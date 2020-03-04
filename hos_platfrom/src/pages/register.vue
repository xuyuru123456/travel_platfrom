<template>
  <div>
    <div style="font-size: 30px;padding-top: 2%">注册</div>
    <el-form ref="user" :model="user" :rules="rules" label-width="30%" style="margin-left: 20%;margin-top: 2%">
      <el-form-item label="账号" style="width: 80%">
        <el-input v-model="user.userName" placeholder="请输入账号"style="width: 50%;margin-left: -50%"></el-input>
      </el-form-item>

      <el-form-item label="姓名" style="width: 80%">
        <el-input v-model="user.name" placeholder="请输入姓名"style="width: 50%;margin-left: -50%"></el-input>
      </el-form-item>

      <el-form-item label="密码" style="width: 80%">
        <el-input type="password" v-model="user.password" auto-complete="off" placeholder="请输入密码" style="width: 50%;margin-left: -50%"></el-input>
      </el-form-item>
      <!--<el-form-item label="确认密码" style="width: 80%">-->
        <!--<el-input type="password" v-model="user.passwordRetry" auto-complete="off" placeholder="请再次输入密码" style="width: 50%;margin-left: -50%"></el-input>-->
      <!--</el-form-item>-->
      <el-form-item label="电话" style="width: 80%">
        <el-input v-model="user.phone"placeholder="请输入电话" style="width: 50%;margin-left: -50%"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" style="width: 80%">
        <el-input  placeholder="请输入邮箱" v-model="user.email" style="width: 50%;margin-left: -50%"></el-input>
      </el-form-item>
      <el-form-item style="margin-left: -75%">
        <el-button type="primary" @click.native.prevent="register">立即注册</el-button>
        <el-button @click="back">返回</el-button>
      </el-form-item>
    </el-form>
  </div>

</template>
<script>
    import api from "../api/Api";
    import Message from "element-ui/packages/message/src/main";
    export default {
        data() {
            return {
              user: {
                userName: '',
                name:'',
                password:'',
                // passwordRetry:'',
                phone:'',
                email:''
                // roleName:''
              },
              rules: {
                name: [
                  {required: true, message: '请输入姓名', trigger: 'blur'},
                  {min: 3, max:8, message: '长度在 3 到 8 个字符', trigger: 'blur'}
                ],
                userName: [
                  {required: true, message: '请输入用户名', trigger: 'change'}
                ],
                password: [
                  {type: true, required: true, message: '请输入密码', trigger: 'blur'}
                ],
                email: [
                  {required: true, message: '请输入邮箱', trigger: 'blur'}
                ],
                phone: [
                  {required: true, message: '请输入电话', trigger: 'blur'}
                ]
            }
        }
      },
      methods:{
        back(){
          this.$router.push("/");
        },
        register() {
          var _this=this;
          api.addUser({
            userName:this.user.userName,
            name:this.user.name,
            password:this.user.password,
            phone:this.user.phone,
            email:this.user.email
          }).then(function (res) {
            if (res.code == "0") {
              Message({
                showClose: true,
                message: "注册成功",
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
        },
        clear(){
          this.user.userName="";
          this.user.name="";
          this.user.password="";
          this.user.phone="";
          this.user.email="";
        }
      }
    }
</script>
<style scoped>

</style>
