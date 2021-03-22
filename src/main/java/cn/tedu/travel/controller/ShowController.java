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
    public String showTicketing() {
        return "ticketing";
    }
    @GetMapping("/showabout")
    public String showAbout(){return "about";}
    @GetMapping("/showcontactus")
    public String showContactUs(){return "contactUs";}
    @GetMapping("/showhome")
    public String showHomePage(HttpServletRequest request,HttpServletResponse response
    ){
        User user=(User)request.getSession().getAttribute("user");
        System.out.println(user);
        return "homePage";
    }
}
