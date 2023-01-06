package com.brandedhustler.PAYROLLSYSTEM.services;

import com.brandedhustler.PAYROLLSYSTEM.exceptions.UserNotFoundException;
import com.brandedhustler.PAYROLLSYSTEM.models.Employee;
import com.brandedhustler.PAYROLLSYSTEM.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee addNewEmployee(Employee employee){
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(employee.getEmail());

        if(employeeOptional.isPresent()){
            throw new IllegalStateException("email already taken");

        }
        return employeeRepository.save(employee);
    }


    public void deleteEmployee(Integer employeeID){

        boolean itExists = employeeRepository.existsById(employeeID);
        if (!itExists){
            throw new IllegalStateException("Employee with id " + employeeID + " does not exist");
        }

        else {
            employeeRepository.deleteById(employeeID);
        }

    }


    @Transactional
    public void updateEmployee( Integer employeeID, String surname,
                                String othername, String email,
                                String position, String phoneNumber,
                                Double basicSalaryUSD,
                                String status){

        Employee employees = employeeRepository.findById(employeeID).orElseThrow(()-> new IllegalStateException(
                "Employee with id " + employeeID + " does not exist"));

        if (surname != null && surname.length() > 0 && !Objects.equals(employees.getSurname(), surname)){
            employees.setSurname(surname);
        }

        if (othername != null && othername.length() > 0 && !Objects.equals(employees.getOthername(), othername)){
            employees.setOthername(othername);
        }
        if (email != null && email.length() > 0 && !Objects.equals(employees.getEmail(), email)){
            Optional<Employee> optionalEmployee = employeeRepository.findEmployeeByEmail(email);
            if (optionalEmployee.isPresent()){
                throw new IllegalStateException("email already exist");
            }
            employees.setEmail(email);
        }
        if (position != null && position.length() > 0 && !Objects.equals(employees.getPosition(), position)){
            employees.setPosition(position);
        }
        if (phoneNumber != null && phoneNumber.length() > 0 && !Objects.equals(employees.getPhoneNumber(), phoneNumber)){
            employees.setPhoneNumber(phoneNumber);
        }

        if (basicSalaryUSD != null && basicSalaryUSD.isNaN() && !Objects.equals(employees.getBasicSalaryUSD(), basicSalaryUSD)){
            employees.setBasicSalaryUSD(basicSalaryUSD);
        }

        if (status != null && status.length() > 0 && !Objects.equals(employees.getStatus(), status)){
            employees.setStatus(status);
        }




    }

    @Transactional
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);

    }


    public Employee findEmployeeById(Integer employeeid) {
    return employeeRepository.findEmployeeByEmployeeID(employeeid).
            orElseThrow(()-> new UserNotFoundException("User with id " + employeeid + " was not found"));
    }
}
