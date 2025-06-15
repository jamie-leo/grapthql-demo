package com.demo.graphqldemo.controller;

import com.demo.graphqldemo.dto.request.BookInput;
import com.demo.graphqldemo.dto.request.PageInput;
import com.demo.graphqldemo.entity.Book;
import com.demo.graphqldemo.repository.BookRepository;

import com.demo.graphqldemo.service.BookService;
import com.demo.graphqldemo.vo.BookVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;
import java.util.Optional;


@Slf4j
@Controller
public class BookController {
    @Autowired
    private BookRepository repository;
    @Autowired
    private BookService bookService;


    @QueryMapping

    public List<BookVO> books() {
        return bookService.selectAllBooks();
    }


    @QueryMapping
    public BookVO bookById(@Argument Long id) {
        return bookService.selectBooksById(id);
    }


    @QueryMapping
    public List<BookVO> bookPages(@Argument PageInput input) {
        if (input == null) {
            throw new IllegalArgumentException("Input is required");
        }
        int page = input.getPage() != null ? input.getPage() : 0;
        int size = input.getSize() != null ? input.getSize() : 5;

        return bookService.getBooksPage(page, size);
    }


    @MutationMapping
    public Book addBook(@Argument BookInput input) {
        return bookService.addBook(input);
    }

    @MutationMapping
    public Book updateBook(@Argument Long id, @Argument BookInput input) {


        Optional<Book> optional = repository.findById(id);
        if (optional.isEmpty()) {
            log.warn("Book with ID {} not found. Update aborted.", id);
            return null;
        }

        Book book = optional.get();
        book.setTitle(input.getTitle());
        book.setAuthor(input.getAuthor());

        return repository.save(book);

    }

    @MutationMapping
    public Boolean deleteBook(@Argument Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }


}
