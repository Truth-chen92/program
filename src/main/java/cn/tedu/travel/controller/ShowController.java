package cn.tedu.travel.controller;

import cn.tedu.travel.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.context.Context;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.Map;

@Controller
@Slf4j
public class ShowController {
    @GetMapping("/showlogin")
    public String showLogin() {
        return "login";
    }
    @GetMapping("/showreg")
    public String showReg() {
        return "reg";
    }
    @GetMapping("/showticket")
    public String showTicketing(HttpServletRequest request,Map<String, Object> map) {
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);
        return "ticketing";
    }
    @GetMapping("/showabout")
    public String showAbout(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);
        return "about";
    }
    @GetMapping("/showcontactus")
    public String showContactUs(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);
        return "contactUs";
    }
    @GetMapping("showinformation")
    public String showInformation(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);
        return "information";
    }
    @GetMapping("/showpersonal")
    public String showPersonal(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);
        return "personal";
    }
    @GetMapping("showpq")
    public String showPQu(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);
        return "passwordquestion";
    }
    @GetMapping("showup")
    public String showUP(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);
        return "updatepassword";
    }
    @GetMapping("/showhome")
    public String showHomePage(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);
        return "homePage";
    }
    @GetMapping("logout")
    public String logOut(HttpServletRequest request,Map<String, Object> map){
        request.getSession().removeAttribute("user");
        return "homePage";
    }
    @GetMapping("notice.html")
    public String shownotice(HttpServletRequest request,Map<String, Object> map){
        request.getSession().removeAttribute("user");
        return "notice";
    }
}
