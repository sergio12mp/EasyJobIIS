REQUISITOS FUNCIONALES:


//El jefe le da la aplicacion a los usuarios y ahi ya se pueden registrar
RF01. -El jefe debe poder incorporar un nuevo trabajador, aportando los datos necesarios, como nombre y apellidos, correo electrónico, etc.
  RF01.01 -El trabajador debe poder configurar su foto de perfil, y cambiar su contraseña y usuario de acceso.
  


RF02. -El usuario (trabajador o jefe/empresa) debe poder usar los servicios básicos de la aplicación. 

  //Cumplido
  RF02.01 -El usuario debe poder buscar y solicitar un horario de trabajo.
  //??
  RF02.02 -La empresa debe poder seleccionar y modificar las horas disponibles.
  //??
  RF02.03 -La empresa debe poder aceptar o rechazar las solicitudes de horarios por un trabajador.
  //
  RF02.04 -Los usuarios deben poder seleccionar varios horarios como favoritos y podrán guardarlos en un apartado de la app.
  //NO HECHO
  RF 02.05 -Los usuarios podrán activar/desactivar la geolocalización dependiendo de si se encuentran dentro o fuera de la jornada laboral.
  //Cumplido
  RF 02.06 -Los usuarios podrán fichar desde la aplicación con un código QR.


//No se va a hacer
RF03. El usuario debe poder filtrar horarios.
  RF03.01 -El usuario debe poder filtrar horarios en función del día o momento que desee, para consultar aquellas franjas horarias libres en dicho periodo.
  RF03.02 -El usuario debe poder filtrar horarios para consultar aquellas horas que tiene que realizar en ese periodo de tiempo.
  RF03.03 -El usuario debe poder visualizar un apartado en el que aparezcan las búsquedas más recientes y sus favoritos.


//Esto se hace desde el Chat mandando mensajes
RF04. Los usuarios deben poder concertar citas con sus superiores y viceversa.
  //No hay calendario, se ven en los mensajes recibidos
  RF04.01 -Las citas deben aparecer en un calendario el cual avisará días antes de dicha fecha a ambas partes.

//No vamos a traducir la apliacion, es añadir un flag donde se indique el idioma para asi poder cambiar en los paneles
RF05. -El usuario debe poder seleccionar entre diferentes idiomas para poder así ayudar a los trabajadores del extranjero.
  RF05.01. -El usuario puede filtrar los idiomas por países
  RF05.02. -El usuario puede coger un idioma como predeterminado.
  RF05.03. -El usuario puede cambiar de idioma tantas veces como desee.
  RF05.04. -El usuario podrá traducir un texto a otro idioma distinto si así lo solicita.
  RF05.05.- El usuario podrá ver el idioma predeterminado de otros usuarios.

//Los usuarios contactan con los desarrolladores a través de la mensajería escribiendo como destinatario "Equipo de Desarrollo"
RF06. -Los usuarios deben poder ponerse en contacto con nuestro equipo de desarrolladores tanto por un correo electrónico como por un pequeño foro donde se podrán ver las FAQS y así poder ayudar a los diferentes usuarios.


//Se ha desarrollado solo para PC
RF07. -Toda alerta de la aplicación debe poder reproducirse en el dispositivo en el que la aplicación esté funcionando.


//El chat funciona
RF08. -La aplicación debe tener un chat funcional para facilitar la comunicación interna entre usuarios de la misma.
  //No enviamos multimedia
  RF08.01 -El usuario debe poder enviar archivos multimedia (imágenes, videos, audios) entre los participantes del mismo.
  RF08.02 -El usuario debe poder compartir su ubicación, durante un determinado periodo de tiempo, con el otro participante del chat.
  //cumplido
  RF08.03 -El usuario debe poder eliminar un mensaje que haya escrito previamente, de tal forma que también sea eliminado para el destinatario.
  //No hay estados de mensaje
  RF08.04 -El usuario debe poder visualizar el estado de su mensaje, que puede estar en cuatro estados, sin enviar, enviado, recibido y leído.



//No está hecho
RF09. -Podrá realizar los pagos desde la propia aplicación.
	RF09.01 - Se podrá ver una lista de los pagos realizados y un gráfico con los movimientos realizados.
	RF09.02 - El receptor tendrá una notificación sobre el pago realizado.
  
  
//No esta hecho	
RF10. -Gestionar los gastos de empresa realizados por los empleados
	
  
//Se hace al final
RF11.-Se podrán gestionar las vacaciones.
	RF11.01 -El usuario podrá solicitar sus vacaciones  
  RF11.02 -La empresa puede aceptar o rechazar las solicitudes de los trabajadores
  RF11.03 -El usuario debe poder visualizar los días de vacaciones disponibles
  RF11.04 -El usuario debe poder visualizar los días de vacaciones ocupados
  RF11.05 -El usuario debe poder visualizar los compañeros que están de vacaciones
