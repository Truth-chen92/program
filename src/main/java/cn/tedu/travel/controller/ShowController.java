package cn.tedu.travel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    @GetMapping("/showcontactUs")
    public String showContactUs(){return "contactUs";}
}
