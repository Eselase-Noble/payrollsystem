import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../models/employee';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private apiServerUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  public getAllEmployees(): Observable<Employee[]>{
    return this.http.get<Employee[]>(`${this.apiServerUrl}/employee/all`)
  }
  public addEmployee(employee: Employee): Observable<Employee>{
    return this.http.post<Employee>(`${this.apiServerUrl}/employee/add`, employee);
  }

  public updateEmployee(employee: Employee): Observable<Employee>{
    return this.http.put<Employee>(`${this.apiServerUrl}/employee/updateEmployee`, employee);
  }

  public deleteEmployee(employeeID: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/employee/deleteEmployee/${employeeID}`);
  }
}
