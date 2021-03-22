package cn.tedu.travel.service;

import cn.tedu.travel.model.Banner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IBannerService extends IService<Banner> {
    List<Banner> getBanners();
}
