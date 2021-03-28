package cn.tedu.travel.service;

import cn.tedu.travel.model.Notice;
import cn.tedu.travel.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface INoticeService extends IService<Notice> {
    List<Notice> findNotices();
}
