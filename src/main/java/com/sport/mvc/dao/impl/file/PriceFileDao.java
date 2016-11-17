package com.sport.mvc.dao.impl.file;

import com.sport.mvc.dao.PriceDao;
import com.sport.mvc.models.Price;

import java.util.List;

public class PriceFileDao extends FileAbstractDao<Price> implements PriceDao {

    public PriceFileDao() {
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

    @Override
    public List<Price> getAll() {
        return null;
    }

    @Override
    public Price getById(Long id) {
        return null;
    }
}
