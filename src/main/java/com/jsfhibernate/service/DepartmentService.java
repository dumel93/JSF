package com.jsfhibernate.service;


import com.jsfhibernate.entity.Department;
import com.jsfhibernate.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface DepartmentService {

    Department createDepartment(Department department);

    Department updateDepartment(Department department);

    Department findDepartment(Long id);

    void deleteDepartment(Long idDepart);

    List<Department> findAllDepartments();



}
