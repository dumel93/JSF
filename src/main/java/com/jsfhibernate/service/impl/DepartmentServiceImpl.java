package com.jsfhibernate.service.impl;

import com.jsfhibernate.dao.DepartmentDAO;
import com.jsfhibernate.entity.Department;
import com.jsfhibernate.entity.User;
import com.jsfhibernate.service.DepartmentService;
import lombok.AllArgsConstructor;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import com.jsfhibernate.stereotypes.Service;
import javax.transaction.Transactional;

import java.util.List;


@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDAO departmentDAO;


    public Department createDepartment(Department department) {
        departmentDAO.save(department);
        return department;
    }

    @Override
    public Department updateDepartment(Department department) {

        department.setId(department.getId());
        departmentDAO.update(department);
        return department;
    }

    @Override
    public Department findDepartment(Long idDepart) {

        return departmentDAO.findOne(idDepart);

    }

    @Override
    public void deleteDepartment(Long idDepart) {
        departmentDAO.delete(idDepart);
    }


    @Override
    public List<Department> findAllDepartments() {
        return departmentDAO.findAll();
    }







}