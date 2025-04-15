package cepapi.utils;

import cepapi.model.Cep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWriter {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void saveLikeJson(List<Cep>ceps) {
        try (FileWriter escrita = new FileWriter("ceps.json")) {
            gson.toJson(ceps, escrita);
        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar arquivo JSON: " + e.getMessage());
        }
    }
}
