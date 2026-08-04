#include <stdio.h>
#include <stdlib.h>

void cofator(int* arr, int* temp,int n, int p,int dimensao){
    int i=0;
    int j=0;
    for (int linha=0;linha<dimensao; linha++){
        for (int coluna=0;coluna<dimensao;coluna++){
            if (linha!=n && coluna!=p){
                *(temp+i*(dimensao-1)+j)=*(arr+ linha*dimensao +coluna); //cofator sempre uma dimensao a menos do que matriz anterior, logo dimensao -1
                j++;
                if (j==dimensao-1){
                    j=0;
                    i++;
                }
            }
        }
    }
}
int determinante (int* arr, int dimensao){
    int D=0;
    if (dimensao==1){
        return *arr;
    }
    int dimensao_temp=dimensao-1;
    int* temp = (int*) malloc(dimensao_temp*dimensao_temp*sizeof(int));  //tanto faz dimensao_temp ou dimensao normal, so que isso economiza um pc
    int sinal=1;
    for (int f = 0; f < dimensao; f++){
        int elemento=*(arr+f); // ==arr[0][f], aritmetica de ponteiros com i==0
        // Cofator de arr[0][f](sempre expandindo na 1 linha)
        cofator(arr, temp, 0, f, dimensao); //pega o cofator para o elemento arr[0][f], coloca ele no array temporario
        D += sinal * elemento* determinante(temp, dimensao - 1); //calcula o determinante desse cofator
        // Alterna sinal
        sinal = -sinal;
    }
    free(temp); //liberar espaco alocado.
    return D;
}
int main(void ){
    int dimensao=5;
    int arr[5][5] = {{1, 0, 2, 7,10},
                     {3, 0, 0, 5,5},
                     {2, 1, 10, 8,3},
                     {1, 0, 3, 0,4},
                     {1,2,3,4,5}};

    // Teste
    printf("Determinante da matriz eh: %d\n",determinante((int*) arr,dimensao));
    return 0;
}
