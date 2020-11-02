package com.jsfhibernate.dao.impl;

import com.jsfhibernate.dao.DepartmentDAO;
import com.jsfhibernate.entity.Department;
import com.jsfhibernate.pojo.Student;
import com.jsfhibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.enterprise.inject.Default;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
@DAO
@Default
public class DepartmentDAOImpl implements DepartmentDAO {

    private static Transaction transObj;
    private static final Session sessionObj = HibernateUtil.getSessionFactory().openSession();


    @Override
    public void save(Department department) {
        try {
            transObj = sessionObj.beginTransaction();
            sessionObj.save(department);
            System.out.println("department Record With Id: " + department.getId() + " Is Successfully Created In Database");

            // XHTML Response Text
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("createdDepartmentId", department.getId());
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        } finally {
            transObj.commit();
        }
    }

    @Override
    public void delete(Long idDepart) {
        try {
            transObj = sessionObj.beginTransaction();
            Department department = (Department) sessionObj.load(Department.class, idDepart);
            sessionObj.delete(idDepart);
            System.out.println("Department Record With Id: " + idDepart + " Is Successfully Deleted From Database");
            // XHTML Response Text
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("deletedDepartmentId", idDepart);
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        } finally {
            transObj.commit();
        }
    }

    @Override
    public Department findOne(Long idDepart) {
        Department department = new Department();
        List<Department> departmentList = new ArrayList<>();
        try {
            transObj = sessionObj.beginTransaction();
            Query queryObj = sessionObj.createQuery("from Department where id= :department_id").setLong("department_id", idDepart);
            department = (Department)queryObj.uniqueResult();
            System.out.println("Department Record With Id: " + idDepart + " Is Fetched Successfully From Database");
            // XHTML Response Text
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("findDepartmentById",  idDepart);
        } catch(Exception exceptionObj) {
            exceptionObj.printStackTrace();
        } finally {
            transObj.commit();
        }
        return department;
    }


    @Override
    public List<Department> findAll() {
        Department department;
        List<Department> departmentList = new ArrayList<>();
        try {
            transObj = sessionObj.beginTransaction();
            Query queryObj = sessionObj.createQuery("from Department");
            departmentList = queryObj.list();
            for(Department dep : departmentList) {
                department = new Department();
                department.setId(dep.getId());
                department.setCity(dep.getCity());
                department.setName(dep.getName());
                department.setMinSalary(dep.getMinSalary());
                department.setMaxSalary(dep.getMaxSalary());
            }
            System.out.println("All The Departments Records Are Fetched Successfully From Database");

            // XHTML Response Text
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("findDepartmentById", "true");
        } catch(Exception exceptionObj) {
            exceptionObj.printStackTrace();
        } finally {
            transObj.commit();
        }
        return departmentList;
    }

    @Override
    public void update(Department department) {
        try {
            transObj = sessionObj.beginTransaction();
            sessionObj.update(department);
            System.out.println("Department Record With Id: " + department.getId() + " Is Successfully Updated In Database");

            // XHTML Response Text
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("updatedDepartmentRecord",  "Success");
        } catch(Exception exceptionObj){
            exceptionObj.printStackTrace();
        } finally {
            transObj.commit();
        }
    }
}
