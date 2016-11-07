package com.sport.mvc.dao.accessors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;

public abstract class FileDataSourceAccessor {

    public BufferedReader load() throws FileNotFoundException{
        File file = new File(this.getDataSourceName());
        return new BufferedReader(new FileReader(file));
    }

    public abstract String getDataSourceName();
}
