package com.ajstudy.nbrg.Server;

public class ResultObject<T> {

    String responseMsg;
    int responseCode;
    T result;

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public ResultObject(String responseMsg, int responseCode) {
        this.responseMsg = responseMsg;
        this.responseCode = responseCode;
    }

}
