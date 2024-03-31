package com.miapp.biblioteca.ui;

public class UtilidadesMenu {

    public static void mostrarMenuPrincipal() {
        System.out.println("**********************************");
        System.out.println("*   Menú Sistema Biblioteca 2.0  *");
        System.out.println("**********************************");
        System.out.println("        1. A.B.M. Usuarios"        );
        System.out.println("        2. A.B.M. Libros"          );
        System.out.println("        3. Movimientos"            );
        System.out.println("                                  ");
        System.out.println("        5. Carga Automatica de    ");
        System.out.println("           datos prueba           ");
        System.out.println("                                  ");
        System.out.println("        9. Salir del Sistema"      );
        System.out.println("**********************************");
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


    public static void mostrarMenuMovimientos() {
        System.out.println("******************************");
        System.out.println("*  SubMenu Movimientos       *");
        System.out.println("******************************");
        System.out.println("    1. Prestamos              ");
        System.out.println("    2. Devoluciones           ");
        System.out.println("                              ");
        System.out.println("    9. Menu Principal         ");
        System.out.println("******************************");
    }



}
