## ENDPOINTS - APLICATION

#### 1. ENDPOINT - AUTH

- POST  /api/auth/register -->  registrar un nuevo usuario **(ruta sin protección)**
- POST  /api/auth/login --> iniciar sesión **(ruta sin proteccción)**


#### 2. ENDPOINT - Client

- 


#### 3- ENDPOINT - TASK

**1.** <span style="font-weight: 700; color: cyan; " >POST<span> <div style="font-size: 15px; color: red; font-weight: 900;">/project/create/<span style="color: cyan">{client_id}</span></div>

``` json
    {
        name: String,
        description: String,
        date: Date
    }
```

<p>Este endpoint nos permitira crear un nuevo proyecto segun la id del cliente en este caso<p>

**2.** <span style="font-weight: 700; color: cyan; " >GET<span> <div style="font-size: 15px; color: red; font-weight: 900;">/project/read/<span style="color: cyan">{client_id}</span></div>

<p>Este endpoint nos ayudara a leer o obtener todos los projectos por la id del cliente</p>

**3.** <span style="font-weight: 700; color: cyan; " >GET<span> <div style="font-size: 15px; color: red; font-weight: 900;">/project/read/<span style="color: cyan">{client_id}/{id}</span></div>

<p>Este endpoint nos ayudara a leer o obtener un proyecto en especifico gracias a la id del client y la id del proyecto el cual creó</p>

**4.** <span style="font-weight: 700; color: cyan; " >PUT<span> <div style="font-size: 15px; color: red; font-weight: 900;">/project/update/<span style="color: cyan">{client_id}/{id}</span></div>

``` json
    {
        id: number,
        name: String,
        description: String,
        date: Date
    }
```

<p>Este endpoint nos ayudara hacer put a una tarea ya creada , con la ayuda del id del cliente y la id del proyecto es podrá modificar la tarea!</p>

**5.** <span style="font-weight: 700; color: cyan; " >DELETE<span> <div style="font-size: 15px; color: red; font-weight: 900;">/project/delete/<span style="color: cyan">{client_id}/{id}</span></div>

<p>Este endpoint nos ayudara a eliminar una tarea por la id del cliente y la id del proyecto!</p>