# Red Sísmica – PPAI 2025

**Proyecto Práctico de Aplicación Integrador – UTN FRC / FRVM**
**Materia:** Diseño de Sistemas de Información
**Grupo:** \[Número de grupo]

---

## Objetivo del proyecto

Implementar en Java el caso de uso **CU 23: Registrar resultado de revisión manual** del sistema Red Sísmica. Esta funcionalidad permite al **Analista en Sismos** revisar eventos sísmicos auto detectados y registrar el resultado de dicha revisión: **confirmación**, **rechazo** o **derivación a experto**.

El trabajo incluye:

* Modelado UML (clases de análisis, diagrama de secuencia, máquina de estados)
* Implementación orientada a objetos en Java
* Persistencia en base de datos SQLite
* Interfaz por consola

---

## Análisis y Guía de Uso del Proyecto

### ¿Qué hicimos?

* Estructuramos el proyecto en carpetas separando modelo, persistencia, utilidades, interfaz y controlador.
* Creamos la base de datos SQLite y las tablas necesarias (`usuarios`, `eventos_sismicos`, `cambios_estado`).
* Agregamos datos de prueba para poder ver resultados inmediatos al ejecutar el sistema.
* Implementamos la conexión a la base de datos desde Java usando JDBC.
* Desarrollamos las clases principales: modelo (`EventoSismico`), acceso a datos (`EventoSismicoDAO`, `DatabaseConnection`), utilidades (`Estado`), interfaz de usuario (`PantallaRevisionManual`) y el punto de entrada (`Main`).
* Probamos la aplicación y solucionamos errores comunes de compilación, conexión y estructura de la base de datos.

---

## Estructura del proyecto

```
red-sismica/
├── src/
│   ├── model/
│   │   └── EventoSismico.java
│   ├── persistence/
│   │   ├── DatabaseConnection.java
│   │   └── EventoSismicoDAO.java
│   ├── utils/
│   │   └── Estado.java
│   ├── boundary/
│   │   └── PantallaRevisionManual.java
│   └── Main.java
├── database/
│   └── red_sismica.db
├── lib/
│   └── sqlite-jdbc-3.42.0.0.jar
├── script.sql
├── out/                # (se genera al compilar)
└── README.md
```

**Notas:**

* El archivo `red_sismica.db` debe estar en la carpeta `database/`.
* El archivo `sqlite-jdbc-3.42.0.0.jar` debe estar en la carpeta `lib/`.
* El archivo `script.sql` sirve para crear y poblar la base de datos.

---

## Comandos importantes

### 1. Inicializar la base de datos

```bash
sqlite3 database/red_sismica.db < script.sql
```

### 2. Compilar el proyecto

```bash
javac -cp "lib/sqlite-jdbc-3.42.0.0.jar" -d out src/Main.java src/model/EventoSismico.java src/persistence/DatabaseConnection.java src/persistence/EventoSismicoDAO.java src/boundary/PantallaRevisionManual.java src/utils/Estado.java
```

### 3. Ejecutar el programa

```bash
java --enable-native-access=ALL-UNNAMED -cp "out;lib/sqlite-jdbc-3.42.0.0.jar" src.Main
```

---

## ¿Qué hace cada cosa?

* `script.sql`: Crea la base de datos y carga datos de ejemplo.
* `src/model/EventoSismico.java`: Define la entidad principal del sistema.
* `src/persistence/DatabaseConnection.java`: Maneja la conexión a la base de datos SQLite.
* `src/persistence/EventoSismicoDAO.java`: Permite consultar y manipular eventos sísmicos en la base.
* `src/utils/Estado.java`: Enumera los posibles estados de un evento sísmico.
* `src/boundary/PantallaRevisionManual.java`: Interfaz de consola para interactuar con el sistema.
* `src/Main.java`: Punto de entrada de la aplicación.
* `lib/sqlite-jdbc-3.42.0.0.jar`: Driver JDBC necesario para conectar Java con SQLite.
* `database/red_sismica.db`: Archivo físico de la base de datos.

---

## Pasos para correr el proyecto

1. Clona el repositorio y entra a la carpeta:

   ```sh
   git clone <url-del-repo>
   cd red-sismica
   ```

2. Crea la base de datos y carga los datos de prueba:

   ```sh
   sqlite3 database/red_sismica.db < script.sql
   ```

3. Compila el proyecto:

   ```sh
   javac -cp "lib/sqlite-jdbc-3.42.0.0.jar" -d out src/Main.java src/model/EventoSismico.java src/persistence/DatabaseConnection.java src/persistence/EventoSismicoDAO.java src/boundary/PantallaRevisionManual.java src/utils/Estado.java
   ```

4. Ejecuta la aplicación:

   ```sh
   java --enable-native-access=ALL-UNNAMED -cp "out;lib/sqlite-jdbc-3.42.0.0.jar" src.Main
   ```

5. ¡Listo! Usa el menú en consola para interactuar con el sistema.

---

## .gitignore sugerido

Incluí las siguientes líneas para evitar subir archivos innecesarios:

```
/out/
*.class
*.db
*.sqbpro
.DS_Store
```

Esto evita subir:

* Archivos compilados (`.class`)
* Base de datos (`.db`) generada en local
* Archivos del editor SQLite como `.sqbpro`
* Archivos ocultos del sistema

---

## Estado del desarrollo

* [x] Proyecto ejecuta y muestra eventos correctamente
* [x] Estructura general organizada y modular
* [x] Conexión con base SQLite validada
* [ ] Flujo de CU completo con revisiones y cambios de estado (en progreso)

---

## Historial de entregas

| Fecha          | Entrega                    | Descripción                        |
| -------------- | -------------------------- | ---------------------------------- |
| 2024-06-04     | Entrega 1 – Modelado UML   | Clases, secuencia, estados         |
| 2024-06-07     | Entrega 2 – Código inicial | Setup + conexión a BD + estructura |
| \[por definir] | Entrega final              | Flujo completo CU23 implementado   |
