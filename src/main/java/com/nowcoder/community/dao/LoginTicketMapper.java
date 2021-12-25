package com.nowcoder.community.dao;

import com.nowcoder.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

/**
 * @author xh
 * @create 2021-12-11 11:20
 */
@Mapper
@Deprecated
public interface LoginTicketMapper {

    // 插入凭证记录
    @Insert({
            "insert into login_ticket(user_id, ticket, status, expired) ",
            "values(#{userId}, #{ticket}, #{status}, #{expired})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertLoginTicket(LoginTicket loginTicket);

    // 查询凭证
    @Select({
            "select id, user_id, ticket, status, expired ",
            "from login_ticket where ticket=#{ticket}"
    })
    LoginTicket selectByTicket(String ticket);

    // 修改配置状态，使配置失效，关于if和script标签，只是为了演示如何使用条件判断进行sql语句拼接
    @Update({
            "<script>",
            "update login_ticket set status=#{status} where ticket=#{ticket} ",
            "<if test=\"ticket!=null\">",
            "and 1=1",
            "</if>",
            "</script>"
    })
    int updateStatus(@Param("ticket") String ticket, @Param("status") int status);
}
