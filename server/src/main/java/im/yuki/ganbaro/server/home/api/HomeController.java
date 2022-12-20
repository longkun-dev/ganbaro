package im.yuki.ganbaro.server.home.api;

import im.yuki.ganbaro.server.common.entity.Response;
import im.yuki.ganbaro.server.home.entity.CheckIn;
import im.yuki.ganbaro.server.home.entity.DailySentence;
import im.yuki.ganbaro.server.home.service.CheckInService;
import im.yuki.ganbaro.server.home.service.DailySentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author longkun
 * @version V1.1.0
 * @date 2022/12/20 9:57 PM
 * @description 首页
 */
@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private CheckInService checkInService;

    @Autowired
    private DailySentenceService dailySentenceService;

    @PostMapping("/checkIn")
    public Response<?> checkIn(@RequestBody CheckIn checkIn) {
        return checkInService.checkIn(checkIn.getUid(), checkIn.getIsDidIt());
    }

    @GetMapping("/dailySentence")
    public Response<?> checkIn() {
        return dailySentenceService.getDailySentence();
    }

    @PutMapping("/dailySentence")
    public Response<?> checkIn(@RequestBody DailySentence dailySentence) {
        return dailySentenceService.likeDailySentence(dailySentence.getId());
    }
}
