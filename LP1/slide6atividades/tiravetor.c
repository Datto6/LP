# include <stdio.h>
void printar(int* vet, int numero){
    for (int i=0;i<numero;i++){
        printf("%d ",vet[i]);
    }
    printf("\n");
}
int main(void){
    int vet[5];
    for (int i=0;i<5;i++){
        scanf("%d",&vet[i]);
    }
    printar(vet,5);
    int numero;
    scanf("%d",&numero);
    for (int i=numero+1;i<5;i++){ //comecar uma unidade dps do alvo
        vet[i-1]=vet[i]; //troca o anterior pelo atual, deslocando todos 1 p esquerda
    }
    vet[4]=0; //colocar zero no final. Com N elementos removidos, logica fica mais dificil
    printar(vet,5);
    return 0;
}
