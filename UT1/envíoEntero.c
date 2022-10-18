#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

int main(void )
{
        int fd[2];
        pid_t pid;
        int entero = 42;
        char buffer[sizeof(entero)];

        pipe(fd); //creo pipe
        pid=fork(); // creo proceso

        switch(pid) {
                case -1 : //ERROR
                        printf("NO SE HA PODIDO CREAR HIJO ... " );
                        exit (-1);
                case 0: //HIJO RECIBE
                        close(fd[1]); //cierra el descriptor de entrada
                        entero = -1;
                        read(fd[0], &entero, sizeof(entero)); //leo el pipe
                        printf("\tEl HIJO recibe algo del pipe : %d\n",entero);
                        break;
                default : // PADRE ENVIA
                        close(fd[0]);
                        printf("El PADRE ENVIA MENSAJE AL HIJO ...\n");
                        write(fd[1],&entero, sizeof(entero)); //escribo en pipe
                        wait(NULL); //espero al proceso hijo
                        break;
        }
        return 0;
}
