import mysql.connector
import sys

choice = sys.argv[1]
name = sys.argv[2]
surname = sys.argv[3]
passwd = sys.argv[4]


conexion = mysql.connector.connect(user = 'uedpuxpbdtabbhho',  password = 'RrODXbDs6qHJc2Ald9HC', 
                                   host = 'blfp7rfo0gbs3pyrubrk-mysql.services.clever-cloud.com', 
                                   database = 'blfp7rfo0gbs3pyrubrk', port = '3306')


cursor=conexion.cursor()
   
def pushUsuario(name, passwd ,surname='nosurname', mail='noMail', edad=0, documento=0):
    sql = "INSERT INTO users (name, surname, passwd, email, age, dni) VALUES (%s,%s, %s, %s, %s, %s)"
    cursor.execute(sql, (name, surname, passwd, mail, int(edad), int(documento)))
    conexion.commit()  # Guardar los cambios en la BD
    print("Usuario agregado correctamente.")


if choice == "1":
    pushUsuario(name, passwd,surname)
elif choice == "2":
    cursor.execute(f"SELECT * FROM users where name = '{name}'")
    resultados = cursor.fetchall()
    if(resultados != []):
        print(True)
    else:
        print(False)
    #for fila in resultados:
        #print(fila)











# Cerrar el cursor y la conexión
cursor.close()
conexion.close()