package com.zwwhnly.springbootaction.mybatis.annotation;

import com.zwwhnly.springbootaction.mybatis.entity.Author;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AuthorMapper {
    @Insert("insert into author(author_name, pen_name) values(#{author_name}, #{pen_name})")
    int add(@Param("author_name") String authorName, @Param("pen_name") String penName);

    @Update("update author set author_name = #{author_name}, pen_name = #{pen_name} where author_id = #{id}")
    int update(@Param("author_name") String authorName, @Param("pen_name") String penName, @Param("id") Integer id);

    @Delete("delete from author where author_id = #{id}")
    int delete(Integer id);

    @Select("select author_id as authorId, author_name as authorName, pen_name as penName from author where author_id = #{id}")
    Author findAuthor(@Param("id") Integer id);

    @Select("select author_id as authorId, author_name as authorName, pen_name as penName from author")
    List<Author> findAuthorList();
}
