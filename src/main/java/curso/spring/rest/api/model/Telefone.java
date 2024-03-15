package curso.spring.rest.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String numero;
	
	/*JsonIgnore para quando buscar telefone do usuário
	 * não gerar o json de usuário novamente acarretando em uma RECURSIVIDADE(LOOP na geração do json)*/
	@JsonIgnore
	/*ForeignKey: Chave estrangeira que aponta para usuário*/
	@org.hibernate.annotations.ForeignKey(name = "usuario_id") 
	/*Muitos telefones para um usuário*/
	/*optional: telefone precisa de um pai - usuario NOT NULL*/
	@ManyToOne(optional = false) 
	private Usuario usuario;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	

}
