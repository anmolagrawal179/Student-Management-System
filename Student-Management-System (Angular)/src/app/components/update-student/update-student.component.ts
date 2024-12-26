import { Component } from '@angular/core';
import { StudentService } from '../../services/student.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from '../../classes/student';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from '../header/header.component';
import { FooterComponent } from '../footer/footer.component';

@Component({
  selector: 'app-update-student',
  standalone: true,
  imports: [FormsModule,HeaderComponent,FooterComponent],
  templateUrl: './update-student.component.html',
  styleUrl: './update-student.component.css'
})
export class UpdateStudentComponent {

  constructor(private studentService:StudentService,private router:Router,private route:ActivatedRoute){}

  id:number=0;
  student:Student=new Student();
  isStudentUpdated=false;


  ngOnInit()
  {
    this.id=this.route.snapshot.params['id'];
    this.studentService.getStudentById(this.id).subscribe((data)=>{
      this.student=data;
    })
  }

  updateStudent()
  {
    this.studentService.updateStudent(this.student,this.id).subscribe((data)=>{

      this.isStudentUpdated=true;
      setTimeout(() => {
        this.router.navigate(['student-list']);
      }, 2000);
        
      
    })
  }
  onSubmit()
  {
    this.updateStudent();
  }
}
