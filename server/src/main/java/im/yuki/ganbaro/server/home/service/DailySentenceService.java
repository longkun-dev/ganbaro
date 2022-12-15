package im.yuki.ganbaro.server.home.service;

import org.springframework.stereotype.Service;

import im.yuki.ganbaro.server.common.entity.Response;
import im.yuki.ganbaro.server.home.entity.DailySentence;

/**
 * @author longkun
 * @since 12/15/2022 9:40 PM
 */
@Service
public interface DailySentenceService {

    Response<DailySentence> getDailySentence();

    Response<Integer> likeDailySentence(String id);

}
