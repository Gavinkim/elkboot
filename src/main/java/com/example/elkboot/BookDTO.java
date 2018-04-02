package com.example.elkboot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author gavin
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookDTO {

    @NotBlank
    @Size(min = 1,max = 100)
    private String name;
    private String description;

    public BookDTO(Book book) {
        this.name = book.getName();
        this.description = book.getDescription();
    }
}
