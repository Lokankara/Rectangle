package main.java.com.ua.univer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniverApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UniverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello from Spring Eclipse");

	}

}
