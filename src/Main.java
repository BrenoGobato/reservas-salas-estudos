import factory.SalaFactory;
import factory.TipoSala;
import model.Sala;
import repository.ReservaRepository;

public class Main {

    public static void main(String[] args) {

        ReservaRepository repository = ReservaRepository.getInstance();

        Sala sala1 = SalaFactory.criarSala(TipoSala.INDIVIDUAL, "Sala 101");
        Sala sala2 = SalaFactory.criarSala(TipoSala.GRUPO, "Sala 202");

        repository.adicionarSala(sala1);
        repository.adicionarSala(sala2);

        for (Sala sala : repository.listarSalas()) {
            System.out.println(sala.getNome());
        }
    }
}