package main.java.map.Pesquisa;

import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {

    Map<String, Integer> palavras;

    public ContagemPalavras() {
        this.palavras = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        palavras.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        try {
            verificarMapVazio();
            if (palavras.containsKey(palavra)) {
                palavras.remove(palavra);
                System.out.println("A palavra " + palavra + " foi removida da contagem");
            } else {
                System.out.println("A palavra " + palavra + " não está registrada.");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void exibirContagemPalavras() {
        try {
            verificarMapVazio();
            System.out.println(palavras);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public Map.Entry<String, Integer> encontrarPalavraMaisFrequente() {
        Map.Entry<String, Integer> palavraMaisFrequente = null;
        try {
            verificarMapVazio();
            int maiorFrequencia = Integer.MIN_VALUE;
            for (Map.Entry<String, Integer> entry : palavras.entrySet()) {
                if (entry.getValue() > maiorFrequencia) {
                    maiorFrequencia = entry.getValue();
                    palavraMaisFrequente = entry;
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return palavraMaisFrequente;
    }

    public void verificarMapVazio() {
        if (palavras.isEmpty()) {
            throw new RuntimeException("Nenhuma palavra registrada.");
        }
    }

    public static void main(String[] args) {

        ContagemPalavras contagemPalavras = new ContagemPalavras();

        contagemPalavras.adicionarPalavra("Batata", 7);
        contagemPalavras.adicionarPalavra("Carne", 2);
        contagemPalavras.adicionarPalavra("Legumes", 5);
        contagemPalavras.adicionarPalavra("Açaí",19);
        contagemPalavras.adicionarPalavra("Carne", 3);
        contagemPalavras.exibirContagemPalavras();

        contagemPalavras.removerPalavra("Legumes");
        contagemPalavras.removerPalavra("Frutas");
        contagemPalavras.exibirContagemPalavras();

        System.out.println("A palavra mais frequente no texto é : " +
                contagemPalavras.encontrarPalavraMaisFrequente());

    }

}
