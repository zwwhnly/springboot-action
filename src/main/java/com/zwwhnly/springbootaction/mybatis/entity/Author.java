package com.zwwhnly.springbootaction.mybatis.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class Author {
    @JSONField(name = "author_id")
    private Integer authorId;
    @JSONField(name = "author_name")
    private String authorName;
    @JSONField(name = "pen_name")
    private String penName;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPenName() {
        return penName;
    }

    public void setPenName(String penName) {
        this.penName = penName;
    }
}