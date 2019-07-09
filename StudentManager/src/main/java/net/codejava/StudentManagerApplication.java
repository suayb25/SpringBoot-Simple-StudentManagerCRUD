package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StudentManagerApplication.class, args);
	}

}
