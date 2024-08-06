package com.aarfee.persistence.crud;

public interface ReadEmailModel <Entity>{
    public Entity readByEmail(String email);

}
