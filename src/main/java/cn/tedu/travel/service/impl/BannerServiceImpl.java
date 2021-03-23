package cn.tedu.travel.service.impl;

import cn.tedu.travel.mapper.BannerMapper;
import cn.tedu.travel.model.Banner;
import cn.tedu.travel.service.IBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements IBannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> getBanners() {
        List<Banner> banners = list();
        for(Banner banner : banners){
            banner.setUrl("image/homePage/"+banner.getUrl());
        }
        return banners;
    }
}
