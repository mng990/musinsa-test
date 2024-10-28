package com.musinsa.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.musinsa.common.dto.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ApiException.class)
	public ErrorResponse handleApiException(ApiException e) {
		log.error("ApiException", e);
		return ErrorResponse.of(e.getHttpStatus(), e.getMessage(), e.getCode());
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ErrorResponse handleIllegalArgumentException(IllegalArgumentException e) {
		log.error("IllegalArgumentException", e);
		return ErrorResponse.of(HttpStatus.BAD_REQUEST, e.getMessage(), ErrorCode.INVALID_PARAMETER.getCode());
	}
}
