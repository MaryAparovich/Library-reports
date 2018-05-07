package com.epam.library.bean;

public class Book extends Entity {

	private String title;
	private String genre;
	private String dateOfPublishing;
	private String author;

	public Book() {
		super();
	}

	public Book(int id, String title, String genre, String dateOfPublishing, String author) {
		super(id);
		this.title = title;
		this.genre = genre;
		this.dateOfPublishing = dateOfPublishing;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getDateOfPublishing() {
		return dateOfPublishing;
	}

	public void setDateOfPublishing(String dateOfPublishing) {
		this.dateOfPublishing = dateOfPublishing;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((dateOfPublishing == null) ? 0 : dateOfPublishing.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (super.id != other.id) {
			return false;
		} else if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (dateOfPublishing == null) {
			if (other.dateOfPublishing != null)
				return false;
		} else if (!dateOfPublishing.equals(other.dateOfPublishing))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id + ". " + "Название = " + title + ", Жанр = " + genre + ", Дата публикации = " + dateOfPublishing
				+ ", author = " + author + " ";
	}

}
