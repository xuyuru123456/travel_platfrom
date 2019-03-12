package com.dininghall.dhall.system.service;

import com.dininghall.dhall.system.model.Desk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @ClassName: DeskService
 * @Description: TODO桌号模块服务层接口类
 * @Author: XYR
 * @Date: 2019/3/10 17:59
 * @Vresion: 1.0.0
 **/
public interface DeskService {
    Page<Desk> findAllByIdContaining(Long id, Pageable pageable);
    void save(Desk desk);
    void  delete(Desk desk);
    Desk findById(long id);
    List<Desk> findAll();
}
