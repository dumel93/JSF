package com.jsfhibernate.dao;

import com.jsfhibernate.entity.Department;
import com.jsfhibernate.pojo.Student;

import java.util.List;

public interface DepartmentDAO {

    void delete(Long idDepart);

    Department  findOne(Long idDepart);

    void save(Department department);

    List<Department> findAll();

    void update(Department department);
}
