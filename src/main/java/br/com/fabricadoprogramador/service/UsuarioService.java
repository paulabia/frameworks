package br.com.fabricadoprogramador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricadoprogramador.dao.UsuarioDAO;
import br.com.fabricadoprogramador.entidade.Usuario;
import br.com.fabricadoprogramador.exception.DAOException;
import br.com.fabricadoprogramador.exception.ServiceException;

@Service // será instanciado pelo spring
public class UsuarioService {

	@Autowired // injeta o usuarioDAO igual o @inject	
	UsuarioDAO usuarioDAO;
	
	public Usuario salvarUsuario(Usuario usuario) throws ServiceException, DAOException{
		Usuario usuExistente = usuarioDAO.buscaLogin(usuario.getLogin());
		if(usuExistente != null){
			throw new ServiceException("Usuario ja existe");
		}
		usuarioDAO.salvar(usuario);
		return usuario;
	}
	
	public void excluirUsuario(Usuario usuario){
		if(usuario != null){
			usuarioDAO.exclui(usuario);
		}
	}

	public List<Usuario> buscarTodos() {
		return usuarioDAO.buscaTodos();
		 
	}
	
}
