package com.zwwhnly.springbootaction.mybatis.xml;

import com.zwwhnly.springbootaction.mybatis.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceV2 {
    @Autowired
    private AuthorMapperV2 authorMapperV2;

    public int add(String authorName, String penName) {
        return this.authorMapperV2.add(authorName, penName);
    }

    public int update(String authorName, String penName, Integer id) {
        return this.authorMapperV2.update(authorName, penName, id);
    }

    public int delete(Integer id) {
        return this.authorMapperV2.delete(id);
    }

    public Author findAuthor(Integer id) {
        return this.authorMapperV2.findAuthor(id);
    }

    public List<Author> findAuthorList() {
        return this.authorMapperV2.findAuthorList();
    }
}
