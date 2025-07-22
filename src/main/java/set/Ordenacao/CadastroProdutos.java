package main.java.set.Ordenacao;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {

    private Set<Produto> produtos;

    public CadastroProdutos() {
        this.produtos = new HashSet<>();
    }

    public void adicionarProduto(long codigo, String nome, double preco, int quantidade) {
        produtos.add(new Produto(nome, codigo, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {
        Set<Produto> produtosPorNome = new TreeSet<>(produtos);
        return produtosPorNome;
    }

    public Set<Produto> exibirProdutosPorPreco() {
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
        produtosPorPreco.addAll(produtos);
        return produtosPorPreco;
    }

    public static void main(String[] args) {

        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.adicionarProduto(2L, "Produto III", 20d, 8);
        cadastroProdutos.adicionarProduto(3L, "Produto I", 7d, 2);
        cadastroProdutos.adicionarProduto(2L, "Produto IV", 420d, 3);
        cadastroProdutos.adicionarProduto(9L, "Produto X", 60d, 7);

        System.out.println(cadastroProdutos.produtos);

        System.out.println(cadastroProdutos.exibirProdutosPorNome());
        System.out.println(cadastroProdutos.exibirProdutosPorPreco());

    }

}
