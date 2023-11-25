package com.company.dto;

public class ResponseDTO {
    private String message=null;
    private Object object=null;
    public static ResponseDTO of(Object o){
        ResponseDTO r= new ResponseDTO();
        r.object=o;
        return r;
    }
    public ResponseDTO(){}
    public static ResponseDTO of(Object o, String m){
        ResponseDTO r= new ResponseDTO();
        r.object=o;
        r.message=m;
        return r;
    }
    public static ResponseDTO of(String message){
        ResponseDTO r= new ResponseDTO();
        r.message=message;
        return r;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}