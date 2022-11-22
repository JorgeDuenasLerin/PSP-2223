#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

/*

EJEMPLO A MEDIAS. NO SEGUIR POR ALUMNOS.

TODO: Completar.

*/

int main(void )
{
        int hijo1[2];
		int hijo2[2];
        pipe(hijo1); //Del padre al hijo
        pipe(hijo2); 

        pid_t pid;

        srand(time(NULL));

        int idHijo = -1;
        for(int i=0; i < 2;i++){
                if(fork()==0) {
                        idHijo = i;
                }
        }



        pid=fork();

        switch(pid) {
        }
}


int main(void )

{



        int entero = -1;

        char buffer[sizeof(entero)];

	

        pipe(hijo1); //creo pipe

        pipe(hijo2);

	

	for(int i=0; i<2; i++){

		

		if (fork() == 0){ //Hijo

                	do{

                		if(read(hijo1[0], &entero, sizeof(entero))%4==0){

					close(hijo1[1]); //cierra el descriptor de entrada

		                	

		                	printf("\tEl HIJO recibe MULTIPLOS DE 4 : %d\n",entero);

				}else{

					close(hijo2[1]); //cierra el descriptor de entrada

				        read(hijo2[0], &entero, sizeof(entero)); //leo el pipe

				        printf("\tEl HIJO recibe normales: %d\n",entero);

				}

                	}while(read(hijo1[0],&entero, sizeof(entero))!=0 && read(hijo2[0], &entero, sizeof(entero))!=0);

			exit(0);   

		} 		    

	} 

	for(int i=0;i<=20;i++){

		entero=rand() % 100;

		if(entero%4==0){

			close(hijo1[0]);

			write(hijo1[1],&entero, sizeof(entero)); //escribo en pipe

			printf("El PADRE ENVIA MENSAJE AL HIJO MULTIPLOS DE 4 ...%d\n", entero);

		}else{

			close(hijo2[0]);

			write(hijo2[1],&entero, sizeof(entero)); //escribo en pipe

			printf("El PADRE ENVIA MENSAJE AL HIJO normales ...%d\n",entero);

		}

	}

	for(int i=0; i<2; i++){

		wait(NULL); 

	}

        return 0;

}