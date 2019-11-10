package com.beerhouse.exception;

public class NonExistentObjectException extends RuntimeException {
	
    private Integer code = 2;

    public NonExistentObjectException(String message) {
        super(message);
    }

    public Integer getCode() {
        return code;
    }

}
