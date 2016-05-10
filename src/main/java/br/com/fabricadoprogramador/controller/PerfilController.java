package br.com.fabricadoprogramador.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.fabricadoprogramador.entidade.Perfil;
import br.com.fabricadoprogramador.exception.DAOException;
import br.com.fabricadoprogramador.exception.ServiceException;
import br.com.fabricadoprogramador.service.PerfilService;
import br.com.fabricadoprogramador.util.MensagemUtil;

@Controller(value = "perfilController")
public class PerfilController {

	@Autowired
	PerfilService perfilService;

	private Perfil perfil = new Perfil();
	private List<Perfil> perfils;

	@PostConstruct //do pacote javax.annotation faz com que o método anotado seja executado logo após a injeção de dependência. Essa anotação deve ser feita somente sobre um método
	public void init() {
		setPerfils(perfilService.buscarTodos());
	}

	public void salvar() {
		try {
			Perfil pSalvo = perfilService.salvarPerfil(perfil);
			init();
			//limpa o form
			perfil = new Perfil();
			MensagemUtil.msgInfo("Perfil salvo com sucesso!");

		} catch (ServiceException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void excluir(Perfil p) {
		try{
			perfilService.excluirPerfil(p);
			init();	
			MensagemUtil.msgInfo("Perfil excluido com sucesso!");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void editar(Perfil p) {
		this.perfil = p;
		init();
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Perfil> getPerfils() {
		return perfils;
	}

	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}

}
