package br.com.fabricadoprogramador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricadoprogramador.dao.PerfilDAO;
import br.com.fabricadoprogramador.entidade.Perfil;
import br.com.fabricadoprogramador.exception.DAOException;
import br.com.fabricadoprogramador.exception.ServiceException;

@Service // será instanciado pelo spring
public class PerfilService {

	@Autowired // injeta o PerfilDAO igual o @inject	
	PerfilDAO perfilDAO;
	
	public Perfil salvarPerfil(Perfil Perfil) throws ServiceException, DAOException{
			return perfilDAO.salvar(Perfil);	
	}
	
	public void excluirPerfil(Perfil Perfil){
		if(Perfil != null){
			try {
				perfilDAO.exclui(Perfil);
			} catch (DAOException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Perfil> buscarTodos() {
		return perfilDAO.buscarTodos();
	}

	public Object buscarPorId(Integer id) {
		return perfilDAO.buscaPorId(id);
	}
	
}
