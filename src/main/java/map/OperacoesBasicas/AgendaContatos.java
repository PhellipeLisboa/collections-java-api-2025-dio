package main.java.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {

    private Map<String, Integer> contatos;

    public AgendaContatos() {
        this.contatos = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        contatos.put(nome, telefone);
    }

    public void removerContato(String nome) {
        verificarMapVazio();
        contatos.remove(nome);
    }

    public void exibirContatos() {
        System.out.println(contatos);
    }

    public Integer pesquisarPorNome(String nome) {
        verificarMapVazio();
        Integer numeroPorNome = null;
        numeroPorNome = contatos.get(nome);
        return numeroPorNome;
    }

    public void verificarMapVazio() {
        if (contatos.isEmpty()) {
            throw new RuntimeException("A agenda está vazia.");
        }
    }

    public static void main(String[] args) {

        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Phellipe", 234567);
        agendaContatos.adicionarContato("Phellipe", 9845);
        agendaContatos.adicionarContato("Mario", 394584);
        agendaContatos.adicionarContato("Juliana", 394463);
        agendaContatos.adicionarContato("Pedro", 724562);
        agendaContatos.adicionarContato("Phellipe", 50000);

        agendaContatos.exibirContatos();
        agendaContatos.removerContato("Pedro");
        agendaContatos.exibirContatos();

        System.out.println("O número da Juliana é: " + agendaContatos.pesquisarPorNome("Juliana"));

    }

}
