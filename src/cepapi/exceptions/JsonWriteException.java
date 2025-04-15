package cepapi.exceptions;

public class JsonWriteException extends RuntimeException {
    public JsonWriteException(String message) {
        System.out.println("Erro ao salvar JSON!");;
    }
}
