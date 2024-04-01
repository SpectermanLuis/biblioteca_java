# Proyecto Integrador JAVA

El presente documento es sobre el **Proyecto Integrador** de ***ALKEMY***. Esta es una pequeña solución informática que sirve para el manejo basico de una biblioteca , registrar libros y usuarios , prestamos y devoluciones, calificaciones y reseñas como tambien consultas varias

#### Requerimientos
- Jdk 
- GIT v2.40.1
- IDE - Intellij 

#### Estructura de directorios
``` tree
    ├── src
    │   └── com.miapp.biblioteca
    │      ├── Main.java
    │      ├── Libro.java
    │      ├── Usuario.java 
    │      ├── Calificacion.java              
    │      ├── service
    │      │   ├── LibroServicio.java
    │      │   ├── UsuarioServicio.java
    │      │   ├── CalificacionServicio.java    
    │      └── ui     
    │          └── utilidadesMenu.java
    ├── .gitignore
    └── README.md
```

---
### Estructura Menu Sistema Biblioteca
   
``` 
        ******************************************** 
        *   Menú Principal Sistema Biblioteca 2.0  *
        ********************************************
              1. SubMenu Usuarios
                   1. Crear Usuario
                   2. Actualizar Usuario
                   3. Eliminar Usuario
                   4. Consultas
                        1. Todos los Usuarios
                        2. x ID
                        3. x Nombre
                        9. Menu Principal Usuario
                   9. Menu Principal
        
              2. SubMenu Libros
                   1. Crear Libro
                   2. Actualizar Libro
                   3. Eliminar Libro
                   4. Consultas
                        1. Todos los Libros
                        2. x ISBN
                        3. x Titulo
                        4. x Autor
                        5. x Genero
                        6. x Editorial
                        9. Menu Principal Libros
                   9. Menu Principal

              3. SubMenu Movimientos
                   1. Prestamos
                   2. Devoluciones
                   4. Consultas
                        1. Libros en Prestamo
                        2. Libros en Prestamo x Usuario  ( General )
                        3. Libros en Prestamo x Usuario  (Individual)
                        9. Menu Principal Movimientos
                   9. Menu Principal


              4. SubMenu Calificaciones
                   1. Todas las Calificaciones
                   2. Calificaciones x Usuario   ( Individual )
                   3. Calificaciones x Libro ( isbn )
                   9. Menu Principal


              5. Carga Automatica de
                 datos prueba 

              9. Salir del Sistema
```


### Comentarios varios

- En el item devolucion de libro prestado , una vez que se 
  confirma la devolucion , se pregunta si el usuario desea 
  ingresar una calificacion y comentario sobre el libro ,
  lo que alimenta las consultas del submenu de calificaciones.



- En el submenu de Movimientos - en la opcion de consultas , 
  los items Libros en Prestamo x Usuario ( general )  y 
  Libros en Prestamo x Usuario (Individual) podra ser tomado como 
  el equivalente a opcion de Aviso por vencimiento del prestamo
 