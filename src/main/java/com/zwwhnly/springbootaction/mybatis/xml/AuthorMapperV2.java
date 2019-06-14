package com.zwwhnly.springbootaction.mybatis.xml;

import com.zwwhnly.springbootaction.mybatis.entity.Author;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthorMapperV2 {

    int add(@Param("author_name") String authorName, @Param("pen_name") String penName);

    int update(@Param("author_name") String authorName, @Param("pen_name") String penName, @Param("id") Integer id);

    int delete(Integer id);

    Author findAuthor(@Param("id") Integer id);

    List<Author> findAuthorList();
}
