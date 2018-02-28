package com.app.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author young
 *
 */
@Configuration
public class ESConfig {

	@Bean
	public RestHighLevelClient client() {
		return new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",9200,"http")));
	}
}
