#include <stdio.h> 
void compra(int* conta, int valor){
    *conta= *conta-valor; //dereferencia conta, e subtrai o valor dele
}
int main(void){
    int saldo1;
    int saldo2;
    int* ponteiro;
    scanf("%d %d",&saldo1,&saldo2);
    if (saldo1>saldo2){ //define o ponteiro como o endereco do maior saldo, para depois tirar so do maior saldo 
        ponteiro=&saldo1;
    }
    else {
        ponteiro=&saldo2;
    }
    compra(ponteiro,500);
    printf("%d %d\n",saldo1,saldo2); //imprime ambos no terminal
    return 0;
}
