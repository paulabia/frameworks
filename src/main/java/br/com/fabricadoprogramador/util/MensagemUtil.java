package br.com.fabricadoprogramador.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensagemUtil {
	
	public static void msgInfo(String msg){
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,msg, null);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}
	
	public static void msgErro(String msg){
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg, null);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}
	
	public static void msgWarn(String msg){
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_WARN,msg, null);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

}
