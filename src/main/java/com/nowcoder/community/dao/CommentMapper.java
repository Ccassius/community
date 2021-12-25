package com.nowcoder.community.dao;

import com.nowcoder.community.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author xh
 * @create 2021-12-19 7:36
 */
@Mapper
public interface CommentMapper {

    List<Comment> selectCommentsByEntity(@Param("entityType") int entityType, @Param("entityId") int entityId,
                                         @Param("offset") int offset, @Param("limit") int limit);

    int selectCountByEntity(@Param("entityType") int entityType, @Param("entityId") int entityId);

    int insertComment(@Param("userId") int userId, @Param("entityType") int entityType, @Param("entityId") int entityId,
                      @Param("targetId") int targetId, @Param("content") String content, @Param("status") int status,
                      @Param("createTime") Date createTime);

    Comment selectCommentById(@Param("id") int id);

    List<Comment> selectCommentsByUser(@Param("userId") int userId, @Param("offset") int offset, @Param("limit") int limit);

    int selectCountByUser(@Param("userId") int userId);

}











