package com.miapp.biblioteca.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.biblioteca.Libro;

public class LibroServicio {
   private ArrayList<Libro> biblioteca;

    public LibroServicio(ArrayList<Libro> biblioteca) {
        this.biblioteca = biblioteca;
    }

    // Crear un nuevo libro en la biblioteca
    public void crearLibro(String titulo, String autor, String ISBN ,String genero, String editorial)
    {
        Libro nuevoLibro = new Libro(titulo,autor,ISBN,genero,editorial,true);
        biblioteca.add(nuevoLibro);
        System.out.println("NUEVO LIBRO INGRESADO A LA BIBLIOTECA OK !");
    }

    // Obtener todos los libros de la biblioteca
    public ArrayList<Libro> obtenerTodosLosLibros()
    {
     return biblioteca;
    }

    public void actualizarLibro(String ISBN, String tituloActualizado, String autorActualizado,
                                String generoActualizado, String editorialActualizado)
    {
        for(Libro libro :biblioteca){
            if (libro.getISBN().equals(ISBN)) {

                if (!(tituloActualizado.isEmpty() || tituloActualizado.trim().isEmpty())) {
                    libro.setTitulo(tituloActualizado);
                }

                if (!(autorActualizado.isEmpty() || autorActualizado.trim().isEmpty())) {
                   libro.setAutor(autorActualizado);
                }

                if (!(generoActualizado.isEmpty() || generoActualizado.trim().isEmpty())) {
                   libro.setGenero(generoActualizado);
                }

               if (!(editorialActualizado.isEmpty() || editorialActualizado.trim().isEmpty())) {
                   libro.setEditorial(editorialActualizado);
               }

            }

        }

    }

    // Eliminar libro de la biblioteca
    public void eliminarLibro(String ISBN)
    {
        Iterator<Libro> it = biblioteca.iterator();
        while(it.hasNext()){
            if(it.next().getISBN().equals(ISBN)){
                it.remove();
            }
        }
    }

    // buscar libro por ISBN
    public Libro buscarLibroPorISBN(String ISBN) {
      for(Libro libro : biblioteca){
         if(libro.getISBN().equals(ISBN))
         {
           return libro;
         }
      }
     return null;  // no encuentra libro , retorna null

    }

    // buscar libros por titulo
    public ArrayList<Libro> buscarLibroPorTitulo(String titulo)
    {
      ArrayList<Libro> librosEncontrados = new ArrayList<>();
      for(Libro libro : biblioteca){
          if (libro.getTitulo().equalsIgnoreCase(titulo))
          {
            librosEncontrados.add(libro);
          }
      }
      return librosEncontrados;
    }


    // buscar libros segun condicion  titulo , autor , genero , editorial
    public ArrayList<Libro> buscarLibroPorCondicion(String criterioBusqueda ,String terminoBusqueda)
    {
        ArrayList<Libro> librosEncontrados = new ArrayList<>();
        for(Libro libro : biblioteca){
            if (criterioBusqueda.equalsIgnoreCase("titulo") && libro.getTitulo().equalsIgnoreCase(terminoBusqueda)) {
                librosEncontrados.add(libro);
            } else if (criterioBusqueda.equalsIgnoreCase("autor") && libro.getAutor().equalsIgnoreCase(terminoBusqueda)) {
                librosEncontrados.add(libro);
            } else if (criterioBusqueda.equalsIgnoreCase("genero") && libro.getGenero().equalsIgnoreCase(terminoBusqueda)) {
                librosEncontrados.add(libro);
            } else if (criterioBusqueda.equalsIgnoreCase("editorial") && libro.getEditorial().equalsIgnoreCase(terminoBusqueda)) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }


    // buscar libros no disponibles ( Estan en prestamo )
    public ArrayList<Libro> obtenerLibrosEnPrestamo()
    {
        ArrayList<Libro> librosEncontrados = new ArrayList<>();
        for(Libro libro : biblioteca){
            if (!libro.isDisponible())
            {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }

    public boolean verificarDisponibilidad(Libro libro){
        return libro.isDisponible();
    }

}
