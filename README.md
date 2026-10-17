# Usuario Service

Microservicio encargado del registro, autenticación y perfiles de usuarios para la tienda de videojuegos.

## Requisitos previos

- Java 17 (verifica con `java -version`)
- Maven (verifica con `mvn -version`)
- MySQL instalado y corriendo en `localhost:3306`
- El **Eureka Server** (carpeta `infra/eureka-server`) debe estar corriendo en `http://localhost:8761` antes de levantar este microservicio, o no podrá registrarse

## 1. Clonar el repositorio

```bash
git clone <URL_DE_TU_REPOSITORIO>
cd usuario-service
```

## 2. Configurar la base de datos

Abre `src/main/resources/application.properties` y reemplaza `TU_PASSWORD_AQUI` por la contraseña de tu MySQL local.
No es necesario crear la base de datos a mano: con `createDatabaseIfNotExist=true` se crea sola la primera vez.

## 3. Compilar el proyecto con Maven

```bash
mvn clean install
```

Esto descarga las dependencias, compila el código y corre los tests.

## 4. Ejecutar la aplicación

```bash
mvn spring-boot:run
```

La aplicación quedará corriendo en `http://localhost:8081`.

## 5. Generar el .jar ejecutable (empaquetado)

```bash
mvn clean package
```

Esto genera el archivo `target/usuario-service-1.0.0.jar`, que puedes ejecutar directamente con:

```bash
java -jar target/usuario-service-1.0.0.jar
```

## 6. Probar los endpoints con Postman

| Método | URL | Descripción | Body (JSON) |
|---|---|---|---|
| GET | `http://localhost:8081/api/usuarios` | Lista todos los usuarios | — |
| GET | `http://localhost:8081/api/usuarios/1` | Busca un usuario por id | — |
| POST | `http://localhost:8081/api/usuarios` | Crea un usuario | `{"nombre":"Juan Perez","email":"juan@correo.com","password":"123456"}` |
| PUT | `http://localhost:8081/api/usuarios/1` | Actualiza un usuario | `{"nombre":"Juan P.","email":"juan@correo.com","password":"654321"}` |
| DELETE | `http://localhost:8081/api/usuarios/1` | Elimina un usuario | — |

## Estructura del proyecto

```
src/main/java/com/tienda/usuario/
 ├── UsuarioServiceApplication.java   # Clase principal
 ├── controller/UsuarioController.java # Endpoints REST
 ├── service/UsuarioService.java       # Lógica de negocio
 ├── repository/UsuarioRepository.java # Acceso a datos (JPA)
 └── model/Usuario.java                # Entidad / tabla
```
