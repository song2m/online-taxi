package org.online.common.configs;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义异常类
 *
 * @author songming
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {

    private String message;

    public BusinessException(String message) {
        this.message = message;
    }
}
