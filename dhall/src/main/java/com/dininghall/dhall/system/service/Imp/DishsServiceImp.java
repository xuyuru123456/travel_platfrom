package com.dininghall.dhall.system.service.Imp;

import com.dininghall.dhall.system.dao.DishsRepository;
import com.dininghall.dhall.system.model.Dishs;
import com.dininghall.dhall.system.service.DishsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: DishsServiceImp
 * @Description: TODO菜品模块服务层实现类
 * @Author: XYR
 * @Date: 2019/3/6 15:43
 * @Vresion: 1.0.0
 **/
@Service
public class DishsServiceImp implements DishsService {
    @Autowired
    DishsRepository dishsRepository;

    @Override
    public Page<Dishs> findAllByNameContaining(String name, Pageable pageable) {
        return dishsRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Dishs findByNameContainingAndType(String name, String type) {
            return dishsRepository.findAllByNameContainingAndType(name,type);
    }

    @Override
    public List<Dishs> findAllByIdIn(List<Long> id) {
        return dishsRepository.findAllByIdIn(id);
    }

    @Override
    public void save(Dishs dishs) {
        dishsRepository.save(dishs);
    }

    @Override
    public void delete(Dishs dishs) {
        dishsRepository.delete(dishs);
    }

    @Override
    public Dishs findById(long id) {
        return dishsRepository.findById(id);
    }

    @Override
    public List<Dishs> findAll() {

        return dishsRepository.findAll();
    }
}
