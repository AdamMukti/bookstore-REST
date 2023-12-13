package com.engima.bookstore.service;

import com.engima.bookstore.entity.Book;
import com.engima.bookstore.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class BookServiceImplTest {

    @MockBean
    BookRepository bookRepository;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    BookService bookService;

    @Test
    void addBook() {
        Book book = new Book("A001", "Sangkuriang", "Description", "Indonesia", "Publisher", 2020, 200, 10, 50000);
        bookService.addBook(book);
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void getBookById() {
        when(bookRepository.findById("A001")).thenReturn(
                java.util.Optional.of(
                        new Book("A001", "Sangkuriang", "Description", "Indonesia", "Publisher", 2020, 200, 10, 50000)
                )
        );
        Book book = bookService.getBookById("A001");
        assertEquals("Sangkuriang", book.getTitle());
        assertEquals("Indonesia", book.getLanguage());
    }

    @Test
    List<Book> getAllBook() {
        List<Book> books = new ArrayList<Book>();

        Book book = new Book("A001", "Sangkuriang", "Description", "Indonesia", "Publisher", 2020, 200, 10, 50000);
        Book book1 = new Book("A002", "Sangkuriang", "Description", "Indonesia", "Publisher", 2020, 200, 10, 50000);
        Book book2 = new Book("A003", "Sangkuriang", "Description", "Indonesia", "Publisher", 2020, 200, 10, 50000);

        books.add(book);
        books.add(book1);
        books.add(book2);

        when(bookRepository.findAll()).thenReturn(books);

        List<Book> bookList = bookService.getAllBook();
        assertEquals(3, bookList.size());
        verify(bookRepository, times(1)).findAll();
        return books;
    }

    @Test
    void updateBook() {
    }

    @Test
    void deleteBook() {
    }

    @Test
    void getBookPerPage() {
    }

    @Test
    void searchBookTitle() {
    }

    @Test
    void getBookByYear() {
    }
}