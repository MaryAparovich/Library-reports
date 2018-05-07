package com.epam.library.bean;

public class Report {
	private String name;
	private int sumBooks;
	private String dateOfBirth;
	
	public Report() {
		super();
	}

	public Report(String name, int sumBooks, String dateOfBirth) {
		this.name = name;
		this.sumBooks = sumBooks;
		this.dateOfBirth = dateOfBirth;
	}
	
	public Report(String name, int sumBooks) {
		this.name = name;
		this.sumBooks = sumBooks;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSumBooks() {
		return sumBooks;
	}
	public void setSumBooks(int sumBooks) {
		this.sumBooks = sumBooks;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
