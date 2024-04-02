package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Calificacion;
import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;

import java.util.ArrayList;

public class CalificacionServicio {

    private ArrayList<Calificacion> calificaciones;

    public CalificacionServicio(ArrayList<Calificacion> calificaciones)
    {
        this.calificaciones = calificaciones;
    }


    /** Metodo : crearCalificacion
     *           Ingresar una nueva calificacion/reseña realizada por un usuario al devolver
     *           un libro que le habia sido prestado
     *
     * @param idUsuario  Identificacion del usuario que esta calificando el libro devuelto
     * @param isbn       codigo isbn del libro que esta siendo calificado
     * @param estrellas  calificacion ingresada por teclado Valores entre 1 y 5 ( 1 muy malo  / 5 excelente)
     * @param comentario reseña ingresada por teclado por el usuario sobre el libro devuelto
     *
     */
    public void crearCalificacion(String idUsuario, String isbn, int estrellas, String comentario) {
        Calificacion nuevaCalificacion = new Calificacion(idUsuario,isbn,estrellas,comentario);
        calificaciones.add(nuevaCalificacion);
    }

    /**
     *  Metodo obtenerCalificaciones
     *         Se obtienen todas las calificaciones existentes al momento de la consulta
     *         de todos los libros y todos los usuarios
     * @return ArrayList con todas las calificaciones/reseñas ingresadas al momento de la consulta
     *
     */
    public ArrayList<Calificacion> obtenerCalificaciones() {
        {
            return calificaciones;
        }
    }

    /**
     * Metodo : buscarCalificacionPorUsuario
     *          Permite obtener todas las calificaciones/Reseñas ingresadas por un usuario determinado
     *
     * @param idUsuario Identificador del usuario sobre el que se estan consultando todas las calificaciones
     *
     * @return  ArrayList con todas las calificaciones realizadas por el usuario hasta el momento de la consulta
     */
    public ArrayList<Calificacion> buscarCalificacionPorUsuario(String idUsuario)
    {
        ArrayList<Calificacion> calificacionesEncontradas = new ArrayList<>();

        for(Calificacion calificacion : calificaciones){
            if (calificacion.getIdUsuario().equalsIgnoreCase(idUsuario))
            {
                calificacionesEncontradas.add(calificacion);
            }
        }
        return calificacionesEncontradas;
    }


    /**
     *  Metodo : buscarCalificacionPorIsbn
     *          Permite obtener todas las calificaciones/Reseñas ingresadas para un libro determinado
     *
     * @param isbn
     * @return
     */
    // buscar calificaciones por libro
    public ArrayList<Calificacion> buscarCalificacionPorIsbn(String isbn)
    {
        ArrayList<Calificacion> calificacionesEncontradas = new ArrayList<>();

        for(Calificacion calificacion : calificaciones){
            if (calificacion.getIsbn().equalsIgnoreCase(isbn))
            {
                calificacionesEncontradas.add(calificacion);
            }
        }
        return calificacionesEncontradas;
    }

}
