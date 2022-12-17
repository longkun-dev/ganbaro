package im.yuki.ganbaro.server.account.service.impl;

import im.yuki.ganbaro.server.account.dao.UserInfoDao;
import im.yuki.ganbaro.server.account.entity.UserInfo;
import im.yuki.ganbaro.server.account.service.AuthService;
import im.yuki.ganbaro.server.common.constant.ConstantVal;
import im.yuki.ganbaro.server.common.entity.Response;
import im.yuki.ganbaro.server.common.entity.ResultEnum;
import im.yuki.ganbaro.server.common.utils.ResponseUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author longkun
 * @version V1.1.0
 * @date 2022/12/15 1:08 AM
 * @description 鉴权
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public Response<?> login(String uid, String password) {
        if (StringUtils.isBlank(uid) || StringUtils.isBlank(password)) {
            return ResponseUtils.fail(ResultEnum.BAD_REQUEST, "账号密码不能为空");
        }

        UserInfo user = userInfoDao.queryByUid(uid);
        if (user == null) {
            return ResponseUtils.fail(ResultEnum.NOT_FOUND, "该用户不存在");
        } else if (ConstantVal.ACCOUNT_STATUS_BANED.equals(user.getAccountStatus())) {
            return ResponseUtils.fail(ResultEnum.UNAUTHORIZED, "该账号正在封禁中，不允许登录");
        } else if (ConstantVal.ACCOUNT_STATUS_DELETED.equals(user.getAccountStatus())) {
            return ResponseUtils.fail(ResultEnum.NOT_FOUND, "该用户不存在");
        }
        if (!password.equals(user.getPassword())) {
            return ResponseUtils.fail(ResultEnum.UNAUTHORIZED, "uid或密码错误");
        }

        // uid 和密码校验成功，更新最新登陆时间
        userInfoDao.updateLastLoginTimeByUid(uid, new Date());

        return ResponseUtils.success(ResultEnum.OK, "登录成功");
    }

    @Override
    public Response<?> logout() {
        return null;
    }
}
