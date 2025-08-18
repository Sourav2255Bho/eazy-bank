package com.eazybytes.loans;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Loans Microservice REST API Defination",
				description = "EazyBank Loans Microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Sourav Bhowmick",
						email = "bhowmicks2255@gmail.com",
						url = "https://www.linkedin.com/in/sourav-bhowmick-436851192/"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.linkedin.com/in/sourav-bhowmick-436851192/"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "EazyBank Loans microservice REST API Documentation",
				url = "https://www.linkedin.com/in/sourav-bhowmick-436851192/"
		)
)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
