package cn.tedu.travel.service.impl;

import cn.tedu.travel.mapper.NoticeMapper;
import cn.tedu.travel.mapper.UserMapper;
import cn.tedu.travel.model.Notice;
import cn.tedu.travel.model.User;
import cn.tedu.travel.service.INoticeService;
import cn.tedu.travel.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

    @Resource
    NoticeMapper noticeMapper;

    @Override
    public List<Notice> findNotices() {
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("createtime");
        List<Notice> notices = noticeMapper.selectList(queryWrapper);
        return notices;
    }
}
