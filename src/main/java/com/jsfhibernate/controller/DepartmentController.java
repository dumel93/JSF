package com.jsfhibernate.controller;

import com.jsfhibernate.entity.Department;
import com.jsfhibernate.service.DepartmentService;
import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

@SessionScoped
@Data
@ManagedBean
public class DepartmentController implements Serializable {


    private String id;
    private String name;
    private String city;
    private BigDecimal minSalary;
    private BigDecimal maxSalary;
    private Department department;

    @Inject
    private  DepartmentService departmentService;

    public Department createDepartment() {
        Department department = new Department();
        department.setName(name);
        department.setCity(city);
        department.setMinSalary(minSalary);
        department.setMaxSalary(maxSalary);
        departmentService.createDepartment(department);
        return department;
    }


    public Department updateDepartment() {
        Department department1= departmentService.findDepartment(Long.valueOf(id));
        department.setId(department.getId());
        department.setId(department.getId());
        department.setId(department.getId());
        department.setId(department.getId());
        departmentService.updateDepartment(department);
        return department;
    }


    public Department findDepartment() {

        department = departmentService.findDepartment(Long.valueOf(id));
        return department;

    }

    public void deleteDepartment() {
        departmentService.deleteDepartment(Long.valueOf(id));
    }


    public List<Department> findAllDepartments() {
        return departmentService.findAllDepartments();
    }

}
