package com.musinsa.common.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
	//Common
	BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다.", "COMMON-001"),
	INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "요청 파라미터가 잘못 되었습니다.", "COMMON-002"),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부에서 에러가 발생하였습니다.", "COMMON-003"),

	//Product
	PRODUCT_IS_EMPTY(HttpStatus.NOT_FOUND, "조건에 부합하는 상품이 존재하지 않습니다.", "PRODUCT-000"),
	PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, "해당하는 상품을 찾을 수 없습니다.", "PRODUCT-001"),
	PRODUCT_DELETE_FAIL(HttpStatus.BAD_REQUEST, "상품 삭제에 실패하였습니다.", "PRODUCT-002"),
	PRODUCT_UPDATE_FAIL(HttpStatus.BAD_REQUEST, "상품 수정에 실패하였습니다.", "PRODUCT-003"),
	PRODUCT_CREATE_FAIL(HttpStatus.BAD_REQUEST, "상품 작성에 실패하였습니다.", "PRODUCT-004"),

	//Category
	CATEGORY_IS_EMPTY(HttpStatus.NOT_FOUND, "조건에 부합하는 카테고리가 없습니다.", "CATEGORY-000"),
	CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 카테고리 입니다.", "CATEGORY-001"),
	CATEGORY_DELETE_FAIL(HttpStatus.BAD_REQUEST, "카테고리 삭제에 실패하였습니다.", "CATEGORY-002"),
	CATEGORY_UPDATE_FAIL(HttpStatus.BAD_REQUEST, "카테고리 수정에 실패하였습니다.", "CATEGORY-003"),
	CATEGORY_CREATE_FAIL(HttpStatus.BAD_REQUEST, "카테고리 작성에 실패하였습니다.", "CATEGORY-004"),
	CATEGORY_NAME_IS_EMPTY(HttpStatus.BAD_REQUEST, "카테고리 이름이 비어있습니다.", "CATEGORY-005"),

	//Brand
	BRAND_IS_EMPTY(HttpStatus.NOT_FOUND, "조건에 부합하는 브랜드가 없습니다.", "BRAND-000"),
	BRAND_NOT_FOUND(HttpStatus.NOT_FOUND, "해당하는 브랜드를 찾을 수 없습니다.", "BRAND-001"),
	BRAND_DELETE_FAIL(HttpStatus.BAD_REQUEST, "브랜드 삭제에 실패하였습니다.", "BRAND-002"),
	BRAND_UPDATE_FAIL(HttpStatus.BAD_REQUEST, "브랜드 수정에 실패하였습니다.", "BRAND-003"),
	BRAND_CREATE_FAIL(HttpStatus.BAD_REQUEST, "브랜드 작성에 실패하였습니다.", "BRAND-004"),

	// Outfit(코디)
	OUTFIT_IS_EMPTY(HttpStatus.NOT_FOUND, "조건에 부합하는 코디가 없습니다.", "OUTFIT-000"),
	OUTFIT_NOT_FOUND(HttpStatus.NOT_FOUND, "해당하는 코디를 찾을 수 없습니다.", "OUTFIT-001"),
	;


	private final HttpStatus httpStatus;
	private final String message;
	private final String code;
}
