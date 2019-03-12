package com.dininghall.dhall.system.service.Imp;

import com.dininghall.dhall.system.dao.MenuRepository;
import com.dininghall.dhall.system.model.Menu;
import com.dininghall.dhall.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: MenuServiceImp
 * @Description: TODO菜单模块服务层实现类
 * @Author: XYR
 * @Date: 2019/3/8 17:14
 * @Vresion: 1.0.0
 **/
@Service
public class MenuServiceImp implements MenuService {
    @Autowired
    MenuRepository menuRepository;


    @Override
    public Page<Menu> findAllByIdContaining(Long id, Pageable pageable) {
        return menuRepository.findAllByIdContaining(id,pageable);
    }

    @Override
    public void save(Menu menu) {
        menuRepository.save(menu);
    }

    @Override
    public void delete(Menu menu) {
        menuRepository.delete(menu);
    }

    @Override
    public Menu findById(long id) {
        return menuRepository.findById(id);
    }

    @Override
    public List<Menu> findAll() {

        return menuRepository.findAll();
    }
}
