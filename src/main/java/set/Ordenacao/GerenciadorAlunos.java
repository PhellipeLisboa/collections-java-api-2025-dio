package main.java.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {

    private Set<Aluno> alunos;

    public GerenciadorAlunos() {
        this.alunos = new HashSet<>();
    }

    public void adicionarAluno(String nome, long matricula, double media) {
        alunos.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula) {
        verificarSetVazio();

        Aluno alunoParaRemover = null;

        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() == matricula) {
                alunoParaRemover = aluno;
                break;
            }
        }

        if (alunoParaRemover == null) {
            System.out.println("Não existe aluno com matrícula " + matricula);
        } else {
            alunos.remove(alunoParaRemover);
            System.out.println("Aluno removido com sucesso.");
        }

    }

    public Set<Aluno> exibirAlunosPorNome() {
        verificarSetVazio();

        Set<Aluno> alunosPorNome = new TreeSet<>(alunos);
        return alunosPorNome;
    }

    public Set<Aluno> exibirAlunosPorNota() {
        verificarSetVazio();

        Set<Aluno> alunosPorMedia = new TreeSet<>(new ComparatorPorMedia());
        alunosPorMedia.addAll(alunos);
        return alunosPorMedia;
    }

    public void exibirAlunos() {
        verificarSetVazio();
        System.out.println(alunos);
    }

    private void verificarSetVazio() {
        if (alunos.isEmpty()) {
            throw new RuntimeException("O conjunto de alunos está vazio.");
        }
    }

    public static void main(String[] args) {

        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adicionarAluno("Jonas", 9878L, 7.8d);
        gerenciadorAlunos.adicionarAluno("Yasmim", 9880L, 3.5d);
        gerenciadorAlunos.adicionarAluno("Alberto", 9883L, 9.0d);
        gerenciadorAlunos.adicionarAluno("Fernanda", 9880L, 6d); // Tentando criar aluno com mesma matrícula
        gerenciadorAlunos.adicionarAluno("Phellipe", 9879L, 9.8d);
        gerenciadorAlunos.adicionarAluno("Juliana", 9888L, 8.2d);
        gerenciadorAlunos.exibirAlunos();
        gerenciadorAlunos.removerAluno(9888L);
        gerenciadorAlunos.exibirAlunos();
        gerenciadorAlunos.removerAluno(2388L); // Remover aluno inexistente

        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());
        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());

    }

}
