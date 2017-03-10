package com.hai.exception;

/**
 * Created by as on 2017/3/9.
 */
public class CustomException extends Exception {
    private String message;

    public CustomException() {
        super();
        System.out.println(this.getClass().getName());
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
