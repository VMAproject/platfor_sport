package com.sport.mvc.dao.accessors;

import javax.activation.DataSource;

public abstract class DatabaseDataSourceAccessor {

    public DataSource load() {
        return null;
    }

    public abstract String getHost();

    public abstract int getPort();
}
