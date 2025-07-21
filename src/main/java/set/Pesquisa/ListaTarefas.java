package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {

    private Set<Tarefa> tarefas;

    public ListaTarefas() {
        this.tarefas = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {

        verificarSetVazio();

        Tarefa tarefaParaRemover = null;
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefaParaRemover = tarefa;
                break;
            }
        }

        if (tarefaParaRemover == null) {
            System.out.println("Tarefa não encontrada.");
        } else {
            tarefas.remove(tarefaParaRemover);
            System.out.println("Tarefa \"" + tarefaParaRemover.getDescricao() + "\" removida com sucesso.");
        }

    }

    public void exibirTarefas() {
        verificarSetVazio();
        System.out.println(tarefas);
    }

    public int contarTarefas() {
        return tarefas.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        verificarSetVazio();
        Set<Tarefa> tarefasConcluidas = new HashSet<>();

        for (Tarefa tarefa : tarefas) {
            if (tarefa.isConcluida()) {
                tarefasConcluidas.add(tarefa);
            }
        }

        return tarefasConcluidas;
    }
    public Set<Tarefa> obterTarefasPendentes() {
        verificarSetVazio();
        Set<Tarefa> tarefasPendentes = new HashSet<>();

        for (Tarefa tarefa : tarefas) {
            if (!tarefa.isConcluida()) {
                tarefasPendentes.add(tarefa);
            }
        }

        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                if (tarefa.isConcluida()) {
                    System.out.println("A tarefa \"" + tarefa.getDescricao() + "\" já está concluída.");
                } else {
                    tarefa.setConcluida(true);
                }
                break;
            }
        }
    }
    public void marcarTarefaPendente(String descricao) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                if (tarefa.isConcluida()) {
                    tarefa.setConcluida(false);
                } else {
                    System.out.println("A tarefa \"" + tarefa.getDescricao() + "\" já está pendente.");
                }
                break;
            }
        }
    }

    public void limparListaTarefas() {
        verificarSetVazio();
        tarefas.clear();
    }

    public void verificarSetVazio() {
        if (tarefas.isEmpty()) {
            throw new RuntimeException("A lista de tarefas está vazia.");
        }
    }

    public static void main(String[] args) {

        ListaTarefas listaTarefas = new ListaTarefas();

        // Teste 1: Adicionar tarefas
        System.out.println("== Teste 1: Adicionar tarefas ==");
        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Ler livro");
        listaTarefas.adicionarTarefa("Fazer exercícios");
        listaTarefas.adicionarTarefa("Estudar Java"); // Testar inserção de elemento duplicado
        listaTarefas.exibirTarefas();

        // Teste 2: Contar tarefas
        System.out.println("\n== Teste 2: Contar tarefas ==");
        System.out.println("Total de tarefas: " + listaTarefas.contarTarefas());

        // Teste 3: Marcar tarefa como concluída
        System.out.println("\n== Teste 3: Marcar tarefa como concluída ==");
        listaTarefas.marcarTarefaConcluida("Estudar Java");
        listaTarefas.marcarTarefaConcluida("Estudar Java"); // Já concluída
        listaTarefas.marcarTarefaConcluida("Ler livro");

        // Teste 4: Obter tarefas concluídas
        System.out.println("\n== Teste 4: Tarefas concluídas ==");
        Set<Tarefa> concluidas = listaTarefas.obterTarefasConcluidas();
        for (Tarefa tarefa : concluidas) {
            System.out.println(tarefa);
        }

        // Teste 5: Obter tarefas pendentes
        System.out.println("\n== Teste 5: Tarefas pendentes ==");
        Set<Tarefa> pendentes = listaTarefas.obterTarefasPendentes();
        for (Tarefa tarefa : pendentes) {
            System.out.println(tarefa);
        }

        // Teste 6: Marcar como pendente
        System.out.println("\n== Teste 6: Marcar tarefa como pendente ==");
        listaTarefas.marcarTarefaPendente("Estudar Java");
        listaTarefas.marcarTarefaPendente("Estudar Java"); // Já pendente
        listaTarefas.exibirTarefas();

        // Teste 7: Remover tarefa existente
        System.out.println("\n== Teste 7: Remover tarefa existente ==");
        listaTarefas.removerTarefa("Fazer exercícios");
        listaTarefas.exibirTarefas();

        // Teste 8: Remover tarefa inexistente
        System.out.println("\n== Teste 8: Remover tarefa inexistente ==");
        listaTarefas.removerTarefa("Dormir");

        // Teste 9: Limpar todas as tarefas
        System.out.println("\n== Teste 9: Limpar lista de tarefas ==");
        listaTarefas.limparListaTarefas();
        try {
            listaTarefas.exibirTarefas(); // Deve lançar exceção
        } catch (RuntimeException e) {
            System.out.println("Exceção esperada: " + e.getMessage());
        }

    }

}