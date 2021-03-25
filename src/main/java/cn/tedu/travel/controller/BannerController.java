package cn.tedu.travel.controller;

import cn.tedu.travel.model.Banner;
import cn.tedu.travel.service.IBannerService;
import cn.tedu.travel.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class BannerController {

    @Resource
    IBannerService bannerService;

    @GetMapping("/banners")
    public R<List<Banner>> banners(){
        List<Banner> banners =bannerService.getBanners();
        return R.ok(banners);
    }

    @GetMapping("/deleteBanner")
    public R deleteBanner(Integer id){
        bannerService.deleteBanner(id);
        return R.ok("ok");
    }

    @Value("${straw.resource.path}")
    private File resourcePath;

    @Value("${straw.resource.host}")
    private String resourceHost;

    @PostMapping("/addBanner")
    public R addBanner(MultipartFile imageFile) throws IOException {
        String path= DateTimeFormatter.ofPattern("yyyy/MM/dd")
                .format(LocalDate.now());
        File folder=new File(resourcePath,path);
        folder.mkdirs();
        String fileName=imageFile.getOriginalFilename();
        String ext=fileName.substring(fileName.lastIndexOf("."));
        String name= UUID.randomUUID().toString()+ext;
        File file=new File(folder,name);
        log.debug("最终路径:{}",file.getAbsolutePath());
        imageFile.transferTo(file);
        String url=resourceHost+"/"+path+"/"+name;
        return R.ok(url);
    }
}
