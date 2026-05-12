import model.*;

public class Main {

    public static void main(String[] args) {

        Usuario usuario =
                new Usuario("Breno", TipoUsuario.ESTUDANTE);

        Sala sala =
                new SalaGrupo("Sala 101");

        System.out.println(usuario.getNome());
        System.out.println(sala.getNome());
    }
}