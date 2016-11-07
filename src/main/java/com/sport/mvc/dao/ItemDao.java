package com.sport.mvc.dao;

import com.sport.mvc.models.Model;



import java.util.List;

public interface ItemDao <T extends Model> {

    List<T> getAll();

    T getById(Long id);

    void add(T model);

    void update(T model);

    void remove(T Model);



}
