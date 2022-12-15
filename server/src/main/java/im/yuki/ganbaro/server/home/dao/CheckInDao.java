package im.yuki.ganbaro.server.home.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import im.yuki.ganbaro.server.home.entity.CheckIn;

@Mapper
public interface CheckInDao {
    
    int insert(CheckIn checkIn);

    CheckIn queryByUidAndDay(String uid, Date date);

    List<CheckIn> queryByUidAndDayRange(String uid, Date starDate, Date enDate);

    int update(String uid, Date date, String isDidIt);

}
