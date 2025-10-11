# 🧩 GuiLogin-WithDataBase

Este es un proyecto **ultra simple** hecho con **Java** para crear una pequeña **interfaz gráfica de login**, que se comunica con un **script en Python** encargado de verificar las credenciales del usuario contra una **API conectada a una base de datos online**.

---

## 🚀 Descripción

El objetivo fue practicar la **integración entre un frontend hecho en Java (Swing)** y un **backend mínimo en Python**.  
El programa muestra una ventana con campos de **usuario** y **contraseña**, y un botón para iniciar sesión.

Al presionar el botón:
1. El programa Java envía las credenciales al script Python.
2. El script Python llama a una **API REST** que consulta una base de datos online.
3. Si las credenciales son correctas, el GUI muestra un mensaje de éxito.  
   Si no, muestra un error de autenticación.

---

## 🧱 Tecnologías usadas

### 🖥️ Frontend
- Java 17  
- Swing (GUI básico con botones y campos de texto)

### ⚙️ Backend
- Python 3.x  
- `requests` (para conectar con la API)
- API REST (para la base de datos remota)

---
