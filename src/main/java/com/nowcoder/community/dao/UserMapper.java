package com.nowcoder.community.dao;

import org.apache.ibatis.annotations.Mapper;
import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author xh
 * @create 2021-12-04 17:30
 */
@Mapper
public interface UserMapper {

    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(@Param("id") int id, @Param("status") int status);

    int updateHeader(@Param("id") int id, @Param("headerUrl") String headerUrl);

    int updatePassword(@Param("id") int id, @Param("password") String password);

}
