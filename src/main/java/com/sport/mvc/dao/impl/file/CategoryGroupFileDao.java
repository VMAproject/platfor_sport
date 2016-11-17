package com.sport.mvc.dao.impl.file;

import com.sport.mvc.dao.CategoryGroupDao;
import com.sport.mvc.models.CategoryGroup;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "categoryGroupFileDao")
public class CategoryGroupFileDao extends FileAbstractDao<CategoryGroup> implements CategoryGroupDao {

    public CategoryGroupFileDao() {
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

    @Override
    public List<CategoryGroup> getAll() {
        return null;
    }

    @Override
    public CategoryGroup getById(Long id) {
        return null;
    }


}
