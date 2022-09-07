package com.pojo;

public class Code {
    //成功响应码
    public static final Integer SELECT_OK = 200;
    public static final Integer SAVE_OK = 201;
    public static final Integer DELETE_OK = 202;
    public static final Integer UPDATE_OK = 203;
    public static final Integer SELECT_PAGE_OK = 204;

    //失败响应码
    public static final Integer SELECT_ERR = 210;
    public static final Integer SAVE_ERR = 211;
    public static final Integer DELETE_ERR = 212;
    public static final Integer UPDATE_ERR = 213;
    public static final Integer SELECT_PAGE_ERR = 214;

    //其它响应码
    public static final Integer IOEXCEPTION_ERR = 301;
    public static final Integer UNKNOWN_ERR = 404;
    public static final Integer OVERTIME_ERR = 408;
}
