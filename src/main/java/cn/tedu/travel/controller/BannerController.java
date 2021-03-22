package cn.tedu.travel.controller;

import cn.tedu.travel.model.Banner;
import cn.tedu.travel.service.IBannerService;
import cn.tedu.travel.vo.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BannerController {

    @Resource
    IBannerService bannerService;

    @GetMapping("/seleteBanner")
    public R<List<Banner>> seleteBanner(){
        List<Banner> banners =bannerService.getBanners();
        return R.ok(banners);
    }

}