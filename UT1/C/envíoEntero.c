#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

#define LECTURA 0
#define ESCRITURA 1

int main(void )
{

        int tuberia[2];
        pid_t pid;
        int entero = -1;
        char buffer[sizeof(entero)];

        pipe(tuberia); //creo pipe
        pid=fork(); // creo proceso

        switch(pid) {
                case -1 : //ERROR
                        printf("NO SE HA PODIDO CREAR HIJO ... " );
                        exit (-1);
                case 0: //HIJO RECIBE
                        close(tuberia[ESCRITURA]); //cierra el descriptor de entrada
                        read(tuberia[LECTURA], &entero, sizeof(entero)); //leo el pipe
                        printf("\tEl HIJO recibe algo del pipe : %d\n", entero);
                        break;
                default : // PADRE ENVIA
                        close(tuberia[LECTURA]);
                        entero = 42; // Número para enviar
                        printf("El PADRE ENVIA MENSAJE AL HIJO ...\n");
                        write(tuberia[ESCRITURA],&entero, sizeof(entero)); //escribo en pipe
                        wait(NULL); //espero al proceso hijo
                        break;
        }
        return 0;
}
