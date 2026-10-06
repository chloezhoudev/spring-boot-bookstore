package com.chloe.demo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {
    @NotBlank // 不能为 null，也不能是空字符串 ""，也不能是纯空格 " "
    private String title;

    @NotBlank
    private String author;

    @Positive
    @NotNull
    private Double price;

    @NotNull
    private BookCategory category;
}
