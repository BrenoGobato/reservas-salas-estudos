package validation;

import model.Reserva;
import java.util.List;

public interface ValidadorReserva {

    void setProximo(ValidadorReserva proximo);

    boolean validar(Reserva reserva, List<Reserva> reservasExistentes);
}
