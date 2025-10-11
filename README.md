# 🧩 GuiLogin-WithDataBase

Este es un proyecto **ultra simple** hecho con **Java** para crear una pequeña **interfaz gráfica de login**, que se comunica con un **script en Python** encargado de verificar las credenciales del usuario directamente en una **base de datos MySQL alojada en la nube**.

---

## 🚀 Descripción

El objetivo fue practicar la **integración entre un frontend hecho en Java (Swing)** y un **backend mínimo en Python**.  
El programa muestra una ventana con campos de **usuario** y **contraseña**, y un botón para iniciar sesión.

Al presionar el botón:
1. El programa Java envía las credenciales al script Python.
2. El script Python se conecta directamente a una base de datos MySQL remota.
3. Si las credenciales existen en la base, el GUI muestra un mensaje de éxito.  
   Si no, muestra un error de autenticación.

---

## 🧱 Tecnologías usadas

### 🖥️ Frontend
- Java 17  
- Swing (GUI básico con botones y campos de texto)

### ⚙️ Backend
- Python 3.x  
- `mysql.connector` (para conectarse a la base de datos)
- Base de datos MySQL alojada en Clever Cloud

---

## 📂 Estructura del proyecto

