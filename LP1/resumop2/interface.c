#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "constantes.h"
#include "alocacao.h"
int main(void){
    int input;
    while(1){
        puts("");
        printf("Qual materia voce quer ver(digite 0 p sair)? [1] Tipagem de dados [2] Funcoes [3] Ponteiros [4] Compostos [5]Arquivos [6] Listas encadeadas [7] Alocacao Dinamica: ");
        scanf(" %d",&input);
        #ifdef _WIN32
            system("cls");
        #else
            system("clear");
        #endif
        puts("");
        MostrarTopico(input);

        if(input==sair){
            break;
        }
    }
}
