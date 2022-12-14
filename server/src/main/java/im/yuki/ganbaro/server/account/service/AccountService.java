package im.yuki.ganbaro.server.account.service;

import im.yuki.ganbaro.server.account.entity.UserInfo;
import im.yuki.ganbaro.server.common.entity.Response;

/**
 * @author longkun
 * @version V1.1.0
 * @date 2022/12/14 11:40 PM
 * @description 账户操作
 */
public interface AccountService {

    /**
     * 新账号注册
     *
     * @param userInfo 账户信息
     * @return null
     */
    Response<?> register(UserInfo userInfo);

    /**
     * 生成 uid
     * @return 可用的 uid
     */
    String generateUid();

    /**
     * 注销账号
     *
     * @param uid uid
     * @return null
     */
    Response<?> delAccount(String uid);

}
