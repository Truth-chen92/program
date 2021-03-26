package cn.tedu.travel.mapper;

import cn.tedu.travel.model.Banner;
import cn.tedu.travel.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
    //登录验证
    @Select("select id from user where username=#{username} and password=#{password}")
    Integer loginId(String username, String password);
    //存放用户登录信息
    @Select("select * from user where id=#{id}")
    User getUser(Integer id);
    //判断用户名是否重复
    @Select("select id from user where username=#{username}")
    Integer checkByUsername(String username);
    //检查用户手机号是否已注册
    @Select("select id from user where phonenumber=#{phonenumber}")
    Integer checkPhoneNumber(String phoneNumber);
    //修改密码
    @Update("update user set password=${newpassword} where id=${id}")
    Integer updatePassword(String newpassword,Integer id);

}
