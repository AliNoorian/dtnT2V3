package com.dotin.dotintasktwo.dao;


import com.dotin.dotintasktwo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
