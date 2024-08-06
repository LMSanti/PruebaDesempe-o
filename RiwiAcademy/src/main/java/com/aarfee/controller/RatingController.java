package com.aarfee.controller;

import com.aarfee.entities.RatingEntity;
import com.aarfee.models.RatingModel;
import com.aarfee.persistence.imodel.IRatingModel;

import java.util.ArrayList;

public class RatingController {
    IRatingModel ratingModel = new RatingModel();

    public RatingEntity create(RatingEntity request){
        return this.ratingModel.create(request);
    }
    public RatingEntity readByid(int id){
        return this.ratingModel.readById(id);
    }
    public ArrayList<RatingEntity> readAll(){
        return this.ratingModel.readAll();
    }
    public RatingEntity upDate(Object object, int id){
        return this.ratingModel.upDate(object, id);
    }
}
