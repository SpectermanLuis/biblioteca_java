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

    // crear nuevo usuario
    public void crearUsuario(String nombre, String id) {
        Usuario nuevoUsuario = new Usuario(nombre, id);
        usuarios.add(nuevoUsuario);
    }

    // obtener todos los usuario
    public ArrayList<Usuario> obtenerTodosLosUsuarios() {
        return usuarios;
    }

    public Usuario buscarUsuarioPorId(String id) {
        for(Usuario usuario : usuarios){
            if(usuario.getId().equals(id))
            {
                return usuario;
            }
        }
        return null;  // no encuentra usuario , retorna null
    }

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

    public void prestarLibro(Usuario usuario, Libro libro) {
        if(libro.isDisponible()) {
           usuario.getLibrosPrestados().add(libro);
           libro.setDisponible(false);
        } else {
            System.out.println("El libro no esta disponible");
        }
    }

public ArrayList<Libro> obtenerLibrosPrestados(Usuario usuario) {
        return usuario.getLibrosPrestados();
}

 public void devolverLibro(Usuario usuario , Libro libro)
 {
    if(usuario.getLibrosPrestados().contains(libro)) {
        usuario.getLibrosPrestados().remove(libro);
        libro.setDisponible(true);
    } else {
        System.out.println("Este libro no fue prestado al Usuario!");
    }
 }

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


