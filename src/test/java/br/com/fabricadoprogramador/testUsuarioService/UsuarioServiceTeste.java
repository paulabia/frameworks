package br.com.fabricadoprogramador.testUsuarioService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.fabricadoprogramador.entidade.Usuario;
import br.com.fabricadoprogramador.exception.DAOException;
import br.com.fabricadoprogramador.exception.ServiceException;
import br.com.fabricadoprogramador.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/META-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback=false)
public class UsuarioServiceTeste {

	@Autowired
	UsuarioService usuarioService;

	@Test
	public void salvar() throws DAOException {
		Usuario usu = new Usuario();
		usu.setLogin("testSalvar");
		usu.setNome("Usuario Test");
		usu.setSenha("1234");

		try {
			usuarioService.salvarUsuario(usu);
			Assert.assertTrue(true);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
