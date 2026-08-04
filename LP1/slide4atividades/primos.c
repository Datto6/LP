#include <stdio.h>
#include <math.h>
int eh_primo(int n){
    for (int i=2;i<=sqrt(n);i++){
        if (n%i==0){ //se algum desses numeros dividir o n, n nao eh primo
            return 0;
        }
    }
    return 1; //se sobreviveu ao loop, eh primo
}

void todos_os_primos(int max){
    for (int i=2;i<max;i++){
        if (eh_primo(i)){
            printf("%d ",i);
        }
    }
    printf("\n");
}

int main(void){
    todos_os_primos(100);
    return 0;
}
