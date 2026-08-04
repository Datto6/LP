#include <stdio.h>
#include <stdlib.h>

void cofator(int n, int p,int dimensao,int arr[][dimensao], int temp[][dimensao-1]){
    int i=0;
    int j=0;
    for (int linha=0;linha<dimensao; linha++){
        for (int coluna=0;coluna<dimensao;coluna++){
            if (linha!=n && coluna!=p){
                temp[i][j]=arr[linha][coluna];
                j++;
                if (j==dimensao-1){
                    j=0;
                    i++;
                }
            }
        }
    }
}
int determinante ( int dimensao, int arr[][dimensao]){
    int D=0;
    if (dimensao==1){
        return arr[0][0];
    }
    int dimensao_temp=dimensao-1;
    int temp[dimensao-1][dimensao-1];
    int sinal=1;
    for (int f = 0; f < dimensao; f++){
        // Cofator de arr[0][f](sempre expandindo na 1 linha)
        cofator( 0, f,dimensao, arr, temp);
        D += sinal * arr[0][f] * determinante( dimensao - 1,temp);
        // Alterna sinal
        sinal = -sinal;
    }
    return D;
}
int main(void ){
    int dimensao=5; 
    int arr[5][5] = {{1, 0, 2, 7,10}, //resposta correta eh -2002(pego numa calculadora de matriz)
                     {3, 0, 0, 5,5},
                     {2, 1, 10, 8,3},
                     {1, 0, 3, 0,4},
                     {1,2,3,4,5}};

    // Teste
    printf("Determinante da matriz eh: %d\n",determinante( dimensao,arr));
    return 0;
}
