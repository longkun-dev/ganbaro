package im.yuki.ganbaro.server.home.dao;

import java.util.Date;
import java.util.List;

import im.yuki.ganbaro.server.stat.entity.CheckInStat;
import org.apache.ibatis.annotations.Mapper;

import im.yuki.ganbaro.server.home.entity.CheckIn;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CheckInDao {

    int insert(CheckIn checkIn);

    CheckIn queryByUidAndDay(String uid, Date date);

    List<CheckIn> queryByUidAndDayRange(@Param("uid") String uid,
                                        @Param("startDate") Date startDate,
                                        @Param("endDate") Date endDate);

    int update(String uid, Date date, String isDidIt);

    CheckInStat queryMaxContinuousByUid(String uid);

    CheckInStat queryCurrentContinuousByUid(String uid);
}
