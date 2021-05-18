package com.uj.webflux.vo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EmployeeVO {
	
	private Long empId;

	private String empName;

	private String address;

	private BigDecimal eSalary; 

}
