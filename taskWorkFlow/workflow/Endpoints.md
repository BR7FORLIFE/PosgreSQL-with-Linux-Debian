## 🚀 ENDPOINTS - APLICATION

---

### 🔐 1. ENDPOINT - AUTH

<table>
  <thead>
    <tr>
      <th>Método</th>
      <th>Ruta</th>
      <th>Descripción</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><code style="color: green; font-weight: bold;">POST</code></td>
      <td><code>api/auth/register</code></td>
      <td>Registrar un nuevo usuario <strong>(ruta sin protección)</strong></td>
    </tr>
    <tr>
      <td><code style="color: green; font-weight: bold;">POST</code></td>
      <td><code>api/auth/login</code></td>
      <td>Iniciar sesión <strong>(ruta sin protección)</strong></td>
    </tr>
  </tbody>
</table>

---

### 👤 2. ENDPOINT - CLIENT

<table>
  <thead>
    <tr>
      <th>#</th>
      <th>Método</th>
      <th>Ruta</th>
      <th>Descripción</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>1</td>
      <td><code style="color: blue;">GET</code></td>
      <td><code>api/client/all</code></td>
      <td>Recuperar todos los clientes</td>
    </tr>
    <tr>
      <td>2</td>
      <td><code style="color: blue;">GET</code></td>
      <td><code>api/client/<span style="color: cyan;">{id}</span></code></td>
      <td>Obtener cliente por su ID</td>
    </tr>
    <tr>
      <td>3</td>
      <td><code style="color: blue;">GET</code></td>
      <td><code>api/client/rol/<span style="color: cyan;">{client}</span></code></td>
      <td>Obtener cliente por rol</td>
    </tr>
    <tr>
      <td>4</td>
      <td><code style="color: blue;">GET</code></td>
      <td><code>api/client/exists/<span style="color: cyan;">{id}</span></code></td>
      <td>verificar si un cliente existe en la DB</td>
    </tr>
    <tr>
      <td>5</td>
      <td><code style="color: green;">POST</code></td>
      <td><code>api/client/create/</code></td>
      <td>Crear un nuevo cliente</td>
    </tr>
    <tr>
      <td>6</td>
      <td><code style="color: orange;">PUT</code></td>
      <td><code>api/client/create/<span style="color: cyan;">{id}</span></code></td>
      <td>modificar un cliente ya existente</td>
    </tr>
    <tr>
      <td>7</td>
      <td><code style="color: red;">DELETE</code></td>
      <td><code>api/client/<span style="color: cyan;">{id}</span></code></td>
      <td>Eliminar un cliente por la ID</td>
    </tr>
  </tbody>
</table>

---

### 📂 3. ENDPOINT - TASK

<table>
  <thead>
    <tr>
      <th>#</th>
      <th>Método</th>
      <th>Ruta</th>
      <th>Descripción</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>1</td>
      <td><code style="color: green;">POST</code></td>
      <td><code>api/project/create/<span style="color: cyan;">{client_id}</span></code></td>
      <td>Crear un nuevo proyecto<br>
        <strong>Body JSON:</strong>
        <pre><code>{
  "name": "string",
  "description": "string",
  "date": "yyyy-mm-dd"
}</code></pre>
      </td>
    </tr>
    <tr>
      <td>2</td>
      <td><code style="color: blue;">GET</code></td>
      <td><code>api/project/read/<span style="color: cyan;">{client_id}</span></code></td>
      <td>Leer todos los proyectos del cliente</td>
    </tr>
    <tr>
      <td>3</td>
      <td><code style="color: blue;">GET</code></td>
      <td><code>api/project/read/<span style="color: cyan;">{client_id}/{id}</span></code></td>
      <td>Leer un proyecto específico por ID</td>
    </tr>
    <tr>
      <td>4</td>
      <td><code style="color: orange;">PUT</code></td>
      <td><code>api/project/update/<span style="color: cyan;">{client_id}/{id}</span></code></td>
      <td>Actualizar proyecto existente<br>
        <strong>Body JSON:</strong>
        <pre><code>{
  "id": 1,
  "name": "string",
  "description": "string",
  "date": "yyyy-mm-dd"
}</code></pre>
      </td>
    </tr>
    <tr>
      <td>5</td>
      <td><code style="color: red;">DELETE</code></td>
      <td><code>api/project/delete/<span style="color: cyan;">{client_id}/{id}</span></code></td>
      <td>Eliminar proyecto por ID</td>
    </tr>
  </tbody>
</table>
