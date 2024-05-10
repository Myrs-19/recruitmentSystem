package ru.sfedu.lab4.map.model;

public class Result {

    public Result(){}

    public Result(String message, int code) {
        this.message = message;
        this.code = code;
    }

    private String message;

    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}