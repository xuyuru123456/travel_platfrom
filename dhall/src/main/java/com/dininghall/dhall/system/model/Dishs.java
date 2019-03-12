package com.dininghall.dhall.system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
        * @ClassName: Dishs
        * @Description: TODO菜品表
        * @Author: XYR
        * @Date: 2019/3/8 14:08
        * @Vresion: 1.0.0
        **/
@Entity
public class Dishs {
    @Id
    @TableGenerator(name="DISHS_GENERATOR",
            table="pk_generator",
            pkColumnName="PK_COLUMN",
            pkColumnValue="dishs",
            valueColumnName="PK_VALUE",
            initialValue=2000000,
            allocationSize=1)
    @GeneratedValue(strategy= GenerationType.TABLE, generator="DISHS_GENERATOR")
    private Long id;//主键
    private String name;//菜品名
    private String type;//菜的类别
    private float price;//菜品价格
    private boolean sellOut;//是否估清
    private boolean promote;//是否推荐
    private  String image;//图片文件路径
    private String make;//做法
    private Date createTime;//创建时间

    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY,mappedBy = "dishsList")
    @JsonBackReference//防止被序列化，死循环
    private List<Menu> menuList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isSellOut() {
        return sellOut;
    }

    public void setSellOut(boolean sellOut) {
        this.sellOut = sellOut;
    }

    public boolean isPromote() {
        return promote;
    }

    public void setPromote(boolean promote) {
        this.promote = promote;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}
