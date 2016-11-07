package com.sport.mvc.services.impl;

import com.sport.mvc.dao.CategoryGroupDao;
import com.sport.mvc.dao.GroupDao;
import com.sport.mvc.models.CategoryGroup;
import com.sport.mvc.services.CategoryGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bjj on 29.10.2016.
 */
@Service(value = "categoryGroupService")
public class CategoryGroupServiceImpl implements CategoryGroupService {


    @Qualifier("categoryGroupDatabaseDao")
    @Autowired
    private CategoryGroupDao categoryDao;

    public CategoryGroupServiceImpl() {
    }

    @Transactional
    @Override
    public List<CategoryGroup> getAll() {
        return categoryDao.getAll();
    }

    @Transactional
    @Override
    public void addCategoryGroup(CategoryGroup categoryGroup) {
        categoryDao.add(categoryGroup);
    }
    @Transactional
    @Override
    public void deleteListOfCategoryGroup(Long id) {
        categoryDao.remove(categoryDao.getById(id));

    }
    @Transactional
    @Override
    public CategoryGroup getCategoryGroup(long theId) {
        return categoryDao.getById(theId);
    }

    @Transactional
    @Override
    public void updateCategoryGroup(CategoryGroup categoryGroup) {
        categoryDao.update(categoryGroup);
    }
}
