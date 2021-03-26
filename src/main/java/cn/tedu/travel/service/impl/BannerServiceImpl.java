package cn.tedu.travel.service.impl;

import cn.tedu.travel.mapper.BannerMapper;
import cn.tedu.travel.model.Banner;
import cn.tedu.travel.service.IBannerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.UpdateById;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements IBannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    @Transactional
    public List<Banner> getBanners() {
        QueryWrapper<Banner> query=new QueryWrapper<>();
        query.orderByAsc("sort_num");
        List<Banner> banners=bannerMapper.selectList(query);
        return banners;
    }

    @Override
    @Transactional
    public void deleteBanner(Integer id) {
        removeById(id);
    }

    @Override
    @Transactional
    public List<Banner> saveBanner(Banner banner) {
        bannerMapper.updateBannerBySortNum(banner.getSortNum());
        bannerMapper.insert(banner);
        List<Banner> banners = getBanners();
        return banners;
    }
}
