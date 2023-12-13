package com.engima.bookstore.controller;

import com.engima.bookstore.entity.Book;
import com.engima.bookstore.service.BookService;
import com.engima.bookstore.utils.PageResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public Book add(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/search")
    public List<Book> searchByTitle(@RequestParam(name = "title") String title) {
        return bookService.searchBookTitle(title);
    }

    @GetMapping("/year")
    public List<Book> getByYear(){
        return bookService.getBookByYear();
    }

//    @GetMapping
//    public List<Book> getAll() {
//        return bookService.getAllBook();
//    }

    @GetMapping
    public PageResponseWrapper<Book> getPerPage(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                @RequestParam(name = "size", defaultValue = "3") Integer size,
                                                @RequestParam(name = "sortBy", defaultValue = "title") String sortBy,
                                                @RequestParam(name = "direction", defaultValue = "ASC") String direction) {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Book> bookPage = bookService.getBookPerPage(pageable);
        return new PageResponseWrapper<>(bookPage);
    }

    @PutMapping
    public Book update(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping
    public void delete(@RequestParam String id) {
        bookService.deleteBook(id);
    }

}
