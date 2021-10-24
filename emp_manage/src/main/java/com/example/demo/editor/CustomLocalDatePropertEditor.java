package com.example.demo.editor;

import java.beans.*;
import java.time.*;

import org.springframework.stereotype.*;

// 자바에서 자주 사용하는 구현 스타일
// 표준 인터페이스 <- 기본 구현을 추가한 추상 클래스 <- 클래스
//  Servlet <- HttpServlet < - 나의 서블릿
// PropertyEditor <- PropertyEditorSupport <- 나의 에디터

@Component
public class CustomLocalDatePropertEditor extends PropertyEditorSupport {
	// 사용자가 입력한 값이 text라는 파라미터값으로 전달되면 내가 원하는 객체를 만든다음 setValue(객체)
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// text : 2010-11-20 ==> ["2010", "11", "20"] -> 2010, 11, 20 -> LocalDate.of(2010, 11, 20)
		String[] str = text.split("-");
		int year = Integer.parseInt(str[0]);
		int month = Integer.parseInt(str[1]);
		int day = Integer.parseInt(str[2]);
		LocalDate date = LocalDate.of(year, month, day);
		System.out.println(date.getYear());
		setValue(date);
	}
}
