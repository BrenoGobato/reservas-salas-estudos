package validation;

public class ValidadorReservaChainFactory {

    public static ValidadorReserva criarCadeiaValidadores() {
        ValidadorReserva horarioValido = new ValidadorHorarioValido();
        ValidadorReserva salaIndividual = new ValidadorSalaIndividual();

        horarioValido.setProximo(salaIndividual);
        return horarioValido;
    }
}
