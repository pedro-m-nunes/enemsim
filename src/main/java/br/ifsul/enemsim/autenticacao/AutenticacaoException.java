package br.ifsul.enemsim.autenticacao;

@SuppressWarnings("serial")
public class AutenticacaoException extends Exception {

	public AutenticacaoException() {
		super();
	}

	public AutenticacaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AutenticacaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public AutenticacaoException(String message) {
		super(message);
	}

	public AutenticacaoException(Throwable cause) {
		super(cause);
	}

}
