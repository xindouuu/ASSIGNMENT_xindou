package com.jxd.util;

//Customize a generic class for returning results in JSON format.
public class Result<T> {
    private String code;    //Status code
    private String msg;     //Description of the status
    private T data;         //The data carried in the response

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result(){

    }

    public Result(T data){
        this.data = data;
    }

    // return Result(success)
    public static Result success(){
        Result<Object> result = new Result<>();
        result.setCode("200");
        result.setMsg("success");
        return result;
    }
    // return Result(success) and data
    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>(data);
        result.setCode("200");
        result.setMsg("success");
        return result;
    }
    // return Result(error)
    public static Result error(String code, String msg){
        Result<Object> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    // return Result(error) and data
    public static <T> Result<T> error(String code, String msg, T data){
        Result<T> result = new Result<>(data);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
