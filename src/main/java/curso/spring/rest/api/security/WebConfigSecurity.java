package curso.spring.rest.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import curso.spring.rest.api.service.ImplementacaoUserDetailsService;

/*Mapeia URL, endereços, autoriza ou bloqueia acesso a URL*/
@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private ImplementacaoUserDetailsService implementacaoUserDetailsService;
	
	/*Configura as solicitações de acesso por Http*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/*Ativando a proteção contra usuários que não estão validadis por token*/
		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		
		/*Ativando a permissão para acesso a página inicial do sistema*/
		.disable().authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/index").permitAll()
		
		/*URL de Logout - Redireciona após o usuário deslogar do sistema*/
		.anyRequest().authenticated().and().logout().logoutSuccessUrl("/index")
		
		/*Mapeia URl de Logout e invalida o usuário*/
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
		/*Filtra as requisições de login para autrenticação*/
		
		/*Filtra demais requisições para verificar a presença do TOKEN JWT no HEADER HTTP*/
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*Service que irá consultar o usuário no banco de dados*/
		auth.userDetailsService(implementacaoUserDetailsService)
		
		/*Padrão de codificação de senha*/
		.passwordEncoder(new BCryptPasswordEncoder());
		
	}

}
