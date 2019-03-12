package com.dininghall.dhall.system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * @ClassName: Desk
 * @Description: TODO桌号表
 * @Author: XYR
 * @Date: 2019/3/10 17:41
 * @Vresion: 1.0.0
 **/
@Entity
public class Desk {
    @Id
    @TableGenerator(name="DESK_GENERATOR",
            table="pk_generator",
            pkColumnName="PK_COLUMN",
            pkColumnValue="desk",
            valueColumnName="PK_VALUE",
            initialValue=100,
            allocationSize=1)
    @GeneratedValue(strategy= GenerationType.TABLE, generator="DESK_GENERATOR")
    private Long id;
    private String name;
    private String number;
    @OneToOne(mappedBy = "desk")
    @JsonBackReference
    private Menu menu;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
