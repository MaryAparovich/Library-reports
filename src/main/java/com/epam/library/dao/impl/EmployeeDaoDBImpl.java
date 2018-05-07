package com.epam.library.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.library.bean.Employee;
import com.epam.library.dao.EmployeeDao;
import com.epam.library.dao.impl.util.DBConnectionHelper;

public class EmployeeDaoDBImpl implements EmployeeDao {
	private static final String SQL_SELECT_EMPLOYEE = "select *from employees";

	public void create(Employee employee) {

		Connection connection = DBConnectionHelper.connect();

		try {
			Statement st = connection.createStatement();
			st.executeUpdate("INSERT INTO employees (name, email, date_of_birth ) values (" + "'" + employee.getName()
					+ "', " + "'" + employee.getEmail() + "', " + "'" + employee.getDateOfBirth() + "')");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Employee> readByName(String name) {

		List<Employee> listEmployee = new ArrayList<>();

		Connection connection = DBConnectionHelper.connect();

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select *from employees where name =" + "'" + name + "'");

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setEmail(rs.getString("email"));
				employee.setDateOfBirth(rs.getString("date_of_birth"));
				listEmployee.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEmployee;
	}

	public List<Employee> readAll() {

		List<Employee> listEmployee = new ArrayList<>();

		Connection connection = DBConnectionHelper.connect();

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_EMPLOYEE);

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setEmail(rs.getString("email"));
				employee.setDateOfBirth(rs.getString("date_of_birth"));
				listEmployee.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBConnectionHelper.disconnect(connection);
		return listEmployee;
	}

	public void delete(int id) {

		Connection connection = DBConnectionHelper.connect();

		try {
			Statement st = connection.createStatement();
			st.executeUpdate("DELETE FROM employees WHERE id = " + "'" + id + "'");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Employee employee) {
		Connection connection = DBConnectionHelper.connect();

		try {
			Statement st = connection.createStatement();
			st.executeUpdate("UPDATE employees SET name = " + "'" + employee.getName() + "', " + "date_of_birth = " + "'"
					+ employee.getDateOfBirth() + "'," + "email = " + "'" + employee.getEmail() + "' " + "WHERE ID = " + employee.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
