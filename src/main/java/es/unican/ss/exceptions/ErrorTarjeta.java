package es.unican.ss.exceptions;

public class ErrorTarjeta extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 905412387276187620L;
	
	public ErrorTarjeta() {
		super();
	}
	public ErrorTarjeta(String error) {
		super(error);
	}
	

}
