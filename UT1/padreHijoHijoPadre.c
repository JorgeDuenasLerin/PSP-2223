#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

int main(void )
{
        int pipePadreHijo[2];
        int pipeHijoPadre[2];
        
        pid_t pid;
        char saludoPadre[]="Hola hijo soy tu padre.\0";
        char saludoHijo[]="Hola papi soy tu hijo.\0";
        char buffer[23];

        pipe(pipePadreHijo); //Del padre al hijo
        pipe(pipeHijoPadre); 

        pid=fork();

        switch(pid) {
                case -1 : //ERROR
                        printf("NO SE HA PODIDO CREAR HIJO ... " );
                        exit (-1);
                case 0: //HIJO RECIBE
                        // Estoy en el hijo:
                        //  - pipePadreHijo, solo leer. Cierro el envío
                        close(pipePadreHijo[1]);
                        //  - pipeHijoPadre, solo enviar. Cierro lectura
                        close(pipeHijoPadre[0]);

                        printf("El HIJO Escribe\n");
                        write(pipeHijoPadre[1],saludoHijo,strlen(saludoHijo));
                        printf("El HIJO Escribe\n");
                        write(pipeHijoPadre[1],saludoHijo,strlen(saludoHijo));
                        printf("El HIJO Escribe\n");
                        write(pipeHijoPadre[1],saludoHijo,strlen(saludoHijo));

                        read(pipePadreHijo[0], buffer, sizeof(buffer));
                        printf("\tEl HIJO recibe algo del pipe : %s\n",buffer);
                        read(pipePadreHijo[0], buffer, sizeof(buffer));
                        printf("\tEl HIJO recibe algo del pipe : %s\n",buffer);
                        read(pipePadreHijo[0], buffer, sizeof(buffer));
                        printf("\tEl HIJO recibe algo del pipe : %s\n",buffer);
                        break;
                default : // PADRE ENVIA
                        // Estoy en padre
                        //  - pipePadreHijo, solo escribe. Cierro lectura
                        close(pipePadreHijo[0]);
                        //  - pipeHijoPadre, solo lee. Cierro envío
                        close(pipeHijoPadre[1]);

                        printf("El PADRE Escribe\n");
                        write(pipePadreHijo[1],saludoPadre,strlen(saludoPadre)); //escribo en pipe
                        printf("El PADRE Escribe\n");
                        write(pipePadreHijo[1],saludoPadre,strlen(saludoPadre)); //escribo en pipe
                        printf("El PADRE Escribe\n");
                        write(pipePadreHijo[1],saludoPadre,strlen(saludoPadre)); //escribo en pipe

                        read(pipeHijoPadre[0], buffer, sizeof(buffer));
                        printf("\tEl PADRE recibe algo del pipe : %s\n",buffer);
                        read(pipeHijoPadre[0], buffer, sizeof(buffer));
                        printf("\tEl PADRE recibe algo del pipe : %s\n",buffer);
                        read(pipeHijoPadre[0], buffer, sizeof(buffer));
                        printf("\tEl PADRE recibe algo del pipe : %s\n",buffer);

                        wait(NULL); //espero al proceso hijo
                        break;
        }
        return 0;
}