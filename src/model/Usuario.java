package model;

import java.util.Objects;

public class Usuario {

    private String nome;
    private TipoUsuario tipo;

    public Usuario(String nome, TipoUsuario tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return Objects.equals(nome, usuario.nome) && tipo == usuario.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, tipo);
    }
} 