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
  	- Cifrado simétrico
  	- Cifrado asimétrico
	- Autentificación con tokens
  	- Autentificación con clave pública

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
