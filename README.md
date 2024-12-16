# 🏭 ZONA ACME 🏭

## Tabla de Contenido 📋
| Indice | Título  |
|--|--|
| 1. | [Descripción](#descripción-) |
| 2. | [Documentación](#documentación-) |
| 3. | [Funcionalidades](#funcionalidades-) |
| 4. | [Tecnologías](#tecnologías-%EF%B8%8F) |
| 5. | [USO](#uso-) |
| 6. | [Contribución](#contribución-) |
| 7. | [Contacto](#contacto-) |

## Descripción 💻

El propósito de este proyecto es desarrollar un sistema que permita gestionar de manera eficiente el acceso al Complejo Empresarial Zona Acme.

Este sistema registra la correcta entrada y salida de personas al complejo, garantizando la trazabilidad de cada operación y facilitando la gestión por parte de las empresas ubicadas en el complejo. 

## Documentación 📄



## Funcionalidades 🌐

El sistema cubre las siguientes funcionalidades clave:

1. Gestión de Usuarios del Sistema:
- Un superusuario es el encargado de crear a los supervisores de seguridad.
- Los supervisores gestionan la creación de guardas de seguridad y funcionarios de empresas.
- Los funcionarios de empresas pueden registrar trabajadores e invitados asociados a su empresa. En las empresas solo hay un funcionario con este privilegio.
- No se permite la eliminación de usuarios, pero pueden inactivarse para mantener la consistencia del sistema.

2. Registro de Accesos:
- Las personas ingresarán al complejo presentando su documento de identidad.
- El número de documento se puede leer mediante un lector de código de barras o ingresarse manualmente por el guarda de seguridad.
- Si una persona no está registrada, su ingreso será rechazado hasta que el funcionario de la empresa anfitriona realice el registro correspondiente.
- Las anotaciones que tengan los empleados o visitantes deben ser visibles a los guardas en el momento del ingreso al complejo
- Si una persona tiene la anotación de prohibición del ingreso debe ser muy visible al guarda para que no le permita la entrada hasta que la medida sea levantada.

3. Control de Salidas:
- Al salir del complejo, la persona debe presentar su documento para registrar la salida.
- No se permite el ingreso a las personas que no registren la salida correctamente hasta que se haga este proceso manualmente por el funcionario de la empresa, si es un trabajador o invitado, o el supervisor de seguridad si cualquier otro tipo de persona. Este proceso debe quedar debidamente registrado en el sistema (fecha, hora, quien hizo el proceso y anotaciones).

4. Gestión de Vehículos:
- Si una persona ingresa en un vehículo, se registra la placa del vehículo.
- Cada persona dentro del vehículo debe registrar su entrada individualmente.

5. Manejo de Incidentes:
- Los supervisores de seguridad pueden registrar anotaciones sobre comportamientos indebidos.
- Estas anotaciones pueden aplicar la opción del estado de prohibición de acceso al complejo.
- El levantamiento de esta restricción debe estar acompañado de una justificación y quedar registrado.
- Las anotaciones y restricciones nunca se borran del sistema, siempre queda la trazabilidad de estas, aunque los estados cambien con el tiempo.

6. Trazabilidad y Reportes:
- Reportes detallados sobre usuarios activos e inactivos: supervisores, guardas y funcionarios.
- Listados de trabajadores e invitados por empresa.
- Informes de trazabilidad de acceso (ingresos y salidas) de trabajadores y funcionarios en rangos de fechas.

7. Pantallas y Operación:
- La pantalla principal del guarda permite registrar rápidamente accesos.
- Los supervisores pueden monitorear en tiempo real las actividades en la entrada en una pantalla del sistema.
- Los funcionarios visualizan el estado actual de trabajadores e invitados en el complejo. Esto es, pueden saber que han ingresado al complejo y que se dirigen hacia la oficina. 
- Los guardas y supervisores pueden ver en tiempo real en sus pantallas principales cuando los funcionarios de las empresas autoricen o cambien de estado a algún trabajador o invitado que esté en portería.


## Tecnologías 🖥️

- **Java:** Lenguaje de programación multiplataforma orientado a objetos que se ejecuta en miles de millones de dispositivos de todo el mundo.
- **Apache NetBeans IDE:** Es un entorno de desarrollo integrado, gratuito y de código abierto para el desarrollo de aplicaciones en los sistemas operativos Windows, Mac, Linux y Solaris.
- **Java Swing:** Biblioteca gráfica que proporciona una serie de clases que representa de forma gráfica una entrada de datos o una acción específica en una interface gráfica de usuario.
- **MySQL Workbench:** Proporciona modelado de datos, desarrollo de SQL y herramientas de administración integrales para configuración de servidores, administración de usuarios, copias de seguridad y mucho más.
- **Visual Studio Code:** Editor de código fuente desarrollado por Microsoft para Windows, Linux, macOS y Web. Incluye soporte para la depuración, control integrado de Git, resaltado de sintaxis, finalización inteligente de código, fragmentos y refactorización de código.
- **Lucidchart:** Herramienta de diagramación basada en la web, que permite a los usuarios colaborar y trabajar juntos en tiempo real, creando diagramas de flujo, organigramas, esquemas de sitios web, diseños UML, mapas mentales, prototipos de software y muchos otros tipos de diagrama.
- **Star UML:** Herramienta para el modelamiento de software basado en los estándares UML (Unified Modeling Language) y MDA (Model Driven Arquitecture).
- **Clever Cloud:** Ofrece un servicio de plataforma como servicio con sede en Europa. Ayuda a los equipos de desarrollo a poner en producción aplicaciones y servicios digitales en una infraestructura confiable, con escalabilidad automática y precios transparentes.

> [!IMPORTANT]
> ## USO 🔧

Sigue los pasos a continuación para descargar, compilar y ejecutar los archivos Java de este proyecto.

- **Requisitos previos**

*Java Development Kit (JDK):*
- Asegúrate de tener instalado el JDK en tu computadora.
- Verifica la instalación ejecutando:
`(java -version)`

*Git:*
- Debes tener instalado Git para clonar el repositorio.
- Verifica la instalación ejecutando:
`(git --version)`

*Editor o IDE (opcional)*
- Puedes usar un editor de texto como VS Code o un IDE como IntelliJ IDEA, Eclipse o NetBeans para trabajar con los archivos Java.

----------------------------------------------

- **Pasos para clonar y ejecutar el proyecto**

*1. Clonar el repositorio*
- Abre una terminal o consola y ejecuta el siguiente comando:
`(git clone https://github.com/usuario/nombre-repositorio.git)`
- Reemplaza usuario y nombre-repositorio con el nombre del usuario y repositorio correspondiente.
- Ingresa al directorio del proyecto:
`(cd nombre-repositorio)`

*2. Compilar los archivos Java*
- Si los archivos están organizados en una estructura básica, puedes compilarlos usando javac. Por ejemplo:
`(javac src/*.java)`
- Si el proyecto incluye paquetes (carpetas organizadas por namespace), utiliza:
`(javac -d bin src/**/*.java)`

*3. Ejecutar la aplicación*
- Ejecuta la clase principal (la que contiene el método ***public static void main(String[] args***))
`(java -cp bin NombreDeLaClasePrincipal)`
- Asegúrate de reemplazar ***NombreDeLaClasePrincipal*** con el nombre exacto de la clase principal, y utiliza el nombre del paquete si aplica. Por ejemplo:
`(java -cp bin com.ejemplo.miapp.App)`

*Ejecutar con un IDE (opcional)*
Si prefieres usar un IDE, sigue estos pasos:

1. Abre el IDE de tu elección.
2. Importa el proyecto como un proyecto existente o selecciona "Abrir proyecto desde archivo/carpetas".
3. Configura el JDK si es necesario.
4. Encuentra la clase principal y ejecuta el programa.

> [!TIP]
> ## Contribución 👥

¡Me encantaría recibir tus contribuciones! Si deseas contribuir a este proyecto, por favor sigue estos pasos:

- Haz un fork del proyecto.
- Crea una nueva rama `(git checkout -b feature/nueva-funcionalidad)`.
- Realiza tus cambios y haz commit `(git commit -am 'Añadir nueva funcionalidad')`.
- Empuja la rama `(git push origin feature/nueva-funcionalidad)`.
- Abre un Pull Request.

> [!NOTE]
> ## Contacto 🧑‍💻

Hecho por [Alexis Hernández](https://github.com/AlexisH28) [Victor Marimon](https://github.com/VictorMarimon) [Gean Franco Jacome](https://github.com/gfranco7)  

Alexis Rafael Hernández Tocora -- (alexismar1228@gmail.com)
Gean Franco Jácome Laguna -- (deepagmf710@gmail.com)
Victor Andres Marimon Mendoza -- (vmarimon1@udi.edu.co)
