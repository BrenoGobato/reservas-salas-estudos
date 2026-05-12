package service;

import model.Reserva;
import model.Sala;
import model.Usuario;
import repository.ReservaRepository;
import strategy.PoliticaDeReserva;

import java.time.LocalDateTime;
import java.util.List;

public class ReservaService {

    private ReservaRepository repository;
    private PoliticaDeReserva politicaDeReserva;

    public ReservaService(PoliticaDeReserva politicaDeReserva) {
        this.repository = ReservaRepository.getInstance();
        this.politicaDeReserva = politicaDeReserva;
    }

    public void alterarPolitica(PoliticaDeReserva novaPolitica) {
        this.politicaDeReserva = novaPolitica;
    }

    public Reserva criarReserva(Usuario usuario, Sala sala,
                                LocalDateTime inicio,
                                LocalDateTime fim) {

        Reserva novaReserva = new Reserva(usuario, sala, inicio, fim);

        if (!politicaDeReserva.podeReservar(novaReserva, repository.listarReservas())) {
            System.out.println("Não foi possível criar reserva: conflito de horário.");
            return null;
        }

        repository.adicionarReserva(novaReserva);
        System.out.println("Reserva criada com sucesso. ID: " + novaReserva.getId());

        return novaReserva;
    }

    public void modificarReserva(int id, LocalDateTime novoInicio, LocalDateTime novoFim) {
        Reserva reserva = repository.buscarReservaPorId(id);

        if (reserva == null) {
            System.out.println("Reserva não encontrada.");
            return;
        }

        List<Reserva> reservasTemporarias = repository.listarReservas();
        reservasTemporarias.remove(reserva);

        Reserva reservaAtualizada = new Reserva(
                reserva.getUsuario(),
                reserva.getSala(),
                novoInicio,
                novoFim
        );

        if (!politicaDeReserva.podeReservar(reservaAtualizada, reservasTemporarias)) {
            System.out.println("Não foi possível alterar reserva: conflito de horário.");
            return;
        }

        reserva.alterarHorario(novoInicio, novoFim);
        System.out.println("Reserva alterada com sucesso.");
    }

    public void cancelarReserva(int id) {
        Reserva reserva = repository.buscarReservaPorId(id);

        if (reserva == null) {
            System.out.println("Reserva não encontrada.");
            return;
        }

        repository.removerReserva(reserva);
        System.out.println("Reserva cancelada com sucesso.");
    }
}