package cn.tedu.travel.mapper;

import cn.tedu.travel.model.Banner;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerMapper extends BaseMapper<Banner> {

    @Update("update banner set sort_num = sort_num+1 where sort_num >= #{sortNum}")
    int updateBannerBySortNum(Integer sortNum);
}
