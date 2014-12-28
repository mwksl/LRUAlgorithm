package main;

public class PagingSizeException extends RuntimeException {
	
	PagingSizeException() {
		super();
	}
	
	PagingSizeException(String message) {
		super(message);
	}

}
