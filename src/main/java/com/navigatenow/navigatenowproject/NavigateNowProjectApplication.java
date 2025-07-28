package com.navigatenow.navigatenowproject;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title="Navigate Now System",
				version="1.0.0",
				description = "Navigate Now System is your way to enjoy Sydney",
				termsOfService = "run code now",
				contact = @Contact(
						name = "Mr Navigate Now System",
						email = "azal9758@uni.Sydney.edu.au"
				),
				license =  @License(
						name= "licence",
						url = "runcodenow"
				)
		)
)
public class NavigateNowProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NavigateNowProjectApplication.class, args);
	}

}
