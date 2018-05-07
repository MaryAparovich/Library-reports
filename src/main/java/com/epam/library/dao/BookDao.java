package com.epam.library.dao;

import java.util.List;

import com.epam.library.bean.Book;

public interface BookDao extends BaseDao<Book>{

	List<Book> readByTitle(String title);
}
