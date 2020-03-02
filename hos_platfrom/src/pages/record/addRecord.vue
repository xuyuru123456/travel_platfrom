<template>
  <div>
    <div style="font-size: 30px;font-weight: bold">新增就诊</div>
    <el-form ref="record" :model="record" :rules="rules"  style="margin-top: 30px">
      <el-row>
        <el-col :span="6">
          <div class="grid-content bg-purple">
            <el-form-item label="姓名" prop="name" style="width: 100%">
              <el-input v-model="record.name" placeholder="请输入"style="width: 60%;margin-left: -10%"></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="6">
          <div class="grid-content bg-purple-light">
            <el-form-item label="年龄" prop="type" style="width: 100%">
              <el-input v-model="record.age"placeholder="请输入"type="number" style="width: 60%;margin-left: -10%"></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="6">
          <div class="grid-content bg-purple-light">
            <el-form-item label="性别" prop="type" style="width: 100%">
              <el-select v-model="record.sex" placeholder="请选择" style="width: 60%;margin-left: -10%">
                <el-option label="男" value="男"></el-option>
                <el-option label="女" value="女"></el-option>
              </el-select>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="6">
          <div class="grid-content bg-purple-light">
            <el-form-item label="籍贯" prop="type" style="width: 100%">
              <el-input v-model="record.location"placeholder="请输入" style="width: 60%;margin-left: -10%"></el-input>
            </el-form-item>
          </div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="6">
          <div class="grid-content bg-purple-light">
            <el-form-item label="体温" prop="price" style="width: 100%">
              <el-input v-model="record.temperature"placeholder="请输入" type="number" style="width: 60%;margin-left: -10%"></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="6">
          <el-form-item label="有无接触湖北/武汉人员" prop="phone" style="width: 100%">
            <el-radio-group v-model="ishb" style="">
            <el-radio-button :label="true" >有</el-radio-button>
            <el-radio-button :label="false" >无</el-radio-button>
            </el-radio-group>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="有无疑似症状" prop="phone" style="width: 100%">
            <el-radio-group v-model="iszz" style="">
              <el-radio-button :label="true" >有</el-radio-button>
              <el-radio-button :label="false" >无</el-radio-button>
            </el-radio-group>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <div class="grid-content bg-purple">
            <el-form-item label="诊断" prop="phone" style="width: 100%">
              <el-input v-model="record.diagnosis"placeholder="请输入" type="textarea" style="width: 85%;margin-left: -10%;"></el-input>
            </el-form-item>
          </div>
        </el-col>
      </el-row>
    </el-form>
    <!--<el-row>-->
      <!--<el-col :span="12">-->
        <el-card align="center" style="margin-bottom: 20px">
          <div class="demo-input-suffix" style="position:relative;left:-12%;">
            <el-input style="width:20%;" placeholder="请输入药品名" prefix-icon="el-icon-search" v-model="scenicName">
            </el-input>
            <el-select v-model="location1" placeholder="请选择">
              <el-option v-for="item in options" :key="item.value"  :label="item.label" :value="item.value"> </el-option>
            </el-select>
            <el-button  @click="getSpotList" type="text" size="small">查看</el-button>
            <el-button @click="clean" type="text" size="small">清空</el-button>
          </div>
          <hr>
          <div algin="center">
            <el-table :data="drugs"  border style="width: 100%" class="table":header-cell-style="{'text-align':'center'}">
              <el-table-column prop="id" label="药品编号"   align="center">
              </el-table-column>
              <el-table-column prop="name" label="药品名称"   align="center">
              </el-table-column>
              <el-table-column prop="sellPrice" label="药品价格(盒)" w align="center">
              </el-table-column>
              <el-table-column prop="amount" label="数量（盒）"  align="center">
              </el-table-column>
              <el-table-column prop="smallUnit" label="数量（包/粒/克）"  align="center">
              </el-table-column>
              <el-table-column prop="smallPrice" label="最小销售价格（包/粒/克）"  align="center">
              </el-table-column>
            </el-table>

            <div class="block" >
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
        </el-card>
      <!--</el-col>-->
      <!--<el-col :span="12">-->
        <el-card class="drugsTable">
          <span class="cardHeader">药方</span>

          <el-table :data="drugs" stripe border>
            <el-table-column label="药品编号">
              <template slot-scope="scope">
                <div class="drugsDiv">
                  <el-input v-model="scope.row.drugsId" placeholder=""> </el-input>
                </div>
              </template>
            </el-table-column>
            <el-table-column label="药品名称">
              <template slot-scope="scope">
                <div class="drugsDiv">
                  <el-input v-model="scope.row.name" placeholder=""></el-input>
                </div>
              </template>
            </el-table-column>
            <el-table-column label="数量（盒）">
              <template slot-scope="scope">
                <div class="drugsDiv">
                  <el-input v-model="scope.row.amount" type="number"placeholder=""></el-input>
                </div>
              </template>
            </el-table-column>
            <el-table-column label="数量（包/粒/克）">
              <template slot-scope="scope">
                <div class="drugsDiv">
                  <el-input v-model="scope.row.smallUnit" type="number"placeholder=""></el-input>
                </div>
              </template>
            </el-table-column>

            <el-table-column label="操作"
                             width="136px">
              <template slot-scope="scope">
                <el-button type="success"
                           size="mini"
                           icon="el-icon-circle-plus-outline"
                           v-if="scope.row.show === 'true'"
                           plain
                           @click="pushNewEducation(scope.$index)">
                </el-button>
                <el-button type="danger"
                           size="mini"
                           icon="el-icon-delete"
                           plain
                           @click="deleteEducation(scope.$index)">
                </el-button>
              </template>
            </el-table-column>
          </el-table>
          <br>数据:{{drugs}}
        </el-card>
      <!--</el-col>-->
    <!--</el-row>-->

  </div>
