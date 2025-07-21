package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {

    private Set<Contato> contatos;

    public AgendaContatos() {
        this.contatos = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        contatos.add(new Contato(nome, numero));
    }

    public void exibirContatos() {
        verificarSetVazio();
        System.out.println(contatos);
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        verificarSetVazio();
        Set<Contato> contatosPorNome = new HashSet<>();

        for (Contato contato : contatos) {
            if (contato.getNome().startsWith(nome)) {
                contatosPorNome.add(contato);
            }
        }

        return contatosPorNome;

    }

    public Contato atualizarNumeroContato(String nome, int novoNumero) {

        Contato contatoAtualizado = null;
        for (Contato contato : contatos) {

            if (contato.getNome().equalsIgnoreCase(nome)) {
                contato.setNumero(novoNumero);
                contatoAtualizado = contato;
                break;
            }
        }

        return contatoAtualizado;
    }

    public void verificarSetVazio() {
        if (contatos.isEmpty()) {
            throw new RuntimeException("A lista de contatos está vazia.");
        }
    }

    public static void main(String[] args) {

        AgendaContatos agendaContatos = new AgendaContatos();

//        agendaContatos.exibirContatos();

        agendaContatos.adicionarContato("Phellipe",2345678);
        agendaContatos.adicionarContato("Phellipe",0);
        agendaContatos.adicionarContato("Phellipe Lisboa",99999999);
        agendaContatos.adicionarContato("Phellipe JAVA",56457445);
        agendaContatos.adicionarContato("Joaozinho",4534655);

        agendaContatos.exibirContatos();

        System.out.println(agendaContatos.pesquisarPorNome("Joao"));
        System.out.println("Contato atualizado: " + agendaContatos.atualizarNumeroContato("Joaozinho",
                5555555));

        agendaContatos.exibirContatos();

    }

}
