package miu.edu.lab1;


import miu.edu.lab1.Domain.Post;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class lab1Application  {

	public static void main(String[] args) {
		SpringApplication.run(lab1Application.class, args);

		Post post4 = new Post(1l,"My Father's Daughter", "Fiction", "Hannah Pool");
		Post post5 = new Post(2l,"The Consequences of Love", "Romance", "Sulaiman Addonai");
		Post post6 = new Post(3l,"Nothing lasts forever", "Fiction", "Sydney Sheldon");
	}

}
