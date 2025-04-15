package cepapi.service;

import cepapi.api.HttpCepClient;
import cepapi.model.Cep;
import cepapi.utils.JsonWriter;
import cepapi.exceptions.CepNotFoundException;
import cepapi.exceptions.InvalidCepFormatException;
import cepapi.exceptions.InvalidResponseException;
import cepapi.exceptions.JsonWriteException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuscaService {
    private final HttpCepClient client = new HttpCepClient();
    private final List<Cep> cepsEncontrados = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final JsonWriter writer = new JsonWriter();

    public void executarBusca() {
        System.out.println("==== Consulta de CEP ====");
        while (true) {
            System.out.println("Digite um CEP (ou 0 para sair): ");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("0")) {
                break;
            }

            try {
                Cep cep = client.buscarCep(entrada);
                cepsEncontrados.add(cep);

                System.out.println("\n📦 Dados do CEP:");
                System.out.println("CEP: " + cep.cep());
                System.out.println("Logradouro: " + cep.logradouro());
                System.out.println("Bairro: " + cep.bairro());
                System.out.println("Cidade: " + cep.localidade());
                System.out.println("Estado: " + cep.uf());
                System.out.println("DDD: " + cep.ddd() + "\n");
            } catch (CepNotFoundException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (InvalidCepFormatException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (InvalidResponseException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (JsonWriteException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                System.out.println("Finalizando...");
            }
        }
        writer.saveLikeJson(cepsEncontrados);
        System.out.println("✅ Dados salvos com sucesso!");
    }
}