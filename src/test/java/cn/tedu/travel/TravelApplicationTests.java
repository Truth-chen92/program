package cn.tedu.travel;

import cn.tedu.travel.entity.User;
import cn.tedu.travel.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
@Slf4j
@SpringBootTest
class TravelApplicationTests {
    @Resource
    private UserMapper mapper;

    @Test
    void contextLoads() {
        User user = mapper.getUser(3);
        log.debug("{}",user);
    }

}
