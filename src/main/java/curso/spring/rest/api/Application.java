package curso.spring.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
/* Informando para o spring onde estão as classes modelo */
@EntityScan(basePackages = { "curso.spring.rest.api.model" })
/* Injeção de dependencias para o spring controlar nossos objetos */
@ComponentScan(basePackages = { "curso.*" })
/* Qual pasta esta as interfaces de persistencia */
@EnableJpaRepositories(basePackages = { "curso.spring.rest.api.repository" })
/* Para controle nas transações c banco de dados */
@EnableTransactionManagement
/* Habilitando a parte de mvc */
@EnableWebMvc
/* Habilitando a parte de rest */
@RestController
/* Varre as anotações configura o projeto */
@EnableAutoConfiguration
public class Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/* Mapemaneto GLOBAL de segurança (reflete em todo o sistema) */
	@Override
	public void addCorsMappings(CorsRegistry registry) {

		// registry.addMapping("/**"); /*Liveração para todos os end-points*/
		// registry.addMapping("/usuario/**").allowedMethods("*"); /*Liberação para
		// todos os end-points que estão dentro do mapeamento "/usuario"*/
		// registry.addMapping("/usuario/**").allowedMethods("POST", "PUT"); /*Liberação
		// para todos os end-points de POST e PUT que estão dentro do mapeamento
		// "/usuario"*/
		/*
		 * registry.addMapping("/usuario/**") .allowedMethods("POST", "PUT")
		 * .allowedOrigins("www.cliente40.com.br"); /*Liberação para todos os end-points
		 * de POST e PUT que estão dentro do mapeamento "/usuario" apenas para o usuário
		 * cliente40
		 */
		registry.addMapping("/usuario/**").allowedMethods("*")
				.allowedOrigins("*"); /*
										 * Liberando o mapeamento de Usuário para todos os meétodos e origens
										 */

	}

}
