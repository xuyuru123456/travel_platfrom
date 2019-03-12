package com.dininghall.dhall.system.dao;

import com.dininghall.dhall.system.model.Desk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: DeskRepository
 * @Description: TODO
 * @Author: XYR
 * @Date: 2019/3/10 17:45
 * @Vresion: 1.0.0
 **/
@Repository
public interface DeskRepository extends JpaRepository<Desk,Long> {
    Page<Desk> findAllByIdContaining(Long id, Pageable pageable);

    Desk findById(long id);

    List<Desk> findAll();
}
