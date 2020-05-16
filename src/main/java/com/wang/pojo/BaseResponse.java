package com.wang.pojo;

import java.util.List;

public class BaseResponse {

    private Integer code=0;

    private String msg="request successful";

    private Integer count;

    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static BaseResponse getInstance(Object data) {
        BaseResponse response = new BaseResponse();
        if(data instanceof List){
            int  count = ((List) data).size();
            response.setCount(count);
        }
        response.setData(data);
        return  response;
    }
}
