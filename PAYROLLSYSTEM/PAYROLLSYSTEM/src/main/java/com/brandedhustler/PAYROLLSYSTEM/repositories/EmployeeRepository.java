package com.brandedhustler.PAYROLLSYSTEM.repositories;

import com.brandedhustler.PAYROLLSYSTEM.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    Optional<Employee> findEmployeeByEmail(String email);
    Optional<Employee> findEmployeeByEmployeeID(Integer employeeID);

}
