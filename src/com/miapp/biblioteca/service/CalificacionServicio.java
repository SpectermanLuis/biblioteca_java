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

    // ingresar nueva puntuacion / calificacion
    public void crearCalificacion(String idUsuario, String isbn, String estrellas, String comentario) {
        Calificacion nuevaCalificacion = new Calificacion(idUsuario,isbn,estrellas,comentario);
        calificaciones.add(nuevaCalificacion);
    }


    public ArrayList<Calificacion> obtenerCalificaciones() {
        {
            return calificaciones;
        }
    }

    // buscar calificaciones por Usuario
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


    // buscar calificaciones por Usuario
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
