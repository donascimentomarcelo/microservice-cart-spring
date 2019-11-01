package br.com.wiki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EntityScan({"br.com.core.domains"})
@EnableMongoRepositories({"br.com.core.repositories"})
public class WikiApplication {
    public static void main( String[] args ) {
    	SpringApplication.run(WikiApplication.class, args);
    }
}
