#include <stdio.h>
#include <omp.h>
#include <time.h>

int main() {
    int count = 100; //Valores apenas para serem contrastados com os calculados
    int mult = 2120; //Valores apenas para serem contrastados com os calculados
   
#pragma omp parallel for private(count) 
    for (count = 0; count < 10; ++count) {
        mult = count * count;
        printf("Dentro da thread %d; count = %d; mult = %d;\n", omp_get_thread_num(), count, mult);
    }
    printf("Voltando para a thread principal com mult = %d;\n", mult );
    return 0;
}