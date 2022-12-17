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
     * @param uid uid
     * @param password password
     * @return null
     */
    Response<?> login(String uid, String password);

    /**
     * 退出登录
     *
     * @return null
     */
    Response<?> logout();
}
