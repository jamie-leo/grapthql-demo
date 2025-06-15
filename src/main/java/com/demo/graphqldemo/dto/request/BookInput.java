package com.demo.graphqldemo.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookInput {
    private Long id;
    private String title;
    private String author;
}
