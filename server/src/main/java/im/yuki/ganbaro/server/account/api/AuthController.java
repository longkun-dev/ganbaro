package im.yuki.ganbaro.server.account.api;

import im.yuki.ganbaro.server.account.entity.UserInfo;
import im.yuki.ganbaro.server.account.service.AuthService;
import im.yuki.ganbaro.server.common.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author longkun
 * @version V1.1.0
 * @date 2022/12/15 1:19 AM
 * @description 鉴权 api
 */
@RequestMapping("/")
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/account")
    public Response<?> login(@RequestBody UserInfo userInfo) {
        return authService.login(userInfo);
    }
}
