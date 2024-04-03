# Proyecto Integrador JAVA

El presente documento es sobre el **Proyecto Integrador** de ***ALKEMY***. Esta es una pequeña solución informática que sirve para el manejo basico de una biblioteca , registrar libros y usuarios , prestamos y devoluciones, calificaciones y reseñas como tambien consultas varias


# Link GITHUB del proyecto biblioteca :   **https://github.com/SpectermanLuis/biblioteca_java.git**

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


- Tanto en Libros como Usuarios , antes de dar un alta , se verifica que
  que el isbn o identificador no existan previamente registrados , en cuyo
  caso se emite un mensaje informando la situacion.  Por el contrario , en 
  Modificacion y Eliminacion se verifica la existencia previa del
  usuario o libro.


- En el menu principal , la opcion Carga Automatica de datos de prueba ,
  lo que realiza es una carga inicial basica de algunos usuarios y libros 
  como para tener datos para poder usar las opciones del sistema.

- En las opciones en que se muestra la calificacion ingresada por los usuarios ,
  si bien se entra un numero de 1 a 5 , en la visualizacion de consultas , la 
  calificacion se muestra con su equivalente en cantidad de estrellas  
   1 = * , 2 = ** , 3 = *** , 4 = **** , 5 = *****


### Datos de Prueba - Carga Automatica Inicial ( Opcion 5 Menu Principal)

                    Libros
                    Titulo = LIBRO 1    Autor = AUTOR 1   ISBN = 11111    Genero = SUSPENSO   Editorial = MAR AZUL 
                    Titulo = LIBRO 2    Autor = AUTOR 2   ISBN = 22222    Genero = COMEDIA    Editorial = ALFAGUARA
                    Titulo = LIBRO 3    Autor = AUTOR 3   ISBN = 33333    Genero = SUSPENSO   Editorial = MAR AZUL 
                    Titulo = LIBRO 4    Autor = AUTOR 4   ISBN = 44444    Genero = ACCION     Editorial = 3 TIROS  

                    Usuarios 
                    Nombre = Luis   Identificacion = 00001
                    Nombre = Maria  Identificacion = 00002
                    Nombre = Jorge  Identificacion = 00003
                    Nombre = Lucia  Identificacion = 00004
,,,
