package com.dotin.dotintasktwo.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_category_element")
@Getter
@Setter
public class CategoryElement extends Parent {


    @Column(name = "c_english_name")
    private String englishTypeName;

    @Column(name = "c_persian_name")
    private String persianTypeName;

    @NotBlank(message = "is required")
    @Column(name = "c_staff_id")
    private int staffId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_category_id")
    private Category category;


}
