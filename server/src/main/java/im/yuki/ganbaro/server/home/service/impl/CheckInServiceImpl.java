package im.yuki.ganbaro.server.home.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import im.yuki.ganbaro.server.common.constant.ConstantVal;
import im.yuki.ganbaro.server.common.entity.Response;
import im.yuki.ganbaro.server.common.entity.ResultEnum;
import im.yuki.ganbaro.server.common.utils.ResponseUtils;
import im.yuki.ganbaro.server.home.dao.CheckInDao;
import im.yuki.ganbaro.server.home.entity.CheckIn;
import im.yuki.ganbaro.server.home.service.CheckInService;

@Service
public class CheckInServiceImpl implements CheckInService {

    @Autowired
    private CheckInDao checkInDao;

    @Override
    public Response<?> checkIn(String uid, String isDidIt) {
        Date today = new Date();
        CheckIn checkIn = checkInDao.queryByUidAndDay(uid, today);

        if (checkIn != null) {
            checkIn.setIsDidIt(isDidIt);
            checkInDao.update(uid, today, isDidIt);
        } else {
            CheckIn todayCheckIn = new CheckIn();
            todayCheckIn.setUid(uid);
            todayCheckIn.setDay(today);
            todayCheckIn.setIsDidIt(isDidIt);
            checkInDao.insert(todayCheckIn);
        }

        if (ConstantVal.CHECK_IN_Y.equals(isDidIt)) {
            return ResponseUtils.success(ResultEnum.OK, "很棒, 继续保持!");
        } else {
            return ResponseUtils.fail(ResultEnum.CUSTOMIZE_ERROR, "明天要加油哦!");
        }
    }

    @Override
    public Response<List<CheckIn>> queryCheckIn(String uid, int year, int month) {
        Calendar calendar = Calendar.getInstance();
        // 本月 1 日的日期
        calendar.set(year, month, 1);
        Date firstDayOfThisMonth = calendar.getTime();
        Date firstDayOfNextMonth = DateUtils.addMonths(firstDayOfThisMonth, 1);
        Date lastDayOfThisMonth = DateUtils.addDays(firstDayOfNextMonth, -1);

        List<CheckIn> checkInList = checkInDao.queryByUidAndDayRange(uid, firstDayOfNextMonth, lastDayOfThisMonth);
        Map<Date, String> day2IsDidItMap = new HashMap<>(checkInList.size());
        if (CollectionUtils.isNotEmpty(checkInList)) {
            day2IsDidItMap = checkInList.stream().collect(Collectors.toMap(CheckIn::getDay, CheckIn::getIsDidIt));
        }
        CheckIn checkInItem;
        List<CheckIn> checkInItemList = new ArrayList<>(28);
        Date indexDate = firstDayOfThisMonth;
        while (indexDate.before(firstDayOfNextMonth)) {
            checkInItem = new CheckIn();
            checkInItem.setUid(uid);
            checkInItem.setDay(indexDate);
            checkInItem.setIsDidIt(day2IsDidItMap.get(indexDate));
            checkInItemList.add(checkInItem);
            DateUtils.addDays(indexDate, 1);
        }

        return ResponseUtils.success(ResultEnum.OK, checkInItemList);
    }

}
