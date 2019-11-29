package br.com.sancode.fidelidade.resource.exception;

public class NoContentException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NoContentException(String msg) {
        super(msg);
    }

    public NoContentException(String msg, Throwable cause) {
        super(msg, cause);
    }

}