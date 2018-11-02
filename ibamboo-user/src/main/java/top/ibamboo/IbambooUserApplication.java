package top.ibamboo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={"top.ibamboo"})
public class IbambooUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbambooUserApplication.class, args);
	}
}
