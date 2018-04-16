# Instrucciones:

1. Pasos para instalar OC de Openshift ( archivo de texto).
2. Pasos para levantar Base de datos (imagenes con muestra de datos).
3. Levante el proyecto maven con Eclipse o Netbeans con servidor Apache Tomcat( recomiendo Eclipse si no tiene mucho conocimiento de servidores apache).
4. Haga una peticion Get a localhost:8080/IngSoftware/profesores/25
El servidor debe devolver:
*{"codProfesor":"2018J25","nameProfesor":"JULIO","idProfesor":25,"lastNameProfesor":"ROJAS","statusPorfesor":0}*
	
OJO: puede levantar también una instancia de PostgreSQL en su entorno local, solo Utilice los Script de BD que están en el drive del grupo para crear la base de datos, y inserte los datos con los scripts de Insert.
Asegurece de cambiar la URL, usuario y contraseña de la Conexion en la calse Conexion dentro del paquete: com.pe.ingsoftware.dao.conexion
