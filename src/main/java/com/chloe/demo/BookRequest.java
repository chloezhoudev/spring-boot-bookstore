package com.chloe.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {
    private String title;
    private String author;
    private Double price;

    private BookCategory category;
}
