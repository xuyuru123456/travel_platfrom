<template>
  <div align="center">
    <div class="demo-input-suffix" style="position:relative;left:-12%;">
      <el-input v-model="equipmentName" style="width:20%;"placeholder="请输入医疗器材名称"prefix-icon="el-icon-search">
      </el-input>
      <!--<el-date-picker v-model="data1" type="date" placeholder="选择日期">-->
      <!--</el-date-picker>-->
      <el-button  @click="getList" type="text" size="small">查看</el-button>
      <el-button @click="clean" type="text" size="small">清空</el-button>
    </div>
    <hr>
    <div algin="center">
      <el-table :data="equipment"  border style="width: 80%" class="table":header-cell-style="{'text-align':'center'}">
        <el-table-column prop="name" label="医疗器械名称"   :show-overflow-tooltip="true" align="center">
        </el-table-column>
        <el-table-column prop="brand" label="品牌"  align="center">
        </el-table-column>
        <el-table-column prop="origin" label="产地" :show-overflow-tooltip="true" align="center">
        </el-table-column>
        <el-table-column prop="type" label="类型" align="center">
        </el-table-column>
        <el-table-column fixed="right"label="操作"width="100" align="center">
          <template slot-scope="scope" >
            <el-button @click="updataME(scope.row.productId)" type="text" size="small">修改</el-button>
            <el-button @click="deleteById(scope.row.productId)" type="text" size="small">删除</el-button>
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
    <el-dialog class="plan-eff-dialog" title="修改" :visible.sync="updateEquipment" width="40%" style="padding: 0% 10%"center>
      <template>
        <div>
          <span class="ordsum">医疗器材名称：</span>
          <span style="font-weight:bold;"><el-input  style="width:70%;"  v-model="name"></el-input></span>
        </div>
        <div style="margin-top: 2%">
          <span class="ordsum">医疗器材品牌：</span>
          <span style="font-weight:bold;"><el-input  style="width:70%;"  v-model="brand"></el-input></span>
        </div>
        <div style="margin-top: 2%">
          <span class="ordsum">医疗器材产地：</span>
          <span style="font-weight:bold;"><el-input  style="width:70%;"  v-model="origin"></el-input></span>
        </div>
        <div style="margin-top: 2%">
          <span class="ordsum">类型：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
          <span style="font-weight:bold;"><el-input  style="width:70%;" :disabled="true" v-model="type"></el-input></span>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button type="primary" @click="centerDialogVisible = false">确 定</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>
<script>
  import axios from 'axios';
  import Message from "element-ui/packages/message/src/main";
    export default {
        data() {
            return {
              equipment:[],
              equipmentName:'',
              total:'',
              currentPage:1,
              size: 10,
              updateEquipment:false
            }
        },
      created:function() {
        this.getList();
      },
      methods:{
        clean:function(){
          this.equipmentName='';
          this.getList();
        },
        handleSizeChange(val) {
          this.size = val;
          console.log(val);
          this.getList();
        },
        handleCurrentChange(val) {
          this.currentPage = val;
          console.log(`当前页: ${val}`);
          this.getList();
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
          axios.delete("http://localhost:8087/product/"+ index)
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
              _this.getList();
            })
        },
        updataME(){
          this.updateEquipment=true;
        },
        getList(){
          var _this=this;
          axios.post("http://localhost:8087/product/page",{
            name_like:_this.equipmentName,
            type:'3',
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
                _this.equipment=[];
              }else{
                const list=resData.data;
                list.map(item=>{//遍历循环数组，跟for循环效果一样，更简洁方便
                  var type=item.type;
                  if(type=="3"){
                    type="医疗器械";
                  }
                  //把值重新写入list
                  item.type=type;

                })
                _this.equipment = list;
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
