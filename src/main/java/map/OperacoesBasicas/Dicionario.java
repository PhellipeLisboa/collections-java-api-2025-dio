package main.java.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {

    private Map<String, String> dicionario;

    public Dicionario() {
        this.dicionario = new HashMap<>();
    }


    public void adicionarPalavra(String palavra, String definicao) {
        dicionario.put(palavra, definicao);
    }

    public void removerPalavra(String palavra){
        verificarMapVazio();
        dicionario.remove(palavra);
    }

    public void exibirPalavras() {
        System.out.println(dicionario);
    }

    public String pesquisarPorPalavra(String palavra) {
        verificarMapVazio();
        String definicaoPorPalavra = dicionario.get(palavra);
        if (definicaoPorPalavra != null) {
            return definicaoPorPalavra;
        } else {
            return "A definição de " + palavra +  " não foi encontrada no dicionário";
        }
    }

    public void verificarMapVazio(){
        if (dicionario.isEmpty()) {
            throw new RuntimeException("O dicionário está vazio.");
        }
    }

    public static void main(String[] args) {

        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("Medalhar", "Gravar em medalhas; consagrar ou comemorar por meio de medalha.");
        dicionario.adicionarPalavra("Colectoria", "Lugar, onde se pagam os impostos.");
        dicionario.adicionarPalavra("Anúncio", "Aviso; notícia que divulga alguma coisa publicamente.");
        dicionario.adicionarPalavra("Conculcar", "Calcar muito com os pés; espezinhar.");
        dicionario.adicionarPalavra("Anúncio", "Publicidade. Mensagem que busca vender, que faz propaganda, divulgando as vantagens e qualidades de um produto, serviço, atividade.");


        dicionario.exibirPalavras();
        dicionario.removerPalavra("Anúncio");
        dicionario.exibirPalavras();

        System.out.printf("O significado de \"Medalhar\" é : %s \n", dicionario.pesquisarPorPalavra("Medalhar"));
        System.out.printf("O significado de \"Batata\" é : %s \n", dicionario.pesquisarPorPalavra("Batata"));

    }

}