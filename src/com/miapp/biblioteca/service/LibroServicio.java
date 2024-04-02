package com.miapp.biblioteca.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.biblioteca.Libro;

public class LibroServicio {
   private ArrayList<Libro> biblioteca;

    public LibroServicio(ArrayList<Libro> biblioteca) {
        this.biblioteca = biblioteca;
    }

    /**
     *  Metodo : crearLibro
     *           Crear un nuevo libro en la biblioteca con los datos ingresados
     *
     * @param titulo    Titulo del Libro
     * @param autor     Autor del Libro
     * @param ISBN      Codigo ISBN del Libro ( se usara como clave principal )
     * @param genero    Genero del Libro
     * @param editorial Editorial del Libro
     *
     */
    public void crearLibro(String titulo, String autor, String ISBN ,String genero, String editorial)
    {
        Libro nuevoLibro = new Libro(titulo,autor,ISBN,genero,editorial,true);
        biblioteca.add(nuevoLibro);
        System.out.println("NUEVO LIBRO INGRESADO A LA BIBLIOTECA OK !");
    }

    /**
     *  Metodo : obtenerTodosLosLibros
     *           Obtener todos los libros existentes en la biblioteca
     *
     * @return   Devuelve un ArrayList con todos los libros de la biblioteca
     */
    public ArrayList<Libro> obtenerTodosLosLibros()
    {
     return biblioteca;
    }


    /**
     *  Metodo : actualizarLibro
     *           Actualiza un libro de la biblioteca segun los datos ingresados
     * @param ISBN          codigo ISBN del libro , clave de busqueda
     * @param tituloActualizado    Nuevo Valor Ingresado para el titulo del libro
     * @param autorActualizado     Nuevo Valor Ingresado para el autor del libro
     * @param generoActualizado    Nuevo Valor Ingresado para el genero del libro
     * @param editorialActualizado Nuevo Valor Ingresado para la editorial del libro
     */
    public void actualizarLibro(String ISBN, String tituloActualizado, String autorActualizado,
                                String generoActualizado, String editorialActualizado)
    {
        for(Libro libro :biblioteca){
            if (libro.getISBN().equals(ISBN)) {

                // solo se actualizan los campos necesarios cuando hubo ingreso de datos
                // si se detecta que no se ingreso nada , permanece el dato original

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

    /**
     *  Metodo :  eliminarLibro
     *            Elimina un libro de la biblioteca
     *            Para que pueda ser eliminado , debera tener la condicion de Disponible.
     *            En caso contrario no se eliminara porque tiene que ser devuelve a la
     *            biblioteca previamente
     *
     * @param ISBN  Identificador ISBN del libro que se quiere eliminar
     *
     */
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


    /**
     * Metodo : buscarLibroPorISBN
     *          Busca un libro por su codigo de ISBN
     *
     * @param ISBN  Codigo ISBN a buscar
     *
     * @return   En caso que se encuentre , devuelve el objeto libro correspondiente
     *           Si no lo encuentre , se devuelve un valor null
     */
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
    // public ArrayList<Libro> buscarLibroPorTitulo(String titulo)
    //{
    //  ArrayList<Libro> librosEncontrados = new ArrayList<>();
    //  for(Libro libro : biblioteca){
    //      if (libro.getTitulo().equalsIgnoreCase(titulo))
    //      {
    //        librosEncontrados.add(libro);
    //      }
    //  }
    //  return librosEncontrados;
    //}


    /**
     *  Metodo :                  buscarLibroPorCondicion
     *                            Este sirve para realizar busquedas varias segun un criterio indicado
     *
     * @param criterioBusqueda  : seleccion de criterio de busqueda.
     *                            Los valores podran ser : titulo , autor , genero  o editorial
     *
     * @param terminoBusqueda   : texto a buscar en los libros existentes segun el criterio indicado
     *                            en criterioBusqueda
     * @return                  : devuelve un ArrayList con los libros encontrados segun criterio y termino
     *                            de busqueda
     */
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


    /**
     *  Metodo :     obtenerLibrosEnPrestamo
     *               Obtener todos los libros cuya condicion Disponible este en false , o sea
     *               estan entregados en prestamo
     *
     * @return       devuelve un ArrayList con todos los libros encontrados como no disponibles
     *               por estar entregados en prestamo
     *
     */
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

    /**
     *  Metodo : verificarDisponibilidad
     *           Verificar si un un libro determinado esta disponible para ser entregado en prestamo o
     *           ya esta prestado
     *
     * @param libro  Libro a verificar estado de disponibilidad.
     *
     * @return       True = Disponible  False = No Disponible
     */
    public boolean verificarDisponibilidad(Libro libro){
        return libro.isDisponible();
    }

}
