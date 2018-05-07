package com.epam.library.controller;

import java.util.List;

import com.epam.library.bean.Book;
import com.epam.library.bean.Employee;
import com.epam.library.bean.Report;
import com.epam.library.dao.BookDao;
import com.epam.library.dao.EmployeeDao;
import com.epam.library.dao.impl.BookDaoDBImpl;
import com.epam.library.dao.impl.EmployeeDaoDBImpl;
import com.epam.library.service.LibraryService;
import com.epam.library.service.impl.LibraryServiceImpl;
import com.epam.library.service.manager.ProgramManager;

public class MainApp {

	public static void main(String[] args) {
		
		ProgramManager programManager = new ProgramManager();
		BookDao bookDao = new BookDaoDBImpl();
		EmployeeDao employeeDao = new EmployeeDaoDBImpl();
		LibraryService service = new LibraryServiceImpl();
		ConsolePrinter consolePrinter = new ConsolePrinter();

		List<Book> listBooks = bookDao.readAll();
		List<Employee> listEmployee = employeeDao.readAll();
		List<Report> listReportOne = service.getReportMoreThanTwoBooks();
		List<Report> listReportTwo = service.getReportLassThanFiveBooks();

		consolePrinter.printInfo(listBooks, listEmployee);
		consolePrinter.printReportOne(listReportOne);
		consolePrinter.printReportTwo(listReportTwo);
		consolePrinter.printOperations();

		programManager.choiceOfOperation(consolePrinter);
	}
}
