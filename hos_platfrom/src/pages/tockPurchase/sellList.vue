<template>
  <div align="center">
    <div class="demo-input-suffix" style="position:relative;left:-12%;">
      <el-input v-model="drugsName" style="width:20%;"placeholder="请输入关键字"prefix-icon="el-icon-search">
      </el-input>
      <el-date-picker v-model="data1" type="date" placeholder="选择日期">
      </el-date-picker>
      <el-button  @click="getList" type="text" size="small">查看</el-button>
      <el-button @click="clean" type="text" size="small">清空</el-button>
    </div>
    <hr>
    <div style="text-align: left;padding: 10px 20px">
      <el-button type="primary"@click="addSellList = true">进货</el-button>
    </div>
    <div algin="center">
      <el-table :data="list"  border style="width: 100%" class="table":header-cell-style="{'text-align':'center'}">
        <el-table-column prop="productId" label="编号"  width="120" align="center">
        </el-table-column>
        <el-table-column prop="name" label="药品名称"  width="200" :show-overflow-tooltip="true" align="center">
        </el-table-column>
        <el-table-column prop="stock"label="数量（库存）"width="120"  align="center">
        </el-table-column>
        <el-table-column prop="unit"label="计量单位"width="120"  align="center">
        </el-table-column>
        <el-table-column prop="minUnit"label="最小销售单位"width="120"  align="center">
        </el-table-column>
        <el-table-column prop="minPrice"label="最小销售价格"width="120" align="center">
        </el-table-column>
        <el-table-column prop="minUnitStock"label="最小销售单位存量"width="120" align="center">
        </el-table-column>
        <el-table-column prop="purchasePrice"label="进价（元）"width="120"  align="center">
        </el-table-column>
        <el-table-column prop="price"label="售价（元）"width="120" align="center">
        </el-table-column>

        <el-table-column prop="stockDate"label="进货时间"width="200"  align="center">
        </el-table-column>
        <el-table-column prop="purchaser"label="进货商"width="200"  align="center">
        </el-table-column>
        <el-table-column prop="purchaserPhone"label="进货商电话"width="200"  align="center">
        </el-table-column>
        <el-table-column fixed="right"label="操作"width="100" align="center">
          <template slot-scope="scope" >
            <el-button @click="handleClick(scope.row.productId)" type="text" size="small">修改</el-button>
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
    <!-- 新增弹出框 -->
    <el-dialog class="plan-eff-dialog" title="进货" :visible.sync="addSellList" width="70%" center>
      <template>
        <el-row>
          <el-col :span="12">
            <span class="ordsum">药品名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <span style="font-weight:bold;">
              <el-select v-model="productId" placeholder="请选择" style="width:70%;">
                <el-option
                  v-for="item in options"
                  :key="item.productId"
                  :label="item.name"
                  :value="item.productId">
                </el-option>
              </el-select>
            </span>
          </el-col>
          <el-col :span="12">
            <span class="ordsum">数量（库存）&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <span style="font-weight:bold;"><el-input  style="width:70%;" type="number" v-model="stock"></el-input></span>
          </el-col>
        </el-row>
        <el-row style="margin-top: 20px">
          <el-col :span="12">
            <span class="ordsum">进价（元）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <span style="font-weight:bold;"><el-input  style="width:70%;" type="number" v-model="purchasePrice"></el-input></span>
          </el-col>
          <el-col :span="12">
            <span class="ordsum">计量单位：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <span style="font-weight:bold;">
               <el-select v-model="unit" placeholder="请选择" style="width: 70%;">
                  <el-option label="盒" value="包"></el-option>
                </el-select>
            </span>
          </el-col>
        </el-row>
        <el-row style="margin-top: 20px">
          <el-col :span="12">
            <span class="ordsum">售价（元）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <span style="font-weight:bold;"><el-input  style="width:70%;" type="number" v-model="price"></el-input></span>
          </el-col>
          <el-col :span="12">
            <span class="ordsum">最小销售单位：</span>
            <span style="font-weight:bold;">
              <el-select v-model="minUnit" placeholder="请选择" style="width: 70%;">
                <el-option label="包" value="包"></el-option>
                <el-option label="粒" value="粒"></el-option>
                <el-option label="克" value="克"></el-option>
              </el-select>
            </span>
          </el-col>

        </el-row>

        <el-row style="margin-top: 20px">
          <el-col :span="12">
            <span class="ordsum">最小销售单位存量：</span>
            <span style="font-weight:bold;"><el-input  style="width:63%;" type="number" v-model="minUnitStock"></el-input></span>
          </el-col>
          <el-col :span="12">
            <span class="ordsum">最小销售价格：</span>
            <span style="font-weight:bold;"><el-input  style="width:70%;" type="number" v-model="minPrice"></el-input></span>
          </el-col>

        </el-row>
        <el-row style="margin-top: 20px">
          <el-col :span="12">
            <span class="ordsum">进货时间：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <span style="font-weight:bold;">
              <el-date-picker v-model="stockDate" style="width:70%;" type="date" placeholder="选择日期">
              </el-date-picker>
            </span>
          </el-col>
          <el-col :span="12">
            <span class="ordsum">进货商：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <span style="font-weight:bold;"><el-input  style="width:70%;"  v-model="purchaser"></el-input></span>
          </el-col>
        </el-row>
        <el-row style="margin-top: 20px;">
          <el-col :span="12">
            <span class="ordsum">进货商电话：&nbsp;&nbsp;&nbsp;</span>
            <span style="font-weight:bold;"><el-input  style="width:70%;" type="number" v-model="purchaserPhone"></el-input></span>
          </el-col>
          <el-col :span="12">
            <el-button type="primary" @click="addSell" style="margin-left: 50%">确 定</el-button>
          </el-col>
        </el-row>

        <!--<span slot="footer" class="dialog-footer">-->
          <!--<el-button type="primary" @click="">确 定</el-button>-->
        <!--</span>-->
      </template>
    </el-dialog>
  </div>
