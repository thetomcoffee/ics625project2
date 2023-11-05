package edu.metrostate.ics625.courses;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoursesApplication {

	public static void main(String[] args) {
            ConfigurableApplicationContext ctx = 	
                SpringApplication.run(CoursesApplication.class, args);
	}

}





