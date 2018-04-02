package com.example.elkboot;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author gavin
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Document(indexName = "online-store",type = "book")
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Field
    private Long id;
    @Field
    private String name;
    @Field
    private String description;
}
