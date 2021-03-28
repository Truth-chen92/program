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
import javax.servlet.http.HttpServletRequest;
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
    public R<List<Banner>> banners() {
        List<Banner> banners = bannerService.getBanners();
        return R.ok(banners);
    }

    @GetMapping("/deleteBanner")
    public R deleteBanner(Integer id) {
        bannerService.deleteBanner(id);
        return R.ok("ok");
    }

//    @Value("${straw.resource.path}")
//    private File resourcePath;
//
//    @Value("${straw.resource.host}")
//    private String resourceHost;

    @PostMapping("/addBanner")
    public R<List<Banner>> addBanner(MultipartFile imageFile,Integer sortNum, HttpServletRequest request) throws IOException {
        String realPath = request.getServletContext().getRealPath("images");//项目真实路径
        String path= DateTimeFormatter.ofPattern("yyyy/MM/dd").format(LocalDate.now());//年月日
        File folder=new File(realPath,path);//真实路径+年月日
        folder.mkdirs();
        String fileName=imageFile.getOriginalFilename();//文件名
        String ext=fileName.substring(fileName.lastIndexOf("."));//获得后缀
        String name= UUID.randomUUID().toString()+ext;//随机名字+后缀
        File file=new File(folder,name);//最终路径：真实路径+年月日+随机名字+后缀
        log.debug("最终路径:{}",file.getAbsolutePath());
        imageFile.transferTo(file);//保存文件到最终路径
        String url="images"+"/"+path+"/"+name;//前端可以通过这个url直接访问图片
        Banner banner = new Banner().setUrl(url).setId(null).setSortNum(sortNum);
        List<Banner> banners=bannerService.saveBanner(banner);
        return R.ok(banners);
    }
//    @PostMapping("/addBanner")
//    public R<List<Banner>> addBanner(MultipartFile imageFile,Integer sortNum, HttpServletRequest request) throws IOException {
//        //log.debug("imageFile:{}",imageFile);
//        log.debug("imageFile:{},sortNum:{}",imageFile,sortNum);
//        return R.ok("ok");
//    }
}
