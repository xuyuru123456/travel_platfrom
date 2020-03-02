<template>
  <div>
    <div style="font-size: 30px">全国疫情数据</div>
    <el-row>
      <el-col :span="6">
        <div class="number" style=" background: #CC4100;">
          确诊：77046
        </div>
      </el-col>
      <el-col :span="6">
        <div class="number" style=" background: #ffce1f;">
          疑似：4148
        </div>
      </el-col>
      <el-col :span="6">
        <div class="number" style=" background: #A59A9A;">
          死亡：2445
        </div>
      </el-col>
      <el-col :span="6">
        <div class="number" style=" background: #008D5E;">
          治愈：23034
        </div>
      </el-col>
    </el-row>
    <div style="font-size: 30px">福建省疫情数据</div>
    <div style="text-align: left;padding: 10px 20px">
      <el-button type="primary"@click="showAddInfo">新增市数据</el-button>
    </div>
    <div algin="center">
      <el-table :data="list"  border style="width: 100%" class="table":header-cell-style="{'text-align':'center'}">
        <el-table-column prop="province" label="地区"  width="" align="center">
        </el-table-column>
        <el-table-column prop="confirmed" label="确诊(人)" width="" color="red" align="center">
        </el-table-column>
        <el-table-column prop="suspected" label="疑似(人)" width="" align="center">
        </el-table-column>
        <el-table-column prop="death" label="死亡(人)" width="" align="center">
        </el-table-column>
        <el-table-column prop="cured" label="治愈(人)" width="" align="center">
        </el-table-column>
        <el-table-column prop="date" label="更新时间" width="" align="center">
        </el-table-column>
        <el-table-column fixed="right"label="操作"width="100" align="center">
          <template slot-scope="scope" >
            <el-button @click="handleClick(scope.row.sceneryId)" type="text" size="small">修改</el-button>
            <!--<el-button @click="deleteById(scope.row.sceneryId)" type="text" size="small">删除</el-button>-->
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
    <el-dialog class="plan-eff-dialog" title="添加" :visible.sync="addInfo" width="30%" center>
      <div>
        <span class="ordsum">地区：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span style="font-weight:bold;">
          <el-select v-model="province" placeholder="请选择" style="width: 70%;">
            <el-option label="福州市" value="福州市"></el-option>
            <el-option label="厦门市" value="厦门市"></el-option>
            <el-option label="泉州市" value="泉州市"></el-option>
            <el-option label="三明市" value="三明市"></el-option>
          </el-select>
        </span>
      </div>
      <div style="padding-top: 10px;">
        <span class="ordsum">确诊：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span style="font-weight:bold;"><el-input  style="width:70%;" v-model="confirmed"></el-input></span>
      </div>
      <div style="padding-top: 10px;">
        <span class="ordsum">疑似：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span style="font-weight:bold;"><el-input  style="width:70%;" v-model="suspected"></el-input></span>
      </div>
      <div style="padding-top: 10px;">
        <span class="ordsum">死亡：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span style="font-weight:bold;"><el-input  style="width:70%;" v-model="death"></el-input></span>
      </div>
      <div style="padding-top: 10px;">
        <span class="ordsum">治愈：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span style="font-weight:bold;"><el-input  style="width:70%;" v-model="cured"></el-input></span>
      </div>
      <!--<div style="padding-top: 10px;">-->
        <!--<span class="ordsum">更新日期：</span>-->
        <!--<span style="font-weight:bold;">-->
        <!--<el-date-picker type="date" placeholder="选择日期" v-model="date" style="width: 70%;" ></el-date-picker>-->
         <!--</span>-->
      <!--</div>-->
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="add">提交</el-button>
      </div>
    </el-dialog>
    <el-dialog class="plan-eff-dialog" title="修改" :visible.sync="updataInfo" width="30%" center>
      <div style="padding-top: 10px;">
        <span class="ordsum">地区：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span style="font-weight:bold;"><el-input  :disabled="true" style="width:70%;" v-model="location1"></el-input></span>
      </div>
      <div style="padding-top: 10px;">
        <span class="ordsum">确诊：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span style="font-weight:bold;"><el-input  style="width:70%;" v-model="confirmed1"></el-input></span>
      </div>
      <div style="padding-top: 10px;">
        <span class="ordsum">疑似：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span style="font-weight:bold;"><el-input  style="width:70%;" v-model="suspected1"></el-input></span>
      </div>
      <div style="padding-top: 10px;">
        <span class="ordsum">死亡：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span style="font-weight:bold;"><el-input  style="width:70%;" v-model="death1"></el-input></span>
      </div>
      <div style="padding-top: 10px;">
        <span class="ordsum">治愈：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span style="font-weight:bold;"><el-input  style="width:70%;" v-model="cured1"></el-input></span>
      </div>
      <!--<div style="padding-top: 10px;">-->
        <!--<span class="ordsum">更新日期：</span>-->
        <!--<span style="font-weight:bold;">-->
        <!--<el-date-picker type="date" placeholder="选择日期" v-model="data1" style="width: 70%;" ></el-date-picker>-->
         <!--</span>-->
      <!--</div>-->
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
  import axios from 'axios';
  import Message from "element-ui/packages/message/src/main";
  function dateFormat() {
    var date=new Date();
    var year=date.getFullYear();
    /* 在日期格式中，月份是从0开始的，因此要加0
     * 使用三元表达式在小于10的前面加0，以达到格式统一  如 09:11:05
     * */
    var month= date.getMonth()+1<10 ? "0"+(date.getMonth()+1) : date.getMonth()+1;
    var day=date.getDate()<10 ? "0"+date.getDate() : date.getDate();
    // var hours=date.getHours()<10 ? "0"+date.getHours() : date.getHours();
    // var minutes=date.getMinutes()<10 ? "0"+date.getMinutes() : date.getMinutes();
    // var seconds=date.getSeconds()<10 ? "0"+date.getSeconds() : date.getSeconds();
    // 拼接
    return year+"-"+month+"-"+day;
  }
    export default {
        data() {
            return {
              list:[],
              total:'',
              currentPage:1,
              size: 10,
              addInfo:false,
              updataInfo:false,
              province:'',
              confirmed:'',
              suspected:'',
              death:'',
              cured:'',
              data:'',
              province1:'',
              confirmed1:'',
              suspected1:'',
              death1:'',
              cured1:'',
              data1:''
            }
        },
      created:function() {
        this.getList();
      },
      methods:{
          clear(){
            this.province="";
            this.confirmed="";
            this.suspected="";
            this.death="";
            this.cured="";
          },
        handleSizeChange(val) {
          this.size = val;
          console.log(val);
        },
        handleCurrentChange(val) {
          this.currentPage = val;
          console.log(`当前页: ${val}`);
        },
        showAddInfo(){
          this.addInfo=true;
        },
        add(){
          var _this=this;
          let data=dateFormat();

          axios.post("http://localhost:8087/epidemic",{
            province:_this.province,
            // date: dateFormat(_this.data),
            data:data,
            confirmed:_this.confirmed,
            suspected:_this.suspected,
            death:_this.death,
            cured:_this.cured
          }).then(function (res) {
            console.log(res);
            if (res.data.code == 0) {
              Message({
                showClose: true,
                message: "添加成功:",
                type: "success"
              });
              this.addInfo=false;
              _this.clear();
            } else {
              Message({
                showClose: true,
                message: "失败:" + res.data.data,
                type: "error"
              });
            }
          })
        },
        handleClick(){
          var _this=this;
          this.updataInfo=true;

        },
        getList(){
          let _this = this;
          axios.post("http://localhost:8087/epidemic/page",{
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
                _this.list = resData.data;
                _this.currentPage = resData.total.currentPage;
                _this.total = resData.total.total;
                console.log(_this.total);
              }

            }
          }).catch(function(response){
            Message({
              showClose: true,
              message:response.data ,
              type: "error"
            });
          })
        }
      }

    }
</script>
<style scoped>
  .number{
    margin: 10% 10%;
    border-radius: 10px;
    height: 100px;
    line-height: 100px;
    color: #fff;
    font-size: 28px;
    box-shadow:3px 3px 5px #bababa
  }
  .ordsum{
    font-size: 14px;
  }
  el-dialog {
    position: relative;
    margin: 0 auto 50px;
    border-radius: 2px;
    -webkit-box-shadow: 0 1px 3px rgba(0,0,0,.3);
    box-shadow: 0 1px 3px rgba(0,0,0,.3);
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    border-radius: 10px;
    width: 50%;
  }
</style>
