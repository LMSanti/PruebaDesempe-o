package com.aarfee.persistence.crud;

public interface ReadModel <Entity>{
    public Entity readById(int id);

}
