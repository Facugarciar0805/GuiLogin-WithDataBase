import mysql.connector

#definir variables



conexion = mysql.connector.connect(user = 'uedpuxpbdtabbhho',  password = 'RrODXbDs6qHJc2Ald9HC', 
                                   host = 'blfp7rfo0gbs3pyrubrk-mysql.services.clever-cloud.com', 
                                   database = 'blfp7rfo0gbs3pyrubrk', port = '3306')

# Crear un cursor
cursor=conexion.cursor()

#Ejecutar la consulta


def ingresoUsuario():
    nombre = input("Ingrese su nombre: ")
    apellido = input("Ingrese su apellido: ")
    mail = input("Ingrese su mail: ")
    edad = input("Ingrese su edad: ")
    documento = input("Ingrese su DNI: ")
    
    return nombre, apellido, mail, edad, documento
    
 
    
def pushUsuario(nombre, apellido, mail, edad, documento):
    sql = "INSERT INTO users (name, surname, email, age, dni) VALUES (%s, %s, %s, %s, %s)"
    cursor.execute(sql, (nombre, apellido, mail, int(edad), int(documento)))
    conexion.commit()  # Guardar los cambios en la BD
    print("Usuario agregado correctamente.")



    

eleccion = input("Que desea hacer: " '\n'
                 "1-Ingresar un usuario nuevo"'\n'
                 "2-Ver los usuarios ingresados"'\n')





if eleccion == '1':
    nombre, apellido, mail, edad, documento = ingresoUsuario()
    pushUsuario(nombre, apellido, mail, edad, documento) 
elif eleccion == '2':
    cursor.execute("SELECT * FROM users")
    resultados = cursor.fetchall()
    for fila in resultados:
        print(fila)











# Cerrar el cursor y la conexión
cursor.close()
conexion.close()