</template>
<script>
    export default {
        data() {
            return {
              record:[],
              drugsL:[],
              // 药品
              drugs: [{
                // 编号
                drugsId: '',
                // 药品名
                name: '',
                // 数量（盒）
                amount: '',
                // 数量（包/粒/克）
                smallUnit: '',
                // 是否显示新增按钮
                show: 'true',
              }],
            }
        },methods:{
        handleCurrentChange(row, event, column) {
          console.log(row, event, column, event.currentTarget)
        },
        handleEdit(index, row) {
          console.log(index, row);
        },
        handleDelete(index, row) {
          console.log(index, row);
        },
        // 添加新的教育经历
        pushNewEducation(index) {
          const list = this.drugs;
          list[index].show = 'false';
          list.push({
            // 编号
            drugsId: '',
            // 药品名
            name: '',
            // 数量（盒）
            amount: '',
            // 数量（包/粒/克）
            smallUnit: '',
            // 是否显示新增按钮
            show: 'true',
          });
          this.drugs = list;
        },
        // 删除教育经历
        deleteEducation(index) {
          let list=[];
          list = this.drugs;
          if (index === 0 && list.length === 1) {
            list.splice(index, 1);
            list.push({
              // 编号
              drugsId: '',
              // 药品名
              name: '',
              // 数量（盒）
              amount: '',
              // 数量（包/粒/克）
              smallUnit: '',
              // 是否显示新增按钮
              show: 'true',
            });
          } else {
            list.splice(index, 1);
          }
          if (index === list.length) {
            list[index - 1].show = 'true';
          }
          list = this.drugs;
        },
      }

    }
</script>
<style scoped>
  /*body {*/
    /*font-family: Helvetica Neue, Helvetica, PingFang SC, Hiragino Sans GB, Microsoft YaHei, SimSun, sans-serif;*/
    /*overflow: auto;*/
    /*font-weight: 400;*/
    /*-webkit-font-smoothing: antialiased;*/
  /*}*/
  /*.tb-edit .el-input {*/
    /*display: none*/
  /*}*/
  /*.tb-edit .current-row .el-input {*/
    /*display: block*/
  /*}*/
  /*.tb-edit .current-row .el-input+span {*/
    /*display: none*/
  /*}*/
  /*.drugsTable {*/

  /*}*/
  /*.drugsDiv {*/
    /*width: 100%;*/
    /*overflow: hidden;*/
    /*border: 1px solid rgb(231, 227, 227);*/
    /*border-radius: 10px;*/


  /*}*/
  /*.el-input__inner {*/
    /*border: none;*/
  /*}*/
  /*.cardHeader {*/
    /*font-weight: bold;*/
    /*color: #606266;*/
    /*display: block;*/
    /*padding-bottom: 10px;*/
    /*margin-bottom: 20px;*/
    /*border-bottom: 1px solid rgb(211, 211, 211);*/
  /*}*/
</style>
