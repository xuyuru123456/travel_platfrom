package com.dininghall.dhall.system.controller;

import com.dininghall.dhall.framework.entity.Response;
import com.dininghall.dhall.framework.entity.StatusEnum;
import com.dininghall.dhall.system.model.Desk;
import com.dininghall.dhall.system.service.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: DeskController
 * @Description: TODO
 * @Author: XYR
 * @Date: 2019/3/10 18:03
 * @Vresion: 1.0.0
 **/
@RestController
public class DeskController {
    @Autowired
    DeskService deskService;
    @GetMapping("/desk")
    public Response list(){
        List<Desk> dishsList = deskService.findAll();
        return Response.factoryResponse(StatusEnum.RESPONSE_OK.getCode(),dishsList);
    }

}
