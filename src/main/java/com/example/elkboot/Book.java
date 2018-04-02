package com.example.elkboot;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author gavin
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Document(indexName = "online-store",type = "book")
public class Book {
    private Long id;
    private String name;
    private String description;
}
