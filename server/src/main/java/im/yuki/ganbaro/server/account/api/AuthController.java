package im.yuki.ganbaro.server.account.api;

import im.yuki.ganbaro.server.account.service.AuthService;
import im.yuki.ganbaro.server.common.entity.Response;
import im.yuki.ganbaro.server.common.entity.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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

    @GetMapping("/login")
    public Response<?> login(@RequestParam String uid,
                             @RequestParam String password,
                             HttpServletResponse response) {

        Response<?> res = authService.login(uid, password);
        if (res.getCode() == ResultEnum.OK.getCode()) {
            Cookie cookie = new Cookie("ganbaro-token", System.currentTimeMillis() + "");
            response.addCookie(cookie);
        }
        return res;
    }
}
