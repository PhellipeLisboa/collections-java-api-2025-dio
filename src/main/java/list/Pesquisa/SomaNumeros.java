package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {

    private List<Integer> numeros;

    public SomaNumeros() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numeros.add(numero);
    }

    public int calcularSoma() {

        int soma = 0;
        for (Integer numero : numeros) {
            soma += numero;
        }
        return soma;

    }

    public int encontrarMaiorNumero() {

        int maiorNumero = Integer.MIN_VALUE;
        if (numeros.isEmpty()) {
            throw new RuntimeException("A lista está vazia!");
        }

        for (Integer numero : numeros) {
            if (numero >= maiorNumero) {
                maiorNumero = numero;
            }
        }

        return maiorNumero;
    }

    public int encontrarMenorNumero() {

        int menorNumero = Integer.MAX_VALUE;
        if (numeros.isEmpty()) {
            throw new RuntimeException("A lista está vazia!");
        }

        for (Integer numero : numeros) {
            if (numero <= menorNumero) {
                menorNumero = numero;
            }

        }
        return menorNumero;
    }

    public List<Integer> exibirNumeros() {

        if (numeros.isEmpty()) {
            throw new RuntimeException("A lista está vazia!");
        }
        return numeros;

    }

    public static void main(String[] args) {

        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(9);
        somaNumeros.adicionarNumero(3);
        somaNumeros.adicionarNumero(7);
        somaNumeros.adicionarNumero(2);
        System.out.println("A soma dos números é: " +somaNumeros.calcularSoma());
        System.out.println("O maior número é: " + somaNumeros.encontrarMaiorNumero());
        System.out.println("O menor número é: " + somaNumeros.encontrarMenorNumero());
        System.out.println("Números na lista: " + somaNumeros.exibirNumeros());

    }

}
