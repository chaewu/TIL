package com.example.demo.builder;

import lombok.*;

@Builder
public class A {
    @NonNull
    private String name;

    @NonNull
    private Integer classNumber;

    private String hobby;

}