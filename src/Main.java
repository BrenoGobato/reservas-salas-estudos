import factory.SalaFactory;
import factory.TipoSala;
import model.*;
import service.RelatorioService;
import service.ReservaService;
import strategy.PoliticaPrimeiroAReservar;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        ReservaService reservaService =
                new ReservaService(new PoliticaPrimeiroAReservar());

        RelatorioService relatorioService = new RelatorioService();

        Usuario aluno = new Usuario("Breno", TipoUsuario.ESTUDANTE);
        Usuario professor = new Usuario("Carlos", TipoUsuario.PROFESSOR);

        Sala salaGrupo = SalaFactory.criarSala(TipoSala.GRUPO, "Sala 202");
        Sala laboratorio = SalaFactory.criarSala(TipoSala.LABORATORIO, "Lab 01");

        reservaService.criarReserva(
                aluno,
                salaGrupo,
                LocalDateTime.of(2026, 5, 20, 10, 0),
                LocalDateTime.of(2026, 5, 20, 11, 0)
        );

        reservaService.criarReserva(
                professor,
                laboratorio,
                LocalDateTime.of(2026, 5, 20, 14, 0),
                LocalDateTime.of(2026, 5, 20, 16, 0)
        );

        relatorioService.gerarRelatorioDiario(
                LocalDate.of(2026, 5, 20)
        );
    }
}