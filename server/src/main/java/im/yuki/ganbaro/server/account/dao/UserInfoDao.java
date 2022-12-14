package im.yuki.ganbaro.server.account.dao;

import im.yuki.ganbaro.server.account.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * @author longkun
 * @version V1.1.0
 * @date 2022/12/14 11:09 PM
 * @description
 */
@Mapper
public interface UserInfoDao {

    int insert(UserInfo userInfo);

    UserInfo queryByUid(String uid);

    String queryMaxUid();

    int updateAccountStatusByUid(String uid, String accountStatus);

    int updateLastLoginTimeByUid(String uid, Date date);
}
