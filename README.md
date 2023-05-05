# Projecto M3: FX Bank

---
## Autor
- [Carlos Carpio Cuenca](https://github.com/AagieKLZ)
---

## Descripción
En este proyecto hemos trabajado en la creación de interfaces mediante JavaFX y la creación de un diseño más complejo de una aplicación con Java utilizando Programación Orientada a Objetos.

Para ello, hemos utilizado herramientas como UML y JavaFX SceneBuilder, gestionando a su vez el control de versiones mediante un repositorio de GitHub.

---
## Estructura del proyecto
El proyecto está dividido en varios subpaquetes, donde cada uno se encarga de una parte específica del funcionamiento de la aplicación:
- **Account**: Contiene la información sobre las cuentas bancarias, los diferentes tipos de cuentas existentes y el gestor de cuentas que nos permite crear y modificar cuentas
- **ATM**: Contiene la clase central de la aplicación. Es la encargada de hacer llamadas a los diferentes gestores para ejecutar las funciones necesarias
- **Bills**: Contiene la información sobre los billetes presentes en el cajero, así como la funcionalidad para ingresar y extraer dinero
- **Cards**: Contiene la información sobre las tarjetas de las diferentes cuentas corrientes, así como el gestor para crear, asignar y modificar tarjetas
- **Controllers**: Contiene los controladores de las vistas de la aplicación
- **FileReader**: Contiene las clases utilizadas para leer y escribir la información en los ficheros
- **lib**: Contiene clases estáticas auxiliares utilizadas en diferentes partes de la aplicación
- **Operation**: Contiene la información sobre las operaciones de extracción, ingreso y transferencia, así como el gestor de operaciones
- **User**: Contiene la información sobre los usuarios, así como el gestor de usuarios para crear usuarios, iniciar sesión o comprobar el número de intentos restantes para iniciar sesión
---
## Funcionalidades básicas
- Inicio de sesión. Los usuarios pueden iniciar sesión con su email y contraseña. Sin embargo, la cuenta quedará bloqueada después de 5 intentos fallidos
- Cuentas bancarias. Los usuarios dispondrán de una o varias cuentas. Las cuentas serán cuentas corrientes o cuentas de ahorro. Las cuentas corrientes podrán tener tarjetas asociadas, mientras que las cuentas de ahorro tendrán un interés más elevado
- Operaciones del cajero:
  - Consulta de saldo del cliente, por cuenta y en total
  - Retirar dinero de una de las cuentas
  - Ingresar dinero en una cuenta
  - Hacer transferencias entre cuentas, solo entre cuentas corrientes
  - Cambiar la contraseña de la cuenta
  - Cerrar sesión
- Movimientos: Se podrán consultar los diferentes movimientos en las cuentas del usuario, así como saber el tipo, la fecha y la cantidad de dinero implicada
- Billetes: El cajero llevará un registro de los billetes disponibles y utilizados. Se podrán ingresar billetes en el cajero y retirar dinero en billetes, pero solo si el cajero dispone de los billetes necesarios

## Funcionalidades adicionales
- Iniciar sesión con tarjeta: El usuario podrá iniciar sesión indicando el número de tarjeta y el PIN de la misma, siempre y cuando la cuenta de usuario asociada no esté bloqueada
- Menú supersecreto: Mediante una combinación de teclas (ALT + UP + LEFT + DOWN + RIGHT), el usuario podrá acceder al menú donde se podrán ver los billetes disponibles y modificarlos
- Modificación del perfil: Se podrán modificar el nombre y el email. Para hacer modificaciones, será necesario introducir la contraseña actual 2 veces
- Modificación de contraseña: Se podrá modificar la contraseña especificando la contraseña actual y la nueva contraseña 2 veces
- Creación de cuentas: Se podrán crear cuentas corrientes y de ahorro y se podrá especificar una cantidad inicial de dinero al crearlas. En el caso de las cuentas corrientes, se podrá también crear una tarjeta asociada indicando el código PIN deseado
- Creación de usuarios: Se podrán crear usuarios nuevos indicando el nombre, el email y la contraseña
- Creación de tarjetas: Se podrán crear tarjetas nuevas indicando el código PIN deseado