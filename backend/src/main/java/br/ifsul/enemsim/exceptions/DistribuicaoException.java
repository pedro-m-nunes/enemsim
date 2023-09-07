package br.ifsul.enemsim.exceptions;

@SuppressWarnings("serial")
public class DistribuicaoException extends Exception {

	public DistribuicaoException() {
		super();
	}

	public DistribuicaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DistribuicaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DistribuicaoException(String message) {
		super(message);
	}

	public DistribuicaoException(Throwable cause) {
		super(cause);
	}

}
