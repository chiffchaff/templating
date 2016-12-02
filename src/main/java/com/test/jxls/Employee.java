package com.test.jxls;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

@Data
@Accessors
@ToString
@AllArgsConstructor
@Builder
public class Employee {
	String name;
	Date birthDate;
	BigDecimal payment;
	BigDecimal bonus;
	
	
}
