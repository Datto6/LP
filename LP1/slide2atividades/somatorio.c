# include <stdio.h>

int main(void){
    long long int limite;
    scanf("%lld",&limite);
    long long int somatorio;
    for(long long int i=1;i<=limite;i++){
        somatorio+=i*i;
    }  
    printf("%d foi o somatorio dos quadrados ate o numero %d\n",somatorio,limite);
    return 0;
}
