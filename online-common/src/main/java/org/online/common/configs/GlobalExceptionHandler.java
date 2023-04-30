package org.online.common.configs;

import org.online.common.utils.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author songming
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 自定义业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseResult<String> businessExceptionHandler(BusinessException e) {
        LOGGER.error("businessException: {}", e.getMessage());
        return ResponseResult.error(e.getMessage());
    }
}
