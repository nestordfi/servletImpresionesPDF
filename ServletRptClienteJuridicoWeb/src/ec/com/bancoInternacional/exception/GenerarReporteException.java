package ec.com.bancoInternacional.exception;

public class GenerarReporteException extends Exception {

	private static final long serialVersionUID = -5357037704375794999L;

	public GenerarReporteException() {
		super();
	}

	public GenerarReporteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GenerarReporteException(String message, Throwable cause) {
		super(message, cause);
	}

	public GenerarReporteException(String message) {
		super(message);
	}

	public GenerarReporteException(Throwable cause) {
		super(cause);
	}

}
