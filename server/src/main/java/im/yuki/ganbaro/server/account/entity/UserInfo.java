package im.yuki.ganbaro.server.account.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表
 *
 * @TableName user_info
 */
@Data
@ToString
public class UserInfo implements Serializable {

    /**
     * 主键
     */
    private String id;

    /**
     * 用户id
     */
    private String uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登陆密码，md5加密
     */
    private String password;

    /**
     * 性别
     */
    private String sex;

    /**
     * 个人签名
     */
    private String description;

    /**
     * 上次登陆时间
     */
    private Date lastLoginTime;

    /**
     * 账户状态
     */
    private String accountStatus;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 更新人
     */
    private String updatedBy;

    private static final long serialVersionUID = 1L;

}
