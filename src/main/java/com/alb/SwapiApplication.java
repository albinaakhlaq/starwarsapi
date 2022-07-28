package com.alb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwapiApplication.class, args);
    }

/*
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
           People people = restTemplate.getForObject(
                    "https://swapi.dev/api/people/1", People.class);
            System.out.println(people.toString());
        };
    }
*/

}
