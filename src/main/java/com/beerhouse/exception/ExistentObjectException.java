package com.beerhouse.exception;

public class ExistentObjectException extends RuntimeException {
	
    private Integer code = 2;

    public ExistentObjectException(String message) {
        super(message);
    }

    public Integer getCode() {
        return code;
    }

}
