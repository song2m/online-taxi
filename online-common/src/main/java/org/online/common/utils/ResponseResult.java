package org.online.common.utils;

import lombok.Data;
import lombok.experimental.Accessors;
import org.online.common.constants.CommonStatusEnum;

@Accessors(chain = true)
@Data
public class ResponseResult<T> {

    private int status;

    private String message;

    private T data;


    /**
     * 成功响应的方法
     */
    public static <T> ResponseResult<T> success() {
        return new ResponseResult<T>()
                .setStatus(CommonStatusEnum.SUCCESS.getCode())
                .setMessage(CommonStatusEnum.SUCCESS.getValue());
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>()
                .setStatus(CommonStatusEnum.SUCCESS.getCode())
                .setMessage(CommonStatusEnum.SUCCESS.getValue())
                .setData(data);
    }

    /**
     * 失败：统一的失败
     */
    public static <T> ResponseResult<T> error(String message) {
        return new ResponseResult<T>()
                .setStatus(CommonStatusEnum.ERROR.getCode())
                .setMessage(message);
    }

    /**
     * 失败：自定义失败 错误码和提示信息
     */
    public static <T> ResponseResult<T> error(int code, String message) {
        return new ResponseResult<T>().
                setStatus(code)
                .setMessage(message);
    }
    public static <T> ResponseResult<T> error(CommonStatusEnum commonStatusEnum) {
        return new ResponseResult<T>().
                setStatus(commonStatusEnum.getCode())
                .setMessage(commonStatusEnum.getValue());
    }

}