</template>
<script>
  import axios from 'axios';
  import Message from "element-ui/packages/message/src/main";
  function dateFormat(createTime) {
    var date=new Date(createTime);
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
              addSellList:false,
              data1:'',
              total:'',
              currentPage:1,
              size: 10,
              drugsName:'',
              drugsType:'',
              options:[],
              productId:'',
              stock:'',
              purchasePrice:'',
              price:'',
              unit:'',
              minPrice:'',
              minUnit:'',
              minUnitStock:'',
              stockDate:'',
              purchaser:'',
              purchaserPhone:'',

            }
        },
      created:function() {
        this.getList();
        this.getDrugsList();
      },
      methods:{
        clean:function(){
          this.drugsName='';
          this.data1='';
          this.getList();
        },
        clear(){
          this.productId="";
           this.stock="";
            this.purchasePrice="";
            this.price="";
            this.unit="";
            this.minPrice="";
            this.minUnit="";
            this.minUnitStock="";
            this.stockDate="";
            this.purchaser="";
            this.purchaserPhone="";
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
        disabledDate(time) {
          let data= time.getTime() > Date.now();
          return time.getTime() > Date.now();
          console.log(data);
        },
        addSell(){
          if (this.productId=="") {
            Message({
              showClose: true,
              message: "请选择药品名称!" ,
              type: "error"
            });
          }else if (this.stock=="") {
            Message({
              showClose: true,
              message: "请输入数量（存量）!" ,
              type: "error"
            });
          }else if (this.purchasePrice=="") {
            Message({
              showClose: true,
              message: "请输入进价!" ,
              type: "error"
            });
          }else if (this.price=="") {
            Message({
              showClose: true,
              message: "请输入售价!" ,
              type: "error"
            });
          }else if (this.unit=="") {
            Message({
              showClose: true,
              message: "请输入计量单位!" ,
              type: "error"
            });
          }else if (this.minPrice=="") {
            Message({
              showClose: true,
              message: "请输入最小销售价格" ,
              type: "error"
            });
          }else if (this.minUnit=="") {
            Message({
              showClose: true,
              message: "请选择最小销售单位!" ,
              type: "error"
            });
          }else if (this.minUnitStock=="") {
            Message({
              showClose: true,
              message: "请输入最小销售单位存量!" ,
              type: "error"
            });
          }else if (this.stockDate=="") {
            Message({
              showClose: true,
              message: "请选择进货时间!" ,
              type: "error"
            });
          }else if (this.purchaser=="") {
            Message({
              showClose: true,
              message: "请输入采购商" ,
              type: "error"
            });
          }else if (this.purchaserPhone=="") {
            Message({
              showClose: true,
              message: "请输入采购商电话!" ,
              type: "error"
            });
          }else {
            var _this = this;
            var purchasePrice=parseInt(_this.purchasePrice);
            var price=parseInt(_this.price);
            var minPrice=parseInt(_this.minPrice);
            var stock=parseInt(_this.stock);
            axios.post("http://localhost:8087/product", {
              productId: _this.productId,
              stock: stock,
              purchasePrice: purchasePrice,
              price: price,
              unit: _this.unit,
              minPrice: minPrice,
              minUnit: _this.minUnit,
              minUnitStock: _this.minUnitStock,
              stockDate: dateFormat(_this.stockDate),
              purchaser: _this.purchaser,
              purchaserPhone: _this.purchaserPhone
            }).then(function (res) {
              console.log(res)
              if (res.data.code == 0) {
                Message({
                  showClose: true,
                  message: "添加成功:",
                  type: "success"
                });
                _this.addSellList=false;
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
        },
        getList(){
          let _this = this;
          var data=_this.data1;
          if(data){
            data=dateFormat(_this.data1);
          }else{
          }
          axios.post("http://localhost:8087/sell/page",{
            // params:{
            name_like:_this.drugsName,
            stockDate:data,
            page:_this.currentPage,
            size:_this.size
            // }
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
                const list=resData.data;

                list.map(item=>{//遍历循环数组，跟for循环效果一样，更简洁方便
                  var type=item.type;
                  var stock=item.stock;//存量 库存
                  var purchasePrice=item.purchasePrice;//进价
                  var price=item.price;//售价
                  var unit=item.unit;//计量单位 包、粒、克
                  var minPrice=item.minPrice;//最小销售单位 销售价格（（100分/粒/包/克））
                  var minUnit=item.minUnit//最小销售单位（粒/包/克）
                  var purchaser=item.purchaser;
                  var purchaserPhone=item.purchaserPhone;
                  if(type=="1"){
                    type="药品";
                  }else if(type=="2"){
                    type="保健品";
                  }
                  if(stock==null){
                    stock="暂无"
                  }
                  if(purchasePrice==null){
                    purchasePrice="暂无"
                  }else{
                    purchasePrice=purchasePrice/100;
                  }
                  if(price==null){
                    price="暂无"
                  }else{
                    price=price/100;
                  }
                  if(unit==null){
                    unit="暂无"
                  }
                  if(minUnit==null){
                    minUnit="暂无"
                  }
                  if(minPrice==null){
                    minPrice="暂无"
                  }else{
                    minPrice=minPrice/100;
                  }
                  if(purchaser==null){
                    purchaser="暂无"
                  }
                  if(purchaserPhone==null){
                    purchaserPhone="暂无"
                  }
                  //把值重新写入list
                  item.type=type;
                  item.stock=stock;
                  item.purchasePrice=purchasePrice;
                  item.price=price;
                  item.unit=unit;
                  item.minUnit=minUnit;
                  item.minPrice=minPrice;
                  item.purchaser=purchaser;
                  item.purchaserPhone=purchaserPhone
                })
                _this.list = list;
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
        },
        getDrugsList(){
          let _this = this;
          axios.post("http://localhost:8087/product/page",{
            page:_this.currentPage,
            size:_this.size
          }).then(function (res) {
            const resData = res.data;
            console.log(resData);
            if (resData.code == "0" ) {
                _this.options = resData.data;
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
