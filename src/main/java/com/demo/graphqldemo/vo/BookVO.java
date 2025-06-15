package com.demo.graphqldemo.vo;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookVO {
    private Long id;
    private String bookName;
    private String bookAuthor;
}
