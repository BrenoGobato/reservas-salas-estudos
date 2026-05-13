import factory.SalaFactory;
import factory.TipoSala;
import model.*;
import service.ReservaService;
import strategy.PoliticaPrimeiroAReservar;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ReservaService reservaService =
                new ReservaService(new PoliticaPrimeiroAReservar());

        Sala sala101 = SalaFactory.criarSala(TipoSala.INDIVIDUAL, "Sala 101");
        Sala sala202 = SalaFactory.criarSala(TipoSala.GRUPO, "Sala 202");
        Sala lab01 = SalaFactory.criarSala(TipoSala.LABORATORIO, "Lab 01");

        reservaService.adicionarSala(sala101);
        reservaService.adicionarSala(sala202);
        reservaService.adicionarSala(lab01);

        Usuario aluno = new Usuario("Breno", TipoUsuario.ESTUDANTE);

        reservaService.criarReserva(
                aluno,
                sala202,
                LocalDateTime.of(2026, 5, 20, 10, 0),
                LocalDateTime.of(2026, 5, 20, 11, 0)
        );

        List<Sala> disponiveis = reservaService.listarSalasDisponiveis(
                LocalDateTime.of(2026, 5, 20, 10, 30),
                LocalDateTime.of(2026, 5, 20, 11, 30)
        );

        System.out.println("Salas disponíveis:");

        for (Sala sala : disponiveis) {
            System.out.println("- " + sala.getNome());
        }
    }
}