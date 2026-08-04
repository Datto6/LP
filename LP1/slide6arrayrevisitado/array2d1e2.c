#include <stdio.h>

void preenche (int arr[3][4], int l, int c){
    int max=l*c;
    int contador=0;
    for (int i=0;i<3;i++){
        for (int j=0;j<4;j++){
            if (contador<max){
                scanf("%d",&arr[i][j]);
            }
            contador++;
        }
    }
}
float media (int arr[3][4], int l, int c){
    long int soma=0;
    int contador=l*c;
    for (int i=0;i<3;i++){
        for (int j=0;j<4;j++){
            soma+=arr[i][j];
        }
    }
    float media= (float) soma/contador;
    return media;
}
void exibe (int arr[3][4], int l, int c){
    int max=l*c;
    int contador=0;
    for (int i=0;i<3;i++){
        for (int j=0;j<4;j++){
            if (contador<max){
                printf("%d ",arr[i][j]);
            }
            contador++;
        }
        printf("\n");
        if (contador>=max){
            return;
        }
    }
}
int main(void){
    int teste[3][4];
    preenche(teste,3,4);
    printf("%f\n",media(teste,3,4));
    exibe(teste,3,4);
    return 0;
}
