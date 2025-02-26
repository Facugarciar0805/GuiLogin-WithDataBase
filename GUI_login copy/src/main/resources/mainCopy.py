import mysql.connector
import sys

choice = sys.argv[1]
<<<<<<< HEAD
name = sys.argv[2]
surname = sys.argv[3]
passwd = sys.argv[4]
=======
name = sys.argv[3]
surname = sys.argv[4]
passwd = sys.argv[5]
dni = sys.argv[2]
>>>>>>> thirdBranch


conexion = mysql.connector.connect(user = 'uedpuxpbdtabbhho',  password = 'RrODXbDs6qHJc2Ald9HC', 
                                   host = 'blfp7rfo0gbs3pyrubrk-mysql.services.clever-cloud.com', 
                                   database = 'blfp7rfo0gbs3pyrubrk', port = '3306')


cursor=conexion.cursor()
   
<<<<<<< HEAD
def pushUsuario(name, passwd ,surname='nosurname', mail='noMail', edad=0, documento=0):
=======
def pushUsuario(name, passwd, documento,surname='nosurname', mail='noMail', edad=0, ):
>>>>>>> thirdBranch
    sql = "INSERT INTO users (name, surname, passwd, email, age, dni) VALUES (%s,%s, %s, %s, %s, %s)"
    cursor.execute(sql, (name, surname, passwd, mail, int(edad), int(documento)))
    conexion.commit()  # Guardar los cambios en la BD
    print("Usuario agregado correctamente.")


if choice == "1":
<<<<<<< HEAD
    pushUsuario(name, passwd,surname)
elif choice == "2":
    cursor.execute("SELECT user_id FROM users WHERE name = %s", (name,))
    user_id = cursor.fetchone()
    user_id = user_id[0]
    cursor.execute("SELECT passwd FROM users WHERE user_id = %s", (user_id,))
    passwdDb = cursor.fetchone()
    passwdDb = passwdDb[0]
    if(passwdDb == passwd ):
        print("Correcto")
=======
    pushUsuario(name,passwd,dni,surname)
elif choice == "2":
    cursor.execute("SELECT passwd FROM users WHERE dni = %s", (dni,))
    passwdDb = cursor.fetchone()
    passwdDb = passwdDb[0]
    if(passwdDb == passwd ):
        print("Usuario ingresado correctamente")
>>>>>>> thirdBranch
    else:
        print("Contraseña incorrecta")
    #for fila in resultados:
        #print(fila)