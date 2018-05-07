package com.epam.library.service;

import java.util.List;

import com.epam.library.bean.Entity;
import com.epam.library.bean.Report;

public interface LibraryService {
	public List<Report> getReportMoreThanTwoBooks();
	public List<Report> getReportLassThanFiveBooks();

}
