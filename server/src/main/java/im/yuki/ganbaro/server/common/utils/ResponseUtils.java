package im.yuki.ganbaro.server.common.utils;

import im.yuki.ganbaro.server.common.entity.Response;
import im.yuki.ganbaro.server.common.entity.ResultEnum;

/**
 * @author longkun
 * @version V1.1.0
 * @date 2022/12/14 11:55 PM
 * @description api 接口返回信息包装工具类
 */
public class ResponseUtils<T> {

    public static <T> Response<T> success() {
        return new Response<>(ResultEnum.OK);
    }

    public static <T> Response<T> success(ResultEnum resultEnum) {
        return new Response<>(resultEnum);
    }

    public static <T> Response<T> success(ResultEnum resultEnum, String message) {
        return new Response<>(resultEnum, message);
    }

    public static <T> Response<T> success(ResultEnum resultEnum, T data) {
        return new Response<>(resultEnum, data);
    }

    public static <T> Response<T> fail(ResultEnum resultEnum) {
        return new Response<>(resultEnum);
    }

    public static <T> Response<T> fail(ResultEnum resultEnum, String message) {
        return new Response<>(resultEnum, message);
    }
}
