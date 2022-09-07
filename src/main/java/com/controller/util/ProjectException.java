package com.controller.util;

import com.exception.BusinessException;
import com.exception.SystemException;
import com.pojo.Code;
import com.pojo.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.net.SocketTimeoutException;

//项目总异常管理
@RestControllerAdvice
public class ProjectException {

    @ExceptionHandler(BusinessException.class)
    public ResponseResult doBusinessException(BusinessException be){
        return new ResponseResult(be.getCode(),be.getMessage(),null);
    }

    @ExceptionHandler(SystemException.class)
    public ResponseResult doSystemException(SystemException sy){
        return new ResponseResult(sy.getCode(),sy.getMessage(),null);
    }

    @ExceptionHandler(Exception.class)
    public ResponseResult doSystemException(Exception e){
        ResponseResult re;
        if (e instanceof IOException){
            re = new ResponseResult(Code.IOEXCEPTION_ERR,"IO编码异常",null);
        }else if(e instanceof SocketTimeoutException){
            re = new ResponseResult(Code.OVERTIME_ERR,"当前网页访问人数过多,请稍后再试#.#",null);
        }else{
            re = new ResponseResult(Code.UNKNOWN_ERR,"遇到了访问以外的异常,待处理...",null);
        }
        return re;
    }

}
