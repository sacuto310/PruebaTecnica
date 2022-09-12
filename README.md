# PruebaTecnica LER_Prevencion
Este es un programa realizado para una prueba tecnica con el objetivo de medir las capacidades de desarrollo, este se desarrollo utilizando Angular para Frontend, Java para Backend y como base de datos se utilizó PostgreSQL.

## Requisitos
Se utilizó Node.js, Java 18, PostgreSQL ultima version y Angular 14.

## Guia de desarrollo
Se debe crear la base de datos ler_pruebatecnica y crear una tabla llamada usuario, si se ejecuta primero el backend esta tabla se creará automaticamente gracias a la configuracion de create-drop. Esto quiere decir tambien que si se detiene la aplicación y se vuelve a ejecutar la tabla los datos de la tabla serán eliminados, si se desea que estos no se eliminen cambiar la configuracion que se encuentra en el archivo ./pruebatecnica/src/main/resources/application.properties donde dice "create-drop" cambiar a "update"
El frontend y Backend estan debidamente ligados, la aplicación permite guardar, leer, editar y eliminar los datos de uno o más usuarios.
El Frontend se ejecuta de forma normal, situandose en el directorio llamado ./front/ y ejecutar el comando ng serve, de ahí abrir el link http://localhost:4200 para visualizar la aplicación.
