# ⚽ LigaPro Manager

_La app definitiva para gestionar tu liga de fútbol amateur desde tu móvil._

## 📋 Descripción

**LigaPro Manager** es una aplicación Android pensada para gestionar de forma eficiente una liga de fútbol. Te permite llevar un registro detallado de partidos, horarios, resultados, estadísticas de jugadores (goles, tarjetas) y posiciones en la tabla. Está diseñada pensando en usuarios que organizan torneos locales o ligas amateurs.

## ✨ Características principales

- Registro de equipos y jugadores
- Programación de partidos y horarios
- Control de resultados y estadísticas
- Tabla de posiciones actualizada automáticamente
- Gestión de tarjetas (amarillas/rojas) y goles
- Arquitectura moderna y modular para fácil escalabilidad

## 🧱 Arquitectura

Este proyecto sigue la arquitectura **MVVM** y el patrón **Repository**, basado en la guía oficial de arquitectura de Google. Se estructura en dos capas principales:

- **Capa UI**: Compuesta por pantallas y ViewModels que manejan el estado de la app y reaccionan a cambios de datos usando **DataBinding**.
- **Capa de Datos**: Incluye repositorios que contienen la lógica de negocio, acceso a base de datos local (**Room**), preferencias con **DataStore** y peticiones a la red. Es _offline-first_ y sigue el principio de _Single Source of Truth_.

### 🔌 Tecnologías y herramientas
-----------------------------
- [Jetpack Compose](https://developer.android.com/jetpack/compose) para UI declarativa
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) para inyección de dependencias
- [Room](https://developer.android.com/jetpack/androidx/releases/room) y [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) para persistencia local
- Retrofit + OkHttp – Comunicación con APIs
- [Kotlin Flow](https://developer.android.com/kotlin/flow) para manejo reactivo de estados
- Modularización – Organización y compilación eficiente por módulos

## 🗂️ Estructura modular del proyecto

```
LigaProManager/
|
├── app/         # Módulo principal de UI y navegación
├── data/        # Repositorios y lógica de acceso a datos
├── database/    # Base de datos local (Room), DataStore
├── network/     # Clientes HTTP, APIs, interceptores
├── model/       # Modelos compartidos entre capas
```

Cada módulo tiene responsabilidad única y puede evolucionar de forma independiente, lo que permite paralelismo en el desarrollo y mejora la mantenibilidad.

## ⏱ Tiempo estimado de desarrollo

00:00 minutos (para prototipo inicial funcional).

---

## 📱 Capturas de pantalla

*(Agrega aquí imágenes de la app si ya están disponibles)*

## 📌 Licencia

MIT © 2025 Enrique Espinoza
