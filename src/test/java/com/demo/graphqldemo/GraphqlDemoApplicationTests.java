package com.demo.graphqldemo;

import com.demo.graphqldemo.dto.request.BookInput;
import com.demo.graphqldemo.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GraphqlDemoApplicationTests {

    @Test
    void testAddBook() {
        BookServiceImpl  bookService = new BookServiceImpl();
        BookInput bookInput = new BookInput();
        bookInput.setAuthor("TEst");
        bookInput.setTitle("TEst");
        bookService.addBook(bookInput);
    }

}
