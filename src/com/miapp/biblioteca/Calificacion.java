package com.miapp.biblioteca;

public class Calificacion {

    private String idUsuario;
    private String isbn;
    private int estrellas;
    private String comentario;


    public Calificacion(String idUsuario, String isbn, int estrellas, String comentario) {
        this.idUsuario = idUsuario;
        this.isbn = isbn;
        this.estrellas = estrellas;
        this.comentario = comentario;
    }

    public Calificacion() {
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Calificaciones{" +
                "idUsuario='" + idUsuario + '\'' +
                ", isbn='" + isbn + '\'' +
                ", estrellas=" + estrellas +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
