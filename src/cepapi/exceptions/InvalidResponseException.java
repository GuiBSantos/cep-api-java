package cepapi.exceptions;

public class InvalidResponseException extends RuntimeException {
    public InvalidResponseException(String message) {
        System.out.println("A API retornou algo invalido!");;
    }
}
