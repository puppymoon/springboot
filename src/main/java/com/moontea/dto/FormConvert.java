package com.moontea.dto;

public interface FormConvert<S, T> {
	T convert(S s);
}
