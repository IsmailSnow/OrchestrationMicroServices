package org.sid;

import java.util.stream.Stream;

import org.sid.dao.CompanyRepository;
import org.sid.model.Company;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCompanyApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompanyRepository companyRespo) {
		return args -> {
			Stream.of("A","B","C").forEach(cn -> {
				companyRespo.save(new Company(null , cn , 100+ Math.random()*900));
			});
			companyRespo.findAll().forEach(System.out::println);
		};
	}
}

