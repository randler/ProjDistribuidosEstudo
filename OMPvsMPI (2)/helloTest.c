#include <stdio.h>
int main222()
{
  //#pragma omp parallel//quant de threads automática
  #pragma omp parallel num_threads(5)
  {
   printf("Hello World!\n");
  }
}
