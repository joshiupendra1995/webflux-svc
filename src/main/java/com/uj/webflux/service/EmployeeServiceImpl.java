package com.uj.webflux.service;

import org.springframework.stereotype.Service;
import com.uj.webflux.entity.Employee;
import com.uj.webflux.repository.EmployeeRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * CreatedBy:- Upendra.Joshi
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Mono<Employee> create(Employee employee) {
		return employeeRepository.save(employee.setAsNew());

	}

	@Override
	public Mono<Employee> update(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Mono<Employee> findByEmpId(Long empId) {
		return employeeRepository.findByEmpId(empId);
	}

	@Override
	public Flux<Employee> findByEmpName(String empName) {
		return employeeRepository.findByEmpName(empName);
	}

	@Override
	public Flux<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Mono<Employee> delete(Long empId) {
		return employeeRepository.deleteByEmpId(empId);

	}

}
