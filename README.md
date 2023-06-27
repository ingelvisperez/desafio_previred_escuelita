# DESAFIO ESCUELITA PREVIRED

## Comenzando 🚀

_La jerarquía de carpetas del proyecto debe respetar lo siguiente._

```
	-RAÍZ
		-> fuentes - Deja todo el código fuente del ejercicio.
		-> script - Script de insersión de schemas, tablas y data base del ejercicio.
```

## Instrucciones del ejercicio

El portal privado de PREVIRED ha decidido crear un nuevo módulo para sus clientes en empresas. Es por esto que se le ha solicitado al nuevo Desarrollador crear servicios Rest que permitan registrar la información de la(s) Empresa(s) con sus trabajadores activos asociados.

Los datos de la empresa a registrar son: Rut, Razón social, fecha inserción registro. Por otra parte, para los trabajadores (Pueden ser más de uno) asociados a la empresa. Deberás registrar su Rut, Nombre, Apellido paterno, Apellido materno y Dirección física.

Como el producto es nuevo, deberás crear tu solución para una base de datos Postgres y tu servicio Rest con todas las acciones para las nuevas 2 tablas (CRUD completo con acciones: Crear registro, modificar, eliminar y obtener para ambas tablas Empresa y Trabajador(es)). 

Mucha suerte y danos tú mejor esfuerzo.

### Requisitos (Excluyente para el cupo) 📋

```
-> Se debe implementar la solución en Spring Boot, JPA/Hibernate, Maven.
-> Debes comentar tu código (Busca formas de buenas prácticas de SONAR).
-> El código debe ser escrito en Inglés/Español.
-> La solución debe contener un README.md con las instrucciones para compilar e instalar.
-> Hay bonus si usas SWAGGER (Opcional, no excluyente).
-> Enviar una copia Email a escueladetalentosti@previred.com y colocar en ASUNTO: "Postulación desafío ESCUELITA". Para confirmar la finalización de la tarea y revisión.
```

## Entrega solcuión

+ La solución debe ser enviada vía un pull request a este repositorio "crea un Fork antes".
+ Dudas sobre el ejercicio a escueladetalentosti@previred.com

NOTA: Todos los pull request serán rechazados, esto no quiere decir que ha sido rechazada la solución, sino que es una forma de que otros postulantes no copien tu código.

## elvis 

# API de gestión de empresas y trabajadores

Este programa es parte del desafío de Previred, la API RESTful esta aplicada a Empresas y Trabajadores, la misma, permite realizar operaciones CRUD, es decir, operaciones de registro, búsqueda, actualización y eliminación.

- Registro (POST): Permite agregar a nuevos trabajadores y empresas a la base de datos, esto se hace a través de una solicitud de tipo POST.

- Búsqueda (GET): Permite obtener a todos los trabajadores y empresa previamente registrados en la base de datos, esto se hace a través de una solicitud de tipo GET.

- Actualización (PUT): Permite modificar la información de una empresa o trabajador previamente registrados en la base de datos utilizando su ID de registro, esto se hace a través de una solicitud de tipo PUT.

- Eliminar (DELETE): Permite borrar a una empresa o trabajador previamente registrados en la base de datos utilizando su ID de registro, esto se hace a través de una solicitud de tipo DELETE.

# Softwares utilizados

- Visual Studio Code (VSC): Utilizado como Entorno de Desarrollo Integrado (IDE) para la edición del código fuente.

- Git: Control de versiones que nos permite hacer commits y guardar nuestros cambios de manera local.

- Github: Control de versiones que complementa a Git porque nos permite hacer commits y guardar nuestros cambios de manera remota a través del comando git push.

- Postman: Es una plataforma API que permite a los desarrolladores diseñar, construir, probar e iterar sus API. En nuestro caso se utilizo para probar los Endpoint desarrollados.

- MySQL Workbench: Es una herramienta visual de diseño de bases de datos, acá se desarrollador los esquemas y tablas de Empresas y Trabajadores.

# Tecnologías Utilizadas

El programa ha sido desarrollado utilizando las siguientes tecnologías:

- Spring Boot: Framework de desarrollo de aplicaciones Java para la creación de servicios RESTful.
- Spring Data JPA: Biblioteca de persistencia que facilita el acceso a bases de datos relacionales.
- Lombok: Es una biblioteca para Java que nos evita tener que escribir ciertos métodos, que van a ser repetitivos y que realmente tampoco aportan lógica al negocio. En nuestro caso la creación de los métodos Set y Get de las clases Empresa.java y Trabajador.java

## Instrucciones para compilar e instalar en tu computador

1. En Github puedes Clonar, Forkear este repositorio en tu máquina local usando GIT, también puedes descargarlo como archivo ZIP y luego usar tu IDE preferido.

2. Es necesario que tengas Java instalado junto a su Kit de desarrollo (JDK). 
Para verificar que esta instalado en tu PC escribe en la terminal cmd "java -version".
Si no está instalado Java puedes ir al sitio oficial de Oracle o en mi caso que usé VSC dirigirte extensiones y proceder a instarlo "Extension Pack for Java".

3. Es necesario instalar Spring boot, si estas en las extensiones de VSC, instala "Spring Initializr Java Support" y "Spring Boot Dashboard"

4. Importa el proyecto en tu IDE como un proyecto de Maven existente.

5. Espera a que las dependencias del proyecto se descarguen e instalen automáticamente. Esto puede tomar algún tiempo dependiendo de tu conexión a Internet.

6. Busca la clase principal del proyecto llamada `Application` y ejecútala haciendo clic en un ícono triangular parecido al de "Play".

7. La aplicación se ejecutará  y se levantará en la siguiente URL por defecto: `http://localhost:8080`. Puedes acceder a ella utilizando tu navegador web.

8. Ahora deberías tener la aplicación API RESTful ejecutándose en tu entorno local. Puedes probar los diferentes endpoints utilizando Postman.

## Uso
Una vez que la aplicación esté en funcionamiento, podrás interactuar con los endpoints proporcionados mediante las peticiones HTTP correspondientes.
