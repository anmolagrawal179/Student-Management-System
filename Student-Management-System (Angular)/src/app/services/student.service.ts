import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Student } from '../classes/student';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private httpClient:HttpClient) { }

  private baseUrl="http://localhost:8080/student";

  getAllStudents():Observable<Student[]>
  {
   return this.httpClient.get<Student[]>(`${this.baseUrl}`);
  }

  addStudent(student:Student):Observable<Student>
  {
   return this.httpClient.post<Student>(`${this.baseUrl}`,student);
  }

  getStudentById(id:number):Observable<Student>
  {
   return this.httpClient.get<Student>(`${this.baseUrl}/${id}`);
  }

  updateStudent(student:Student,id:number):Observable<Student>
  {
   return this.httpClient.put<Student>(`${this.baseUrl}/${id}`,student);
  }

  deleteStudent(id:number):Observable<Student>
  {
   return this.httpClient.delete<Student>(`${this.baseUrl}/${id}`);
  }
}
