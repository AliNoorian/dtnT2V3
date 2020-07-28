package com.dotin.dotintasktwo.service;


import com.dotin.dotintasktwo.entity.Category;

import java.util.List;

public interface CategoryService {

     List<Category> findAll();

     Category findById(int Id);

     void save(Category category);

     void deleteById(int Id);
}
