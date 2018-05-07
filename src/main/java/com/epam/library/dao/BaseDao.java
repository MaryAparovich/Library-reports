package com.epam.library.dao;

import java.util.List;

import com.epam.library.bean.Entity;

public interface BaseDao<T extends Entity> {

	public void create(T entity);
	public List<T> readAll();
	public void delete(int id);
	public void update(T entity);
}
