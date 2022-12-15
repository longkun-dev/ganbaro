package im.yuki.ganbaro.server.home.service.impl;

import im.yuki.ganbaro.server.common.entity.Response;
import im.yuki.ganbaro.server.common.entity.ResultEnum;
import im.yuki.ganbaro.server.common.utils.ResponseUtils;
import im.yuki.ganbaro.server.home.dao.DailySentenceDao;
import im.yuki.ganbaro.server.home.entity.DailySentence;
import im.yuki.ganbaro.server.home.service.DailySentenceService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author longkun
 * @since 12/15/2022 9:41 PM
 */
@Service
@Slf4j
public class DailySentenceServiceImpl implements DailySentenceService {

    @Autowired
    private DailySentenceDao dailySentenceDao;

    @Override
    public Response<DailySentence> getDailySentence() {
        DailySentence dailySentence = dailySentenceDao.queryByRandom();
        if (dailySentence != null) {
            dailySentenceDao.updateShowTimes(dailySentence.getId());
            return ResponseUtils.success(ResultEnum.OK, dailySentence);
        } else {
            log.warn("【每日一句】未获取到数据");
            return ResponseUtils.fail(ResultEnum.NOT_FOUND);
        }
    }

    @Override
    public Response<Integer> likeDailySentence(String id) {
        dailySentenceDao.updateLikeTimes(id);
        DailySentence dailySentence = dailySentenceDao.queryById(id);
        return ResponseUtils.success(ResultEnum.OK, dailySentence.getLikeTimes());
    }
}
