#include "constantes.h"
#ifndef BAIXONIVEL_H
#define BAIXONIVEL_H

int exibeTopicos(No* coisa){
    No* p=coisa;
    int saida;
    while(p!=NULL){ //enquanto nao chegou ao final
        printf("%s ",p->nome);
        p=p->prox;
        if (p==NULL){
            printf("Escolha o numero do topico que voce quer");
            scanf("%d",&saida);
        } 
    }
    printf("\n");
    return saida;
}

#endif