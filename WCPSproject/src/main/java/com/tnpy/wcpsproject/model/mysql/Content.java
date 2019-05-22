package com.tnpy.wcpsproject.model.mysql;

public class Content {
    private Integer id;

    private String title;

    private String author;

    private String crawTime;

    private String dianjiNum;

    private String contents;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getCrawTime() {
        return crawTime;
    }

    public void setCrawTime(String crawTime) {
        this.crawTime = crawTime == null ? null : crawTime.trim();
    }

    public String getDianjiNum() {
        return dianjiNum;
    }

    public void setDianjiNum(String dianjiNum) {
        this.dianjiNum = dianjiNum == null ? null : dianjiNum.trim();
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }
}