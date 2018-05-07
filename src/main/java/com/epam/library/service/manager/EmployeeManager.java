package com.epam.library.service.manager;

import java.util.List;

import com.epam.library.bean.Employee;
import com.epam.library.controller.Input;
import com.epam.library.dao.EmployeeDao;

public class EmployeeManager {
	
	private EmployeeDao employeeDao;
	
	public EmployeeManager(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public Employee insertEmployee() {

		Employee employee = new Employee();

		System.out.println("\nДобавление нового читателя");

		String name = Input.getString("Введите имя:");
		employee.setName(name);

		String email = Input.getString("\nВведите email:");
		employee.setEmail(email);

		String dateOfBirth = Input.getString("\nВведите дату рождения:");
		employee.setDateOfBirth(dateOfBirth);

		employeeDao.create(employee);
		return employee;
	}

	public int deleteEmployee() {

		System.out.println("\nУдаление читателя");

		int id = Input.getInt("Введите id:");

		employeeDao.delete(id);
		
		return id;
	}

	public Employee employeeUpdate() {

		Employee employee = new Employee();
		System.out.println("\nИзменение книги");

		int id = Input.getInt("Введите id того читателя, информацию которого хотите изменить:");
		employee.setId(id);

		String name = Input.getString("Введите имя:");
		employee.setName(name);

		String dateOfBirth = Input.getString("\nВведите дату рождения:");
		employee.setDateOfBirth(dateOfBirth);

		String email = Input.getString("\nВведите email:");
		employee.setEmail(email);

		employeeDao.update(employee);
		
		return employee;
	}

	public List<Employee> getEmployeesByName() {
		String name = Input.getString("\nВведите имя читателя:");
		return employeeDao.readByName(name);
	}
}
