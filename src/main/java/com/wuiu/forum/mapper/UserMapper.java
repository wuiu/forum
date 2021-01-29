package com.wuiu.forum.mapper;

import com.wuiu.forum.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user () values (#{id},#{accountId},#{login},#{token},#{name},#{avatarUrl},#{url},#{htmlUrl},#{createTime},#{lastUpdateTime})")
    Integer save(User user);
    @Select("select * from user where token = #{token}")
    User queryByToken(@Param("token") String token);
}
