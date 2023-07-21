package com.abdillah.catalog.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatusCode;

import com.abdillah.catalog.enums.ErrorCode;

import lombok.Data;

@Data
public class ErrorResponseDTO implements Serializable {
    private static final long serialVersionUID = -6164863926L;

    private Date timestamp;

    private String message;

    private ErrorCode errorCode;

    private List<String> details;

    private HttpStatusCode status;

    public static ErrorResponseDTO of(final String message, List<String> details, final ErrorCode errorCode,
            HttpStatusCode status) {
        return new ErrorResponseDTO(message, errorCode, details, status);
    }

    public ErrorResponseDTO(String message, ErrorCode errorCode, List<String> details, HttpStatusCode status) {
        super();
        this.message = message;
        this.errorCode = errorCode;
        this.details = details;
        this.status = status;
        this.timestamp = new Date();
    }

}
