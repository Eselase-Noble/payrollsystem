import { Component } from '@angular/core';
import { Employee } from './models/employee';
import { EmployeeService } from './services/employee.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'payrollsystemapp';

  public employees : Employee[] = []

  constructor(private employeeService: EmployeeService){}
  
  ngOnInit(): void{
    this.getAllEmployees();
  }

  public getAllEmployees(): void{
    this.employeeService.getAllEmployees().subscribe({next: (response: Employee[])=>{
      this.employees = response;
    }
    });
  }


}

