package frameworks;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fabricadoprogramador.dao.UsuarioDAO;
import br.com.fabricadoprogramador.entidade.Usuario;

public class UsuarioTestSpring {
	
	@Test
	public void testSpring() {
		//Spring que cria o EntityManagerFactory, injetando as dependencias
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/resources/META-INF/springbeans.xml");
		EntityManagerFactory emf = (EntityManagerFactory)ctx.getBean("entityManagerFactory");
		
		EntityManager em = emf.createEntityManager();
		
		Usuario usu = new Usuario();
		usu.setNome("Robson");
		usu.setLogin("rob.ferreira");
		usu.setSenha("1234567");

		UsuarioDAO usuarioDao = new UsuarioDAO(em);
		usuarioDao.salvar(usu);
		// TODO Auto-generated method stub

	}

}
