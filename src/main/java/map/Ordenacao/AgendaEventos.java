package main.java.map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {

    private Map<LocalDate, Evento> agenda;

    public AgendaEventos() {
        this.agenda = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        agenda.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda() {

        try {
            verificarMapVazio();
            Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(agenda);
            System.out.println(eventosTreeMap);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    public void obterProximoEvento() {

        try {
            LocalDate dataAtual = LocalDate.now();
            LocalDate proximaData = null;
            Evento proximoEvento = null;

            Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(agenda);
            for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {

                if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                    proximaData = entry.getKey();
                    proximoEvento = entry.getValue();
                    System.out.println("O próximo evento: " + proximoEvento + " acontecerá na data " + proximaData);
                    break;
                }

            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }


    }

    public void verificarMapVazio() {
        if (agenda.isEmpty()) {
            throw new RuntimeException("Nenhum evento registrado na agenda.");
        }
    }

    public static void main(String[] args) {

        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2025, Month.JULY, 23), "Evento 0",
                "Atracao 0");
        agendaEventos.adicionarEvento(LocalDate.of(2025, 7, 9), "Evento 2",
                "Atracao 2");
        agendaEventos.adicionarEvento(LocalDate.of(2000, Month.JANUARY, 22), "Evento 3",
                "Atracao 3");
        agendaEventos.adicionarEvento(LocalDate.of(2027, Month.SEPTEMBER, 8), "Evento 4",
                "Atracao 4");
        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();

    }

}
