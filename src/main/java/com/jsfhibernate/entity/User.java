package com.jsfhibernate.entity;


import lombok.Data;

import javax.management.relation.Role;
import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true)
    private String email;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Phone> phones;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column
    @Min(value = 0)
    private BigDecimal salary;

    @Column(name = "created_date", columnDefinition = "DATE")
    private LocalDate dateOfEmployment = LocalDate.now();


}