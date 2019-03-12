package com.dininghall.dhall.system.service;

import com.dininghall.dhall.system.model.Dishs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
/**
 * @ClassName: PerformerService
 * @Description: 菜品模块服务层接口类
 * @Author: MSI
 * @Date: 2019/1/31 10:47
 * @Vresion: 1.0.0
 **/
public interface DishsService {

    Page<Dishs> findAllByNameContaining(String name, Pageable pageable);

    /*
     * @Author xyr
     * @Description //TODO 根据菜品名模糊和菜品类别来查询
     * @Date  2019/3/6
     * @Param [name, type]
     * @return com.dininghall.dhall.system.model.Dishs
     **/
    Dishs findByNameContainingAndType(String name,String type);
    List<Dishs> findAllByIdIn(List<Long> id);
    void save(Dishs dishs);
    void  delete(Dishs dishs);
    Dishs findById(long id);
    List<Dishs> findAll();

}
