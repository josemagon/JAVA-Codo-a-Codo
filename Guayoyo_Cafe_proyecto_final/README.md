<img src="https://github.com/josemagon/JAVA-Codo-a-Codo/blob/master/Guayoyo_Cafe_proyecto_final/web/assets/capture1.PNG">

# Proyecto final JAVA comisión #2111

<p>Decidí hacer el proyecto de CRUD acerca de una cafetería. La web tiene una página principal en la que se ve un encabezado y luego una lista de la variedad de café que ofrece la cafetería.</p>
<p>Los invitados pueden ver la galería de cafés disponibles y también seleccionar uno de los café para ir a la página de ese café donde podrán ver con más detalle la descripción del mismo.</p>
<p>Esta web sólo para propósitos del CRUD y la parte compra y venta o de pedidos del cafés no fue implementada.</p>

<p>Los empleados pueden iniciar sesión ingresando un correo y una clave. El registro de los empleados no está incluido en el alcance de este sistema.</p>
<p>Una vez en el panel de control, con la sesión iniciado, los empleados pueden registrar nuevos cafés, que aparecerán en la página principal. También podrán editar los datos de cafés ya guardados; así como también eliminar un café de la base de datos.</p>

## Acciones del sistema
### Iniciar sesión
<p>Los usuarios deben estar previamente registrados en la base de datos. El registro no está modelado.</p>
<p><strong>Usuario de prueba:</strong> admin@guayoyocafe.com</p>
<p><strong>Clave de prueba:</strong> admin123</p>

En la página principal, si el usuario no está autenticado, aparecerá un botón de inicio de sesión. Si el usuario ya tiene una sesión abierta, el botón dirá "Panel de control" que lo llevará a la parte donde puede administrar los cafés.

### Cerrar sesión

### Registrar un café
Para el registro del café, se pide nombre del café, descripción, origen del café, stock, y opcionalmente para personalizar la página de café: un color y  y una imagen.

### Editar un café
Se podrá editar algunas características de cada café.

### Ver un café
Esta es la página individual de cada café. 

### Eliminar un café

#
<strong>IDE</strong>: Netbeans IDE 12.0

<strong>Servidor:</strong> Apache Tomcat 8.5.69

<strong>Base de datos:</strong> MySQL. Conexión usando el adaptador Java mysql connector 8.0.25
