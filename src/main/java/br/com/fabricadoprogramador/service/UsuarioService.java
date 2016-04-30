package br.com.fabricadoprogramador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricadoprogramador.dao.UsuarioDAO;
import br.com.fabricadoprogramador.entidade.Usuario;
import br.com.fabricadoprogramador.exception.DAOException;
import br.com.fabricadoprogramador.exception.ServiceException;

@Service
public class UsuarioService {

	@Autowired // injeta o usuarioDAO igual o @inject	
	UsuarioDAO usuarioDAO;
	
	public Usuario salvarUsuario(Usuario usuario) throws ServiceException, DAOException{
		Usuario usuExistente = usuarioDAO.buscaLogin(usuario.getLogin());
		if(usuExistente != null){
			throw new ServiceException("Usuário já existe");
		}
		usuarioDAO.salvar(usuario);
		return usuario;
	}
	
}
