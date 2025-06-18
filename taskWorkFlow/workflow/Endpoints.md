## ENDPOINTS - APLICATION

#### 1. ENDPOINT - AUTH

- POST  /api/auth/register -->  registrar un nuevo usuario **(ruta sin protección)**
- POST  /api/auth/login --> iniciar sesión **(ruta sin proteccción)**


#### 2. ENDPOINT - Client

- 


#### 3- ENDPOINT - TASK
- GET /api/project/{client_id} **(ruta protegida)**  <p> Permite acceder a todas las tareas segun la id del cliente<p>

- POST api/task --> Crear una tarea **(ruta protegida)**
- GET /api/tasks -->  Listar todas las tareas **(ruta protegida)**
- GET /api/task/{id} --> Ver una tarea en especifico **(ruta protegida)**
- PUT /api/tasks/{id}/complete --> Marcar una tarea como terminada **(ruta protegida)**
- DELETE /api/tasks/{id} --> Eliminar una tarea **(ruta protegida)**