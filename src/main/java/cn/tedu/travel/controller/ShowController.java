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
    public String showNotice(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);
        return "notice";
    }
    @GetMapping("play1.html")
    public String showPlay1(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);
        return "play1";
    } @GetMapping("play2.html")
    public String showPlay2(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);
        return "play2";
    } @GetMapping("play3.html")
    public String showPlay3(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);
        return "play3";
    } @GetMapping("play4.html")
    public String showPlay4(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);
        return "play4";
    } @GetMapping("play5.html")
    public String showPlay5(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);
        return "play5";
    } @GetMapping("play6.html")
    public String showPlay6(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);
        return "play6";
    } @GetMapping("play7.html")
    public String showPlay7(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);
        return "play7";
    } @GetMapping("play8.html")
    public String showPlay8(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);
        return "play8";
    } @GetMapping("product.html")
    public String showProduct(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);return "product";
    } @GetMapping("product-buy.html")
    public String showProductBuy(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);return "product-buy";
    }@GetMapping("product-eat.html")
    public String showProductEat(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);return "product-eat";
    }@GetMapping("product-live.html")
    public String showProductLive(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);return "product-live";
    }@GetMapping("product-travel.html")
    public String showProductTravel(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);return "product-travel";
    }@GetMapping("publicity-0.html")
    public String showPublicity0(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);return "publicity-0";
    }@GetMapping("publicity-1.html")
    public String showPublicity1(HttpServletRequest request,Map<String, Object> map){User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);
        return "publicity-1";
    }@GetMapping("publicity-2.html")
    public String showPublicity2(HttpServletRequest request,Map<String, Object> map){User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);
        return "publicity-2";
    }@GetMapping("publicity-3.html")
    public String showPublicity3(HttpServletRequest request,Map<String, Object> map){User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);
        return "publicity-3";
    }@GetMapping("video-list.html")
    public String showVideoList(HttpServletRequest request,Map<String, Object> map){
        User user=(User)request.getSession().getAttribute("user");
        map.put("user", user);return "video-list";
    }
}
