import { Component } from '@angular/core';
import { StudentService } from '../../services/student.service';
import { Router } from '@angular/router';
import { Student } from '../../classes/student';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from '../header/header.component';
import { FooterComponent } from '../footer/footer.component';

@Component({
  selector: 'app-add-student',
  standalone: true,
  imports: [FormsModule,HeaderComponent,FooterComponent],
  templateUrl: './add-student.component.html',
  styleUrl: './add-student.component.css'
})
export class AddStudentComponent {

  constructor(private studentService:StudentService,private router:Router){}
  student:Student=new Student();
  isStudentAdded=false;

  addStudent()
  {
    this.studentService.addStudent(this.student).subscribe((data)=>{
      this.isStudentAdded=true;
      setTimeout(() => {
        this.router.navigate(['student-list']);
      }, 2000);

    })
  }

  onSubmit()
  {
    this.addStudent();
  }

}
