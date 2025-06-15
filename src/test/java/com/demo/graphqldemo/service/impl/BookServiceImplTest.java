package com.demo.graphqldemo.service.impl;

import com.demo.graphqldemo.entity.Book;
import com.demo.graphqldemo.repository.BookRepository;
import com.demo.graphqldemo.service.BookService;
import com.demo.graphqldemo.vo.BookVO;
import graphql.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class BookServiceImplTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testSelectAllBooks() {

        ArrayList<BookVO> bookVOArrayList = bookRepository.findAll()
                .stream()
                .map(book -> new BookVO(book.getId(), book.getAuthor(), book.getTitle()))
                .collect(Collectors.toCollection(ArrayList::new));
        Assert.assertTrue(bookVOArrayList.size() > 0);

        bookVOArrayList.forEach(System.out::println);

    }

}
