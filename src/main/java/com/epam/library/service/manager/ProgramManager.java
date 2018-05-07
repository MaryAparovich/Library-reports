package com.epam.library.service.manager;

import java.util.List;

import com.epam.library.bean.Book;
import com.epam.library.bean.Employee;
import com.epam.library.controller.ConsolePrinter;
import com.epam.library.controller.Input;
import com.epam.library.dao.impl.BookDaoDBImpl;
import com.epam.library.dao.impl.EmployeeDaoDBImpl;

public class ProgramManager {

	public void choiceOfOperation(ConsolePrinter consolePrinter) {
		
		BookManager bookManager = new BookManager(new BookDaoDBImpl());
		EmployeeManager employeeManager = new EmployeeManager(new EmployeeDaoDBImpl());
		
		do {
			int id = Input.getInt("\nВведите номер операции:");
			if (id == 1) {
				bookManager.insertBook();
			} else if (id == 2) {
				employeeManager.insertEmployee();
			} else if (id == 3) {
				bookManager.deleteBook();
			} else if (id == 4) {
				employeeManager.deleteEmployee();
			} else if (id == 5) {
				bookManager.bookUpdate();
			} else if (id == 6) {
				employeeManager.employeeUpdate();
			} else if (id == 7) {
				List<Book> listBooks = bookManager.getBooksByTitle();
				consolePrinter.printEntityList(listBooks);
			} else if (id == 8) {
				List<Employee> listEmployee = employeeManager.getEmployeesByName();
				consolePrinter.printEntityList(listEmployee);
			} else {
				consolePrinter.prinInfo("Операции не существует! Выберите номер из данного списка.");
				choiceOfOperation(consolePrinter);
			}
		} while (askAboutContinuation(consolePrinter));
	}

	public boolean askAboutContinuation(ConsolePrinter consolePrinter) {

		String answer = Input.getString("\nПродолжить? (да/нет)");
		if (answer.equals("да")) {
			return true;
		} else if (answer.equals("нет")) {
			return false;
		} else {
			consolePrinter.prinInfo("Неверный ввод!");
			return askAboutContinuation(consolePrinter);
		}
	}
}
