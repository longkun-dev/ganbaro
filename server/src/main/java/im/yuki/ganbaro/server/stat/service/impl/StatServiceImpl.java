package im.yuki.ganbaro.server.stat.service.impl;

import im.yuki.ganbaro.server.common.entity.Response;
import im.yuki.ganbaro.server.common.entity.ResultEnum;
import im.yuki.ganbaro.server.common.utils.ResponseUtils;
import im.yuki.ganbaro.server.home.dao.CheckInDao;
import im.yuki.ganbaro.server.home.entity.CheckIn;
import im.yuki.ganbaro.server.stat.entity.CheckInStat;
import im.yuki.ganbaro.server.stat.service.StatService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author longkun
 * @version V1.1.0
 * @date 2022/12/20 10:35 PM
 * @description 统计
 */
@Service
public class StatServiceImpl implements StatService {

    @Autowired
    private CheckInDao checkInDao;

    @Override
    public Response<List<CheckIn>> queryCheckIn(String uid, int year, int month) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        // 本月 1 日的日期
        calendar.set(year, month - 1, 1, 0, 0, 0);
        Date firstDayOfThisMonth = calendar.getTime();
        Date firstDayOfNextMonth = DateUtils.addMonths(firstDayOfThisMonth, 1);
        Date lastDayOfThisMonth = DateUtils.addDays(firstDayOfNextMonth, -1);

        List<CheckIn> checkInList = checkInDao.queryByUidAndDayRange(uid, firstDayOfThisMonth, lastDayOfThisMonth);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (CheckIn checkIn : checkInList) {
            checkIn.setDayStr(dateFormat.format(checkIn.getDay()));
        }
        Map<String, String> day2IsDidItMap = new HashMap<>(checkInList.size());
        if (CollectionUtils.isNotEmpty(checkInList)) {
            day2IsDidItMap = checkInList.stream().collect(Collectors.toMap(CheckIn::getDayStr, CheckIn::getIsDidIt));
        }
        CheckIn checkInItem;
        List<CheckIn> checkInItemList = new ArrayList<>(28);
        Date indexDate = firstDayOfThisMonth;
        String isDidIt;
        String indexDateStr;
        while (!indexDate.after(lastDayOfThisMonth)) {
            checkInItem = new CheckIn();
            checkInItem.setUid(uid);
            checkInItem.setDay(indexDate);
            indexDateStr = dateFormat.format(indexDate);
            checkInItem.setDayStr(indexDateStr);
            isDidIt = day2IsDidItMap.get(indexDateStr);
            checkInItem.setIsDidIt(StringUtils.isBlank(isDidIt) ? "N" : "Y");
            checkInItemList.add(checkInItem);
            indexDate = DateUtils.addDays(indexDate, 1);
        }

        return ResponseUtils.success(ResultEnum.OK, checkInItemList);
    }

    @Override
    public Response<Map<String, Object>> queryCheckIn(String uid, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        int lengthOfYear = LocalDate.of(year, 1, 1).lengthOfYear();
        String passOfYear = new BigDecimal(dayOfYear)
                .divide(new BigDecimal(lengthOfYear), 4, BigDecimal.ROUND_HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                + "%";

        Response<List<CheckIn>> response;
        List<CheckIn> monthDataList;
        List<CheckIn> yearDataList = new ArrayList<>();
        for (int i = 1; i <= calendar.get(Calendar.MONTH) + 1; i++) {
            response = this.queryCheckIn(uid, year, i);
            monthDataList = response.getData();
            for (CheckIn checkIn : monthDataList) {
                if (checkIn.getDay().before(calendar.getTime())) {
                    yearDataList.add(checkIn);
                } else {
                    break;
                }
            }
        }

        Map<String, Object> result = new HashMap<>(2);
        result.put("yearDataList", yearDataList);
        result.put("passOfYear", passOfYear);
        return ResponseUtils.success(ResultEnum.OK, result);
    }

    @Override
    public Response<Map<String, Integer>> queryCheckIn(String uid) {
        CheckInStat checkInStat = checkInDao.queryMaxContinuousByUid(uid);
        Integer maxContinuousDays = checkInStat.getContinuousDays();

        CheckInStat checkInStat1 = checkInDao.queryCurrentContinuousByUid(uid);
        Integer currentContinuousDays = checkInStat1.getContinuousDays();

        Map<String, Integer> resultMap = new HashMap<>(2);
        resultMap.put("maxContinuousDays", maxContinuousDays);
        resultMap.put("currentContinuousDays", currentContinuousDays);

        return ResponseUtils.success(ResultEnum.OK, resultMap);
    }

    @Override
    public Response<?> queryCheckIn(String uid, String statScope) {
        Map<String, Date> startEndDate = getStartEndDate(statScope);
        Date startDate = startEndDate.get("startDate");
        Date endDate = startEndDate.get("endDate");
        return null;
    }

    private Map<String, Date> getStartEndDate(String statScope) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Map<String, Date> resultMap = new HashMap<>(2);
        Date startDate = null;
        Date endDate = null;
        switch (statScope) {
            case "最近一周":
                startDate = DateUtils.addDays(calendar.getTime(), -7);
                endDate = calendar.getTime();
                break;
            case "本月":
                endDate = calendar.getTime();
                calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.set(Calendar.DATE, 1);
                startDate = calendar.getTime();
                break;
            case "最近三个月":
                break;
            case "最近半年":
                break;
            case "最近一年":
                break;
            default:

        }

        resultMap.put("startDate", startDate);
        resultMap.put("endDate", endDate);
        return resultMap;
    }
}
