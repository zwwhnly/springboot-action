package com.zwwhnly.springbootaction.mybatis.annotation;

import com.zwwhnly.springbootaction.mybatis.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorMapper authorMapper;

    public int add(String authorName, String penName) {
        return this.authorMapper.add(authorName, penName);
    }

    public int update(String authorName, String penName, Integer id) {
        return this.authorMapper.update(authorName, penName, id);
    }

    public int delete(Integer id) {
        return this.authorMapper.delete(id);
    }

    public Author findAuthor(Integer id) {
        return this.authorMapper.findAuthor(id);
    }

    public List<Author> findAuthorList() {
        return this.authorMapper.findAuthorList();
    }
}
