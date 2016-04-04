package frameworks;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fabricadoprogramador.entidade.Usuario;

public class UsuarioTest {

	public static void main(String[] args) {
		// Fabrica de EntityManager
		EntityManagerFactory emf =  Persistence.createEntityManagerFactory("mySqlBD");
		
		//Gerenciador de Entidades -> pega todas as entidades com @Entity e persiste no banco
		EntityManager em = emf.createEntityManager();
		
		Usuario usu = new Usuario();
		usu.setNome("BIa");
		usu.setLogin("bia.siqueira");
		usu.setSenha("1234567");
		
		// Iniciando uma transação
		em.getTransaction().begin();
		
		//realizando a persistência no banco
		em.persist(usu);
		
		//Confirmando a transação e salva a persistencia
		em.getTransaction().commit();

	}

}
