package br.com.fabricadoprogramador.exception;

public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Instanciando passando mensagem para a classe base
	 * 
	 * @param msg
	 *            Mensagem da Exception
	 */
	public DAOException(String msg) {
		super(msg);
	}

	/**
	 * Instanciando passando mensagem e causa para a classe base
	 * 
	 * @param msg
	 *            Mensagem da Exception
	 * @param causa
	 *            Objeto Exception para Embrulhar (wrapping)
	 */
	public DAOException(String msg, Throwable causa) {
		super(msg, causa);
	}

	/**
	 * Instanciando passando somente causa para a classe base
	 * 
	 * @param causa
	 *            Objeto Exception para Embrulhar (wrapping)
	 */
	public DAOException(Throwable causa) {
		super(causa);
	}

}
