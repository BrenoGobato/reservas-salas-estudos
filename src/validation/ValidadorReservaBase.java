package validation;

import model.Reserva;
import java.util.List;

public abstract class ValidadorReservaBase implements ValidadorReserva {

    protected ValidadorReserva proximo;

    @Override
    public void setProximo(ValidadorReserva proximo) {
        this.proximo = proximo;
    }

    @Override
    public boolean validar(Reserva reserva, List<Reserva> reservasExistentes) {
        if (!executarValidacao(reserva, reservasExistentes)) {
            return false;
        }

        if (proximo != null) {
            return proximo.validar(reserva, reservasExistentes);
        }

        return true;
    }

    protected abstract boolean executarValidacao(Reserva reserva, List<Reserva> reservasExistentes);
}
