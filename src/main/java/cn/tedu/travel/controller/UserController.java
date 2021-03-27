package cn.tedu.travel.controller;

import cn.tedu.travel.mapper.UserMapper;
import cn.tedu.travel.model.User;
import cn.tedu.travel.service.IUserService;
import cn.tedu.travel.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Resource
    IUserService userService;

    @GetMapping("/users")
    public R<List<User>> showAllUsers(){
        List<User> users = userService.list();
        return R.ok(users).setCode(0);
    }

    @GetMapping("/deleteUser")
    public R deleteUser(Integer id){
        userService.removeById(id);
        return R.ok("ok");
    }
}
