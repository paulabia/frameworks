package frameworks;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.fabricadoprogramador.dao.UsuarioDAO;
import br.com.fabricadoprogramador.entidade.Usuario;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/META-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback=false)
public class UsuarioTestSpring {
	
	@Autowired
	UsuarioDAO usuarioDao;
	
	@Test
	public void testSpring() {
	
		Usuario usu = new Usuario();
		usu.setNome("Robson");
		usu.setLogin("rob.ferreira");
		usu.setSenha("1234567");

		usuarioDao.salvar(usu);

	}

}
