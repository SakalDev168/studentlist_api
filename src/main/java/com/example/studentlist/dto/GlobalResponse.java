package com.example.studentlist.dto;

public record GlobalResponse<T>(
        boolean success,
        int statusCode,
        String message,
        T data
) {

    public static <T> GlobalResponse<T> success(boolean success,int statusCode, T data) {
        return new GlobalResponse<>(true, 200, null, data);
    }
    public static <T> GlobalResponse<T> success(boolean success ,String message, T data) {
        return new GlobalResponse<>(true, 200, message, data);
    }
    public static <T> GlobalResponse<T> badRequest(boolean success,int statusCode, String message) {
        return new GlobalResponse<>(false, 404, message, null);
    }
}