package com.brandedhustler.PAYROLLSYSTEM.resources;

import com.brandedhustler.PAYROLLSYSTEM.models.Employee;
import com.brandedhustler.PAYROLLSYSTEM.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/employee")
//@CrossOrigin("*")
public class EmployeeController {


    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/all")

    public ResponseEntity<List<Employee>> getEmployee(){
        List<Employee> employees = employeeService.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeid") Integer employeeid){
        Employee employee = employeeService.findEmployeeById(employeeid);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


    @PostMapping("/add")

    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.addNewEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.CREATED);

    }

    @DeleteMapping( "/delete/{employeeID}")
    public void deletesEmployee(@PathVariable("employeeID") Integer employeeID){
        employeeService.deleteEmployee(employeeID);

    }

    @PutMapping( "/updatesEmployee/{employeeID}")
    public void updateEmployee(@PathVariable("employeeID") Integer employeeID,
                               @RequestParam(required = false) String surname,
                               @RequestParam(required = false) String othername,
                               @RequestParam(required = false) String email,
                               @RequestParam(required = false) String position,
                               @RequestParam(required = false) String phonenumber,
                               @RequestParam(required = false) Double basicSalaryUSD,
                               @RequestParam(required = false) String status){
        employeeService.updateEmployee(employeeID, surname, othername, email, position, phonenumber, basicSalaryUSD, status);


    }


    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployee/{employeeid}")
    public ResponseEntity<?>deleteEmployee(@PathVariable("employeeid") Integer employeeid){
        employeeService.deleteEmployee(employeeid);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
