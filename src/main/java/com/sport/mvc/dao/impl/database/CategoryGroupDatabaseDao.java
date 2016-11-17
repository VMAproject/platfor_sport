package com.sport.mvc.dao.impl.database;

import com.sport.mvc.dao.CategoryGroupDao;
import com.sport.mvc.models.CategoryGroup;
import org.springframework.stereotype.Repository;

@Repository(value = "categoryGroupDatabaseDao")
public class CategoryGroupDatabaseDao extends HibernateAbstractDao<CategoryGroup> implements CategoryGroupDao {

    public CategoryGroupDatabaseDao() {
    }

}
