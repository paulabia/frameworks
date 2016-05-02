package br.com.fabricadoprogramador.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.fabricadoprogramador.entidade.Usuario;
import br.com.fabricadoprogramador.exception.DAOException;
import br.com.fabricadoprogramador.exception.ServiceException;
import br.com.fabricadoprogramador.service.UsuarioService;

@Controller(value="usuController")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;
	
	@PostConstruct
	public void init(){
		setUsuarios(usuarioService.buscarTodos());
	}
	
	public void salvar(){
		try {
			usuarioService.salvarUsuario(usuario);
			usuarios.add(usuario);
		} catch (ServiceException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	

}