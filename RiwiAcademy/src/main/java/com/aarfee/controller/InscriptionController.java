package com.aarfee.controller;

import com.aarfee.entities.InscriptionEntity;
import com.aarfee.models.InscriptionModel;
import com.aarfee.persistence.imodel.IInscriptionModel;

import java.util.ArrayList;

public class InscriptionController {
    IInscriptionModel inscriptionModel = new InscriptionModel();

    public InscriptionEntity create(InscriptionEntity request){
        return this.inscriptionModel.create(request);
    }

    public InscriptionEntity readById(int id){
        return this.inscriptionModel.readById(id);
    }

    public ArrayList<InscriptionEntity> readAll(){
        return this.inscriptionModel.readAll();
    }

    public InscriptionEntity upDate(Object object, int id){
        return this.inscriptionModel.upDate(object, id);
    }

    public Boolean delete(int id){
        return this.inscriptionModel.delete(id);
    }
}
