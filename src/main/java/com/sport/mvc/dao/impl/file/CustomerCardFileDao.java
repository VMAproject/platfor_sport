package com.sport.mvc.dao.impl.file;

import com.sport.mvc.dao.CustomerCardDao;
import com.sport.mvc.models.CustomerCard;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "customerCardFileDao")
public class CustomerCardFileDao extends FileAbstractDao<CustomerCard> implements CustomerCardDao {

    public CustomerCardFileDao() {
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

    @Override
    public List<CustomerCard> getAll() {
        return null;
    }

    @Override
    public CustomerCard getById(Long id) {
        return null;
    }


}
