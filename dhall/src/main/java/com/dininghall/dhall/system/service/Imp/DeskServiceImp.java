package com.dininghall.dhall.system.service.Imp;

import com.dininghall.dhall.system.dao.DeskRepository;
import com.dininghall.dhall.system.model.Desk;
import com.dininghall.dhall.system.service.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: DeskServiceImp
 * @Description: TODO
 * @Author: XYR
 * @Date: 2019/3/10 18:01
 * @Vresion: 1.0.0
 **/
@Service
public class DeskServiceImp implements DeskService {
    @Autowired

    DeskRepository deskRepository;

    @Override
    public Page<Desk> findAllByIdContaining(Long id, Pageable pageable) {
        return deskRepository.findAllByIdContaining(id,pageable);
    }

    @Override
    public void save(Desk desk) {
        deskRepository.save(desk);
    }

    @Override
    public void delete(Desk desk) {
        deskRepository.delete(desk);
    }

    @Override
    public Desk findById(long id) {
        return deskRepository.findById(id);
    }

    @Override
    public List<Desk> findAll() {
        return deskRepository.findAll();
    }


}
