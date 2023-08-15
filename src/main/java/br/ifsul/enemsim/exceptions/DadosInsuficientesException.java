package br.ifsul.enemsim.exceptions;

@SuppressWarnings("serial")
public class DadosInsuficientesException extends Exception {

	public DadosInsuficientesException() {
		super();
	}

	public DadosInsuficientesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DadosInsuficientesException(String message, Throwable cause) {
		super(message, cause);
	}

	public DadosInsuficientesException(String message) {
		super(message);
	}

	public DadosInsuficientesException(Throwable cause) {
		super(cause);
	}

}
