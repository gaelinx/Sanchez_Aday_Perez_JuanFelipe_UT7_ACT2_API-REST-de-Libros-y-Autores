# Sanchez_Aday_Perez_JuanFelipe_UT7_ACT2_API-REST-de-Libros-y-Autores

##  Nombre del Proyecto:

*API REST de Libros y Autores*

**AUTORES**
- Aday Sánchez
- Juan Felipe Perez

## Descripcion

Actividad de la Unidad 7, API REST de Libros y Autores

## Objetivos

 -Aplicar relaciones entre las entidades propuestas, búsquedas y ordenación en Spring Boot.

## Competencias Desarrolladas
- Git, Github
- Entidades
- Endpoints
- Postman
- Repositorios
- Trabajo en Equipo

## Descripcion
Esta actividad es una API REST que utiliza Spring Boot. Esta actividad cuenta con dos entidades [Autor] [Libro] que están relacionadas entre si con relaciones @OneToMany y @ManyToOne. Estas relaciones indican que un autor puede tener varios libros, y un libro solo pertenece a un único autor.

Los servicios y controladores de estas entidades tienen operaciones CRUD completas, es decir Create, Read, Update y Delete. 

La entidad [Autor] cuenta con métodos para listar todos los autores y sus libros, lista autor por id, crear autor, actualizar y finalmente borrar.
La entidad [Libro] cuenta con los métodos para listar todos los libros, listar libros por id, crear borrar y actualizar libro, y por último una función para buscar libros, ya sea por su título, año mínimo, año máximo, y por orden.




## Recomendaciones de Ejecucion

Para ejecutar esta API, es recomendable usar Visual Studio y obligatorio tener la extensión de Spring Boot instalada. Para ejecutar la API, es necesario saber la siguiente información:
- El nombre de la app es **biblioapp**

- El nombre de la base de datos es **biblioteca_db** y utiliza el puerto 3306.

- El nombre del usuario para realizar la conexión es **root** , y no tiene contraseña. En caso de que tu tengas un usuario y una contraseña diferente, hay que cambiar el archivo *application.properties* , dentro de la carpeta src/main/resources.