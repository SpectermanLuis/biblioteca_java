# Proyecto Integrador JAVA

El presente documento es sobre el **Proyecto Integrador** de ***ALKEMY***. Esta es una pequeña solución informática que sirve para el manejo basico de una biblioteca , registrar libros y usuarios , prestamos y devoluciones como tambien consultas varias

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
                        1. Todos los Usuario
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

 - #### TESTS
    Hasta el momento, hay una sola suite de test (proyecto2.test.js). La misma, se ejecuta por medio del comando ***npm run test***. Para que dicho test pase correctamente, se debe tener una base de datos en MongoDB llamada *muebleria* que tenga una collection denominada *muebles* y esta, contenga los documentos de los muebles. Además, se debe tener el servidor HTTP ejecutandose en otra terminal de Visual Studio Code. Esto se hace con ***npm run start***.

 - #### ERRORES & FORMATOS
    La comprobación de errores y formatos se ejecuta por medio del comando ***npm run eslint***. se hace por medio de Eslint. Para visualizar los errores en tiempo de escritura, se debe tener instalada la extensión de **Eslint** en Visual Studio Code.
    
---
### MÓDULO DE MUEBLES

Este módulo permite la gestión de muebles. El mismo, ofrece funciones para agregar, modificar, borrar o leer el registro de un mueble. Además, permite visualizar reportes filtrados por diferentes criterios de búsqueda.

#### Métodos HTTP
| Tipo | URI | Descripción |
|------|-----|-------------|
| GET | http://127.0.0.1:3005/api/v1/muebles | Obtiene los registros (permite filtros) |
| GET | http://127.0.0.1:3005/api/v1/muebles/1 | Obtiene un registro en específico |
| POST | http://127.0.0.1:3005/api/v1/muebles | Crea un nuevo registro |
| PUT | http://127.0.0.1:3005/api/v1/muebles/1 | Modifica un registro en específico |
| DELETE | http://127.0.0.1:3005/api/v1/muebles/1 | Elimina un registro en específico |


#### Método GET:
- Request:
  - Parámetros opcionales de tipo QUERY:
    - categoria=Oficina  *(tipo: string. Trae los muebles de una misma categoría)* 
    - precio_gte=500.00  *(tipo: decimal. Trae los muebles que tienen un precio mayor o igual a $500)* 
    - precio_lte=400.00  *(tipo: decimal. Trae los muebles que tienen un precio menor o igual a $400)* 
- Response:
    ``` json
        [
            {
                "_id": "64b082dabbbdbf35047fd6b6",
                "codigo": 7,
                "nombre": "Cama individual",
                "precio": 399.99,
                "categoria": "Dormitorio"
            }
        ]
    ```
  - Código HTTP: **200** *payload: muebles*
  - Código HTTP: **500** *message: Se ha generado un error en el servidor*


#### Método GET - Específico:
- Request:
  - Parámetro obligatorio de tipo URL:
    - 9 *(tipo: integer. Indica el código del mueble que se requiere obtener)*
- Response:
    ``` json
        {
              "_id": "64b082dabbbdbf35047fd6b7",
              "codigo": 9,
              "nombre": "Mesa de Comedor de Madera",
              "precio": 299.99,
              "categoria": "Comedor"
        }
    ```
  - Código HTTP: **200** *payload: mueble*
  - Código HTTP: **400** *message: El código no corresponde a un mueble registrado*
  - Código HTTP: **500** *message: Se ha generado un error en el servidor*


#### Método POST:
- Request:
  - Parámetros requeridos del BODY:
    - nombre=Biblioteca de madera deluxe *(tipo: string. Establece el valor del nombre)* 
    - precio=1250.55                     *(tipo: integer. Establece el valor del precio)* 
    - categoria=Oficina                  *(tipo: decimal. Establece el valor del categoría)* 
- Response:
  - Código HTTP: **201** *message: 'Registro creado', payload: mueble*
  - Código HTTP: **400** *message: Faltan datos relevantes*
  - Código HTTP: **500** *message: Se ha generado un error en el servidor*
- Nota: *Los valores indicados en el ejemplo, son datos esperados en los tests.*


#### Método PUT:
- Request:
  - Parámetro obligatorio de tipo URL:
    - 16 *(tipo: integer. Indica el código del mueble que se requiere modificar)*
  - Parámetros requeridos del BODY:
    - nombre=Modular metálico deluxe *(tipo: string. Establece el valor del nombre)* 
    - precio=999.75                  *(tipo: integer. Establece el valor del precio)* 
    - categoria=Oficina              *(tipo: decimal. Establece el valor del categoría)* 
- Response:
  - Código HTTP: **200** *message: 'Registro actualizado', payload: mueble*
  - Código HTTP: **400** *message: El código no corresponde a un mueble registrado*
  - Código HTTP: **400** *message: Faltan datos relevantes*
  - Código HTTP: **500** *message: Se ha generado un error en el servidor*
- Nota: *Los valores indicados en el ejemplo, son datos esperados en los tests.*


#### Método DELETE:
- Request:
  - Parámetro obligatorio de tipo URL:
    - 16 *(tipo: integer. Indica el código del mueble que se requiere eliminar)*
- Response:
  - Código HTTP: **200** *message: 'Registro eliminado'*
  - Código HTTP: **500** *message: Se ha generado un error en el servidor*
- Nota: *Los valores indicados en el ejemplo, son datos esperados en los tests.*
