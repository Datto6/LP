#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>
#ifndef CONSTANTES_H
#define CONSTANTES_H

#define novalinha '-'
#define novotopico '$'
#define inicioinfo '@'
#define finalinfo '~'
#define ARQUIVO_ALOC "alocacao.txt"

// chars =='-' serao equivalentes a \n na saida, e '$' Significa um novo topico

typedef enum entrada{
    sair,  //0
    tipagem, funcoes, ponteiros, compostos, arquivos, encadeadas, alocacao //1,2,3,4,5,6,7
}entrada;

typedef struct No{
    int numero;
    char* nome; //tamanho do nome do topico
    struct No* prox;
}No;

void InsereEnc(No ** L, int e,int tam, No ** u) {  //cria um novo vetor de char
	No * novo = (No *) malloc(sizeof(No));
    novo->nome=(char*) malloc(sizeof(char)*tam);
	novo->numero = e; novo->prox = NULL; 
	if (*u == NULL) {
		*L = novo; 
	} else {
		(*u)->prox = novo;
	}
	*u = novo; 
}


#endif