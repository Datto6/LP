#include <stdio.h>
void cofator(int arr[4][4], int temp[4][4],int n, int p,int dimensao){
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
int determinante (int arr[4][4], int dimensao){
    int D=0;
    if (dimensao==1){
        return arr[0][0];
    }
    int temp[4][4];
    int sinal=1;
     for (int f = 0; f < dimensao; f++){
        // Cofator de arr[0][f]
        cofator(arr, temp, 0, f, dimensao);
        D += sinal * arr[0][f]* determinante(temp, dimensao - 1);

        // Alterna sinal
        sinal = -sinal;
    }

    return D;
}
int main(void ){
    int L=4;
    int arr[4][4] = {{1, 0, 2, -1},
                     {3, 0, 0, 5},
                     {2, 1, 4, -3},
                      {1, 0, 5, 0}};

    //Teste da funcao
    printf("Determinant of the matrix is : %d\n",determinante(arr, L));
    return 0;
}
