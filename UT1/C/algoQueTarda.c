#include <stdio.h>

void main(void) {
    for(int i = 0; i < 2000; i++) {
        for(int k = 0; k < 2000; k++) {
            for(int j = 0; j < 2000; j++) {
                if (j % 500 == 0 && k % 500 == 0 && i % 500 == 0) {
                    printf(".");
                }
            }
        }
    }
}