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
    public Response<?> checkIn(String uid, String isDidIt);

    /**
     * 指定月打卡情况查询
     * 
     * @param uid uid
     * @param year 指定的年份，如 2022
     * @param month 指定的月份，如 1 则表示 1 月份
     * @return 该月打卡情况
     */
    Response<List<CheckIn>> queryCheckIn(String uid, int year, int month);

}
