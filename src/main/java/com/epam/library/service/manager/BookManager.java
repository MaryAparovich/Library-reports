package com.epam.library.service.manager;

import java.util.List;

import com.epam.library.bean.Book;
import com.epam.library.controller.Input;
import com.epam.library.dao.BookDao;

public class BookManager {
	
	private BookDao bookDao;

	public BookManager(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public Book insertBook() {

		Book book = new Book();

		System.out.println("\nДобавление новой книги");

		String title = Input.getString("Введите название:");
		book.setTitle(title);

		String author = Input.getString("\nВведите автора:");
		book.setAuthor(author);

		String genre = Input.getString("\nВведите описание:");
		book.setGenre(genre);

		String dateOfPublishing = Input.getString("\nВведите дату публикации:");
		book.setDateOfPublishing(dateOfPublishing);
		
		bookDao.create(book);

		return book;
	}

	public int deleteBook() {

		System.out.println("\nУдаление книги");

		int id = Input.getInt("Введите id:");
		bookDao.delete(id);
		return id;
	}

	public Book bookUpdate() {

		Book book = new Book();
		System.out.println("\nИзменение книги");

		int id = Input.getInt("Введите id той книги, информацию которой хотите изменить:");
		book.setId(id);

		String title = Input.getString("Введите название:");
		book.setTitle(title);

		String author = Input.getString("\nВведите автора:");
		book.setAuthor(author);

		String genre = Input.getString("\nВведите описание:");
		book.setGenre(genre);

		String dateOfPublishing = Input.getString("\nВведите дату публикации:");
		book.setDateOfPublishing(dateOfPublishing);

		bookDao.update(book);
		return book;
	}

	public List<Book> getBooksByTitle() {
		String title = Input.getString("\nВведите название книги:");
		return bookDao.readByTitle(title);
	}
}
