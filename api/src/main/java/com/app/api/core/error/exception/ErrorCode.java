package com.app.api.core.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    INVALID_INPUT_VALUE(400, "C001", " Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, "C002", " Invalid Input Value"),
    INVALID_TYPE_VALUE(400, "C005", " Invalid Type Value"),
    HANDLE_ACCESS_DENIED(403, "C006", "Access is Denied"),

    // Uesr
    LOGIN_USER_NOT_FOUND(500, "U001", "Login User Not Found"),
    USER_EMAIL_FAIL(500, "U002", "Login User Email Fail"),
    USER_PASSWORD_FAIL(500, "U003", "Login User Password fail"),
    USER_UPDATE_FAIL(500, "U004", "User Update Fail"),
    USER_NOT_FOUND(500 , "U005" , "User is Not Found") ,
    SAME_USER(500 , "U006" , "User same email") ,

    USER_DISABLED(500 , "U006" , "USER DISABLED") ,
    INVALID_CREDENTIALS(500 , "U007" , "INVALID CREDENTIALS") ,

    // Store
    STORE_NOT_FOUND(500 , "S001" , "Store is Not Found"),

    // Category
    CATEGORY_NOT_FOUND(500 , "P001" , "Category is Not Found"),
    PRODUCT_NOT_FOUND(500 , "P002" , "Product is Not Found"),

    //jwt
    UNABLE_JWT_TOKEN(500 , "J001" , "Unable to get JWT Token"),
    EXPIRED_JWT_TOKEN(500 , "J002" , "JWT Token has expired 1"),
    AUTHORIZATION_NOT_FOUND(500, "J003", "JWT Authorization Not Found"),
    USERNAME_NOT_FOUND(500, "J004", "JWT UserName Not Found"),

    //roles
    AUTH_NOT_ROLES(500, "R001", "Auth Not Roles"),

    SYSTEM_ERROR(500, "E001", "System Error"),
    BAD_REQUEST(500 , "E002" , "Bad Request"),

    ORDER_NOT_FOUND(500 , "O001" , "Order Not Found"),

    MENUN_NOT_FOUND(500 , "M001" , "Menu Not Found"),

    AUTHURL_NOT_FOUND(500 , "A001" , "AuthUrl Not Found"),

    REVIEW_NOT_FOUND(500 , "R001" , "Review Not Found"),

    QUESTION_NOT_FOUND(500 , "Q001" , "Question Not Found"),

    BASKET_NOT_FOUND(500 , "B001" , "Basket Not Found")

    ;

    private final String code;
    private final String message;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }


}
