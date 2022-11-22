# Ejercicios Java programación multiproceso

## 01 Repaso de excepciones

Escribe una función Java que genere de forma aleatoria una de estas excepciones.

- ArithmeticException
- NegativeArraySizeException
- NullPointerException
- IndexOutOfBoundsException

Escribe un programa Java que use 10 veces la función y maneje las excepciones generadas, indicando qué tipo de excepción es y la pila de llamadas. Después de manejar la excepción escribirá siempre: "El programa no ha explotado gracias al manejo de excepciones"

Escribe un segundo programa que maneje las excepciones de forma general (No es necesario espcificar el tipo)

## 02 Parametrización de programas

### Uso de los parámetros del main.

```
String[] args 
```

```
    java saludador 10
```

Escribe
```
Hola mundo!
Hola mundo!
Hola mundo!
Hola mundo!
Hola mundo!
Hola mundo!
Hola mundo!
Hola mundo!
Hola mundo!
Hola mundo!
```

### Varios parámetros

Escribe un programa que recibe una lista de parámetros variables. El primero es el separador y el resto serán cadenas. El programa concatena los parámetro con el separador y lo escribe por pantalla.

```
    java concat - Hola mundo de los parámetros
```

Escribe:

```
    Hola-mundo-de-los-parámetros
```


## 03 Mini práctica

Aprende a utilizar el comando wget (Para windows). Puede hacer peticiones de páginas web, descargar el contenido y mostrarlo por la pantalla.

[https://eternallybored.org/misc/wget/](https://eternallybored.org/misc/wget/)

Crea un programa en Java que reciba como parámetro una url, ejecute el comando wget para extraer el HTML y extraiga todos lo enlaces de dentro. Si la url pertence al mismo dominio, el programa escribirá un línea con cada enlace. Si la url pertence a otro dominio lo escribirá por la salida de errores. NOTA: El programa solo visitará un página.

¿Cómo extraer los enlaces?
- Utiliza expresiones regulares para extraer
- XPath

```bash
java urlextractor https://site.educa.madrid.org/ies.juandelacierva.madrid/
```

Salida estandard
```
https://site.educa.madrid.org/ies.juandelacierva.madrid/
https://site.educa.madrid.org/ies.juandelacierva.madrid/profesores/
https://site.educa.madrid.org/ies.juandelacierva.madrid/otracosa/
https://site.educa.madrid.org/ies.juandelacierva.madrid/blabla/
```

Salida errores
```
htpps://google.com/algo/
```

### Segunda parte

Crea otro programa en Java que utilice el programa anterior para realizar un análisis de las url de un dominio dado. Este programa ejecutará al anterior hasta que todas las url hayan sido visitadas. Si una página ya ha sido visitada no se debe volver a descargar.

Utiliza un HashMap para almacenar qué páginas has visitado y cuales no.

[https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)





https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html