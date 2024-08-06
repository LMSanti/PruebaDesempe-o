package com.aarfee.controller;

import com.aarfee.entities.StudentEntity;
import com.aarfee.models.StudentModel;
import com.aarfee.persistence.imodel.IStudentModel;

import java.util.ArrayList;

public class StudentController {
    IStudentModel studentModel = new StudentModel();

    public StudentEntity create(StudentEntity request){
        return this.studentModel.create(request);
    }
    public StudentEntity readById(int id){
        return this.studentModel.readById(id);
    }
    public StudentEntity readByEmail(String email){
        return this.studentModel.readByEmail(email);
    }
    public ArrayList<StudentEntity> readAll(){
        return this.studentModel.readAll();
    }
    public StudentEntity upDate(Object object, int id){
        return this.studentModel.upDate(object, id);
    }
}
