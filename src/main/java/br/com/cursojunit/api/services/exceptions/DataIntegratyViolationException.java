package br.com.cursojunit.api.services.exceptions;

public class DataIntegratyViolationException extends RuntimeException{
    public DataIntegratyViolationException(String message) {

        super(message);
    }
}
