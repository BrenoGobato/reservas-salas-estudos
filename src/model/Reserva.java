package model;

import java.time.LocalDateTime;

public class Reserva {

    private Usuario usuario;
    private Sala sala;
    private LocalDateTime inicio;
    private LocalDateTime fim;

    public Reserva(Usuario usuario, Sala sala,
                   LocalDateTime inicio,
                   LocalDateTime fim) {

        this.usuario = usuario;
        this.sala = sala;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Sala getSala() {
        return sala;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }
}