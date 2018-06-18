# Instrucciones:

1. Levante el proyecto maven con Eclipse o Netbeans con servidor Apache Tomcat, Glassfish, JBoss, etc( recomiendo Eclipse si no tiene mucho conocimiento de servidores con apache tomcat).
2. Haga una peticion Get a localhost:port/IngSoftware/profesores/25
El servidor debe devolver:
*{"codProfesor":"2018J25","nameProfesor":"JULIO","idProfesor":25,"lastNameProfesor":"ROJAS","statusPorfesor":0}*
3. Para consumir la RESTAPI en el mismo servidor se ha levantado un consumidor ingrese a localhost:port/IngSoftware/index.jsp
4. Todas las peticiones que se realizan son Rest, desde el login hasta el logout.
5. Puede utiizar el usuario de desarrollo : use: dieguito.1743@gmail.com  pass: ADMF2018FISI
	
OJO: puede levantar también una instancia de PostgreSQL en su entorno local, solo Utilice los Script de BD que están en el drive del grupo para crear la base de datos, y inserte los datos con los scripts de Insert.
Asegurece de cambiar la URL, usuario y contraseña de la Conexion en la clase Conexion dentro del paquete: com.pe.ingsoftware.dao.conexion
La BD que se encuentra en el drive carece de las vistas de para reportes.
