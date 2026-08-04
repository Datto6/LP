#include <stdio.h>

int main(void){
    int num1;
    int num2;
    scanf("%d",&num1);
    scanf("%d",&num2);
    if (num1>num2){
        printf("%d\n",num1);
    }
    else if (num1<num2){
        printf("%d\n",num2);
    }
    else{
        printf("%d, Voce escreveu dois numeros iguais.\n");
    }
    
    return 0;
}
