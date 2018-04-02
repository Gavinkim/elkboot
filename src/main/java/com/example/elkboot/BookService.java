package com.example.elkboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author gavin
 */
@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;

    public Optional<BookDTO> save(Book book) throws Exception {
        try {
            return Optional.of(new BookDTO(bookRepository.save(book)));
        } catch (Exception e) {
            //send to logstash
            logger.error("{}",e);
            throw new Exception(e);
        }
    }
}
