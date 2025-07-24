package main.java.map.Ordenacao;

import java.util.*;

public class LivrariaOnline {

    private Map<String, Livro> livros;

    public LivrariaOnline() {
        this.livros = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco) {
        livros.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo) {

        try {
            verificarMapVazio();
            String keyParaRemover = null;
            for (Map.Entry<String, Livro> entry : livros.entrySet()) {
                if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                    keyParaRemover = entry.getKey();
                    break;
                }
            }
            if (keyParaRemover == null) {
                throw new RuntimeException("O livro " + titulo + " não existe no catálogo.");
            }
            livros.remove(keyParaRemover);
            System.out.println("Livro removido com sucesso.");

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {

        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

        try {
            verificarMapVazio();

            List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livros.entrySet());

            Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco());


            for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
                livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        if (livrosOrdenadosPorPreco.isEmpty()) {
            return null;
        }
        return livrosOrdenadosPorPreco;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {


        Map<String, Livro> livrosPorAutor = new HashMap<>();

        try {
            verificarMapVazio();

            for (Map.Entry<String, Livro> entry : livros.entrySet()) {
                if (entry.getValue().getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.put(entry.getKey(), entry.getValue());
                }
            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        if (livrosPorAutor.isEmpty()) {
            System.out.println("Não existe nenhum livro registrado do autor " + autor + ".");
        }
        return livrosPorAutor;

    }

    public Livro obterLivroMaisCaro() {

        Livro livroMaisCaro = null;

        try {
            verificarMapVazio();

            double maiorPreco = Double.MIN_VALUE;
            for (Map.Entry<String, Livro> entry : livros.entrySet()) {

                if (entry.getValue().getPreco() > maiorPreco) {
                    maiorPreco = entry.getValue().getPreco();
                    livroMaisCaro = entry.getValue();
                }

            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return livroMaisCaro;

    }

    public Livro exibirLivroMaisBarato() {

        Livro livroMaisBarato = null;

        try {
            verificarMapVazio();

            double menorPreco = Double.MAX_VALUE;
            for (Map.Entry<String, Livro> entry : livros.entrySet()) {

                if (entry.getValue().getPreco() < menorPreco) {
                    menorPreco = entry.getValue().getPreco();
                    livroMaisBarato = entry.getValue();
                }

            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return livroMaisBarato;

    }

    public void verificarMapVazio() {
        if (livros.isEmpty()) {
            throw new RuntimeException("Não existe nenhum livro no catálogo.");
        }
    }

    public static void main(String[] args) {

        LivrariaOnline livrariaOnline = new LivrariaOnline();

        livrariaOnline.adicionarLivro("https://teste.com", "Livro", "Autor", 67.9d);
        livrariaOnline.adicionarLivro("https://teste2.com", "Livro 2", "Autor2", 43d);
        livrariaOnline.adicionarLivro("https://teste3.com", "Livro 3", "Autor3", 202.5d);
        livrariaOnline.adicionarLivro("https://teste4.com", "Livro 4", "Autor3", 206.5d);
        livrariaOnline.adicionarLivro("https://teste5.com", "Livro 5", "Autor3", 220.5d);
        livrariaOnline.adicionarLivro("https://teste6.com", "Livro 6", "Autor4", 20.45d);
        livrariaOnline.removerLivro("Livro 9");
        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorPreco());
        System.out.println(livrariaOnline.pesquisarLivrosPorAutor("Autor3"));
        System.out.println(livrariaOnline.pesquisarLivrosPorAutor("Autor20"));

        System.out.println("O livro mais caro é: " + livrariaOnline.obterLivroMaisCaro());
        System.out.println("O livro mais barato é: " + livrariaOnline.exibirLivroMaisBarato());
        livrariaOnline.removerLivro("livro 6");
        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorPreco());

    }
}