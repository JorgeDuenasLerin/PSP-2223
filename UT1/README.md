# Práctica multiproceso y comunicación

## Práctica multiproceso

En esta práctica trabajaremos con procesos desde C. Para que haya diferencias significativas entre las ejecuciones debemos elegir una tarea que requiera tiempo, en este caso vamos a escribir por pantalla los números primos entre el número 100000 y el 200000.

Vamos a generar varias versiones del mismo programa:

- versión de un solo proceso
- versión 2 proceso
- versión de 4 procesos

Estas distintas veriones se ejecutaran en distintas máquinas con distintas cantidades de CPUs (Usaremos máuinas virtuales, cambiando el número de CPUs). Con estas ejecuciones generaremos una tabla con los tiempos de ejecución


| versión\CPUs | 1 | 2 | 4 |
|--------------|---|---|---|
| 1proceso     |   |   |   |
| 2procesos    |   |   |   |
| 4procesos    |   |   |   |


### Toma de tiempo

Para la toma de tiempos podemos usar herramientas del sistema operativo como el comando ```time```

```c
jorge@PSP:~/PSP-2223/UT1$ gcc algoQueTarda.c -o algoQueTarda
jorge@PSP:~/PSP-2223/UT1$ ./algoQueTarda 
................................................................jorge@PSP:~/PSP-2223/UT1$ 
jorge@PSP:~/PSP-2223/UT1$ 
jorge@PSP:~/PSP-2223/UT1$ 
jorge@PSP:~/PSP-2223/UT1$ time ./algoQueTarda 
................................................................
real	0m17,616s
user	0m17,624s
sys	0m0,000s
jorge@PSP:~/PSP-2223/UT1$ date;./algoQueTarda;date

```

### Escritura en pantalla

La función printf de la librería de C stdio.h está orientada a buffer, si queremos ver los números primos segun se generen sin necesidad de esperar la gestión del buffer debemos usar las funciones write en vez de ```printf```.

### Versión mono proceso

Aquí se muestra el Pseudocódigo de la versión de 1 solo proceso. Un programa normal.

NOTA: Se recomienda poner el código que indica si es primo en una función para la legibilidad del código.

```
Desde 100000 hasta 200000
  Si el núemro es primo
     Escribe por pantalla
  FinSi
FinDesde
```

### Versión 2 procesos

En esta verión colaborará el padre y el hijo

```
ClonarProceso
Si soyHijo Entonces
   Hacer la mitad de los cálculos
Sino
   Hacer la otra mitad
FinSi
```

A la hora de dividir el trabajo debemos ser justos, si hacemos una división de 100000-150000 y 150000-200000 el que tenga el último tramo tendrá un trabajo mucho mayor. La mejor idea es divir el procesado de los pares e impares.

### Versión multiproceso

En esta versión el padre arrancará N procesos, las tareas se llevarán a cabo por lo hijos y el padre estará esperándoles. El padre no realizará ni uno de los cálculos pero arrancará y coordinará los procesos hijos.

```
NumProcesos = 4

// Proceso de arranque de hijos
Desde 0 hasta 4
  ClonaProceso
  Si soyHijo
    Sal del bucle
FinDesde

Si soy hijo
  // Zona de trabajo
  Imprimo números primos de mi tare
Sino soy padre
  // Zona de coordinación
  Desde 0 hasta 4
    Espera a algún hijo
  FinDesde
```

NOTA: Sigue pensando en la mejor forma para dividir el trabajo.

#### Ejemplo de fork y for

```c
#include<stdio.h>
  
  
int main()
{
    for(int i=0;i<5;i++) // loop will run n times (n=5)
    {
        if(fork() == 0)
        {
            printf("[son] pid %d from [parent] pid %d\n",getpid(),getppid());
            exit(0);
        }
    }
    for(int i=0;i<5;i++) // loop will run n times (n=5)
    wait(NULL);
      
}
```


### Para finalizar

Una vez que hayas rellenado la tabla, contesta a esta pregunta
¿Por qué se comportan así los tiempos?


## Comunicación entre procesos

### Pipes

Escribe un programa que cree un hijo. Después generará números aleatorios entre el 0 y el 20, hasta que el número aletaroio sea el 17. Cada Número se le enviará al hijo, el hijo al recibir un número lo escribe por pantalla y al final muestra la suma. El padre espera a que el hijo termine.

```
// Envío
int n = 42;
write(pipe_w, &n, sizeof(n));

// Recepción
int n;
read(pipe_r, &n, sizeof(n));
```

NOTA: El padre deberá cerrar el fichero para que el hijo pueda salir del bucle.
NOTA: Investiga las funciones para leer en un bucle while.

### Pipes

Escribe un programa en C que cree dos hijos. Después generará 100 números aleatorios y envía al hijo primero lo mútiplos de 4 y el resto al segundo hijo. Cada uno de los hijos realizará la suma y se la devolverá al padre.

### Señales

Crea un proceso que escriba "Interrúmpeme si puedes soy el PID: <pid>" y duerma 1 segundo. Cuando el usuario intente hacer un Ctrl+C el proceso manejará la situeción y se clonará con Fork.

### Pipes y señales

Escribe un programa en C que cree 1 hijo. El programa hijo genererá números aleatorios entre 0 y 10 y se los enviará al padre a través de un pipe. El padre los irá sumando pero cuando el hijo le mande un 0 el padré le enviará una señal para detenerlo. El padré después esperará a que el hijo muera y mostrará la suma.

NOTA: Para depurar es recomendable que el hijo muestre los número mandados al padre
