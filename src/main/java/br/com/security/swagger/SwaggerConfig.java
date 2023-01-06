package br.com.security.swagger;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private Contact contato() {
		return new Contact(
				"Julio Cesar Melegari",
				"github/JulioCesarMelegari",
				"www.naotenhosite.com.br");
	}
	

	
	private ApiInfoBuilder informacoesApi() {
		
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		
		apiInfoBuilder.title("Title - API Spring Security");
		apiInfoBuilder.description("Exemplo de API utilizando Spring Security + Swagger");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
		apiInfoBuilder.license("Licenca - Toda!");
		apiInfoBuilder.licenseUrl("http://www.nãotenhosite.com.br");
		apiInfoBuilder.contact(this.contato());
		
		return apiInfoBuilder;
	}
	
	
	@Bean
	public Docket DetalheApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		
		docket
		.select()
		.apis(RequestHandlerSelectors.basePackage("br.com.security.configuration"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(this.informacoesApi().build())
		.consumes(new HashSet<String>(Arrays.asList("application/json")))
		.produces(new HashSet<String>(Arrays.asList("application/json")));
		
		return docket;
	}

}
