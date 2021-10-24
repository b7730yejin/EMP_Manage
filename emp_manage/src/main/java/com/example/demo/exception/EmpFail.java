package com.example.demo.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmpFail {
	public static class UserRejectAccessException extends RuntimeException {
		
	}
	public static class UserNotFoundException extends RuntimeException {
	}
}
