package com.dotin.dotintasktwo.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "category_element")
@Data
public class CategoryElement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_element_id", nullable = false)
    private int categoryElementId;


    @Column(name = "english_name")
    private String englishTypeName;

    @Column(name = "persian_name")
    private String persianTypeName;

    @NotBlank(message = "is required")
    @Column(name = "staff_id")
    private String staffId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "employeeRole", cascade = CascadeType.ALL)
    private List<Employee> employees;

    @OneToMany(mappedBy = "leaveType", cascade = CascadeType.ALL)
    private List<Leave> leaveType;

    @OneToMany(mappedBy = "leaveStatus", cascade = CascadeType.ALL)
    private List<Leave> leaveStatus;


    public CategoryElement(String englishTypeName, String persianTypeName, @NotBlank(message = "is required") String staffId, Category category, List<Employee> employees, List<Leave> leaveType, List<Leave> leaveStatus) {
        this.englishTypeName = englishTypeName;
        this.persianTypeName = persianTypeName;
        this.staffId = staffId;
        this.category = category;
        this.employees = employees;
        this.leaveType = leaveType;
        this.leaveStatus = leaveStatus;
    }

    public CategoryElement(int categoryElementId, String englishTypeName, String persianTypeName, @NotBlank(message = "is required") String staffId, Category category, List<Employee> employees, List<Leave> leaveType) {
        this.categoryElementId = categoryElementId;
        this.englishTypeName = englishTypeName;
        this.persianTypeName = persianTypeName;
        this.staffId = staffId;
        this.category = category;
        this.employees = employees;
        this.leaveType = leaveType;
    }
}
