# Elasticsearch for spring boot sample

<pre>
spring boot sample for elasticsearch and spring data jpa , logstash
how to insert to elasticsearch and database
how to search from elasticsearch and database
</pre>

## download elasticsearch
* [download link] ()https://www.elastic.co/kr/downloads/elasticsearch)
* [download link] ()https://www.elastic.co/kr/downloads/logstash)

## run elasticsearch and logstash
* <download elasticsearch>/bin/elasticsearch
* <download logstash>/bin/logstash

## custom pipeline config logstash

* vi elkbook_logstash.conf

<pre>
input {
  tcp {
    port => 9998
  }
}

output {
  elasticsearch {
    hosts => [ "localhost:9200" ]
  }
}
</pre>

## spring application
<pre>
 - insert H2 database
 - insert elasticsearch
 - Get(search) from elasticsearch
 - Get from H2 database
</pre>