package com.example.elkboot;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElkbootApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
    private BookElasticsearchRepository bookElasticsearchRepository;

	@Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

	@Before
    public void beforeSetup() {

    }

    @Test
    public void setElasticsearchTest() {
        bookElasticsearchRepository.deleteAll();
        bookElasticsearchRepository.saveAll(Arrays.asList(
                new Book(1L,"spring","learn spring boot"),
                new Book(2L,"angular","learn angular"),
                new Book(3L,"python","learn python")
        ));


	    Pageable pageable = PageRequest.of(0,10);
        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
                .must(QueryBuilders.termQuery("name","spring"))
                .mustNot(QueryBuilders.termQuery("description","learn spring boot"))
                .should(QueryBuilders.termQuery("id",1L));
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(queryBuilder)
                .build();

        // using elasticsearch repository
	    Page<Book> bookList1 = bookElasticsearchRepository.search(searchQuery);
	    Assert.assertNotNull(bookList1.getContent());

	    //using elasticsearch template
        List<Book> bookList2 = elasticsearchTemplate.queryForList(searchQuery,Book.class);
        Assert.assertNotNull(bookList2);


    }

}
