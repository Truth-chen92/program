package cn.tedu.travel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Slf4j
public class SystemController {
    @GetMapping("/backstage_supporter.html")
    public ModelAndView loginForm(){
            return new ModelAndView("backstage_supporter");
    }

}
