package com.miapp.biblioteca;

import com.miapp.biblioteca.service.LibroServicio;
import com.miapp.biblioteca.service.UsuarioServicio;
import com.miapp.biblioteca.service.CalificacionServicio;

// import com.sun.xml.internal.ws.api.client.SelectOptimalEncodingFeature;
import com.miapp.biblioteca.ui.UtilidadesMenu;

// import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Libro>        biblioteca = new ArrayList<>();
        ArrayList<Usuario>      usuarios = new ArrayList<>();
        ArrayList<Calificacion> calificaciones = new ArrayList<>();

        LibroServicio libroServicio = new LibroServicio(biblioteca);
        UsuarioServicio usuarioServicio = new UsuarioServicio(usuarios);
        CalificacionServicio calificacionServicio = new CalificacionServicio(calificaciones);

        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            UtilidadesMenu.mostrarMenuPrincipal();
            System.out.print("Ingresar Opcion : ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    int opcionUsuarios;
                    do {
                        UtilidadesMenu.mostrarMenuUsuarios();
                        System.out.print("Ingresar Opcion : ");
                        opcionUsuarios = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcionUsuarios) {
                            case 1:
                                // Alta nuevo usuario
                                System.out.println("Ingresar Datos Nuevo Usuario");

                                System.out.print("Id. Usuario  :");
                                String idUsuario = scanner.nextLine();

                                System.out.print("Nombre Usuario :");
                                String nombreUsuario = scanner.nextLine();

                                // verificar que id usuario a crear no exista
                                Usuario usuarioVerificar = usuarioServicio.buscarUsuarioPorId(idUsuario);
                                if(usuarioVerificar == null)
                                  {
                                    usuarioServicio.crearUsuario(nombreUsuario, idUsuario);
                                    System.out.println("*********************************");
                                    System.out.println("*  NUEVO USUARIO INGRESADO OK ! *");
                                    System.out.println("*********************************");

                                  } else {
                                    System.out.println("****************************");
                                    System.out.println("*  No se Pudo dar el Alta  *");
                                    System.out.println("*  Id.Usuario YA EXISTE    *");
                                    System.out.println("*    como registrado.!!    *");
                                    System.out.println("****************************");
                                }

                                System.out.println("Presiona Enter para continuar...");
                                scanner.nextLine();
                                break;

                            case 2:
                                // actualizacion usuario
                                System.out.println("Ingresar Id usuario a modificar :");
                                String idUsuarioModificar = scanner.nextLine();

                                //  poner verificar que id usuario a modificar exista
                                Usuario usuarioVerificarm = usuarioServicio.buscarUsuarioPorId(idUsuarioModificar);

                               if(usuarioVerificarm != null) {
                                   System.out.println("Ingrese Nombre Modificado :");
                                   String nuevoNombre = scanner.nextLine();
                                   usuarioServicio.actualizarUsuario(idUsuarioModificar, nuevoNombre);
                                   System.out.println("*****************************");
                                   System.out.println("*  Usuario Modificado Ok !  *");
                                   System.out.println("*****************************");

                               } else {
                                   System.out.println("**************************************");
                                   System.out.println("*  Usuario Ingresado para Modificar  *");
                                   System.out.println("*    NO EXISTE como Registrado       *");
                                   System.out.println("**************************************");
                               }
                                System.out.println("Presiona Enter para continuar...");
                                scanner.nextLine();

                                break;

                            case 3:
                                // eliminar usuario
                                System.out.println("Ingresar el Id del Usuario a eliminar : ");
                                String idUsuarioEliminar = scanner.nextLine();

                                // poner verificar que id usuario a modificar exista
                                Usuario usuarioVerificare = usuarioServicio.buscarUsuarioPorId(idUsuarioEliminar);
                                if(usuarioVerificare != null) {
                                    // verificar que el usuario no tenga libros pendientes de devolver
                                    if(usuarioServicio.obtenerLibrosPrestados(usuarioVerificare).isEmpty()) {
                                        usuarioServicio.eliminarUsuario(idUsuarioEliminar);
                                        System.out.println("****************************");
                                        System.out.println("*  Usuario Eliminado OK !  *");
                                        System.out.println("****************************");

                                    } else {
                                        System.out.println("*********************************************");
                                        System.out.println("*        Usuario NO Se Puede Eliminar       *");
                                        System.out.println("*  por tener libros prestados sin devolver  *");
                                        System.out.println("*********************************************");
                                    }

                                } else {
                                    System.out.println("*************************************************");
                                    System.out.println("* Usuario A Eliminar NO EXISTE como registrado  *");
                                    System.out.println("*************************************************");
                                }
                                System.out.println("Presiona Enter para continuar...");
                                scanner.nextLine();

                                break;

                            case 4:
                                int opcionConsultaUsuarios;
                                do {
                                    UtilidadesMenu.mostrarMenuConsultasUsuarios();
                                    System.out.print("Ingresar Opcion : ");
                                    opcionConsultaUsuarios = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (opcionConsultaUsuarios){
                                        case 1:
                                            ArrayList<Usuario> listaUsuarios = usuarioServicio.obtenerTodosLosUsuarios();
                                            System.out.println("********************************");
                                            System.out.println("* Consulta General de Usuarios *");
                                            System.out.println("********************************");
                                            System.out.println(" ID           Nombre    ");
                                            System.out.println("-----       ----------  ");

                                            for(Usuario usuario: listaUsuarios){
                                                System.out.println(usuario.getId() + "        " + usuario.getNombre() );
                                            }

                                            System.out.println("Presiona Enter para continuar...");
                                            scanner.nextLine();

                                            break;

                                        case 2:
                                            // buscar usuario x id
                                            System.out.print("Ingresar el ID del usuario a buscar : ");
                                            String idBuscar = scanner.nextLine();

                                            Usuario usuarioId = usuarioServicio.buscarUsuarioPorId(idBuscar);

                                            if(usuarioId != null){
                                                System.out.println("Usuario encontrado ");
                                                System.out.println("Id : " + idBuscar);
                                                System.out.println("Nombre : " + usuarioId.getNombre());

                                            } else {
                                                System.out.println("*************************");
                                                System.out.println("* Usuario No Encontrado *");
                                                System.out.println("*************************");
                                            }
                                            System.out.println("Presiona Enter para continuar...");
                                            scanner.nextLine();
                                            break;

                                        case 3:
                                            // buscar usuarios  por Nombre
                                            System.out.println("Ingrese Nombre del Usuario a buscar : ");
                                            String campoBusquedaNombre = scanner.nextLine();
                                            ArrayList<Usuario> usuariosEncontradosNombre  = usuarioServicio.buscarUsuarioPorCondicion("nombre",campoBusquedaNombre);
                                            if(!usuariosEncontradosNombre.isEmpty())
                                            {
                                                System.out.println("Usuarios  Encontrados");
                                                for (Usuario usuario :usuariosEncontradosNombre){
                                                    System.out.println("Id :" + usuario.getId());
                                                    System.out.println("Nombre " + usuario.getNombre());
                                                    System.out.println("-----------------------------------");
                                                }

                                            } else {
                                                System.out.println("******************************************************");
                                                System.out.println("* Ningun Usuario cumple con la condicion de busqueda *");
                                                System.out.println("******************************************************");

                                            }
                                            System.out.println("Presiona Enter para continuar...");
                                            scanner.nextLine();
                                            break;

                                        default:
                                            System.out.println("Opcion Invalida!! Reingresar");
                                    }

                                }while (opcionConsultaUsuarios != 9);
                                break;

                            default:
                                System.out.println("Opcion Invalida!! Reingresar");
                        }

                    }while (opcionUsuarios != 9);
                    break;

                case 2:
                    int opcionLibros;
                    do {
                        UtilidadesMenu.mostrarMenuLibros();
                        System.out.print("Ingresar Opcion : ");
                        opcionLibros  = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcionLibros){
                            case 1:
                                // Alta de un libro
                                System.out.println("Ingresar Datos Nuevo Libro");

                                System.out.print("Titulo Libro :");
                                String titulo = scanner.nextLine();

                                System.out.print("Autor Libro :");
                                String autor = scanner.nextLine();

                                System.out.print("ISBN Libro :");
                                String isbn = scanner.nextLine();

                                System.out.print("Genero Libro :");
                                String genero = scanner.nextLine();

                                System.out.print("Editorial Libro :");
                                String editorial  = scanner.nextLine();

                                Libro libroVerificar = libroServicio.buscarLibroPorISBN(isbn);

                                if(libroVerificar == null) {
                                    libroServicio.crearLibro(titulo, autor, isbn, genero, editorial);
                                    System.out.println("*******************************");
                                    System.out.println("*  NUEVO LIBRO INGRESADO OK ! *");
                                    System.out.println("*******************************");
                                } else {
                                    System.out.println("**************************************");
                                    System.out.println("*     NO se Pudo dar el Alta         *");
                                    System.out.println("*  ISBN YA EXISTE como registrado.!! *");
                                    System.out.println("**************************************");
                                }
                                System.out.println("Presiona Enter para continuar...");
                                scanner.nextLine();
                                break;

                            case 2:
                                // actualizacion libro
                                System.out.println("Ingresar el ISBN libro a modificar :");
                                String isbnModificar = scanner.nextLine();

                                // VERIFICAR QUE EXISTA EL LIBRO A MODIFICAR
                                Libro librom = libroServicio.buscarLibroPorISBN(isbnModificar);

                                if(librom !=null) {
                                    // por ser no null indica que se encontro al libro
                                    // y se puede pedir datos para modificarlo
                                    System.out.println("Ingrese Titulo Modificado :");
                                    String nuevoTitulo = scanner.nextLine();

                                    System.out.println("Ingrese Autor Modificado :");
                                    String nuevoAutor = scanner.nextLine();

                                    System.out.println("Ingrese Genero Modificado :");
                                    String nuevoGenero = scanner.nextLine();

                                    System.out.println("Ingrese Editorial Modificada :");
                                    String nuevoEditorial = scanner.nextLine();

                                    libroServicio.actualizarLibro(isbnModificar, nuevoTitulo, nuevoAutor, nuevoGenero, nuevoEditorial);
                                    System.out.println("****************************");
                                    System.out.println("*  Libro actualizado OK !  *");
                                    System.out.println("****************************");

                                } else {
                                    System.out.println("********************************************");
                                    System.out.println("*  Isbn ingresado del libro para modificar *");
                                    System.out.println("*     NO Existe como registrado            *");
                                    System.out.println("********************************************");
                                }
                                System.out.println("Presiona Enter para continuar...");
                                scanner.nextLine();
                                break;

                            case 3:
                                // eliminar libro de la biblioteca
                                System.out.println("Ingresar el ISBN del libro a eliminar : ");
                                String ISBNLibroEliminar = scanner.nextLine();

                                // verificar que exista el libro a eliminar
                                Libro libroe = libroServicio.buscarLibroPorISBN(ISBNLibroEliminar);

                                if(libroe !=null) {
                                    // verificar que el libro este disponible
                                    // es decir esta fisicamente en la biblioteca
                                    // si no esta disponible es que el usuario
                                    // lo tiene en prestamo todavia

                                    if(libroe.isDisponible()) {
                                        libroServicio.eliminarLibro(ISBNLibroEliminar);
                                        System.out.println("****************************");
                                        System.out.println("*  Libro Eliminado  OK !   *");
                                        System.out.println("****************************");
                                    } else {
                                        System.out.println("*******************************");
                                        System.out.println("*  Libro NO SE PUEDE ELIMINAR *");
                                        System.out.println("*     No esta disponible      *");
                                        System.out.println("*     Esperar devolucion      *");
                                        System.out.println("*******************************");
                                    }

                                } else {
                                    System.out.println("********************************************");
                                    System.out.println("*  Isbn ingresado del libro para Eliminar  *");
                                    System.out.println("*     NO Existe como registrado            *");
                                    System.out.println("********************************************");
                                }
                                System.out.println("Presiona Enter para continuar...");
                                scanner.nextLine();
                                break;

                            case 4:
                                int opcionConsultaLibros;
                                do {
                                    UtilidadesMenu.mostrarMenuConsultasLibros();
                                    System.out.print("Ingresar Opcion : ");
                                    opcionConsultaLibros = scanner.nextInt();
                                    scanner.nextLine();

                                     switch (opcionConsultaLibros){
                                         case 1:
                                             ArrayList<Libro> listaLibros = libroServicio.obtenerTodosLosLibros();

                                             for(Libro libro: listaLibros){
                                                 System.out.println("ISBN: "    + libro.getISBN()   + "   "  +
                                                         "Titulo: "  + libro.getTitulo() + "   "  +
                                                         "Autor : "  + libro.getAutor()  + "  "   +
                                                         "Genero:  " + libro.getGenero() + "  "   +
                                                         "Editorial: " + libro.getEditorial() + "   " +
                                                         "Disponible: " + libro.isDisponible());
                                             }

                                             System.out.println("Presiona Enter para continuar...");
                                             scanner.nextLine();

                                             break;

                                         case 2:
                                             // buscar libro x isbn
                                             System.out.print("Ingresar el ISBN del libro a buscar : ");
                                             String isbnBuscar = scanner.nextLine();
                                             Libro libroISBN = libroServicio.buscarLibroPorISBN(isbnBuscar);
                                             if(libroISBN != null){
                                                 System.out.println("Libro encontrado : " + libroISBN.getTitulo());

                                             } else {
                                                 System.out.println("**************************");
                                                 System.out.println("*  Libro No Encontrado   *");
                                                 System.out.println("**************************");
                                             }
                                             System.out.println("Presiona Enter para continuar...");
                                             scanner.nextLine();

                                            break;

                                         case 3:
                                            // buscar libros por titulo
                                             System.out.println("Ingrese titulo de libro a buscar : ");
                                             String campoBusquedaTitulo = scanner.nextLine();
                                             ArrayList<Libro> librosEncontradosTitulo  = libroServicio.buscarLibroPorCondicion("titulo",campoBusquedaTitulo);
                                             if(!librosEncontradosTitulo.isEmpty())
                                             {
                                                 System.out.println("Libros Encontrados");
                                                 for (Libro libro :librosEncontradosTitulo){
                                                     System.out.println("ISBN: "    + libro.getISBN()   + "   "  +
                                                                        "Titulo: "  + libro.getTitulo() + "   "  +
                                                                        "Autor : "  + libro.getAutor()  + "  "   +
                                                                        "Genero:  " + libro.getGenero() + "  "   +
                                                                        "Editorial: " + libro.getEditorial() + "   " +
                                                                        "Disponible: " + libro.isDisponible());
                                                 }
                                             } else {
                                                 System.out.println("******************************************************");
                                                 System.out.println("*  Ningun libro cumple con la condicion de busqueda  *");
                                                 System.out.println("******************************************************");
                                             }
                                             System.out.println("Presiona Enter para continuar...");
                                             scanner.nextLine();

                                             break;

                                         case 4:
                                             // buscar libros por autor
                                             System.out.println("Ingrese autor de libro a buscar : ");
                                             String campoBusquedaAutor = scanner.nextLine();
                                             ArrayList<Libro> librosEncontradosAutor  = libroServicio.buscarLibroPorCondicion("autor",campoBusquedaAutor);
                                             if(!librosEncontradosAutor.isEmpty())
                                             {
                                                 System.out.println("Libros Encontrados");
                                                 for (Libro libro :librosEncontradosAutor){
                                                     System.out.println("ISBN: "    + libro.getISBN()   + "   "  +
                                                             "Titulo: "  + libro.getTitulo() + "   "  +
                                                             "Autor : "  + libro.getAutor()  + "  "   +
                                                             "Genero:  " + libro.getGenero() + "  "   +
                                                             "Editorial: " + libro.getEditorial() + "   " +
                                                             "Disponible: " + libro.isDisponible());
                                                 }

                                             } else {
                                                 System.out.println("Ningun libro cumple con la condicion de busqueda");
                                             }
                                             System.out.println("Presiona Enter para continuar...");
                                             scanner.nextLine();

                                             break;

                                         case 5:
                                             // buscar libros por genero
                                             System.out.println("Ingrese genero de libro a buscar : ");
                                             String campoBusquedaGenero = scanner.nextLine();
                                             ArrayList<Libro> librosEncontradosGenero  = libroServicio.buscarLibroPorCondicion("genero",campoBusquedaGenero);
                                             if(!librosEncontradosGenero.isEmpty())
                                             {
                                                 System.out.println("Libros Encontrados");
                                                 for (Libro libro :librosEncontradosGenero){
                                                     System.out.println("ISBN: "    + libro.getISBN()   + "   "  +
                                                             "Titulo: "  + libro.getTitulo() + "   "  +
                                                             "Autor : "  + libro.getAutor()  + "  "   +
                                                             "Genero:  " + libro.getGenero() + "  "   +
                                                             "Editorial: " + libro.getEditorial() + "   " +
                                                             "Disponible: " + libro.isDisponible());
                                                 }

                                             } else {
                                                 System.out.println("Ningun libro cumple con la condicion de busqueda");
                                             }
                                             System.out.println("Presiona Enter para continuar...");
                                             scanner.nextLine();
                                             break;

                                         case 6:
                                             // buscar libros por editorial
                                             System.out.println("Ingrese editorial de libro a buscar : ");
                                             String campoBusquedaEditorial = scanner.nextLine();
                                             ArrayList<Libro> librosEncontradosEditorial  = libroServicio.buscarLibroPorCondicion("editorial",campoBusquedaEditorial);
                                             if(!librosEncontradosEditorial.isEmpty())
                                             {
                                                 System.out.println("Libros Encontrados");
                                                 for (Libro libro :librosEncontradosEditorial){
                                                     System.out.println("ISBN: "    + libro.getISBN()   + "   "  +
                                                             "Titulo: "  + libro.getTitulo() + "   "  +
                                                             "Autor : "  + libro.getAutor()  + "  "   +
                                                             "Genero:  " + libro.getGenero() + "  "   +
                                                             "Editorial: " + libro.getEditorial() + "   " +
                                                             "Disponible: " + libro.isDisponible());
                                                 }

                                             } else {
                                                 System.out.println("Ningun libro cumple con la condicion de busqueda");
                                             }
                                             System.out.println("Presiona Enter para continuar...");
                                             scanner.nextLine();

                                             break;

                                         default:
                                             System.out.println("Opcion Invalida!! Reingresar");
                                     }

                                }while (opcionConsultaLibros != 9);
                                break;
                        }

                    }while (opcionLibros  != 9);
                    break;

                case 3:
                    int opcionMovimientos;
                    do {
                        UtilidadesMenu.mostrarMenuMovimientos();
                        System.out.print("Ingresar Opcion : ");
                        opcionMovimientos  = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcionMovimientos){
                            case 1:
                                // Prestamos
                                System.out.println("Ingresar el Id del usuario :");
                                String idUsuario = scanner.nextLine();
                                Usuario usuarioPrestamo = usuarioServicio.buscarUsuarioPorId(idUsuario);
                                if(usuarioPrestamo != null) {
                                    System.out.println("Ingresar el ISBN del libro a prestar :");
                                    String isbnPrestamo = scanner.nextLine();
                                    Libro libroPrestamo = libroServicio.buscarLibroPorISBN(isbnPrestamo);
                                    if(libroPrestamo != null) {
                                       if(libroServicio.verificarDisponibilidad(libroPrestamo)){
                                          usuarioServicio.prestarLibro(usuarioPrestamo,libroPrestamo);
                                           System.out.println("*********************************");
                                           System.out.println("*     Prestamo Procesado OK     *");
                                           System.out.println("*  Libro prestado a " + usuarioPrestamo.getNombre() +" *");
                                           System.out.println("*********************************");

                                       } else {
                                           System.out.println("**************************************");
                                           System.out.println("*  Libro No Disponible para Prestamo *");
                                           System.out.println("**************************************");
                                       }

                                    } else {
                                        System.out.println("*************************");
                                        System.out.println("*  Libro No Encontrado  *");
                                        System.out.println("*************************");
                                    }
                                } else {
                                    System.out.println("***************************");
                                    System.out.println("*  Usuario No Encontrado  *");
                                    System.out.println("***************************");
                                }
                                System.out.println("Presiona Enter para continuar...");
                                scanner.nextLine();

                                break;

                            case 2:
                                // devoluciones
                                System.out.println("Ingresar Id del Usuario :");
                                String idUsuarioDevuelve = scanner.nextLine();
                                Usuario usuarioDevuelve = usuarioServicio.buscarUsuarioPorId(idUsuarioDevuelve);
                                if(usuarioDevuelve != null)
                                 {
                                    System.out.println("Ingresar el ISBN del libro a devolver :");
                                    String isbnDevuelve = scanner.nextLine();
                                    Libro libroDevuelve = libroServicio.buscarLibroPorISBN(isbnDevuelve);
                                    if(libroDevuelve != null)
                                    {
                                        usuarioServicio.devolverLibro(usuarioDevuelve,libroDevuelve);
                                        System.out.println("**************************************");
                                        System.out.println("*       Devolucion OK                *");
                                        System.out.println("*  Libro devuelve por " + usuarioDevuelve.getNombre() + " *");
                                        System.out.println("**************************************");
                                        // una vez devuelto preguntar si quiere
                                        // ingresar calificacion - comentario del libro
                                        System.out.println("Desea Calificar al Libro ?   ( SI/NO)");
                                        String sinoCalificacion  = scanner.nextLine();

                                        if(sinoCalificacion.equalsIgnoreCase("SI"))
                                           {
                                            // ingresar comentario / puntuacion

                                           System.out.println("Ingresar Comentario del Libro :");
                                           String comentarioLibroDevuelto = scanner.nextLine();

                                           System.out.println("**************************************");
                                           System.out.println("*  Ingresar Puntuacion al Libro      *");
                                           System.out.println("*  Escala del 1 al 5                 *");
                                           System.out.println("*  Siendo 1 Muy Malo  y 5 Excelente  *");
                                           System.out.println("**************************************");

                                           int puntuacionLibroDevuelto = scanner.nextInt();

                                            calificacionServicio.crearCalificacion(idUsuarioDevuelve, isbnDevuelve, puntuacionLibroDevuelto, comentarioLibroDevuelto);
                                            scanner.nextLine();
                                            System.out.println("*********************************");
                                            System.out.println("*  Calificacion Ingresada OK !  *");
                                            System.out.println("*********************************");
                                           }
                                    } else {
                                        System.out.println("*************************");
                                        System.out.println("*  Libro No Encontrado  *");
                                        System.out.println("*************************");
                                    }

                                 } else {
                                    System.out.println("***************************");
                                    System.out.println("*  Usuario No Encontrado  *");
                                    System.out.println("***************************");
                                        }
                                System.out.println("Presiona Enter para continuar...");
                                scanner.nextLine();
                                break;

                            case 4:
                                int opcionConsultaMovimientos;
                                do {
                                    UtilidadesMenu.mostrarMenuConsultasMovimientos();
                                    System.out.print("Ingresar Opcion : ");
                                    opcionConsultaMovimientos = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (opcionConsultaMovimientos){
                                        case 1:
                                            // libros en prestamo general
                                            ArrayList<Libro> listaLibrosEnPrestamo = libroServicio.obtenerLibrosEnPrestamo();

                                            if(!listaLibrosEnPrestamo.isEmpty()){
                                                // hay libros en prestamo , listarlos
                                                for(Libro libro: listaLibrosEnPrestamo){
                                                    System.out.println(libro.getISBN() + "  " + libro.getTitulo());
                                                    System.out.println("ISBN: "    + libro.getISBN()   + "   "  +
                                                            "Titulo: "  + libro.getTitulo() + "   "  +
                                                            "Autor : "  + libro.getAutor()  + "  "   +
                                                            "Genero:  " + libro.getGenero() + "  "   +
                                                            "Editorial: " + libro.getEditorial() + "   " +
                                                            "Disponible: " + libro.isDisponible());
                                                }
                                            } else {
                                                System.out.println("*******************************");
                                                System.out.println("*  No Hay Libros en Prestamo  *");
                                                System.out.println("*******************************");
                                            }

                                            System.out.println("Presiona Enter para continuar...");
                                            scanner.nextLine();

                                            break;

                                        case 2:
                                            // libros prestados x usuario general
                                            ArrayList<Usuario> usuariosConLibrosPrestados = usuarioServicio.obtenerUsuariosConLibrosPrestados();

                                            if(usuariosConLibrosPrestados.isEmpty()) {
                                                System.out.println("No hay usuarios con libros prestados");
                                            } else {

                                                for (Usuario usuario :usuariosConLibrosPrestados){

                                                    ArrayList<Libro> librosPrestados = usuario.getLibrosPrestados();

                                                    for (Libro libroPrestadoUsuario:librosPrestados) {
                                                        System.out.println("Usuario :" +  usuario.getId() + "   "+
                                                                           "Nombre : " +  usuario.getNombre() + "   " +
                                                                           "ISBN : "   + libroPrestadoUsuario.getISBN() + "   " +
                                                                           "Titulo : " +libroPrestadoUsuario.getTitulo());
                                                    }
                                                }
                                            }
                                            System.out.println("Presiona Enter para continuar...");
                                            scanner.nextLine();

                                            break;

                                        case 3:

                                            System.out.println("Ingresar Id del Usuario :");
                                            String idUsuarioPrestamo = scanner.nextLine();
                                            Usuario usuario   = usuarioServicio.buscarUsuarioPorId(idUsuarioPrestamo);

                                            if(usuario != null) {

                                               ArrayList<Libro>  librosPrestados = usuarioServicio.obtenerLibrosPrestados(usuario);

                                                if(!librosPrestados.isEmpty()) {
                                                    System.out.println("Usuario : " + usuario.getId());
                                                    System.out.println("Nombre  : " + usuario.getNombre());

                                                    for(Libro libro : librosPrestados) {
                                                        System.out.println("ISBN : " + libro.getISBN() + "   " +
                                                                           "Titulo :" + libro.getTitulo());
                                                    }

                                                } else {
                                                    System.out.println("***************************************");
                                                    System.out.println("*  Usuario No tiene Libros Prestados  *");
                                                    System.out.println("***************************************");
                                                }

                                            } else {
                                                System.out.println("***************************");
                                                System.out.println("*  Usuario No Encontrado  *");
                                                System.out.println("***************************");

                                            }
                                            System.out.println("Presiona Enter para continuar...");
                                            scanner.nextLine();
                                            break;

                                        default:
                                            System.out.println("Opcion Invalida!! Reingresar");
                                    }

                                }while (opcionConsultaMovimientos != 9);
                                break;

                        }

                    }while (opcionMovimientos  != 9);

                break;


                case 4:
                    // submenu calificaciones

                    int opcionCalificaciones;
                    do {
                        UtilidadesMenu.mostrarMenuCalificaciones();
                        System.out.print("Ingresar Opcion : ");
                        opcionCalificaciones  = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcionCalificaciones)
                        {
                            case 1:
                                // consulta calificaciones generales emitidas por todos los libros / usuarios
                                ArrayList<Calificacion> listaCalificaciones = calificacionServicio.obtenerCalificaciones();
                                System.out.println(" Usuario         ISBN         Puntuacion     Comentario");
                                System.out.println("-------------  ----------  --------------   -----------");

                                for(Calificacion calificacion: listaCalificaciones){
                                    System.out.println(calificacion.getIdUsuario() + "  " + calificacion.getIsbn() +
                                            "    "  + convierteNumeroEnEstrellas(calificacion.getEstrellas()) +
                                            "     " + calificacion.getComentario());
                                }
                                System.out.println("Presiona Enter para continuar...");
                                scanner.nextLine();
                                break;

                            case 2:
                                System.out.println("Ingresar Id del Usuario :");
                                String idUsuarioCalificacion = scanner.nextLine();
                                Usuario usuario   = usuarioServicio.buscarUsuarioPorId(idUsuarioCalificacion);

                                if(usuario != null) {

                                    ArrayList<Calificacion>  calificacionUsuario = calificacionServicio.buscarCalificacionPorUsuario(idUsuarioCalificacion) ;

                                    if(!calificacionUsuario.isEmpty()) {
                                        System.out.println("Usuario : " + usuario.getId());
                                        System.out.println("Nombre  : " + usuario.getNombre());

                                        for(Calificacion calificacion : calificacionUsuario) {
                                            Libro libro = libroServicio.buscarLibroPorISBN(calificacion.getIsbn());
                                            System.out.println("ISBN :   " + calificacion.getIsbn() + "   " +
                                                               "Titulo : " + libro.getTitulo() + "   " +
                                                               "Calificacion : " +
                                                               convierteNumeroEnEstrellas(calificacion.getEstrellas()) + "  "  +
                                                                "Comentario : " +  calificacion.getComentario());
                                        }
                                    } else {
                                        System.out.println("************************************************");
                                        System.out.println("*  Usuario No tiene Calificaciones Realizadas  *");
                                        System.out.println("************************************************");
                                    }

                                } else {
                                    System.out.println("***************************");
                                    System.out.println("*  Usuario No Encontrado  *");
                                    System.out.println("***************************");
                                }
                                System.out.println("Presiona Enter para continuar...");
                                scanner.nextLine();
                                break;

                            case 3:
                                System.out.println("Ingresar ISBN del Libro :");
                                String isbnCalificacion = scanner.nextLine();
                                Libro libro =  libroServicio.buscarLibroPorISBN(isbnCalificacion);

                                if(libro != null) {

                                    ArrayList<Calificacion>  calificacionIsbn = calificacionServicio.buscarCalificacionPorIsbn(isbnCalificacion) ;

                                    if(!calificacionIsbn.isEmpty()) {

                                        System.out.println("ISBN : "   + libro.getISBN());
                                        System.out.println("Titulo : " + libro.getTitulo());

                                        for(Calificacion calificacion : calificacionIsbn) {
                                            Usuario usuario1 = usuarioServicio.buscarUsuarioPorId(calificacion.getIdUsuario());
                                            System.out.println("Usuario  : " + calificacion.getIdUsuario() + "   " +
                                                    "Nombre  : " + usuario1.getNombre() + "   " +
                                                    "Calificacion : " +
                                                    convierteNumeroEnEstrellas(calificacion.getEstrellas()) + "  "  +
                                                    "Comentario : " +  calificacion.getComentario());
                                        }

                                    } else {
                                        System.out.println("******************************");
                                        System.out.println("*  Libro Sin Calificaciones  *");
                                        System.out.println("******************************");
                                    }

                                } else {
                                    System.out.println("*************************");
                                    System.out.println("*  Libro No Encontrado  *");
                                    System.out.println("*************************");
                                }

                                System.out.println("Presiona Enter para continuar...");
                                scanner.nextLine();
                                break;

                        }

                    }while (opcionCalificaciones  != 9);

                    break;

                case 5:
                   // carga automatica de libros para prueba inicial
                    libroServicio.crearLibro("LIBRO 1","AUTOR 1","11111","SUSPENSO","MAR AZUL");
                    libroServicio.crearLibro("LIBRO 2","AUTOR 2","22222","COMEDIA","ALFAGUARA");
                    libroServicio.crearLibro("LIBRO 3","AUTOR 3","33333","SUSPENSO","MAR AZUL");
                    libroServicio.crearLibro("LIBRO 4","AUTOR 4","44444","ACCION","3 TIROS");

                    // carga automatica de usuarios  para prueba inicial
                    usuarioServicio.crearUsuario("Luis","00001");
                    usuarioServicio.crearUsuario("Maria","00002");
                    usuarioServicio.crearUsuario("Jorge","00003");
                    usuarioServicio.crearUsuario("Lucia","00004");
                break;

                case 9:
                    System.out.println("*************************");
                    System.out.println("*  Hasta la proxima !!  *");
                    System.out.println("*************************");
                    break;

                default:
                    System.out.println("Opcion Invalida!! Reingresar");
                    break;

            }

        } while (opcion != 9);
    }

public static String convierteNumeroEnEstrellas(int valor){
       String cadena = "";
       switch (valor){
           case 1:
             cadena = "*";
           break;

           case 2:
               cadena = "**";
               break;

           case 3:
               cadena = "***";
               break;

           case 4:
               cadena = "****";
               break;

           case 5:
               cadena = "*****";
               break;
       }

     return cadena;

    }

}
