package com.dotin.dotintasktwo.service;


import com.dotin.dotintasktwo.entity.CategoryElement;

import java.util.List;

public interface CategoryElementService {

    List<CategoryElement> findAll();

    CategoryElement findById(int Id);

    void save(CategoryElement categoryElement);

    void deleteById(int Id);
}
