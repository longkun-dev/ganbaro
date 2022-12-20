package im.yuki.ganbaro.server.home.service.impl;

import im.yuki.ganbaro.server.common.constant.ConstantVal;
import im.yuki.ganbaro.server.common.entity.Response;
import im.yuki.ganbaro.server.common.entity.ResultEnum;
import im.yuki.ganbaro.server.common.utils.ResponseUtils;
import im.yuki.ganbaro.server.home.dao.CheckInDao;
import im.yuki.ganbaro.server.home.entity.CheckIn;
import im.yuki.ganbaro.server.home.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CheckInServiceImpl implements CheckInService {

    @Autowired
    private CheckInDao checkInDao;

    @Override
    public Response<?> checkIn(String uid, String isDidIt) {
        Date today = new Date();
        CheckIn checkIn = checkInDao.queryByUidAndDay(uid, today);

        if (checkIn != null) {
            checkInDao.update(uid, today, isDidIt);
        } else {
            CheckIn todayCheckIn = new CheckIn();
            todayCheckIn.setUid(uid);
            todayCheckIn.setDay(today);
            todayCheckIn.setIsDidIt(isDidIt);
            todayCheckIn.setCreatedBy(uid);
            todayCheckIn.setUpdatedBy(uid);
            checkInDao.insert(todayCheckIn);
        }

        String message;
        if (ConstantVal.CHECK_IN_Y.equals(isDidIt)) {
            message = "很棒, 继续保持!";
        } else {
            message = "明天要加油哦!";
        }

        return ResponseUtils.fail(ResultEnum.OK, message);
    }

}
