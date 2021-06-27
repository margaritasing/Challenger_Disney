# _CHALLENGE BACKEND_ -_Java_
## _Spring Boot (API)_ �

## Objetivo
      Desarrollar una API para explorar el mundo de Disney, la cual permitirá conocer y modificar los
      personajes que lo componen y entender en qué películas estos participaron. Por otro lado, deberá
      exponer la información para que cualquier frontend pueda consumirla.

### 👉 Utilizar Spring Boot.
### 👉 No es necesario armar el Frontend.
### 👉 Las rutas deberán seguir el patrón REST.
### 👉 Utilizar la librería Spring Security.
## _Requerimientos técnicos_
## 1. _Modelado de Base de Datos_

## _● Personaje: deberá tener,_
    ○ Imagen.
    ○ Nombre.
    ○ Edad.
    ○ Peso.
    ○ Historia.
    ○ Películas o series asociadas.
## _● Película o Serie: deberá tener,_
    ○ Imagen.
    ○ Título.
    ○ Fecha de creación.
    ○ Calificación (del 1 al 5).
    ○ Personajes asociados.
## _● Género: deberá tener,_
    ○ Nombre.
    ○ Imagen.
    ○ Películas o series asociadas.

## _2. Autenticación de Usuarios_
      Para realizar peticiones a los endpoints subsiguientes el usuario deberá contar con un token que
      obtendrá al autenticarse. Para ello, deberán desarrollarse los endpoints de registro y login, que
      permitan obtener el token.
      Los endpoints encargados de la autenticación deberán ser:
      ● /auth/login
      ● /auth/register
## _3. Listado de Personajes_
      El listado deberá mostrar:
      ● Imagen.
      ● Nombre.
      El endpoint deberá ser:
      ● /characters
## _4. Creación, Edición y Eliminación de Personajes (CRUD)_
      Deberán existir las operaciones básicas de creación, edición y eliminación de personajes.
## _5. Detalle de Personaje_
      En el detalle deberán listarse todos los atributos del personaje, como así también sus películas o
      series relacionadas.
## _6. Búsqueda de Personajes_
    Deberá permitir buscar por nombre, y filtrar por edad, peso o películas/series en las que participó.
    Para especificar el término de búsqueda o filtros se deberán enviar como parámetros de query:
    ● GET /characters?name=nombre
    ● GET /characters?age=edad
    ● GET /characters?movies=idMovie
## _7. Listado de Películas_
     Deberá mostrar solamente los campos imagen, título y fecha de creación.
     El endpoint deberá ser:
     ● GET /movies
## _8. Detalle de Película / Serie con sus personajes_
     Devolverá todos los campos de la película o serie junto a los personajes asociados a la misma
## _9. Creación, Edición y Eliminación de Película / Serie_
     Deberán existir las operaciones básicas de creación, edición y eliminación de películas o series.
## _10.Búsqueda de Películas o Series_
     Deberá permitir buscar por título, y filtrar por género. Además, permitir ordenar los resultados por
     fecha de creación de forma ascendiente o descendiente.
      El término de búsqueda, filtro u ordenación se deberán especificar como parámetros de query:
      ● /movies?name=nombre
      ● /movies?genre=idGenero
      ● /movies?order=ASC | DESC
## _11. Envío de emails_
      Al registrarse en el sitio, el usuario deberá recibir un email de bienvenida. Es recomendable, la
      utilización de algún servicio de terceros como SendGrid.
      Documentación
      Es deseable documentar los endpoints utilizando alguna herramienta como Postman o
      Swagger.
## _Tests_
      De forma opcional, se podrán agregar tests de los diferentes endpoints de la APP, verificando
      posibles escenarios de error:
      - Campos faltantes o con un formato inválido en BODY de las peticiones
      - Acceso a recursos inexistentes en endpoints de detalle
      Los tests pueden realizarse utilizando JUnit y Mockito
