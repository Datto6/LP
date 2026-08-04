#include <stdio.h>

int main(void){
    long int soma;
    long int entrada=-1;

    while (entrada!=0){
        scanf("%d",&entrada);
        soma+=entrada;
    }
    printf("%d foi a soma final \n",soma);
    return 0;
}
