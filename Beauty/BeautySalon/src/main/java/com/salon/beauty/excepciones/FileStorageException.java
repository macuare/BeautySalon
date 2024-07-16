package com.salon.beauty.excepciones;

public class FileStorageException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6654343545084356765L;

	public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }

}
