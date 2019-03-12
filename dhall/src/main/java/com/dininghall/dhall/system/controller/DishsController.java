package com.dininghall.dhall.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.dininghall.dhall.framework.configurer.Permission;
import com.dininghall.dhall.framework.entity.PermissionConstants;
import com.dininghall.dhall.framework.entity.Response;
import com.dininghall.dhall.framework.entity.StatusEnum;
import com.dininghall.dhall.framework.until.CommUtil;
import com.dininghall.dhall.framework.until.FileUtil;
import com.dininghall.dhall.system.model.Dishs;
import com.dininghall.dhall.system.service.DishsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;

/**
 * @ClassName: DishsController
 * @Description: TODO 菜品控制器
 * @Author: XYR
 * @Date: 2019/3/6 16:10
 * @Vresion: 1.0.0
 **/
@RestController
public class DishsController {

    @Autowired
    DishsService dishsService;
    /*
     * @Author xyr
     * @Description //TODO 添加菜品
     * @Date  2019/3/7
     * @Param [name, type, price, sellOut, promote, multipartFile, make, create_time]
     * @return com.dininghall.dhall.framework.entity.Response
     **/
    @PostMapping("/dishs")
    @Permission(PermissionConstants.USER_ROLE_MANAGER)
    public Response add(@RequestParam("name") String name,
                        @RequestParam("type") String type,
                        @RequestParam("price") String price,
                        @RequestParam("sellOut") String sellOut,
                        @RequestParam("promote") String promote,
                        @RequestParam("image") MultipartFile multipartFile,
                        @RequestParam("make") String make,
                        @RequestParam("createTime") String createTime) {
        System.out.println("multipartFile ="+ multipartFile.getOriginalFilename());
        //1.1 验证数据完整性，参数是否完整
        if(CommUtil.isNullString(name,type,price,sellOut,promote,make,createTime)){
            return Response.factoryResponse(StatusEnum.SYSTEM_ERROR_9002.getCode(),StatusEnum.SYSTEM_ERROR_9002.getData());
        }
        //1.2验证菜品是否存在
        if (dishsService.findByNameContainingAndType(name,type)!=null){
            return Response.factoryResponse(StatusEnum.DISHS_ERROR_4001.getCode(),StatusEnum.DISHS_ERROR_4001.getData());
        }
        //2封装数据
        Dishs dishs = new Dishs();
        dishs.setName(name);
        dishs.setType(type);
        dishs.setPrice(Float.valueOf(price));
        dishs.setSellOut(Boolean.valueOf(sellOut));
        dishs.setPromote(Boolean.valueOf(promote));
        dishs.setMake(make);
        dishs.setCreateTime(CommUtil.stringToDate(createTime,"yyyy-MM-dd"));
        //3调用工具类保存图片
        String fileName  = FileUtil.fileUpload("dishs",multipartFile);
        if (fileName == null){
            return Response.factoryResponse(StatusEnum.SYSTEM_ERROR_9004.getCode(),StatusEnum.SYSTEM_ERROR_9004.getData());
        }
        //4.写入图片路径，保存演员信息
        dishs.setImage(fileName);
        try {
            dishsService.save(dishs);
        }catch (Exception e){
            return Response.factoryResponse(StatusEnum.RET_INSERT_FAIL.getCode(),StatusEnum.RET_INSERT_FAIL.getData());
        }
        return Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),StatusEnum.RESPONSE_OK.getData());
    }

    /*
     * @Author xyr
     * @Description //TODO 删除菜品
     * @Date  2019/3/7
     * @Param
     * @return
     **/
    @DeleteMapping("/dishs/{id}")
    public Response delete(@PathVariable Long id){
        //1.验证数据完整性
        if (CommUtil.isNullValue(id)){
            return Response.factoryResponse(StatusEnum.SYSTEM_ERROR_9002.getCode(),StatusEnum.SYSTEM_ERROR_9002.getData());
        }
        //2.查找菜品
        Dishs dishs = dishsService.findById(id);
        if (dishs == null){
            return Response.factoryResponse(StatusEnum.DISHS_ERROR_4002.getCode(),StatusEnum.DISHS_ERROR_4002.getData());
        }
        //3.删除失败的话报错
        try {
            dishsService.delete(dishs);
        }catch (Exception e){
            return Response.factoryResponse(StatusEnum.RET_DELETE_FAIL.getCode(),StatusEnum.RET_DELETE_FAIL.getData());
        }
        return Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),StatusEnum.RESPONSE_OK.getData());
    }

    /*
     * @Author xyr
     * @Description //TODO 修改菜品信息
     * @Date  2019/3/7
     * @Param
     * @return
     **/
    @PutMapping("dishs")
    @Permission(PermissionConstants.USER_ROLE_MANAGER)
    public Response update(@RequestBody JSONObject data){
        //1.接收数据
        Long id = data.getLong("id");
        String name = data.getString("name");
        String type = data.getString("type");
        float price = data.getFloat("price");
        boolean sellOut = data.getBoolean("sellOut");
        boolean promote = data.getBoolean("promote");
        String make = data.getString("make");
        Date createTime = data.getSqlDate("createTime");
        //2.1 验证数据完整性
        if (CommUtil.isNullValue(id)){
            return Response.factoryResponse(StatusEnum.SYSTEM_ERROR_9002.getCode(),StatusEnum.SYSTEM_ERROR_9002.getData());
        }
        //2.2 验证菜品是否存在
        Dishs dishs = dishsService.findById(id);
        if (dishs == null){
            return Response.factoryResponse(StatusEnum.DISHS_ERROR_4002.getCode(),StatusEnum.DISHS_ERROR_4002.getData());
        }
        //3.修改菜品信息
        dishs.setName(name);
        dishs.setType(type);
        dishs.setPrice(price);
        dishs.setSellOut(sellOut);
        dishs.setPromote(promote);
        dishs.setMake(make);
        dishs.setCreateTime(createTime);
        try {
            dishsService.save(dishs);
        }catch (Exception e){
            return  Response.factoryResponse(StatusEnum.RET_UPDATE_FAIL.getCode(),StatusEnum.RET_UPDATE_FAIL.getData());
        }
        return  Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),StatusEnum.RESPONSE_OK.getData());
    }

    /*
     * @Author xyr
     * @Description //TODO 查询菜品详细 根据id
     * @Date  2019/3/7
     * @Param []
     * @return com.dininghall.dhall.framework.entity.Response
     **/
    @GetMapping("/dishs/{id}")
    public Response detaail(@PathVariable("id")Long id){
        //1.验证数据完整性
        if (CommUtil.isNullValue(id)){
            return Response.factoryResponse(StatusEnum.SYSTEM_ERROR_9002.getCode(),StatusEnum.SYSTEM_ERROR_9002.getData());
        }
        //2.查询菜品是否存在
        Dishs dishs = dishsService.findById(id);
        if (dishs == null){
            return Response.factoryResponse(StatusEnum.DISHS_ERROR_4002.getCode(),StatusEnum.DISHS_ERROR_4002.getData());
        }
        return Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),dishs);
    }
    /*
     * @Author xyr
     * @Description //TODO 查询菜品列表
     * @Date  2019/3/6
     * @Param []
     * @return com.dininghall.dhall.framework.entity.Response
     **/
    @GetMapping("/dishs")
    public Response list(){
        List<Dishs> dishsList = dishsService.findAll();
        return Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),dishsList);
    }
}
