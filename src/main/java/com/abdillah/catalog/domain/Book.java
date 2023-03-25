package com.abdillah.catalog.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Book implements Serializable {

    private Long id;

    private String title;

    private String description;

    private Author author;
}
