import factory.SalaFactory;
import factory.TipoSala;
import model.*;
import repository.ReservaRepository;
import strategy.PoliticaDeReserva;
import strategy.PoliticaPrimeiroAReservar;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        ReservaRepository repository = ReservaRepository.getInstance();

        Sala sala = SalaFactory.criarSala(TipoSala.GRUPO, "Sala 202");

        Usuario aluno = new Usuario("Breno", TipoUsuario.ESTUDANTE);

        Reserva reserva1 = new Reserva(
                aluno,
                sala,
                LocalDateTime.of(2026, 5, 20, 10, 0),
                LocalDateTime.of(2026, 5, 20, 11, 0)
        );

        Reserva reserva2 = new Reserva(
                aluno,
                sala,
                LocalDateTime.of(2026, 5, 20, 10, 30),
                LocalDateTime.of(2026, 5, 20, 11, 30)
        );

        PoliticaDeReserva politica = new PoliticaPrimeiroAReservar();

        repository.adicionarReserva(reserva1);

        if (politica.podeReservar(reserva2, repository.listarReservas())) {
            repository.adicionarReserva(reserva2);
            System.out.println("Reserva criada com sucesso.");
        } else {
            System.out.println("Reserva negada: conflito de horário.");
        }
    }
}