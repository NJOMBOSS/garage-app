package org.fonke.garageapp.exception;
public enum ErrorCodes {

    CAR_NOT_FOUND(1000),
    CAR_NOT_VALID(1001);
    private int code;

    ErrorCodes(int code){
        this.code = code ;
    }
    public int getCode(){
        return code;
    }
}

