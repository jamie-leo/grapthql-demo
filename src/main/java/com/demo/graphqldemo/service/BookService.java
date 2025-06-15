package com.demo.graphqldemo.service;

import com.demo.graphqldemo.dto.request.BookInput;
import com.demo.graphqldemo.entity.Book;
import com.demo.graphqldemo.vo.BookVO;

import java.util.List;

public interface BookService {
    Book addBook(BookInput input);

    Book updateBook(Long id, BookInput input);

    List<BookVO> selectAllBooks();

    BookVO selectBooksById(Long id);

    List<BookVO> getBooksPage(int page, int size);
}
