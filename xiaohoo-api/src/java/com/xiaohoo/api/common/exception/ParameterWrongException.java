/**
 * 
 */
package com.xiaohoo.api.common.exception;

/**
 * @author haojwang
 *
 */
public class ParameterWrongException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1116108025864896347L;

	/**
	 * 
	 */
	public ParameterWrongException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ParameterWrongException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ParameterWrongException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ParameterWrongException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ParameterWrongException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
