# Bowpi Code Challenge
## Arquitectura
- Inyección de depencias (Hilt)
- Navigation Components
- Firebase Realtime Database

## Listado de tareas
<img width="477" alt="Captura de pantalla 2024-09-25 a la(s) 10 35 34 a  m" src="https://github.com/user-attachments/assets/3520a6f5-2d47-4b4f-b285-4e342a898671">

## Tarea Nueva

<img width="477" alt="Captura de pantalla 2024-09-25 a la(s) 10 36 54 a  m" src="https://github.com/user-attachments/assets/5d8d26cb-c343-409a-9fbc-600b7475e355">

## Detalle de Tarea

<img width="477" alt="Captura de pantalla 2024-09-25 a la(s) 10 37 40 a  m" src="https://github.com/user-attachments/assets/1774799b-05bf-448f-9c64-cc60d16c7c5e">

## Siguientes pasos
- Terminar de armar una arqutectura MVVM para que sea escalable

## Area de preguntas
 **¿Utilizo algún patrón de diseño para manejar la conexión con la BD? Describa como implemento
la conexión.** 
- Si, utilize injeccion de dependecias para hacer la instancia de firebase solo una vez y utilizarla donde sea requerido, esto nos evita crear varias instancias de un objeto.
  
**En el desarrollo de la interfaz, manejo todas las pantallas como Activity o implemento el uso de
Fragments.**
- Utlize el praton de Navigation Components y safe args para la comunicacion entre fragmentos que dependen de una sola Activity

**¿Como manejo los componentes en las vistas lógicas del Activity/Fragment? (FindviewById o
con librerías como ButterKnife)**
- Utilize viewBinding que es el estandar hoy en dia para manejar vistas

**¿Cómo manejaría la seguridad en el APP? (Progruard, tipo de conexión, cifrados, etc.)**
- Usaria un ofuscador de codigo como Proguard o Dexguard, y agregaria una capa de encriptación sobre los datos almacenados localmente.
- Todas las claves, tokens etc estarian isladas al proyecto.

**¿Cómo ha manejado o implementado el que su diseño UI sea responsiva?**
- Use ConstraintLayout ya que es un layout que nos permite hacer IU responsiva

