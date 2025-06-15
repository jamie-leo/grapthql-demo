package com.demo.graphqldemo.repository;

import com.demo.graphqldemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
