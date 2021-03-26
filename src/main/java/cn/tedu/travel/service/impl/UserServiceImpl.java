package cn.tedu.travel.service.impl;

import cn.tedu.travel.mapper.BannerMapper;
import cn.tedu.travel.mapper.UserMapper;
import cn.tedu.travel.model.Banner;
import cn.tedu.travel.model.User;
import cn.tedu.travel.service.IBannerService;
import cn.tedu.travel.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
