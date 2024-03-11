package curso.spring.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
/*Informando para o spring onde estão as classes modelo*/
@EntityScan(basePackages = {"curso.spring.rest.api.model"})
/*Injeção de dependencias para o spring controlar nossos objetos*/
@ComponentScan(basePackages = {"curso.*"})
/*Qual pasta esta as interfaces de persistencia*/
@EnableJpaRepositories(basePackages = {"curso.spring.rest.api.repository"})
/*Para controle nas transações c banco de dados*/
@EnableTransactionManagement
/*Habilitando a parte de mvc*/
@EnableWebMvc
/*Habilitando a parte de rest*/
@RestController
/*Varre as anotações configura o projeto*/
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
