<template>
  <div align="center">
    <div class="demo-input-suffix" style="position:relative;left:-12%;">
      <el-input v-model="drugsName" style="width:20%;"placeholder="请输入关键字"prefix-icon="el-icon-search">
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
      <el-button  @click="getDrugsList" type="text" size="small">查看</el-button>
      <el-button @click="clean" type="text" size="small">清空</el-button>
    </div>
    <hr>
    <div algin="center">
      <el-table :data="drugs"  border style="width: 100%" class="table":header-cell-style="{'text-align':'center'}">
        <el-table-column prop="name" label="药品名称"  width="120" :show-overflow-tooltip="true" align="center">
        </el-table-column>
        <el-table-column prop="description" label="药品性状" width="120" :show-overflow-tooltip="true" align="center">
        </el-table-column>
        <el-table-column prop="type" label="药品类型" width="120" align="center">
        </el-table-column>
        <el-table-column prop="indications" label="主治功能" width="200" :show-overflow-tooltip="true" align="center">
        </el-table-column>
        <el-table-column prop="component" label="药品成分" width="200" :show-overflow-tooltip="true" align="center">
        </el-table-column>
        <el-table-column prop="pack" label="包装" width="120" align="center">
        </el-table-column>
        <el-table-column prop="storage" label="贮存" width="120" align="center">
        </el-table-column>
        <el-table-column prop="adverseReactions"label="不良反应"width="200"  :show-overflow-tooltip="true" align="center">
        </el-table-column>
        <el-table-column prop="dosageAdministration"label="用法用量"width="200" :show-overflow-tooltip="true" align="center">
        </el-table-column>
        <el-table-column prop="precautions"label="注意事项"width="200" :show-overflow-tooltip="true" align="center">
        </el-table-column>
        <el-table-column prop="contraindications"label="禁忌"width="200" :show-overflow-tooltip="true" align="center">
        </el-table-column>

        <!--<el-table-column prop="stock"label="数量（库存）"width="120"  align="center">-->
        <!--</el-table-column>-->
        <!--<el-table-column prop="minUnit"label="最小销售单位"width="120"  align="center">-->
        <!--</el-table-column>-->
        <!--<el-table-column prop="minPrice"label="最小销售价格"width="120" align="center">-->
        <!--</el-table-column>-->
        <!--<el-table-column prop="purchasePrice"label="进价（元）"width="120"  align="center">-->
        <!--</el-table-column>-->
        <!--<el-table-column prop="price"label="售价（元）"width="120" :align="center">-->
        <!--</el-table-column>-->
        <!--<el-table-column prop="unit"label="计量单位"width="200"  align="center">-->
        <!--</el-table-column>-->
        <!--<el-table-column prop="purchaser"label="进货商"width="200"  align="center">-->
        <!--</el-table-column>-->
        <!--<el-table-column prop="purchaserPhone"label="进货商电话"width="200"  align="center">-->
        <!--</el-table-column>-->
        <el-table-column fixed="right"label="操作"width="100" align="center">
          <template slot-scope="scope" >
            <el-button @click="detail(scope.row.productId)" type="text" size="small">查看</el-button>
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
  </div>
</template>
<script>
  import axios from 'axios';
  import Message from "element-ui/packages/message/src/main";
    export default {
        data() {
            return {
              drugs:[],
              total:'',
              currentPage:1,
              size: 10,
              drugsName:'',
              drugsType:'',
              options: [{
                value: '药品',
                label: '药品'
              }, {
                value: '保健品',
                label: '保健品'
              }],
            }
        },
      created:function() {
        this.getDrugsList();
      },
      methods:{
        clean:function(){
          this.drugsName='';
          this.drugsType='';
          this.getDrugsList();
        },
        detail(index){
          console.log(index);
          this.$router.push({
            path: '/drugs/drugsDetail',
            query: {
              productId: index
            }
          })
        },
        handleSizeChange(val) {
          this.size = val;
          console.log(val);
          this.getDrugsList();
        },
        handleCurrentChange(val) {
          this.currentPage = val;
          console.log(`当前页: ${val}`);
          this.getDrugsList();
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
              _this.getDrugsList();
            })
        },
        getDrugsList(){
          let _this = this;
          axios.post("http://localhost:8087/product/page",{
              name_like:_this.drugsName,
              type:_this.drugsType,
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
                _this.drugs=[];
              }else{
                _this.drugs = resData.data;
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
