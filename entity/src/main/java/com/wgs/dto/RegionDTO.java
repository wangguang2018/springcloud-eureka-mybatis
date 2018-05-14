package com.wgs.dto;

import java.io.Serializable;
import java.util.List;

public class RegionDTO implements Serializable{

    private String name;
    private String level;
    private Integer id;
    private List<RegionDTO> childs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<RegionDTO> getChilds() {
        return childs;
    }

    public void setChilds(List<RegionDTO> childs) {
        this.childs = childs;
    }
}
