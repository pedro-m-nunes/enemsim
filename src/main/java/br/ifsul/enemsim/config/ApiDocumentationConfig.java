package br.ifsul.enemsim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class ApiDocumentationConfig {

	@Bean
	public OpenAPI apiDocConfig() {
		return new OpenAPI()
				.info(new Info()
						.title("EnemSim API")
//						.description(null) // ...
						.contact(new Contact()
								.name("Pedro Müller Nunes")
								.url("https://github.com/pedro-m-nunes")
								)
//						.contact(new Contact()
//								.name("João Guilherme Severo Schröer")
//								.url("https://github.com/joaoguilhermeseveroschroer")
//								)
						);
	}
	
}
