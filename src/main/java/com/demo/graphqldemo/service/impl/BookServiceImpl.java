package com.demo.graphqldemo.service.impl;

import com.demo.graphqldemo.dto.request.BookInput;
import com.demo.graphqldemo.entity.Book;
import com.demo.graphqldemo.repository.BookRepository;
import com.demo.graphqldemo.service.BookService;
import com.demo.graphqldemo.vo.BookVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book addBook(BookInput input) {
        Book book = new Book();
        book.setTitle(input.getTitle());
        book.setAuthor(input.getAuthor());
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, BookInput input) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()) {
            log.info("Book with ID {} not found. Update aborted.", id);
            return null;
        }

        Book book = optionalBook.get();

        book.setTitle(input.getTitle());

        book.setAuthor(input.getAuthor());

        return bookRepository.save(book);

    }

    @Override
    public List<BookVO> selectAllBooks() {

        return bookRepository.findAll()
                .stream()
                .map(book -> new BookVO(book.getId(), book.getTitle(), book.getAuthor()))
                .collect(Collectors.toCollection(ArrayList::new));

    }

    @Override
    public BookVO selectBooksById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.map(book -> new BookVO(book.getId(), book.getTitle(), book.getAuthor())).orElseThrow(() -> new RuntimeException("Book with ID " + id + " not found."));
    }

    @Override
    public List<BookVO> getBooksPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> bookPages = bookRepository.findAll(pageable);

        return bookPages.stream().map(book -> new BookVO(book.getId(), book.getTitle(), book.getAuthor())).collect(Collectors.toList());
    }
}
