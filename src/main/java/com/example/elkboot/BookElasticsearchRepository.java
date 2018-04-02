package com.example.elkboot;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author gavin
 */
public interface BookElasticsearchRepository extends ElasticsearchRepository<Book,Long> {
}
