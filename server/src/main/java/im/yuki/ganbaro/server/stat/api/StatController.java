package im.yuki.ganbaro.server.stat.api;

import im.yuki.ganbaro.server.common.entity.Response;
import im.yuki.ganbaro.server.home.entity.CheckIn;
import im.yuki.ganbaro.server.stat.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author longkun
 * @version V1.1.0
 * @date 2022/12/20 10:37 PM
 * @description 统计 api
 */
@RestController
@RequestMapping("/")
public class StatController {

    @Autowired
    private StatService statService;

    @GetMapping("/stat/{uid}/{year}/{month}")
    public Response<List<CheckIn>> statByYearMonth(@PathVariable String uid,
                                                   @PathVariable int year,
                                                   @PathVariable int month) {
        return statService.queryCheckIn(uid, year, month);
    }

    @GetMapping("/stat/{uid}/{year}")
    public Response<Map<String, Object>> statByYear(@PathVariable String uid,
                                                    @PathVariable int year) {
        return statService.queryCheckIn(uid, year);
    }

    @GetMapping("/stat/{uid}")
    public Response<Map<String, Integer>> statByYear(@PathVariable String uid) {
        return statService.queryCheckIn(uid);
    }
}
