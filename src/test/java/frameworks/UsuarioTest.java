package frameworks;

import br.com.fabricadoprogramador.dao.UsuarioDAO;
import br.com.fabricadoprogramador.entidade.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuarioTest {

	public static void main(String[] args) {
		// Fabrica de EntityManager
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("mySqlBD");

		// Gerenciador de Entidades -> pega todas as entidades com @Entity e
		// persiste no banco
		EntityManager em = emf.createEntityManager();

		Usuario usu = new Usuario();
		usu.setNome("BIa");
		usu.setLogin("bia.siqueira");
		usu.setSenha("1234567");

		UsuarioDAO usuarioDao = new UsuarioDAO(em);
		usuarioDao.salvar(usu);
	}
}
