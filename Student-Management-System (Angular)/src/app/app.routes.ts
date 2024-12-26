import { Routes } from '@angular/router';
import { StudentListComponent } from './components/student-list/student-list.component';
import { AddStudentComponent } from './components/add-student/add-student.component';
import { UpdateStudentComponent } from './components/update-student/update-student.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';

export const routes: Routes = [
    {
        path:"student-list",component:StudentListComponent
    },
    {
        path:"add-student",component:AddStudentComponent
    },
    {
        path:"update-student/:id",component:UpdateStudentComponent
    },
    {
        path:"",component:StudentListComponent,pathMatch:'full'
    },
    {
        path:"**",component:PageNotFoundComponent
    }
];
