package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itens = new ArrayList<>();

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        Item item = new Item(nome, preco, quantidade);
        itens.add(item);
    }

    public void removerItem(String nome) {

        List<Item> itensParaRemover = new ArrayList<>();

        if (itens.isEmpty()) {
            System.out.println("A lista já está vazia.");
        } else {
            for (Item item : itens) {
                if (item.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(item);
                }
            }
            itens.removeAll(itensParaRemover);
        }
    }

    public double calcularValorTotal() {

        double valorTotal = 0d;

        if (itens.isEmpty()) {
            throw new RuntimeException("A lista está vazia.");
        } else {
            for (Item item : itens) {
                valorTotal += (item.getPreco() * item.getQuantidade());
            }
            return valorTotal;
        }
    }

    public void exibirItens() {

        if (itens.isEmpty()) {
            System.out.println("A lista está vazia.");
        } else {
            for (Item item : itens) {
                System.out.println(item);
            }
        }

    }

    public static void main(String[] args) {

        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        System.out.println(carrinhoDeCompras.calcularValorTotal());
        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.adicionarItem("Batata", 5.5, 2);
        carrinhoDeCompras.adicionarItem("Abacaxi", 13, 5);
        carrinhoDeCompras.adicionarItem("Cebola", 3.5, 2);

        System.out.println("Valor total do carrinho: " + carrinhoDeCompras.calcularValorTotal());
        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.removerItem("Cebola");

        System.out.println("Valor total do carrinho: " + carrinhoDeCompras.calcularValorTotal());
        carrinhoDeCompras.exibirItens();

    }

}
