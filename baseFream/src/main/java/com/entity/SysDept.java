package com.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="sys_dept")
public class SysDept {
    @Id@GeneratedValue
    private Integer id;//主键.
    private String name;//名称.
    private String demo;
    private Long parentId; //父编号
    private Boolean available = Boolean.FALSE;//是否可用

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }


    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }
}
