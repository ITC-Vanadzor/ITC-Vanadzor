package com.itcvanadzor.lunch.controller;

public class ResponseBodyCode {
    
    int code;
    
    String body;
    
    public ResponseBodyCode(int code, String body){
        this.code = code;
        this.body = body;
    }

    ResponseBodyCode(int codeOk, int sessionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getBody(){
        return body;
    }
    
    public int getCode(){
        return code;
    }
}
