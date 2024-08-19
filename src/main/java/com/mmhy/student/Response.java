package com.mmhy.student;
//此类用于判断请求是否成功，并返回相应的数据或者错误信息
public class Response <T> {
    private T data;
    private boolean success;
    private String errorMsg;

    public static <k> Response <k> newSuccess(k data) {
        Response<k> response = new Response<>();
        response.setData(data);
        response.setSuccess(true);
        return response;
    }

    public static Response <Void> newFail(String errorMsg) {
        Response<Void> response = new Response<>();
        response.setErrorMsg(errorMsg);
        response.setSuccess(false);
        return response;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}