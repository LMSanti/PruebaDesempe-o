package com.aarfee.persistence.crud;

import java.util.ArrayList;

public interface ReadAllModel<Entity> {
    public ArrayList<Entity> readAll();
}
