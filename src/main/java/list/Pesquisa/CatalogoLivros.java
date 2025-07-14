package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {

    private List<Livro> livros;

    public CatalogoLivros() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {

        livros.add(new Livro(titulo, autor, anoPublicacao));

    }

    public List<Livro> pesquisarPorAutor(String autor) {

        //TODO: Pesquisa livros por autor e retorna uma lista com os livros encontrados.

        List<Livro> resultadoPesquisa = new ArrayList<>();

        if (livros.isEmpty()) {
            System.out.println("Não existe nenhum livro no catálogo.");
        } else {


            for (Livro livro : livros) {

                if (livro.getAutor().trim().equalsIgnoreCase(autor.trim())) {
                    resultadoPesquisa.add(livro);
                }

            }

            if (resultadoPesquisa.isEmpty()) {
                System.out.println("Nenhum livro encontrado do autor " + autor);
            }

        }

        return resultadoPesquisa;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {

        //TODO: Pesquisa livros publicados em um determinado intervalo de anos e retorna uma lista com os livros
        // encontrados.

            List<Livro> resultadoPesquisa = new ArrayList<>();

            if (livros.isEmpty()) {
                System.out.println("Não existe livro no catálogo.");
            } else {

                for (Livro livro: livros) {

                    if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal) {
                        resultadoPesquisa.add(livro);
                    }

                }

                if (resultadoPesquisa.isEmpty()) {
                    System.out.printf("Nenhum livro com data de publicação entre %s e %s encontrado. \n",
                            anoInicial, anoFinal);
                }

            }

            return resultadoPesquisa;
    }

    public Livro pesquisarPorTitulo(String titulo) {

        //TODO: Pesquisa livros por título e retorna o primeiro livro encontrado.

        Livro resultadoPesquisa = null;

        if (livros.isEmpty()) {
            System.out.println("Não existe nenhum livro no catálogo.");
        } else {

            for (Livro livro : livros) {

                if (livro.getTitulo().trim().equalsIgnoreCase(titulo.trim())) {
                    resultadoPesquisa = livro;
                    break;
                }

            }

            if (resultadoPesquisa == null) {
                System.out.printf("Nenhum livro encontrado com o título \"%s\". \n", titulo);
            }

        }

        return resultadoPesquisa;
    }

    public static void main(String[] args) {

        CatalogoLivros catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivro("Livro 1", "Autor 1", 1916);
        catalogoLivros.adicionarLivro("Livro 2", "Autor 1", 1934);
        catalogoLivros.adicionarLivro("Livro 2", "Autor 2", 2009);
        catalogoLivros.adicionarLivro("Livro 3", "Autor 3", 2009);
        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2008, 2025));
        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2024, 2025));
        System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 3"));
        System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 2"));
        System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 4"));
        System.out.println(catalogoLivros.pesquisarPorAutor("Autor 1"));
        System.out.println(catalogoLivros.pesquisarPorAutor("Autor 5"));
    }

}