package com.abdillah.catalog.exception;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.abdillah.catalog.dto.ErrorResponseDTO;
import com.abdillah.catalog.enums.ErrorCode;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(ResourceNotFoundException ex,
            WebRequest request) {
        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.of("data not found", details, ErrorCode.DATA_NOT_FOUND,
                HttpStatusCode.valueOf(400));
        return ResponseEntity.badRequest().body(errorResponseDTO);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<String> details = new ArrayList<String>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.of("INVALID DATA", details, ErrorCode.INVALID_DATA,
                HttpStatusCode.valueOf(400));
        return ResponseEntity.badRequest().body(errorResponseDTO);
    }

}
