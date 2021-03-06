package cn.tedu.travel.controller;

import cn.tedu.travel.model.User;
import cn.tedu.travel.mapper.UserMapper;
import cn.tedu.travel.utils.SessionUtil;
import com.zhenzi.sms.ZhenziSmsClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class LoginController {
    @Resource
    private UserMapper mapper;

    //登录验证
    @PostMapping("login")
    @ResponseBody
    public String login(HttpServletRequest request, HttpSession session) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Integer id = mapper.loginId(username, password);
        if (id != null) {
            User user = mapper.getUser(id);
            session.setAttribute("user", user);
            return "success";
        } else {
            return "error";
        }
    }

    //注册用户框失去焦点判定
    @GetMapping("check")
    @ResponseBody
    public String check(HttpServletRequest request) {
        String username = request.getParameter("username");
        Integer id = mapper.checkByUsername(username);
        if (id != null) {
            return "用户名已存在";
        } else {
            return "用户名可用";
        }
    }
    //获取短信
    @PostMapping("getCode")
    @ResponseBody
    public String getCode(HttpServletRequest request,HttpSession session) {
        try {//获取电话号码
            String phone = request.getParameter("phone");
            //短信验证码
            String apiUrl = "https://sms_developer.zhenzikj.com";
            String appId = "108233";
            String appSecret = "f90bd1a6-9a35-4ca8-8f0f-fe4a0ce397bf";
            ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("number", phone);
            params.put("templateId", "3870");
            String code = (int) ((Math.random() * 1000000)) + "";
            String[] templateParams = new String[2];
            templateParams[0] = code;
            templateParams[1] = "5分钟";
            params.put("templateParams", templateParams);
            String result = client.send(params);
            log.debug("发送：{}",result);
            //将验证码存到session中,同时存入创建时间
            session = request.getSession();
            SessionUtil.save(session, phone, code, 5 * 60);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //提交注册判定
    @PostMapping("checkcode")
    @ResponseBody
    public String checkCode(HttpServletRequest request,HttpSession session){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phonenumber=request.getParameter("phone");
        String code=request.getParameter("code");
        session = request.getSession();
        Integer n=mapper.checkPhoneNumber(phonenumber);
        if (n!=null){
            return "手机号已被注册，请换个手机号再试。";
        }
        String result= SessionUtil.validate(session,phonenumber,code);
        if (result.equals("未生成验证码")||result.equals("验证码错误")||result.equals("验证码已过期")) {
            return result;
        }else {
            User user=new User().setUsername(username).setPassword(password).setPhonenumber(phonenumber).setAdministrators(0);
            mapper.insert(user);
            return "success";
        }
    }

    @PostMapping("updatepassword")
    @ResponseBody
    public String updatePassword(HttpServletRequest request,HttpSession session){
        User user=(User)request.getSession().getAttribute("user");
        String oldpassword=request.getParameter("oldpassword");
        String newpassword1=request.getParameter("newpassword1");
        String newpassword2=request.getParameter("newpassword2");
        if (!user.getPassword().equals(oldpassword)) {
            return "旧密码输入错误";
        }else if(!newpassword1.equals(newpassword2)){
            return "两次密码输入不一致";
        }else if(user.getPassword().equals(newpassword2)){
            return "与原密码一致，请重新输入";
        }else{
            mapper.updatePassword(newpassword1,user.getId());
            return "success";
        }

    }


}
