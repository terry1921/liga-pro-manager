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

## ⚡️ Pre-Commit Hooks y Commitlint

Este proyecto utiliza pre-commit para asegurar la calidad del código antes de subir cambios al repositorio, y commitlint para validar los mensajes de commit siguiendo las convenciones Angular.

### 📦 Instalación rápida

Ejecuta el script de instalación automática:

```bash
./setup.sh
```
Este script:
- Instala pre-commit si no está instalado.
- Instala dependencias npm necesarias (commitlint y configuración).
- Registra los hooks en tu repositorio

### 🛡️ Hooks configurados

Cada vez que hagas git commit, automáticamente se ejecutarán:

• ktlint: Formatea automáticamente el código Kotlin.
• validate-gradle: Valida que los archivos build.gradle.kts y settings.gradle.kts estén correctos.
• run-unit-tests: Corre las pruebas unitarias (./gradlew testDebugUnitTest).
• commitlint: Valida que tu mensaje de commit siga la convención Angular.

Si alguno de los hooks falla, se cancelará el commit.

### ✏️ Convenciones de Mensajes de Commit (Commitlint)

Debes escribir tus mensajes siguiendo esta estructura:

```php
<tipo>(<alcance>): <descripción breve>
```
#### Tipos válidos:
- `feat`: Una nueva funcionalidad.
- `fix`: Un bug corregido.
- `docs`: Cambios en la documentación.
- `style`: Cambios de formato (sin cambios de lógica).
- `refactor`: Refactorización de código (sin cambios de funcionalidad).
- `test`: Cambios relacionados a tests.
- `chore`: Tareas de mantenimiento.

#### Ejemplos correctos ✅:

```bash
feat: add user authentication
fix: correct login error
docs: update API usage section
style: format HomeScreen layout
refactor: simplify repository calls
test: add tests for LoginViewModel
chore: update dependencies
```


#### Ejemplos incorrectos ❌:

```bash
added new feature
Fix login crash
bugfix: wrong password validation
style corrected
update stuff
```

### 💡 Notas adicionales

- Asegúrate de tener pip, npm, y node instalados en tu máquina.
- Si alguna validación falla, corrígela y vuelve a intentar hacer commit.
- Puedes correr manualmente todos los hooks antes de commitear:
```bash
pre-commit run --all-files"
```

### 🚀 Beneficios
- Código limpio y formateado automáticamente.
- Builds de Gradle validados antes de integrarlos.
- Pruebas ejecutadas automáticamente.
- Mensajes de commit consistentes y entendibles.
- Mayor calidad de código y menos errores en producción.

### ¡Feliz coding! 🎯

## 📱 Capturas de pantalla

*(Agrega aquí imágenes de la app si ya están disponibles)*

## 📌 Licencia

MIT © 2025 Enrique Espinoza
