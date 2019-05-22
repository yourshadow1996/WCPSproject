package com.tnpy.wcpsproject.model.mysql;

public class TbFamousPerson {
    private Integer id;

    private String title;

    private String famous;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getFamous() {
        return famous;
    }

    public void setFamous(String famous) {
        this.famous = famous == null ? null : famous.trim();
    }
}