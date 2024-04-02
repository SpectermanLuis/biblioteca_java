package com.miapp.biblioteca;

public class Libro {
    private String titulo;        // titulo del libro
    private String autor;         // autor del libro
    private String ISBN;          // identificador isbn del libro
    private String genero;        // genero del libro
    private boolean disponible;   // estado de disponibilidad del libro  ( true = disponible  false = no disponible
    private String editorial;     // editorial del libro

   public Libro() {
   }

    public Libro(String titulo, String autor, String ISBN, String genero,String editorial, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.genero = genero;
        this.editorial = editorial;
        this.disponible = disponible;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", genero='" + genero + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}
