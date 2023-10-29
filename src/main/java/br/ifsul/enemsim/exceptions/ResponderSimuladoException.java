package br.ifsul.enemsim.exceptions;

@SuppressWarnings("serial")
public class ResponderSimuladoException extends Exception {

	public ResponderSimuladoException() {
		super();
	}

	public ResponderSimuladoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ResponderSimuladoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResponderSimuladoException(String message) {
		super(message);
	}

	public ResponderSimuladoException(Throwable cause) {
		super(cause);
	}

}
