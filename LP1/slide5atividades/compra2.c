#include <stdio.h> 
void compra(int* conta, int valor){
    *conta= *conta-valor;
}
int main(void){
    int compras[]={ 100, 50, 80, 30, 20 };
    int saldo1;
    int saldo2;
    int* ponteiro;
    scanf("%d %d",&saldo1,&saldo2);
    for (int i=0;i<5;i++){
        if (saldo1>saldo2){
            ponteiro=&saldo1;
        }
        else {
            ponteiro=&saldo2;
        }
        compra(ponteiro,compras[i]);
    }
    printf("%d %d\n",saldo1,saldo2);
    return 0;
}
