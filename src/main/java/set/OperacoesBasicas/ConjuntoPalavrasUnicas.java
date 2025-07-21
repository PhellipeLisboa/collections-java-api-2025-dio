package main.java.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {

    private Set<String> palavras;

    public ConjuntoPalavrasUnicas() {
        this.palavras = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        palavras.add(palavra);
    }

    public void removerPalavra(String palavra) {
        verificarSetVazio();

        if (palavras.contains(palavra)) {
            palavras.remove(palavra);
        } else {
            System.out.println("Palavra não encontrada no conjunto!");
        }

    }

    public boolean verificarPalavra(String palavra) {
        return palavras.contains(palavra);
    }

    public void exibirPalavrasUnicas() {
        verificarSetVazio();
        System.out.println(palavras);
    }

    public void verificarSetVazio() {
        if (palavras.isEmpty()) {
            throw new RuntimeException("O set está vazio!");
        }
    }

    public static void main(String[] args) {

        ConjuntoPalavrasUnicas conjuntoAnimais = new ConjuntoPalavrasUnicas();

        conjuntoAnimais.adicionarPalavra("cavalo");
        conjuntoAnimais.adicionarPalavra("morcego");
        conjuntoAnimais.adicionarPalavra("morcego");
        conjuntoAnimais.adicionarPalavra("lobo");

        conjuntoAnimais.exibirPalavrasUnicas();
        System.out.println(conjuntoAnimais.verificarPalavra("cavalo"));

        conjuntoAnimais.removerPalavra("cavalo");
        System.out.println(conjuntoAnimais.verificarPalavra("cavalo"));
        conjuntoAnimais.exibirPalavrasUnicas();

    }

}
