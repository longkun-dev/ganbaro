package im.yuki.ganbaro.server.common.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author longkun
 * @version V1.1.0
 * @date 2022/12/14 11:41 PM
 * @description api 接口返回信息包装
 */
@Data
@ToString
public class Response<T> {

    private int code;

    private String message;

    private T data;

    public Response(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public Response(ResultEnum resultEnum, String message) {
        this.code = resultEnum.getCode();
        this.message = message;
    }

    public Response(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }
}
