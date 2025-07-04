package com.example.bookstore.service;

import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    BookRepository bookRepo = Mockito.mock(BookRepository.class);
    BookService service = new BookService(bookRepo);

    @Test
    void testUpdateStockSuccess() {
        Book book = new Book();
        book.setId(1L);
        book.setStock(10);

        when(bookRepo.findById(1L)).thenReturn(Optional.of(book));
        when(bookRepo.save(any(Book.class))).thenReturn(book);

        service.updateStock(1L, 5);
        assertEquals(5, book.getStock());
    }

    @Test
    void testUpdateStockNotEnough() {
        Book book = new Book();
        book.setId(1L);
        book.setStock(2);

        when(bookRepo.findById(1L)).thenReturn(Optional.of(book));

        ResponseStatusException ex = assertThrows(ResponseStatusException.class,
            () -> service.updateStock(1L, 5));
        assertEquals("400 BAD_REQUEST \"Not enough stock\"", ex.getMessage());
    }
}
