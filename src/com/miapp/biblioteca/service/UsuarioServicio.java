package com.miapp.biblioteca.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;
public class UsuarioServicio {
    private ArrayList<Usuario> usuarios;

    public UsuarioServicio(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     *  Metodo : crearUsuario
     *           Crea un nuevo usuario con los datos ingresados por teclado
     * @param nombre  Nombre del Usuario
     * @param id      Identificacion del Usuario
     */
    public void crearUsuario(String nombre, String id) {
        Usuario nuevoUsuario = new Usuario(nombre, id);
        usuarios.add(nuevoUsuario);
        System.out.println("NUEVO USUARIO INGRESADO OK !");
    }

    /**
     *  Metodo : obtenerTodosLosUsuarios
     *           Obtiene todos los usuarios creados
     * @return   Devuelve un ArrayList con todos los usuarios
     */
    public ArrayList<Usuario> obtenerTodosLosUsuarios() {
        return usuarios;
    }

    /**
     *  Metodo : buscarUsuarioPorId
     *           Busca si existe un deterrminado usuario segun un Id ingresado
     * @param id  Identificador de usuario a buscar
     * @return    Si encuentra la existencia del usuario , devuelve un objeto usuario
     *            En caso contrario devuelve null
     */
    public Usuario buscarUsuarioPorId(String id) {
        for(Usuario usuario : usuarios){
            if(usuario.getId().equals(id))
            {
                return usuario;
            }
        }
        return null;  // no encuentra usuario , retorna null
    }

    /**
     *  Metodo buscarUsuarioPorCondicion
     *         Busca los usuarios que cumplan cierta condicion
     *         Sirve para realizar busquedas varias segun un criterio indicado
     *
     * @param criterioBusqueda  : seleccion de criterio de busqueda.
     *                            Los valores podran ser : nombre
     *                            Por el momento es el unico criterio , pero se podran agregar
     *                            nuevos criterios si se ingresaran mas datos al usuario
     *
     * @param terminoBusqueda   : texto a buscar en los usuarios existentes segun el criterio indicado
     *                            en criterioBusqueda
     *
     * @return                  : devuelve un ArrayList con los usuarios encontrados segun criterio y termino
     *                            de busqueda
     */
    public ArrayList<Usuario> buscarUsuarioPorCondicion(String criterioBusqueda ,String terminoBusqueda)
    {

        ArrayList<Usuario> usuariosEncontrados = new ArrayList<>();

        for(Usuario usuario : usuarios){
            if (criterioBusqueda.equalsIgnoreCase("nombre") && usuario.getNombre().equalsIgnoreCase(terminoBusqueda)) {
                usuariosEncontrados.add(usuario);
            }
        }
        return usuariosEncontrados;
    }

    // actualizar un usuario

    /**
     *  Metodo actualizarUsuario
     *  Actualiza datos del usuario
     * @param id  identificacion del usuario a modificar
     * @param nombreActualizado  nuevo nombre de usuario para reemplazar al actual
     */
    public void actualizarUsuario(String id, String nombreActualizado) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                usuario.setNombre(nombreActualizado);
                return;
            }
        }

    }

    /**
     *  Metodo : eliminarUsuario
     *  Eliminar un usuario determinado
     * @param id  = identificacion del usuario a eliminar
     */
    public void eliminarUsuario(String id){
        Iterator<Usuario> it = usuarios.iterator();

        while (it.hasNext()) {
            if (it.next().getId().equals(id)) {
                it.remove();
            }
        }

    }

    /**
     * Metodo : prestarLibro
     *          Cambia el estado del libro de disponible (true) a no disponible (false)
     *
     * @param usuario  Usuario a quien se le prestara un libro
     * @param libro    Libro que sera entregado en prestamo al Usuario
     */
    public void prestarLibro(Usuario usuario, Libro libro) {
        if(libro.isDisponible()) {
           usuario.getLibrosPrestados().add(libro);
           libro.setDisponible(false);
        } else {
            System.out.println("El libro no esta disponible");
        }
    }

    /**
     *  Metodo obtenerLibrosPrestados
     *         Obtiene de un usuario determinado la lista de libros
     *         que tiene entregados en prestamo
     *
     * @param usuario Objeto de un usuario determinado
     *
     * @return  Arraylist con la lista de libros prestados al usuario
     */
    public ArrayList<Libro> obtenerLibrosPrestados(Usuario usuario) {
        return usuario.getLibrosPrestados();
}

    /**
     *  Metodo : devolverLibro
     *           Se cambia la marca de no disponible a disponible
     *           en el libro indicado del usuario indicado que
     *           esta devolviendo el libro prestado
     * @param usuario Usuario que devuelve el libro
     * @param libro   Libro que esta siendo devuelto
     *
     *                Se quitara el libro de la lista de libros en prestado del usuario
     *                y se pondra la marca de disponible en true
     */
    public void devolverLibro(Usuario usuario , Libro libro)
    {
       if(usuario.getLibrosPrestados().contains(libro)) {
           usuario.getLibrosPrestados().remove(libro);
           libro.setDisponible(true);
       } else {
           System.out.println("Este libro no fue prestado al Usuario!");
       }
    }

    /**
     *  Metodo : obtenerUsuarioConLibrosPrestados
     *           Se obtiene la lista de usuarios que tienen libros en condicion de prestamo
     * @return   Devuelve un ArrayList con los usuarios cuya lista de libros prestados no este vacia
     */
     public ArrayList<Usuario> obtenerUsuariosConLibrosPrestados()
     {
         ArrayList<Usuario> usuariosEncontrados = new ArrayList<>();
         ArrayList<Libro>   librosPrestados     = new ArrayList<>();

         for(Usuario usuario : usuarios){
             librosPrestados = obtenerLibrosPrestados(usuario);
             if (!librosPrestados.isEmpty()) {
                 usuariosEncontrados.add(usuario);
             }
         }
     return usuariosEncontrados;
 }

}
