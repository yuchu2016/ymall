package com.yuchu.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * @Author: yuchu
 * @Description:
 * @Date: Create in 15:27  2017/9/26
 * @Modified By:
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//保证序列化JSON，Null对象key也会消失
public class ServerResponse<T> implements Serializable{

    private int status;

    private String msg;

    private T data;

    private ServerResponse(int status){
        this.status = status;
    }

    private ServerResponse(int status,T data){
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status,String msg,T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(int status,String msg){
        this.status = status;
        this.msg = msg;
    }

    @JsonIgnore
    public boolean isSuccess(){
       return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus(){
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData(){
        return data;
    }

    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T>ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T>ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T>ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }

    public static <T>ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }

    public static <T>ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T>ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new ServerResponse<T>(errorCode,errorMessage);
    }
}
