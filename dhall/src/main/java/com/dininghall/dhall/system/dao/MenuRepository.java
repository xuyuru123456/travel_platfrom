package com.dininghall.dhall.system.dao;

import com.dininghall.dhall.system.model.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: MenuRepository
 * @Description: TODO菜单DAO接口，继承JPA的JpaRepository接口，JpaRepository<实体名,主键数据类型>
 *  *                可以直接使用其接口的基本方法（增删改查）
 *  *                需要新方法可以根据关键字编写接口，JPA会自动完成查询语句。
 * @Author: XYR
 * @Date: 2019/3/8 14:18
 * @Vresion: 1.0.0
 **/
@Repository
public interface MenuRepository extends JpaRepository<Menu,Long> {
    Page<Menu> findAllByIdContaining(Long id, Pageable pageable);
    Menu findById(long id);
    List<Menu> findAll();
}
