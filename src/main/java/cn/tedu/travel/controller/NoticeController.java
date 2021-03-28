package cn.tedu.travel.controller;

import cn.tedu.travel.model.Notice;
import cn.tedu.travel.service.INoticeService;
import cn.tedu.travel.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
public class NoticeController {

    @Resource
    INoticeService noticeService;

    @GetMapping("/notices")
    public R<List<Notice>> notices (){
        return R.ok(noticeService.findNotices()).setCode(0);
    }

    @PostMapping("/saveNotice")
    public R saveNotice(Notice notice){
        notice.setCreatetime(LocalDateTime.now());
        noticeService.save(notice);
        return R.ok("添加成功");
    }

    @GetMapping("/deleteNotice")
    public R deleteNotice(Integer id){
        noticeService.removeById(id);
        return R.ok("删除成功");
    }

    @GetMapping("/findNotice")
    public R<Notice> findNotice(Integer id){
        return R.ok(noticeService.getById(id));
    }
}
