package im.yuki.ganbaro.server.home.dao;

import im.yuki.ganbaro.server.home.entity.DailySentence;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author longkun
 * @since 12/15/2022 9:33 PM
 */
@Mapper
public interface DailySentenceDao {

    int insert(DailySentence dailySentence);

    DailySentence queryByRandom();

    DailySentence queryById(String id);

    int updateShowTimes(String id);

    int updateLikeTimes(String id);

}
