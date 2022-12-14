package im.yuki.ganbaro.server.account.dao;

import im.yuki.ganbaro.server.account.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author longkun
 * @version V1.1.0
 * @date 2022/12/14 11:17 PM
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class UserInfoDaoTest {

    @Autowired
    private UserInfoDao userInfoDao;

    @Test
    public void queryByUid() {
        UserInfo userInfo = userInfoDao.queryByUid("U20221211");
        log.info("userInfo: {}", userInfo);
    }
}
