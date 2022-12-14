package im.yuki.ganbaro.server.common.entity;

import lombok.Getter;

/**
 * @author longkun
 * @version V1.1.0
 * @date 2022/12/14 11:43 PM
 * @description api 接口返回结果类型
 */
@Getter
public enum ResultEnum {

    OK(200, "操作成功"),

    CREATED(201, "创建成功"),

    ACCEPTED(202, "请求成功，处理中"),

    NO_CONTENT(204, "删除成功"),

    BAD_REQUEST(400, "请求错误"),

    UNAUTHORIZED(401, "尚未被授权"),

    FORBIDDEN(403, "禁止访问"),

    NOT_FOUND(404, "未找到相关数据"),

    GONE(410, "数据不存在"),

    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),

    CUSTOMIZE_ERROR(-1, "");

    private final int code;

    private final String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
