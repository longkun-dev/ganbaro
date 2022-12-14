package im.yuki.ganbaro.server.account.service.impl;

import im.yuki.ganbaro.server.account.dao.UserInfoDao;
import im.yuki.ganbaro.server.account.entity.UserInfo;
import im.yuki.ganbaro.server.account.service.AccountService;
import im.yuki.ganbaro.server.common.constant.ConstantVal;
import im.yuki.ganbaro.server.common.entity.Response;
import im.yuki.ganbaro.server.common.entity.ResultEnum;
import im.yuki.ganbaro.server.common.utils.ResponseUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author longkun
 * @version V1.1.0
 * @date 2022/12/15 12:10 AM
 * @description 账号操作接口实现
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public Response<?> register(UserInfo userInfo) {
        boolean isValidUserInfo = this.isValidRegisterInfo(userInfo);
        if (!isValidUserInfo) {
            return ResponseUtils.fail(ResultEnum.BAD_REQUEST, "用户姓名、密码、性别不能为空");
        }

        userInfo.setUid(this.generateUid());
        userInfo.setAccountStatus(ConstantVal.ACCOUNT_STATUS_NORMAL);
        userInfo.setCreatedBy(userInfo.getUid());
        userInfo.setUpdatedBy(userInfo.getUid());

        userInfoDao.insert(userInfo);

        return ResponseUtils.success(ResultEnum.CREATED);
    }

    /**
     * 注册信息是否有效
     *
     * @param userInfo 注册信息
     * @return 有效返回 true，否则返回 false
     */
    private boolean isValidRegisterInfo(UserInfo userInfo) {
        return userInfo != null
                && StringUtils.isNoneBlank(userInfo.getUsername())
                && StringUtils.isNoneBlank(userInfo.getPassword())
                && StringUtils.isNoneBlank(userInfo.getSex());
    }

    @Override
    public String generateUid() {
        String availableUid;
        String uid = userInfoDao.queryMaxUid();
        if (StringUtils.isNoneBlank(uid)) {
            String uidNum = uid.replaceAll(ConstantVal.ACCOUNT_UID_PREFIX, "");
            int newUidNum = Integer.parseInt(uidNum) + 1;
            availableUid = ConstantVal.ACCOUNT_UID_PREFIX
                    + StringUtils.leftPad(newUidNum + "", 8, '0');
        } else {
            availableUid = "U00000001";
        }
        return availableUid;
    }

    @Override
    public Response<?> delAccount(String uid) {
        if (StringUtils.isBlank(uid)) {
            return ResponseUtils.fail(ResultEnum.BAD_REQUEST, "uid 不能为空");
        }

        UserInfo userInfo = userInfoDao.queryByUid(uid);
        if (userInfo == null) {
            return ResponseUtils.fail(ResultEnum.NOT_FOUND);
        }

        userInfoDao.updateAccountStatusByUid(userInfo.getUid(),
                ConstantVal.ACCOUNT_STATUS_DELETED);
        return ResponseUtils.success(ResultEnum.NO_CONTENT, "账号注销成功");
    }
}
