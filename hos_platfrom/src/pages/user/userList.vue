<template>
  <div align="center">
    <div class="demo-input-suffix" style="position:relative;left:-12%;">
      <el-input v-model="userName" style="width:20%;"placeholder="请输入关键字"prefix-icon="el-icon-search">
      </el-input>
      <el-select v-model="drugsType" placeholder="请选择">
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
      <!--<el-date-picker v-model="data1" type="date" placeholder="选择日期">-->
      <!--</el-date-picker>-->
      <el-button  @click="getUserList" type="text" size="small">查看</el-button>
      <el-button @click="clean" type="text" size="small">清空</el-button>
    </div>
    <hr>
    <div algin="center">
      <el-table :data="user"  border style="width: 100%" class="table":header-cell-style="{'text-align':'center'}">
        <el-table-column prop="userId" label="编号"  align="center">
        </el-table-column>
        <el-table-column prop="userName" label="用户名"  :show-overflow-tooltip="true" align="center">
        </el-table-column>
        <!--<el-table-column prop="password" label="用户密码" width="120" align="center">-->
        <!--</el-table-column>-->
        <el-table-column prop="name" label="姓名" :show-overflow-tooltip="true" align="center">
        </el-table-column>
        <el-table-column prop="phone" label="手机号"  :show-overflow-tooltip="true" align="center">
        </el-table-column>
        <el-table-column prop="email" label="邮箱" align="center">
        </el-table-column>
        <el-table-column fixed="right"label="操作" align="center" width="120" >
          <template slot-scope="scope" >
            <!--<el-button @click="detail(scope.row.productId)" type="text" size="small">查看</el-button>-->
            <el-button @click="deleteById(scope.row.userId)" type="text" size="small">删除</el-button>
          </template>
        </el-table-column>
      </el-table>

      <div class="block">
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page.sync="currentPage"
          :page-size="10"
          layout="prev, pager, next, jumper"
          :total="total">
        </el-pagination>
      </div>
    </div>
  </div>
</template>
<script>
    import api from "../../api/Api";
    import axios from 'axios';
    import Message from "element-ui/packages/message/src/main";
    export default {
        data() {
            return {
              user:[],
              currentPage:1,
              total:'',
              size:10
            }
        },
      created:function() {
        this.getUserList();
      },
      methods:{
        handleSizeChange(val) {
          this.size = val;
          console.log(val);
          this.getUserList();
        },
        handleCurrentChange(val) {
          this.currentPage = val;
          console.log(`当前页: ${val}`);
          this.getUserList();
        },
        deleteById(index) {
          this.$confirm('是否进行删除', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
            center: true
          }).then(() => {
            this.handleDelete(index);
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '放弃本次操作'
            });
          });
        },
        handleDelete(index,row) {
          console.log(index);
          var _this = this;
          axios.delete("http://localhost:8087/user/"+ index)
            .then((response) => {
              const resDate = response.data;
              if(resDate.code == '0'){
                this.$message({
                  showClose: true,
                  message: "删除成功",
                  type: 'success'
                });
              }else {
                this.$message({
                  showClose: true,
                  message: "删除失败: " + resDate.data,
                  type: 'error'
                });
              }
              _this.getUserList();
            })
        },
        getUserList(){
          let _this = this;
          api.userList({
            page:_this.currentPage,
            size:_this.size
          }).then(function (res) {
            const resData = res.data;
            console.log(resData);
            if (resData.code == "0" ) {
              if(resData.data=="未查询到相关记录"){
                Message({
                  showClose: true,
                  message:resData.data ,
                  type: "success"
                });
                _this.user=[];
              }else{
                _this.user = resData.data;
                _this.currentPage = resData.total.currentPage;
                _this.total = resData.total.total;
                console.log(_this.total);
              }

            }
          }).catch(function(response){
            Message({
              showClose: true,
              message:response.data.data ,
              type: "error"
            });
          })
        }
      }

    }
</script>
<style>

</style>
