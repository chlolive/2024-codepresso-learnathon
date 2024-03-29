package com.example.sns.user.dao;

import com.example.sns.user.domain.Like;
import com.example.sns.user.domain.Post;
import com.example.sns.user.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(long id);

    @Select("SELECT * FROM users")
    List<User> findAll();

    @Insert("INSERT INTO users (userName, email, password, joinDate) VALUES (#{userName}, #{email}, #{password}, #{joinDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);

    @Update("UPDATE users SET name = #{userName}, email = #{email} WHERE id = #{id}")
    int update(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    int deleteById(int id);

    @Select("SELECT * FROM users WHERE userName LIKE '%${userName}%'")
    List<User> search(String name);

    @Insert("INSERT INTO posts (userId, content, postDate) VALUES (#{userId}, #{content}, #{postDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertPost(Post post);

    @Select("SELECT * FROM posts")
    List<Post> findAllPost();

    @Insert("INSERT INTO likes (userId, postId) VALUES (#{userId}, #{postId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertLike(Like like);

    @Select("SELECT * FROM likes")
    List<Like> findAllLike();

}
