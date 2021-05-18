package com.uj.webflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import com.uj.webflux.entity.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Integer> {
    Flux<Employee> findByEmpName(final String empName);

	Mono<Employee> findByEmpId(Long empId);

	Mono<Employee> deleteByEmpId(Long empId);
}
