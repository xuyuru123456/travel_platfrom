package com.dininghall.dhall.system.service;


import com.dininghall.dhall.system.model.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @ClassName: MenuService
 * @Description: TODO菜单模块服务层接口类
 * @Author: XYR
 * @Date: 2019/3/8 14:23
 * @Vresion: 1.0.0
 **/
public interface MenuService {
    Page<Menu>findAllByIdContaining(Long id, Pageable pageable);
    void save(Menu menu);
    void  delete(Menu menu);
    Menu findById(long id);
    List<Menu> findAll();
}
