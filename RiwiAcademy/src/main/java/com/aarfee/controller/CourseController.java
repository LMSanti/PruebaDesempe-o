package com.aarfee.controller;

import com.aarfee.entities.CourseEntity;
import com.aarfee.models.CourseModel;
import com.aarfee.persistence.imodel.ICourserModel;

import java.util.ArrayList;

public class CourseController {
    ICourserModel courserModel = new CourseModel();

    public CourseEntity create(CourseEntity request){
        return this.courserModel.create(request);
    }
    public CourseEntity readById(int id){
        return this.courserModel.readById(id);
    }
    public ArrayList<CourseEntity> readAll(){
        return this.courserModel.readAll();
    }
    public Boolean delete(int id){
        return this.courserModel.delete(id);
    }
    public CourseEntity upDate(Object object, int id){
        return this.courserModel.upDate(object, id);
    }

}
