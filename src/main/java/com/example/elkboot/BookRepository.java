package com.example.elkboot;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gavin
 */
public interface BookRepository extends JpaRepository<Book,Long> {
}
