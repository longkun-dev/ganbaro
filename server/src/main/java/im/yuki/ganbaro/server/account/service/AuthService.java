package im.yuki.ganbaro.server.account.service;

import im.yuki.ganbaro.server.account.entity.UserInfo;
import im.yuki.ganbaro.server.common.entity.Response;

/**
 * @author longkun
 * @version V1.1.0
 * @date 2022/12/15 1:06 AM
 * @description 登录及操作鉴权
 */
public interface AuthService {

    /**
     * 登录操作
     *
     * @param userInfo uid 和 密码
     * @return null
     */
    Response<?> login(UserInfo userInfo);

    /**
     * 退出登录
     *
     * @return null
     */
    Response<?> logout();
}
