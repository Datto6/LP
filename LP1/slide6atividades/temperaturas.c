# include <stdio.h>
void preenche (int* xs, int n){
    for (int i=0;i<n;i++){
        int elemento;
        scanf("%d",&elemento);
        *(xs+i)=elemento;
    }
}

float media(int *xs,int n){
    int soma=0;
    for (int i=0;i<n;i++){
        soma+= *(xs+i); //adiciona cada elemento, comecando no xs offset 0
    }

    return (float) soma/n;
}
int main(void){
    int vec[100];
    int numero;
    scanf("%d",&numero);
    preenche(vec,numero);
    printf("Sua media foi: %f\n",media(vec,numero));
    return 0;
}
