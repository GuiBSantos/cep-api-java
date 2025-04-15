package cepapi.exceptions;

public class InvalidCepFormatException extends RuntimeException {
    public InvalidCepFormatException(String message) {
        System.out.println("CEP digitado fora do formato esperado");;
    }
}
