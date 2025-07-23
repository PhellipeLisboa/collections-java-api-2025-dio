package main.java.map.Pesquisa;

import main.java.map.Pesquisa.Produto;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {

    private Map<Long, Produto> produtos;

    public EstoqueProdutos() {
        this.produtos = new HashMap<>();
    }

    public void adicionarProduto(Long cod, String nome, int quantidade, double preco) {
        produtos.put(cod, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos() {
        try {
            verificarSetVazio();
            System.out.println(produtos);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public double calcularValorTotalEstoque() {

        double total = 0d;
        try {
            verificarSetVazio();
            for (Produto produto : produtos.values()) {
                total += produto.getValorTotal();
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return total;
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;

        try {

            double maiorPreco = Double.MIN_VALUE;
            for (Produto produto : produtos.values()) {
                if (produto.getPreco() > maiorPreco) {
                    maiorPreco = produto.getPreco();
                    produtoMaisCaro = produto;
                }
            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;

        try {

            double menorPreco = Double.MAX_VALUE;
            for (Produto produto : produtos.values()) {
                if (produto.getPreco() < menorPreco) {
                    menorPreco = produto.getPreco();
                    produtoMaisBarato = produto;
                }
            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto produtoMaiorTotal = null;

        try {

            double maiorTotal = Double.MIN_VALUE;
            for (Produto produto : produtos.values()) {
                if (produto.getValorTotal() > maiorTotal) {
                    maiorTotal = produto.getValorTotal();
                    produtoMaiorTotal = produto;
                }
            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return produtoMaiorTotal;
    }

    public void verificarSetVazio() {
        if (produtos.isEmpty()) {
            throw new RuntimeException("O estoque está vazio.");
        }
    }

    public static void main(String[] args) {

        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.adicionarProduto(1L, "Caneta", 2, 2.5);
        estoqueProdutos.adicionarProduto(2L, "Borracha", 6, 1.75);
        estoqueProdutos.adicionarProduto(3L, "Lápis", 8, 3);
        estoqueProdutos.adicionarProduto(4L, "Caderno", 1, 17.90);
        estoqueProdutos.exibirProdutos();
        System.out.println("O valor total do estoque é: R$ " + estoqueProdutos.calcularValorTotalEstoque());
        System.out.println("O produto mais caro do estoque é: " + estoqueProdutos.obterProdutoMaisCaro());
        System.out.println("O produto mais barato do estoque é: " + estoqueProdutos.obterProdutoMaisBarato());
        System.out.println("O produto com maior valor total do estoque é: " +
                estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());

    }

}
