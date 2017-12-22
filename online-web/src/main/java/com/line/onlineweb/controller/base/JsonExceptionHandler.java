package com.line.onlineweb.controller.base;

import com.line.exception.ErrorCodeException;
import com.line.onlineweb.bean.JsonResult;
import com.line.utils.StringUtils;
import org.slf4j.Logger;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackages = "com.line.onlineweb.controller")
public class JsonExceptionHandler {

    private static Logger log = org.slf4j.LoggerFactory.getLogger(JsonExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult handler(HttpServletRequest req, Exception e) throws Exception {
        JsonResult json = JsonResult.wrapper(null);
        json.success = false;
        json.errcode = null;
        String msg = e.getMessage();

        log.error(msg, e);

        if (e instanceof ErrorCodeException) {
            ErrorCodeException we = (ErrorCodeException) e;
            json.errcode = we.getErrcode();
            json.errmsg = we.getMessage();
        }else if (e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException we = (MethodArgumentNotValidException) e;
            json.errmsg = we.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        }else if (e instanceof BindException){
            BindException we = (BindException) e;
            json.errmsg = we.getFieldErrors().get(0).getDefaultMessage();
        }

        /**
         * 如果有中文，错误信息为中文
         *  如果没有中文，按照异常类型进行翻译。
         */
        else if (null != msg && StringUtils.isContainsChinese(msg)) {
            json.errmsg = msg;
        } else {
            if (e instanceof HttpMessageNotReadableException) {
                json.errmsg = "请求数据错误";
            } else {
                json.errmsg = "系统错误";
            }
        }
        return json;
    }


}
