package com.jsfhibernate.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String city;

    @Column(name = "min_salary")
    @Min(value = 0,message = "must be a positive number")
    private BigDecimal minSalary;

    @Column(name = "max_salary")
    @Min(value = 0,message = "must be a positive number")
    private BigDecimal maxSalary;


}