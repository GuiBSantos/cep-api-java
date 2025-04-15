package cepapi.exceptions;

public class CepNotFoundException extends  RuntimeException{
    public CepNotFoundException(String mensagem) {
        System.out.println("O CEP nao foi encontrado!");
    }
}
