<template>
  <div class="bj">
    <el-form ref="user" :model="user" :rules="rules"  label-width="20%"
             class="login" >
      <i><h1 style="color: #fff;padding-top: 3%">X&nbsp;X&nbsp;社&nbsp;区&nbsp;诊&nbsp;所</h1></i>


      <el-form-item prop="username" style="width: 70%; margin-left: 10%" >
        <el-input type="text"   auto-complete="off" placeholder="账号" v-model="user.account"></el-input><br>
      </el-form-item>
      <el-form-item prop="pwd" style="width: 70%;margin-left: 10%">
        <el-input type="password"  auto-complete="off" placeholder="密码" v-model="user.pwd"></el-input><br>
      </el-form-item>
      <el-row style="">
        <!--<el-col :span="12">-->
          <el-checkbox  v-model="checked" checked class="remember">记住密码</el-checkbox>
        <!--</el-col>-->
        <!--<el-col :span="12">-->
          <el-form style="width: 70%;margin-left: 30%;margin-top: -5.5%">
            <el-button @click="register" type="text" style="color: #fff;">没有账号?点我注册</el-button>
          </el-form>
        <!--</el-col>-->
      </el-row>


      <el-form style="width:100%;padding-bottom: 3%">
        <el-button type=""  @click.native.prevent="handleLogin" round style="width:20%;margin-top: 0%;margin-left: 0%">登录</el-button><br>
      </el-form>
    </el-form>
  </div>
</template>
<script>
  import Message from "element-ui/packages/message/src/main";

  export default {
        data() {
            return {
              user: {
                account: '',
                pwd: ''
              },
              checked: true,
              rules: {
                // username:[
                //   {required: true, message: '请输入账号', trigger: 'blur'},
                // ],
                pwd: [
                  {required: true, message: '请输入密码', trigger: 'blur'},
                  //{ validator: validaePass2 }
                ]
              },
            }
        },
      methods:{
        register(){
          this.$router.push({ path: '/register' });
        },
        handleLogin() {
          var params = new URLSearchParams();
          //alert(2);
          params.append("account", this.user.account);
          params.append("password", this.user.pwd);
          //alert(this.user.account);
          //api.requestLogin(params).then(res => res.data)
          api.requestLogin(params).then(res => {
            //alert(JSON.stringify(data));
            let {code,data, token} = res;
            if (code == '0'){
              if(this.user.account == 'manager'){
                sessionStorage.setItem("userRoot", '管理员(经理)');
              }else{
                sessionStorage.setItem("userRoot", '普通用户（服务员）');
              }
              sessionStorage.setItem('access-token', token);
              sessionStorage.setItem("LoginName", this.user.account);
              //跳转到后台主界面
              this.$message({
                message: data,
                type: 'success'
              });
              this.$router.push({ path: '/Index' });
            }
            else{
              Message({
                message:data,
                type: 'error'
              });
            }
          });
        }
      }

    }
</script>
<style >

  .bj{
    /*background: url('../assets/4.png') no-repeat;*/
    background: url('../assets/2.jpg') no-repeat;
    background-size:100% 100%;
    width: 100%;
    height:100%;
    position: fixed;
  }
  .login{
    /*background: white;*/
    background: #ffffff17;
    /*background-image: linear-gradient(to right, #fff, #E6E6E6);*/
    margin-top: 14%;
    margin-left: 29.5%;
    height: 50%;
    width: 40%;
    border-radius: 10px;
    /*box-shadow:2px 2px 5px #888888*/
  }
  .remember{
    margin-right:25%;
    color: #fff;
  }
  /*.el-button--primary {*/
    /*color: #8bcfe4;*/
    /*font-weight: bold;*/
    /*background-color: #fff;*/
     /*border-color: #8bcfe4;*/
  /*}*/
</style>
