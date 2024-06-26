package com.miapp.biblioteca.ui;

/**
 *  Metodos varios que van diseñando los distintos menues y submenues del sistema
 *  Son invocados desde el main
 */
public class UtilidadesMenu {

    public static void mostrarMenuPrincipal() {
        System.out.println("********************************************");
        System.out.println("*   Menú Principal Sistema Biblioteca 2.0  *");
        System.out.println("********************************************");
        System.out.println("        1. SubMenu Usuarios                 ");
        System.out.println("        2. SubMenu Libros                   ");
        System.out.println("        3. SubMenu Movimientos              ");
        System.out.println("        4. SubMenu Calificaciones           ");
        System.out.println("                                            ");
        System.out.println("        5. Carga Automatica Datos de Prueba ");
        System.out.println("                                            ");
        System.out.println("        9. Salir del Sistema                ");
        System.out.println("********************************************");
    }

    public static void mostrarMenuUsuarios() {
        System.out.println("******************************");
        System.out.println("*   SubMenu Usuarios          *");
        System.out.println("******************************");
        System.out.println("        1. Crear Usuario      ");
        System.out.println("        2. Actualizar Usuario ");
        System.out.println("        3. Eliminar Usuario   ");
        System.out.println("        4. Consultas          ");
        System.out.println("                              ");
        System.out.println("        9. Menu Principal     ");
        System.out.println("******************************");
    }

    public static void mostrarMenuConsultasUsuarios() {
        System.out.println("******************************");
        System.out.println("*  SubMenu Consultas Usuario *");
        System.out.println("******************************");
        System.out.println("    1. Todos los Usuarios     ");
        System.out.println("    2. x ID                   ");
        System.out.println("    3. x Nombre               ");
        System.out.println("                              ");
        System.out.println("    9. Menu Principal Usuario ");
        System.out.println("******************************");
    }


    public static void mostrarMenuLibros() {
        System.out.println("******************************");
        System.out.println("*   SubMenu Libros           *");
        System.out.println("******************************");
        System.out.println("        1. Crear Libro        ");
        System.out.println("        2. Actualizar Libro   ");
        System.out.println("        3. Eliminar Libro     ");
        System.out.println("        4. Consultas          ");
        System.out.println("                              ");
        System.out.println("        9. Menu Principal     ");
        System.out.println("******************************");
    }


    public static void mostrarMenuConsultasLibros() {
        System.out.println("******************************");
        System.out.println("*  SubMenu Consultas Libros  *");
        System.out.println("******************************");
        System.out.println("    1. Todos los Libros       ");
        System.out.println("    2. x ISBN                 ");
        System.out.println("    3. x Titulo               ");
        System.out.println("    4. x Autor                ");
        System.out.println("    5. x Genero               ");
        System.out.println("    6. x Editorial            ");
        System.out.println("                              ");
        System.out.println("    9. Menu Principal Libros  ");
        System.out.println("******************************");
    }

    public static void mostrarMenuMovimientos() {
        System.out.println("******************************");
        System.out.println("*  SubMenu Movimientos       *");
        System.out.println("******************************");
        System.out.println("    1. Prestamos              ");
        System.out.println("    2. Devoluciones           ");
        System.out.println("                              ");
        System.out.println("    4. Consultas              ");
        System.out.println("                              ");
        System.out.println("    9. Menu Principal         ");
        System.out.println("******************************");
    }

    public static void mostrarMenuConsultasMovimientos() {
        System.out.println("*************************************************");
        System.out.println("* SubMenu Consultas Movimientos                 *");
        System.out.println("*************************************************");
        System.out.println("    1. Libros en Prestamo                        ");
        System.out.println("    2. Libros en Prestamo x Usuario  ( General ) ");
        System.out.println("    3. Libros en Prestamo x Usuario  (Individual)");
        System.out.println("                                                 ");
        System.out.println("    9. Menu Principal Movimientos                ");
        System.out.println("*************************************************");
    }


    public static void mostrarMenuCalificaciones() {
        System.out.println("*************************************************");
        System.out.println("* SubMenu Consultas Calificaciones              *");
        System.out.println("*************************************************");
        System.out.println("    1. Todas las Calificaciones                  ");
        System.out.println("    2. Calificaciones x Usuario   ( Individual ) ");
        System.out.println("    3. Calificaciones x Libro ( isbn )           ");
        System.out.println("                                                 ");
        System.out.println("    9. Menu Principal                            ");
        System.out.println("*************************************************");
    }


}
