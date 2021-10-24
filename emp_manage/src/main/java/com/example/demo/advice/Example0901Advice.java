package com.example.demo.advice;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.exception.*;

// 주소가 아니라 예외에 응답하는 컨트롤러

@ControllerAdvice
public class Example0901Advice {
	
	@ExceptionHandler(EmpFail.UserNotFoundException.class)
	public ResponseEntity<?> userNotFoundExceptionHandler() {
		return ResponseEntity.status(HttpStatus.CONFLICT).body("사용자를 찾을 수 없습니다.");
	}
	
	@ExceptionHandler(EmpFail.UserRejectAccessException.class)
	public ResponseEntity<?> userRejectAccessExceptionHandler() {
		return ResponseEntity.status(HttpStatus.CONFLICT).body("접근 권한이 없습니다.");
	}
	
}
