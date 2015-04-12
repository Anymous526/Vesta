package com.wallet.vesta.core.exception;

/**
 * 餐桌管理统一的异常
 * 
 * @author Kevin Sun
 *
 */
public class TableManagerException extends RuntimeException {
	private static final long serialVersionUID = 3328402083382671054L;

	public TableManagerException() {
		super();
	}

	public TableManagerException(String message) {
		super(message);
	}

	public TableManagerException(Throwable cause) {
		super(cause);
	}

	public TableManagerException(String message, Throwable cause) {
		super(message, cause);
	}
}
