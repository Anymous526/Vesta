package com.wallet.vesta.core.exception;

public class DuplicatedUserException extends UserManagerException {
	private static final long serialVersionUID = 3328402083382671054L;

	public DuplicatedUserException() {
		super();
	}

	public DuplicatedUserException(String message) {
		super(message);
	}

	public DuplicatedUserException(Throwable cause) {
		super(cause);
	}

	public DuplicatedUserException(String message, Throwable cause) {
		super(message, cause);
	}
}
