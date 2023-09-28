package br.ifsul.enemsim.exceptions;

@SuppressWarnings("serial")
public class RespostaAoSimuladoException extends Exception {

	public RespostaAoSimuladoException() {
		super();
	}

	public RespostaAoSimuladoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RespostaAoSimuladoException(String message, Throwable cause) {
		super(message, cause);
	}

	public RespostaAoSimuladoException(String message) {
		super(message);
	}

	public RespostaAoSimuladoException(Throwable cause) {
		super(cause);
	}

}
