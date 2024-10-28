package com.musinsa.common.mapper;

public class PriceMapper {

	public static String longToString (Long price) {
		return String.format("%,d", price);
	}

	public static Long stringToLong(String priceStr) {
		return Long.parseLong(priceStr.replaceAll(",", ""));
	}
}
