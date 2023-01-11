package com.example.getinline.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    OK(0, ErrorCategory.NORMAL, "OK"), //정상

    BAD_REQUEST(10000, ErrorCategory.CLIENT_SIDE,"Bad request"), //클라이언트 잘못
    SPRING_BAD_REQUEST(10001, ErrorCategory.CLIENT_SIDE, "Spring-detected bad request"),

    INTERNAl_ERROR(20000, ErrorCategory.SERVER_SIDE,"Internal error"), //서버 잘못
    SPRING_INTERNAL_ERROR(20001, ErrorCategory.SERVER_SIDE,"Spring-detected internal error");

    private final Integer code;
    private final ErrorCategory errorCategory;
    private final String message;

    public String getMessage(Exception e) {
        return getMessage(e.getMessage());
    }

    public String getMessage(String mmessage) {
        return Optional.ofNullable(message)
                .filter(Predicate.not(String::isBlank))
                .orElse(getMessage());
    }

    public boolean isClientSideError() {
        return this.getErrorCategory() == ErrorCategory.CLIENT_SIDE;
    }

    public boolean isServerError() {
        return this.getErrorCategory() == ErrorCategory.SERVER_SIDE;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", name(), this.getCode());
    }

    public enum ErrorCategory{
        NORMAL, CLIENT_SIDE,SERVER_SIDE
    }


    /*public static ErrorCode valueOf(HttpStatus httpStatus) {
        if(httpStatus == null) {
            throw new GeneralException("HttpStatus is null.");
        }
        return Arrays.stream(values())
                .filter(errorCode -> errorCode.getHttpStatus() == httpStatus)
                .findFirst()
                .orElseGet(() -> {
                    if (httpStatus.is4xxClientError()) {
                        return ErrorCode.BAD_REQUEST;
                    }
                    else if(httpStatus.is5xxServerError()) {
                        return ErrorCode.INTERNAl_ERROR;
                    }
                    else {
                        return ErrorCode.OK;
                    }
                });
    }

    public String getMessage(Throwable e) {
        return this.getMessage(this.getMessage() + "-" + e.getMessage());
    }

    public String getMessage(String message) {
        return Optional.ofNullable(message)
                .filter(Predicate.not(String::isBlank))
                .orElse(this.getMessage());
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", this.name(), this.getCode());
    }*/


}
