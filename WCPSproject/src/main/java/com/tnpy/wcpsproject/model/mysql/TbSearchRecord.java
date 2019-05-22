package com.tnpy.wcpsproject.model.mysql;

import java.util.Date;

public class TbSearchRecord {
    private String searchContent;

    private Date searchTime;

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent == null ? null : searchContent.trim();
    }

    public Date getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Date searchTime) {
        this.searchTime = searchTime;
    }
}