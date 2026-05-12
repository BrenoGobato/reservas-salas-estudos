import factory.SalaFactory;
import factory.TipoSala;
import model.Sala;

public class Main {

    public static void main(String[] args) {

        Sala sala1 = SalaFactory.criarSala(TipoSala.INDIVIDUAL, "Sala 101");
        Sala sala2 = SalaFactory.criarSala(TipoSala.GRUPO, "Sala 202");
        Sala sala3 = SalaFactory.criarSala(TipoSala.LABORATORIO, "Lab 01");

        System.out.println(sala1.getNome());
        System.out.println(sala2.getNome());
        System.out.println(sala3.getNome());
    }
}