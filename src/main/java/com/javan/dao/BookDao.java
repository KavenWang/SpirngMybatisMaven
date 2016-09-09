package com.javan.dao;

import com.javan.entity.Book;

public interface BookDao {
	 /**
     * 通过ID查询单本图书
     * 
     * @param id
     * @return
     */
    Book queryById(long id);
}
