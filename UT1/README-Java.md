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