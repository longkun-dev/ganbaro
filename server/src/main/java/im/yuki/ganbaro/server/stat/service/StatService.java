package im.yuki.ganbaro.server.stat.service;

import im.yuki.ganbaro.server.common.entity.Response;
import im.yuki.ganbaro.server.home.entity.CheckIn;

import java.util.List;
import java.util.Map;

/**
 * @author longkun
 * @version V1.1.0
 * @date 2022/12/20 10:35 PM
 * @description
 */
public interface StatService {

    /**
     * 指定月打卡情况查询
     *
     * @param uid   uid
     * @param year  指定的年份，如 2022
     * @param month 指定的月份，如 1 则表示 1 月份
     * @return 该月打卡情况
     */
    Response<List<CheckIn>> queryCheckIn(String uid, int year, int month);

    /**
     * 获取年度打卡
     *
     * @param uid  uid
     * @param year year
     * @return 年度打卡数据
     */
    Response<Map<String, Object>> queryCheckIn(String uid, int year);

    /**
     * 获取年度打卡
     *
     * @param uid uid
     * @return 当前连续，最佳连续
     */
    Response<Map<String, Integer>> queryCheckIn(String uid);

    /**
     * 时间段统计
     *
     * @param uid       uid
     * @param statScope 周 / 月 / 三个月 / 半年 / 年
     * @return 天数
     */
    Response<?> queryCheckIn(String uid, String statScope);
}
