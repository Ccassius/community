package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xh
 * @create 2021-12-05 9:07
 */
@Mapper
public interface DiscussPostMapper {

    // 起始行行号，显示条数
    List<DiscussPost> selectDiscussPosts(@Param("userId") int userId, @Param("offset") int offset, @Param("limit") int limit);

    // @Param注解用于给参数取别名,
    // 如果只有一个参数,并且在<if>里使用,则必须加别名.
    int selectDiscussPostRows(@Param("userId") int userId);

    // 添加帖子
    int insertDiscussPost(@Param("discussPost") DiscussPost discussPost);

    // 查询帖子的详情
    DiscussPost selectDiscussPostById(@Param("id") int id);

    // 更新评论数量
    int updateCommentCount(@Param("id") int id, @Param("commentCount") int commentCount);

}










