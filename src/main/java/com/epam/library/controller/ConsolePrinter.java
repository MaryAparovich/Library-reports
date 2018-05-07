package com.epam.library.controller;

import java.util.List;

import com.epam.library.bean.Book;
import com.epam.library.bean.Employee;
import com.epam.library.bean.Entity;
import com.epam.library.bean.Report;

public class ConsolePrinter {

	public void prinInfo(String message) {
		System.out.println(message);
	}
	
	public void printInfo(List<Book> listBooks, List<Employee> listEmployee) {

		System.out.println("1. Report on the books");
		System.out.println("____________________________________________________________________________ ");
		System.out.println("№\t" + "Title\t\t" + "Genre\t\t" + "Date of publishing\t" + "Author\t");
		System.out.println("____________________________________________________________________________ ");
		for (Book book : listBooks) {
			System.out.println(book.getId() + ". \t" + book.getTitle() + "\t\t" + book.getGenre() + "\t\t"
					+ book.getDateOfPublishing() + "\t\t" + book.getAuthor() + "\t");
			System.out.println(" --------------------------------------------------------------------------- ");

		}
		System.out.println("\n2. Report on the employees ");
		System.out.println("______________________________________________________________ ");
		System.out.println("№\t" + "Name\t\t" + "Email\t\t\t" + "Date of birth\t\t");
		System.out.println("______________________________________________________________ ");
		for (Employee employee : listEmployee) {
			System.out.println(employee.getId() + ". \t" + employee.getName() + "\t\t" + employee.getEmail() + "\t\t"
					+ employee.getDateOfBirth() + "\t\t");
			System.out.println(" -------------------------------------------------------------");
		}
	}

	public void printReportOne(List<Report> listReport) {
		System.out.println("\n");
		System.out.println("3. Report on the employees who have read more than 2 book:");
		System.out.println(" _______________________________________ ");
		System.out.println("\tName\t\t  Sum of books\t");
		System.out.println(" _______________________________________ ");
		for (Report report : listReport) {
			System.out.println("\t" + report.getName() + "\t\t\t" + report.getSumBooks() + "\t");
			System.out.println(" --------------------------------------- ");
		}
	}

	public void printReportTwo(List<Report> listReport) {
		System.out.println("\n");
		System.out.println("4. Report on the employees who have read less than or equal to 5 books:");
		System.out.println(" _______________________________________________________ ");

		System.out.println("\t" + "Name \t\t" + "Date of birth\t" + "   Sum of books\t\t");
		System.out.println(" _______________________________________________________ ");
		for (Report report : listReport) {
			System.out.println(
					"\t" + report.getName() + "\t\t" + report.getDateOfBirth() + "\t\t" + report.getSumBooks() + "\t");
			System.out.println(" ------------------------------------------------------- ");
		}
	}

	public void printEntityList(List<? extends Entity> entities) {
		for (Entity entity : entities) {
			System.out.println(entity);
		}
	}

	public void printOperations() {
		System.out.println("\n 1. Добавить книгу");
		System.out.println(" 2. Добавить читателя");
		System.out.println(" 3. Удалить книгу");
		System.out.println(" 4. Удалить читателя");
		System.out.println(" 5. Изменить информацию о книге");
		System.out.println(" 6. Изменить информацию о читателе");
		System.out.println(" 7. Найти книгу по названию");
		System.out.println(" 8. Найти читателя по имени");
	}
}
