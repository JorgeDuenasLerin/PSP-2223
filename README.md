# PSP-2223

## Unidades de trabajo

- 01 Programación multiproceso
  - [Sistemas y C](./UT1/README.md)
  - [Java](./UT1/README-Java.md)

- 02 Programación multithread
  - [Threads](./src/ut02hilos/)
- 03 Programación en red
- 04 Programación servicios en red
- 05 Programación segura

## Programación de aula

- Diciembre
  - Semana 12-16
  	- Repaso de red
  	- Prácticas con nc
  	- Prácticas de protocolos. Ejempo de HTTP y Autentificación
  	- Introducción a [Java TCP](https://www.geeksforgeeks.org/socket-programming-in-java/)
  - Semana 19-22
    - TCP Cliente
    - servidor
- Enero
  - Semana 9-13
    - Reconfigurado:
		- Repaso TCP
		- Ejempo de HTTP y Autentificación
		- Introducción a [Java TCP](https://www.geeksforgeeks.org/socket-programming-in-java/)
	- TCP Cliente y Servidor
		- [Presentación Slideshare](https://slideplayer.com/slide/16292964/)
  - Semana 16-20
  	- TCP Cliente y Servidor
		- Continuación
	- Ejercicio de [ahorcado](#Ahorcado)
  - Semana 23-27
  	- UDP Envío y recepción
		- [Ejemplo1](https://www.geeksforgeeks.org/working-udp-datagramsockets-java/)
		- [DatagramSocket - Doc oficial](https://docs.oracle.com/javase/7/docs/api/java/net/DatagramSocket.html) 
		- [DatagramPacket - Doc oficial](https://docs.oracle.com/javase/7/docs/api/java/net/DatagramPacket.html) 
  	- UDP Broadcast
		- IP 255
		- Con [netcat](https://stackoverflow.com/a/63216462)
	- UDP Multicast
		- Rangos de IPs especiales
		- [Tutorial](https://www.developer.com/design/how-to-multicast-using-java-sockets/)
- Febrero
  - Semana 30-3
	- Repaso protocolos: TCP, UDP
  - Semana 6-10
	- Servicios
	- Protocolo HTTP
  	- Servidor web
  	- Autentificación web
  	- Autentificación con token
	- Peticiones HTTP
  - Semana 13-17
  	- Introducción a cifrado
  	- [Cifrado simétrico](https://www.geeksforgeeks.org/symmetric-encryption-cryptography-in-java/?ref=lbp)
  	- [Cifrado asimétrico](https://www.geeksforgeeks.org/asymmetric-encryption-cryptography-in-java/?ref=lbp)
	- Autentificación con tokens
  	- Autentificación con clave pública
	- Implementa un cifrado cesar.
  - Para saber más
	- [EN EL PRINCIPIO... FUE LA LÍNEA DE COMANDOS](https://traficantes.net/sites/default/files/pdfs/En%20el%20principio%20fue...-TdS.pdf)

## Resueltos

[Chat UDP](https://github.com/Zharell/PSP/blob/main/VisualCode/EVA2/java/UDP/ChatUDP/ChatUDPServer.java)
[Chat UDP Multithread]
(https://github.com/hidratarse/PSP-2223/blob/main/Java/EV2/protocolos/src/ejercicios/UDP/ClienteUDP.java)



## Ahorcado

Implementa un servidor de ahorcado Multithread con el protocolo TCP

## Ejercicios UDP

- Implementa un chat con UDP (Servidor - Cliente)
- Analiza qué cambio tendrías que hacer para realizar un ahorcado con UDP
- Haz una retransmisión desde Java en Broadcast
- Haz una retransmisión desde Java en Multicast

## Otros

Vista el repositorio de pruebas de concepto de videojuegos

[PoC VideoJuegos desde cero](https://github.com/JorgeDuenasLerin/Java-GUI-PoC-Juegos)


## Email

```
>openssl s_client -connect smtp.educa.madrid.org:587 -starttls smtp
https://www.stevenrombauts.be/2018/12/test-smtp-with-telnet-or-openssl/
https://halon.io/blog/how-to-test-smtp-servers-using-the-command-line
```


## Basic Auth

https://en.wikipedia.org/wiki/Basic_access_authentication

## Repaso

### Threads

Dentro de los posibles problemas de concurrencia, hemos visto dos:
- Acceso a una región crítica con exclusión mutua. Los raveros y el acceso al baño.
- Versión reducida de productor consumidor. El bingo que genera números y los bingueros que los consumen.

Suma de números en paralelo:
Escribe un programa en Java que genere un array de 1000 números aleatorio y los sume en paralelo utilizando 4 threads. Sin números mágicos.
Cada thread debe sumar una parte del array y el resultado final debe ser la suma de todas las partes.

Productor-consumidor: Implementa un programa en Java que utilice la técnica de productor-consumidor para compartir datos entre threads. El productor debe generar números aleatorios y el consumidor debe imprimirlos en pantalla.

Comunicación de mensajes: Implementa un programa en Java que utilice dos threads para enviar y recibir mensajes. El thread de envío debe pedir al usuario que ingrese un mensaje, y luego enviarlo al thread de recepción. El thread de recepción debe imprimir el mensaje recibido.

Control de acceso: Escribe un programa en Java que utilice threads para simular el acceso a un recurso compartido, por ejemplo, una impresora. Cada thread debe intentar acceder al recurso y esperar un tiempo aleatorio antes de liberarlo. Si el recurso está ocupado, el thread debe esperar a que se libere antes de intentar acceder nuevamente.

Cálculo de números primos: Crea un programa en Java que calcule todos los números primos entre 1 y 1000 utilizando threads para paralelizar el procesamiento y los almacene en un array. Cada thread debe procesar una parte del rango y el resultado final debe ser la combinación de todas las partes.

Granja: Escribe un programa en Java que simule una granja. Cada animal debe ser un thread que se mueve y hace sonidos. Después de hacer un número aleatorios de movimientos y sonidos intentará comer. Para comer debe acceder al recipiente de comida. Solo puede acceder cada vez uno.

Granja2: Modifica el ejercicio anterior. Cada vez que un animal entre al recipiente y coma, el recipiente se quedará vacío. Cuando un animal entra a comer y está vacío dice que "Está vacío". Crea otro Thread Cuidador/a que cata 100 milisegundo (Sin números mágicos) rellene el recipiente si está vacío.

Sala de espera de hospital: Implementa un programa en Java que simule una sala de espera de hospital. Cada paciente debe ser un thread que llega al hospital, espera en la sala de espera y luego es atendido por un doctor aleatorio. También debe haber un thread para la enfermero/a que se encarga de guiar a los pacientes.
Explicación para implementar: Crea la clase Hospital que contenga un Array de cadenas con nombre de pacientes. Ese array es una región crítica. El Thread Enfermero/a genera genera pacientes aleatorios y llama a un método del hospital para añadir al paciente. Los threads Doctor/a pide pacientes a la clase Hospital.


### Comunicación

¿Eres un primo?
Crea un programa Multihread que reciba por parámetro el puerto en el que escucha en TCP. Cada Thread recibe un número, calcula si es primero y lo devuelve al cliente.
Crea un programa con GUI, GUITCP que utiliza el servicio que has creado.

¿Eres primo UDP?
Modifica el programa anterior para que utiliza UDP (No necesitas multithread)
Crea otro programa con GUI como el anterior para que utilice el servicio UDP

Calculadora: En vez de primos los server esperan una cadena operación y dos números. Cada uno en una línea. Haz lo mismo que antes server tcp y udp y dos clientes

Carrera UDP con threads
Utiliza como base el programa de la carrera de threads del primer trimestre y haz que la salida se la dé otro proceso a través de UDP


### Servicios

DAMHttpServer:
Crea un programa Multithread con TCP que reciba como parámetro un puerto y una ruta del sistema operativo. El programa esperará peticion HTTP (podrás usar un navegador web). Obtendrá de la petición HTTP la ruta del fichero, lo leerá y construirá una respuesta HTTP con el contenido del fichero.


Correo
Escribe un programa que reciba dos número y una dirección de correo. El programa construirá un cuadrado de asteriscos con el alto y ancho que representan los dos números y lo manda a la dirección de correo.


Correo y web. La fiesta total.


### Seguridad y Autentificación

Dado un HashMap con dos cadenas. Las claves son cadenas de texto y los valores son el resultado del comando md5sum. Haz un programa que lo recorra y reporte que hash han sido bien calculados.

Realiza un programa que obtenga la cookie del aula virtual de tu usuario, después sacará un listado de los curso en los que estás matriculado.

Crea un programa que reciba una dirección web y una dirección de correo. El programa obtendrá el HTML, extraerá los textos de los h1 y lo enviará por correo.

Crea un programa que reciba como parámetro una dirección, un puerto, una rotación y un mensaje. El programa cifrará el mensaje con cifrado cesar usando la rotación (Ejemplo: 13, -3, 17)

Crea un programa que reciba como parámetro el puerto y clave, este programa será capaz de descifrar el mensaje del otro programa.

Cesar++: Crea un programa que modifique el cifrado cesar y cada vez que se usa incrementará la clave de cifrado. Como los rotores de enigma.
Cesar++ Lector: El programa que descifra al anterior.