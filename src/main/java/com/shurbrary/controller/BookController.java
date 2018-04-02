package com.shurbrary.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shurbrary.model.Book;
import com.shurbrary.repository.BookRepository;

@RestController
@RequestMapping("api/v1/")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public List<Book> list() {
        return bookRepository.findAll();
    }

    @RequestMapping(value = "books", method = RequestMethod.POST)
    public Book create(@RequestBody Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @RequestMapping(value = "books/{id}", method = RequestMethod.GET)
    public Book get(@PathVariable Long id) {
        return bookRepository.getOne(id);
    }

    @RequestMapping(value = "books/{id}", method = RequestMethod.PUT)
    public Book update(@PathVariable Long id, @RequestBody Book book) {
        Book existingBook = bookRepository.getOne(id);
        BeanUtils.copyProperties(book, existingBook);
        return bookRepository.saveAndFlush(existingBook);
    }

    @RequestMapping(value = "books/{id}", method = RequestMethod.DELETE)
    public Book delete(@PathVariable Long id) {
        Book existingBook = bookRepository.getOne(id);
        bookRepository.delete(existingBook);
        return existingBook;
    }
}
