package im.yuki.ganbaro.server.account.api;

import im.yuki.ganbaro.server.account.entity.UserInfo;
import im.yuki.ganbaro.server.account.service.AccountService;
import im.yuki.ganbaro.server.common.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author longkun
 * @version V1.1.0
 * @date 2022/12/14 11:32 PM
 * @description 账户 api 接口
 */
@RequestMapping("/")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account")
    public Response<?> register(@RequestBody UserInfo userInfo) {
        return accountService.register(userInfo);
    }

    @DeleteMapping("/account")
    public Response<?> delAccount(@RequestParam String uid) {
        return accountService.delAccount(uid);
    }

}
