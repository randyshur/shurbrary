package com.shurbrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shurbrary.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}

