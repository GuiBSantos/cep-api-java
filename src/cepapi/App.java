package cepapi;

import cepapi.service.BuscaService;

public class App {
    public static void main(String[] args) {
        BuscaService buscaService = new BuscaService();
        buscaService.executarBusca();
    }
}