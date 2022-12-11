package im.yuki.ganbaro.web.api.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author longkun
 * @since 12/11/2022 5:00 PM
 */
@RequestMapping("/")
@RestController
public class TestController {

    @PostMapping( "/account")
    public String createNewAccount() {
        return "创建成功";
    }

    @PostMapping( "/account")
    public String updateAccount() {
        return "创建成功";
    }

    @GetMapping( "/account")
    public String findAccount() {
        return "创建成功";
    }
}
