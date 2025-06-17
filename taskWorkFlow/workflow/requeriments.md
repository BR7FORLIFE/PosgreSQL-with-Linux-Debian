# 📌 Proyecto Backend: TaskFlow - Gestor de Tareas Colaborativo

## 🎯 Objetivo General

Desarrollar un sistema backend con Java y Spring Boot que permita gestionar proyectos y tareas colaborativas entre usuarios, aplicando buenas prácticas como arquitectura en capas, DTOs, manejo de errores, autenticación JWT, validaciones, y más.

---

## 🧩 Módulos del Sistema

### 1. 👤 Módulo de Usuarios

#### Funcionalidades:

- Registro de usuario (`POST /auth/register`)
- Login de usuario (`POST /auth/login`)
- Obtener perfil actual (`GET /users/me`)
- Listar todos los usuarios (admin) (`GET /users`)

#### Campos de Usuario:

- id (Long)
- nombre (String)
- correo (String)
- contraseña (String) → cifrada
- rol (enum: `USER`, `ADMIN`)
- fecha_creación (DateTime)

---

### 2. 📁 Módulo de Proyectos

#### Funcionalidades:

- Crear proyecto (`POST /projects`)
- Obtener todos los proyectos del usuario actual (`GET /projects`)
- Ver detalles de un proyecto (`GET /projects/{id}`)
- Editar proyecto (`PUT /projects/{id}`)
- Eliminar proyecto (`DELETE /projects/{id}`)

#### Campos de Proyecto:

- id (Long)
- nombre (String)
- descripción (String)
- fecha_creación (DateTime)
- creado_por (id usuario)

---

### 3. ✅ Módulo de Tareas

#### Funcionalidades:

- Crear tarea en un proyecto (`POST /projects/{id}/tasks`)
- Ver tareas de un proyecto (`GET /projects/{id}/tasks`)
- Asignar tarea a un usuario (`PUT /tasks/{id}/assign`)
- Cambiar estado de una tarea (`PUT /tasks/{id}/status`)
- Editar tarea (`PUT /tasks/{id}`)
- Eliminar tarea (`DELETE /tasks/{id}`)

#### Campos de Tarea:

- id (Long)
- título (String)
- descripción (String)
- estado (enum: `PENDIENTE`, `EN_PROCESO`, `FINALIZADA`)
- proyecto_id (Long)
- asignado_a (id usuario)
- fecha_creación (DateTime)
- fecha_entrega (DateTime opcional)

---

## 🔐 Seguridad y Autenticación

### JWT (JSON Web Tokens)

- Al autenticarse, el usuario recibe un token JWT.
- Los endpoints protegidos requieren token válido en `Authorization: Bearer <token>`.

### Roles

- `USER`: Puede gestionar sus propios proyectos y tareas.
- `ADMIN`: Puede ver todos los usuarios y todos los proyectos.

---

## 🧠 Validaciones

### Validaciones con `@Valid`

- Campos obligatorios (`@NotNull`, `@NotBlank`)
- Longitud mínima y máxima (`@Size`)
- Correos válidos (`@Email`)

---

## 🧱 Arquitectura Sugerida
