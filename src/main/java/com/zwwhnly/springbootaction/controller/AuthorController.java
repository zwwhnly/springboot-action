package com.zwwhnly.springbootaction.controller;

import com.alibaba.fastjson.JSONObject;
import com.zwwhnly.springbootaction.mybatis.entity.Author;
import com.zwwhnly.springbootaction.mybatis.annotation.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/mybatis/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    /**
     * 查询作者列表
     */
    @RequestMapping(value = "getAuthorList", method = RequestMethod.GET)
    public Map<String, Object> getAuthorList() {
        List<Author> authorList = this.authorService.findAuthorList();
        Map<String, Object> param = new HashMap<>();
        param.put("total", authorList.size());
        param.put("rows", authorList);
        return param;
    }

    /**
     * 查询单个作者信息
     */
    @RequestMapping(value = "/getAuthor/{authorId:\\d+}", method = RequestMethod.GET)
    public Author getAuthor(@PathVariable Integer authorId) {
        Author author = this.authorService.findAuthor(authorId);
        if (author == null) {
            throw new RuntimeException("查询错误");
        }
        return author;
    }

    /**
     * 新增
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void add(@RequestBody JSONObject jsonObject) {
        String authorName = jsonObject.getString("authorName");
        String penName = jsonObject.getString("penName");

        try {
            this.authorService.add(authorName, penName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("新增错误");
        }
    }

    /**
     * 更新
     */
    @RequestMapping(value = "/update/{authorId:\\d+}", method = RequestMethod.PUT)
    public void update(@PathVariable Integer authorId, @RequestBody JSONObject jsonObject) {
        Author author = this.authorService.findAuthor(authorId);
        String authorName = jsonObject.getString("authorName");
        String penName = jsonObject.getString("penName");

        try {
            this.authorService.update(authorName, penName, author.getAuthorId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("更新错误");
        }
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete/{authorId:\\d+}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer authorId) {
        try {
            this.authorService.delete(authorId);
        } catch (Exception e) {
            throw new RuntimeException("删除错误");
        }
    }
}
