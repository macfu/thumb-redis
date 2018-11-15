package com.macfu.globalutils;

import com.macfu.exception.CustomerException;
import com.macfu.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Author: liming
 * @Date: 2018/11/14 15:03
 * @Description:
 */
@ControllerAdvice
public class ControllerUtilsAdvice {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 全局异常
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    private Result errorHandler(Exception e) {
        log.error("全局异常" + e);
        return Result.error(-1, "全局异常" + e);
    }

    /**
     * Spring接收参数异常
     */
    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    private Result httpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("${Enum.INVALID_PARAMETER.msg} - 【msg】" + e.getMessage());
        return Result.error(Enum.INVALID_PARAMETER.getValue(), Enum.INVALID_PARAMETER.getMsg());
    }

    /**
     * 自定义异常
     */
    @ResponseBody
    @ExceptionHandler(CustomerException.class)
    private Result customerException(CustomerException e) {
        log.error("自定义异常--【code】" + e.getCode() + "--【msg】" + e.getMsg() + "--【data】" + e.getData());
        return Result.error(e.getCode(), e.getMsg(), e.getData());
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private Result notValid(MethodArgumentNotValidException e) {
        log.error(e.getMessage());
        return Result.error(Enum.INVALID_PARAMETER.getValue(), Enum.INVALID_PARAMETER.getMsg());
    }

}
