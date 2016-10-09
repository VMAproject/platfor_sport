package com.sport.mvc.dao.impl;


import com.sport.mvc.dao.accessors.FileDataSourceAccessor;
import com.sport.mvc.models.Model;

public abstract class FileAbstractDao<T extends Model> extends FileDataSourceAccessor {

    public void remove(T model) {

    }

    public void add(T model) {

    }

    public void update(T model) {

    }

}
