package com.dininghall.dhall.system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: Menu
 * @Description: TODO菜单表
 * @Author: XYR
 * @Date: 2019/3/8 14:08
 * @Vresion: 1.0.0
 **/
@Entity
public class Menu {
    @Id
    @TableGenerator(name="MENU_GENERATOR",
            table="pk_generator",
            pkColumnName="PK_COLUMN",
            pkColumnValue="menu",
            valueColumnName="PK_VALUE",
            initialValue=3000000,
            allocationSize=1)
    @GeneratedValue(strategy= GenerationType.TABLE, generator="MENU_GENERATOR")
    private Long id;//主键菜单号
    private Date time;//点餐时间
    private String totalPrice;//总价

    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "desk_id", referencedColumnName = "id")
    private Desk desk;

    //菜品
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinTable(name = "menu_dishs",joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "dishs_id"))
    //@JsonBackReference//防止被序列化，死循环
    private List<Dishs> dishsList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Desk getDesk() {
        return desk;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public List<Dishs> getDishsList() {
        return dishsList;
    }

    public void setDishsList(List<Dishs> dishsList) {
        this.dishsList = dishsList;
    }


}
