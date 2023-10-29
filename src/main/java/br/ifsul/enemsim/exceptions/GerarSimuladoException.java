package br.ifsul.enemsim.exceptions;

@SuppressWarnings("serial")
public class GerarSimuladoException extends Exception {

	public GerarSimuladoException() {
		super();
	}

	public GerarSimuladoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GerarSimuladoException(String message, Throwable cause) {
		super(message, cause);
	}

	public GerarSimuladoException(String message) {
		super(message);
	}

	public GerarSimuladoException(Throwable cause) {
		super(cause);
	}

}
