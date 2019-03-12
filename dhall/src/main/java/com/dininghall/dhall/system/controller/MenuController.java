package com.dininghall.dhall.system.controller;

import com.dininghall.dhall.framework.configurer.Permission;
import com.dininghall.dhall.framework.entity.PermissionConstants;
import com.dininghall.dhall.framework.entity.Response;
import com.dininghall.dhall.framework.entity.StatusEnum;
import com.dininghall.dhall.framework.until.CommUtil;
import com.dininghall.dhall.system.model.Desk;
import com.dininghall.dhall.system.model.Dishs;
import com.dininghall.dhall.system.model.Menu;
import com.dininghall.dhall.system.service.DeskService;
import com.dininghall.dhall.system.service.DishsService;
import com.dininghall.dhall.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: MenuController
 * @Description: TODO菜单控制器
 * @Author: XYR
 * @Date: 2019/3/8 17:28
 * @Vresion: 1.0.0
 **/
@RestController
public class MenuController {
    @Autowired
    MenuService menuService;

    @Autowired
    DishsService dishsService;

    @Autowired
    DeskService deskService;

    @PostMapping("/menu")
    @Permission((PermissionConstants.USER_ROLE_MANAGER))
    public Response add(@RequestParam("time") String time,
                        @RequestParam("totalPrice") String tatalPrice,
                        @RequestParam("dishsId") String dishsId,
                        @RequestParam("deskId") String deskId){
        //1.1 验证完整性
        if (CommUtil.isNullString(time,tatalPrice)){
            return Response.factoryResponse(StatusEnum.SYSTEM_ERROR_9002.getCode(),StatusEnum.SYSTEM_ERROR_9002.getData());
        }
        //1.2 验证菜品是否存在
        List<Dishs> dishsList = dishsService.findAllByIdIn(CommUtil.splitString(dishsId));
        if (dishsList == null){
            return Response.factoryResponse(StatusEnum.DISHS_ERROR_4005.getCode(),StatusEnum.DISHS_ERROR_4005.getData());
        }
        //1.3验证桌号是否存在
        Desk desk = deskService.findById(Long.valueOf(deskId));
        if (desk == null){
            return Response.factoryResponse(StatusEnum.DESK_ERROR_3002.getCode(),StatusEnum.DESK_ERROR_3002.getData());
        }
        //2 封装数据
        Menu menu = new Menu();
        menu.setTime(CommUtil.stringToDate(time,"yyyy-MM-dd HH:mm:ss"));
        menu.setTotalPrice(tatalPrice);
        menu.setDishsList(dishsList);
        menu.setDesk(desk);
        //保存菜单
        try {
            menuService.save(menu);
            return  Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),StatusEnum.RESPONSE_OK.getData());
        }catch (Exception e){
            return Response.factoryResponse(StatusEnum.RET_INSERT_FAIL.getCode(),StatusEnum.RET_INSERT_FAIL.getData());
        }
    }
    /*
     * @Author xyr
     * @Description //TODO 查询菜单详情
     * @Date  2019/3/10
     * @Param [id]
     * @return com.dininghall.dhall.framework.entity.Response
     **/
    @GetMapping("/menu/{id}")
    public Response detail(@PathVariable("id") Long id){
        if (CommUtil.isNullValue(id)){
            return Response.factoryResponse(StatusEnum.SYSTEM_ERROR_9002.getCode(),StatusEnum.SYSTEM_ERROR_9002.getData());
        }
        Menu menu=menuService.findById(id);
        if (menu == null){
            return Response.factoryResponse(StatusEnum.MENU_ERROR_2002.getCode(),StatusEnum.MENU_ERROR_2002.getData());
        }
        return Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),menu);
    }
    /*
     * @Author xyr
     * @Description //TODO  查询菜单列表
     * @Date  2019/3/8
     * @Param []
     * @return com.dininghall.dhall.framework.entity.Response
     **/
    @GetMapping("/menu")
    public Response list(){
        List<Menu> menuList = menuService.findAll();
        return Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),menuList);
    }
}
