package com.dotin.dotintasktwo.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@Data
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private int categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<CategoryElement> categoryElements;

    public Category(List<CategoryElement> categoryElements) {
        this.categoryElements=categoryElements;
    }


    public Category(String categoryName, List<CategoryElement> categoryElements) {
        this.categoryName = categoryName;
        this.categoryElements = categoryElements;
    }

    public Category(int categoryId, String categoryName, List<CategoryElement> categoryElements) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryElements = categoryElements;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryElements=" + categoryElements +
                '}';
    }

}
