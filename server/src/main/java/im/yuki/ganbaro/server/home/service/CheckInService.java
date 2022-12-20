package im.yuki.ganbaro.server.home.service;

import java.util.List;

import org.springframework.stereotype.Service;

import im.yuki.ganbaro.server.common.entity.Response;
import im.yuki.ganbaro.server.home.entity.CheckIn;

/**
 * @author longkun
 * @since 12/15/2022 9:41 PM
 */
@Service
public interface CheckInService {

    /**
     * 打卡
     *
     * @param uid uid
     * @param isDidIt Y or N
     * @return null
     */
    Response<?> checkIn(String uid, String isDidIt);

}
