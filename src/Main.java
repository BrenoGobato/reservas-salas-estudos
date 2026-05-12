import factory.SalaFactory;
import factory.TipoSala;
import model.*;
import service.ReservaService;
import strategy.PoliticaPrimeiroAReservar;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        ReservaService reservaService =
                new ReservaService(new PoliticaPrimeiroAReservar());

        Usuario aluno = new Usuario("Breno", TipoUsuario.ESTUDANTE);

        Sala sala = SalaFactory.criarSala(TipoSala.GRUPO, "Sala 202");

        Reserva reserva = reservaService.criarReserva(
                aluno,
                sala,
                LocalDateTime.of(2026, 5, 20, 10, 0),
                LocalDateTime.of(2026, 5, 20, 11, 0)
        );

        reservaService.criarReserva(
                aluno,
                sala,
                LocalDateTime.of(2026, 5, 20, 10, 30),
                LocalDateTime.of(2026, 5, 20, 11, 30)
        );

        if (reserva != null) {
            reservaService.modificarReserva(
                    reserva.getId(),
                    LocalDateTime.of(2026, 5, 20, 12, 0),
                    LocalDateTime.of(2026, 5, 20, 13, 0)
            );

            reservaService.cancelarReserva(reserva.getId());
        }
    }
}