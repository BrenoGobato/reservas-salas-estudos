package validation;

import model.Reserva;
import java.time.LocalDateTime;
import java.util.List;

public class ValidadorHorarioValido extends ValidadorReservaBase {

    @Override
    protected boolean executarValidacao(Reserva reserva, List<Reserva> reservasExistentes) {
        LocalDateTime inicio = reserva.getInicio();
        LocalDateTime fim = reserva.getFim();

        if (inicio == null || fim == null) {
            System.out.println("Não foi possível criar reserva: horário de início ou fim inválido.");
            return false;
        }

        if (!inicio.isBefore(fim)) {
            System.out.println("Não foi possível criar reserva: horário de início deve ser anterior ao horário de fim.");
            return false;
        }

        return true;
    }
}
