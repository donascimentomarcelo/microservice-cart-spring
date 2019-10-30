package br.com.wiki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"br.com.core.domains"})
@ComponentScan({"br.com.core.enums"})
@ComponentScan({"br.com.core.repositories"})
public class WikiApplication {
    public static void main( String[] args ) {
    	SpringApplication.run(WikiApplication.class, args);
    }
}
