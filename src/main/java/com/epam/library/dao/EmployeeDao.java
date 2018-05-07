package com.epam.library.dao;

import java.util.List;

import com.epam.library.bean.Employee;

public interface EmployeeDao extends BaseDao<Employee>  {

	List<Employee> readByName(String name);
}
