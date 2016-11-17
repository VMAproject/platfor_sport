package com.sport.mvc.services;

import com.sport.mvc.models.CategoryGroup;

import java.util.List;


public interface CategoryGroupService {

    List<CategoryGroup> getAll();

    void addCategoryGroup(CategoryGroup categoryGroup);

    void deleteListOfCategoryGroup(Long id);

    CategoryGroup getCategoryGroup(long theId);

    void updateCategoryGroup(CategoryGroup categoryGroup);


}
