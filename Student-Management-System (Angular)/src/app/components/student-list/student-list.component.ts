import { Component } from '@angular/core';
import { StudentService } from '../../services/student.service';
import { Router } from '@angular/router';
import { Student } from '../../classes/student';
import { HeaderComponent } from '../header/header.component';
import { FooterComponent } from '../footer/footer.component';

@Component({
  selector: 'app-student-list',
  standalone: true,
  imports: [HeaderComponent,FooterComponent],
  templateUrl: './student-list.component.html',
  styleUrl: './student-list.component.css'
})
export class StudentListComponent {

  students:Student[]=[];
  ngOnInit()
  { 
    this.getAllStudents();
  }

  constructor(private studentService:StudentService,private router:Router){}

  getAllStudents()
  {
    this.studentService.getAllStudents().subscribe((data)=>{
      this.students=data;
    })
  }

  updateStudent(id:number)
  {
this.router.navigate(['update-student',id]);
  }

  deleteStudent(id:number)
  {
    this.studentService.deleteStudent(id).subscribe((data)=>{
      this.getAllStudents();
    })
  }
}
