package br.com.fabricadoprogramador.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
/**
 * Class no Padrão JavaBean
 * Um Java Bean precisa ser Serializado, conter atributos privados,conter um construtor vazio,  
 * conter um construtor com parâmetros, conter métodos publicos Getters\Setters, sobrescrever o método ToString()
 * obrescrever o método HashCode(), sobrescrever o método Equals() e conter uma identificação única )(ID)
 *@author Ana Paula Siqueira
 *
 */
@Entity
public class Usuario implements Serializable{
	
	/**
	 * Controla a versão da class, dado que a estrutura seja alterada assim é gerado um novo número
	 * Podendo comprar para ver as alterações
	 */
	private static final long serialVersionUID = -6690883986996807051L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@SequenceGenerator(name="seq", sequenceName="SEQ_GEN")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
	private Integer id;
	private String nome;
	private String login;
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", login=" + login
				+ ", senha=" + senha + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
	
	
	

}
