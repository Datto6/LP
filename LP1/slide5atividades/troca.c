#include <stdio.h>
void troca(int* x, int* y){
    int temp=*x;
    *x=*y;  //dereferencia o valor do ponteiro x, mexe no valor a qual o endereco se refere
    *y=temp; //bota o antigo valor de *x em y 
}
int main(void){
    int x=10, y=20;
    troca(&x, &y);              // definir essa funcao
    printf("%d %d\n", x, y);
    return 0;
}
