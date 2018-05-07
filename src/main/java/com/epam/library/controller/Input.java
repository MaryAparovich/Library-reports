package com.epam.library.controller;

import java.util.Scanner;

import com.epam.library.bean.Book;
import com.epam.library.bean.Employee;
import com.epam.library.dao.BookDao;
import com.epam.library.dao.EmployeeDao;
import com.epam.library.dao.impl.BookDaoDBImpl;
import com.epam.library.dao.impl.EmployeeDaoDBImpl;

public class Input {

	public static Scanner scanner = new Scanner(System.in);
	
	public static String getString(String message) {
		System.out.println(message);
		return scanner.next(); 
	}
	
	public static int getInt(String message) {
		System.out.println(message);
		return scanner.nextInt();
	}
}
