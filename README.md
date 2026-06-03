# 📱 TFG - Aplicación de Gestión y Seguridad en el Transporte Escolar

## 📖 Descripción del proyecto

Este repositorio contiene el desarrollo del Trabajo Fin de Grado (TFG) en Ingeniería Informática realizado por **Alexia Lasheras Cortina** en la **Universidad Internacional de La Rioja (UNIR)**.

El proyecto consiste en el diseño y desarrollo de una aplicación móvil Android orientada a mejorar la seguridad y la gestión del transporte escolar mediante herramientas digitales que facilitan el control de los menores durante los trayectos y mejoran la comunicación entre cuidadores y familias.

La solución propuesta nace como respuesta a una problemática real relacionada con la supervisión de menores durante el transporte escolar y la necesidad de proporcionar información actualizada a las familias sobre el estado del servicio.

---

# 🎯 Objetivos del proyecto

Los principales objetivos del sistema son:

* Mejorar la seguridad de los menores durante el transporte escolar.
* Digitalizar el control de subida y bajada de los usuarios del servicio.
* Facilitar el seguimiento de las rutas escolares.
* Mejorar la comunicación entre cuidadores y familias.
* Centralizar la información relevante del trayecto en una única aplicación.
* Validar la viabilidad técnica de una solución tecnológica aplicada al transporte escolar.

---

# ⚙️ Funcionalidades implementadas

### 👤 Gestión de usuarios

* Inicio de sesión.
* Acceso diferenciado para cuidadores y familias.
* Navegación entre módulos de la aplicación.

### 🚌 Gestión del transporte escolar

* Consulta de menores asignados a la ruta.
* Registro digital de subida y bajada de menores.
* Control del estado de asistencia.
* Gestión básica de incidencias.

### 📍 Seguimiento de rutas

* Visualización de la ruta escolar.
* Consulta de paradas.
* Consulta de horarios asociados a las paradas.

### 👨‍👩‍👧‍👦 Panel de familias

* Consulta del estado del menor.
* Consulta de información del trayecto.
* Visualización de avisos y notificaciones.

### 🔔 Comunicación

* Sistema de avisos informativos.
* Gestión de notificaciones relacionadas con el servicio.

---

# 🏗️ Arquitectura del sistema

La aplicación ha sido desarrollada utilizando una arquitectura modular basada en componentes Android.

La solución está compuesta por:

* Aplicación móvil Android.
* Interfaz gráfica desarrollada mediante XML.
* Lógica de negocio implementada en Java.
* Navegación basada en Activities e Intents.
* Estructuras de datos utilizadas para la validación funcional del sistema.

La arquitectura ha sido diseñada para permitir futuras integraciones con servicios de persistencia de datos, geolocalización en tiempo real y sistemas avanzados de notificación.

---

# 🛠️ Tecnologías utilizadas

## Desarrollo

* Java
* Android Studio
* Android SDK
* XML

## Gestión del proyecto

* Git
* GitHub

## Tecnologías previstas para futuras ampliaciones

* Firebase Authentication
* Cloud Firestore
* Firebase Cloud Messaging
* Google Maps API

---

# 📂 Estructura del repositorio

```text
tfg-transporte-escolar-app/
│
├── app/
├── database/
├── docs/
│   ├── memoria/
│   ├── diagramas/
│   ├── mockups/
│   ├── planificacion/
│   └── capturas/
├── anexos/
├── README.md
├── LICENSE
└── archivos de configuración Android Studio
```

---

# 🗄️ Modelo de datos

Durante la fase de análisis se diseñó un modelo conceptual de datos que representa las principales entidades del sistema:

* Usuarios
* Menores
* Rutas
* Paradas
* Trayectos
* Eventos
* Incidencias
* Notificaciones

La implementación actual utiliza estructuras de datos locales para la validación funcional de la aplicación, manteniendo una arquitectura preparada para futuras integraciones con sistemas de persistencia de datos.

---

# 🔐 Seguridad y privacidad

El diseño de la aplicación tiene en consideración aspectos relacionados con la seguridad y la protección de la información.

Entre las medidas contempladas se encuentran:

* Diferenciación de perfiles de usuario.
* Restricción de acceso según rol.
* Protección de información sensible.
* Diseño orientado al cumplimiento del Reglamento General de Protección de Datos (RGPD).

---

# 🧪 Pruebas realizadas

Durante el desarrollo se realizaron pruebas funcionales sobre las principales características del sistema:

* Inicio de sesión.
* Navegación entre pantallas.
* Gestión de menores.
* Consulta de rutas y paradas.
* Visualización de información para familias.
* Funcionamiento de botones y navegación general.

Los resultados obtenidos permitieron validar el correcto funcionamiento de las funcionalidades implementadas en esta versión del proyecto.

---

# 🚀 Líneas futuras de desarrollo

Entre las posibles evoluciones futuras del sistema destacan:

* Integración completa con Firebase.
* Persistencia de datos en la nube mediante Cloud Firestore.
* Geolocalización en tiempo real mediante Google Maps.
* Notificaciones push mediante Firebase Cloud Messaging.
* Integración con plataformas educativas.
* Incorporación de tecnologías RFID o códigos QR para el control automático de asistencia.
* Optimización de rutas mediante técnicas de análisis de datos e inteligencia artificial.

---

# 👩‍💻 Autoría

**Alexia Lasheras Cortina**

Grado en Ingeniería Informática
Universidad Internacional de La Rioja (UNIR)

Trabajo Fin de Grado - Curso 2025/2026

---

# 📄 Licencia

Este proyecto se distribuye bajo licencia MIT (MIT License).

Se permite el uso, modificación y distribución del software de acuerdo con los términos establecidos en el archivo LICENSE incluido en este repositorio.

---

# 🔗 Repositorio del proyecto

https://github.com/aixela30-bot/tfg-transporte-escolar-app

