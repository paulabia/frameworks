package br.com.fabricadoprogramador.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fabricadoprogramador.entidade.Perfil;
import br.com.fabricadoprogramador.exception.ServiceException;
import br.com.fabricadoprogramador.service.PerfilService;
import br.com.fabricadoprogramador.util.MensagemUtil;

@Component("perfilConverter")
public class PerfilConverter implements Converter {

	@Autowired
	private PerfilService perfilService;

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		// Id a Transformar em objeto
		Integer id = null;
		try {
			// tentando converter o texto para número inteiro
			id = Integer.parseInt(value);
			return perfilService.buscarPorId(id);
		} catch (NumberFormatException e) {
			// Quando der exceção de conversão
			MensagemUtil.msgErro("Erro ao carregar Perfil. Utilize a caixa	de seleção para escolher um perfil!");
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		//Se for nulo ou senão for uma instancia de Perfil
		if(value==null || !(value instanceof Perfil)) return "";
		//Fazendo um cast
		Perfil perfil = (Perfil) value;
		//Retornando o Id como String
		return perfil.getId().toString();
	}
}
