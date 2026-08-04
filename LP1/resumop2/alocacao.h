#include "constantes.h"
#include "baixonivel.h"
#ifndef ALOCACAO_H
#define ALOCACAO_H

FILE* abrirParada(int topico){
        switch (topico){
            case tipagem:
                return fopen("tipagem.txt","rb");
                break;
            case funcoes:
                return fopen("funcoes.txt","rb");
            case ponteiros:
                return fopen("ponteiros.txt","rb");
            case compostos:
                return fopen("compostos.txt","rb");
            case arquivos:
                return fopen("arquivos.txt","rb");
            case encadeadas:
                return fopen("encadeadas.txt","rb");
            case alocacao:
                return fopen("alocacao.txt","rb");
            deafult:
                return NULL;
                break;
        }
}

void MostrarTopico(int topico){
    FILE* arq=abrirParada(topico);
    assert(arq!=NULL);
    int numtopicos=0;
    char lido;
    No* topicos=NULL; No* ultimo=NULL;
    fseek(arq,0,SEEK_SET);
    while(fread(&lido,sizeof(char),1,arq)){ //percorre o arquivo olhando os topicos
        int indiceInicio=ftell(arq);
        int indicefinal;
        if(lido==novotopico){
            numtopicos++;
            while(fread(&lido,sizeof(char),1,arq)){ //enquanto le e nao encontra um :, ou seja o nome inteiro do topico
                if(lido==':'){
                    indicefinal=ftell(arq);
                    break;
                }
            }
            int tam=indicefinal-indiceInicio; //pega o tamanho necessario do nome do topico
            InsereEnc(&topicos,numtopicos,tam+1,&ultimo); //insere na lista encadeada de topicos, inicialmente com o nome vazio
        }
    }
    fseek(arq,0,SEEK_SET);
    int indice=0;
    No* informacoes=NULL; ultimo=NULL;
    while(fread(&lido,sizeof(char),1,arq) && indice<numtopicos){ //percorre o arquivo olhando as informacoes
        int indiceInicio=ftell(arq);
        int indicefinal;
        if(lido==inicioinfo){
            while(fread(&lido,sizeof(char),1,arq)){ //enquanto le e nao encontra um ~
                if(lido==finalinfo){
                    indicefinal=ftell(arq);
                    break;
                }
            }
            int tam=indicefinal-indiceInicio; //pega tamanho do string total da informacao
            InsereEnc(&informacoes,indice,tam+1,&ultimo); //cria lista encadeada de informacoes, com seu respectivo indice, e tamanho a ser alocado
            //string de nome inicialmente vazio
        }
    }
    No* p=topicos; No* q=informacoes; //
    fseek(arq,0,SEEK_SET);
    indice=0;

    while(fread(&lido,sizeof(char),1,arq)){ //percorre o arquivo preenchendo os vetores de topicos e de informacoes
        if(lido==novotopico && p!=NULL){ //encontrou um novo topico e p nao eh nulo
            indice++;
            int j=0;
            while(fread(&lido,sizeof(char),1,arq)){ //le, e quando ver um : para de preencher o topico
                //o loop while para quando ele le 0 em vez de 1, ou seja, chegou ate o final do arquivo
                p->nome[j]=lido;
                if(lido==':'){
                    p->nome[j]=lido;
                    p->nome[j+1]='\0'; //p poder usar %s no printf depois
                    break;
                }
                j++; //indice que estamos preenchendo no nome de cada no de topico
            }
            p=p->prox;//anda com p pra preencher proximo topico
        }
        if(lido==inicioinfo && q!=NULL){ //encontrou um novo info e p nao eh nulo
            int j=0;
            while(fread(&lido,sizeof(char),1,arq)){ //enquanto le e nao encontra um ~
                q->nome[j]=lido;
                if(lido==finalinfo){
                    q->nome[j]='\0'; //p poder usar %s no printf depois
                    break;
                }
                j++;  //identico ao usado no topico
            }
            q=q->prox;// anda pro proximo no de info
        }
    }
    indice=exibeTopicos(topicos)-1; //topico 1 vai ser indice 0, mais facil assim
    p=topicos; q=informacoes;
    int j=0;
    while(p!=NULL && q!=NULL){
        if(j==indice){
            printf("%s ",p->nome);
            printf("%s ",q->nome);
            break;
        }
        j++;
        p=p->prox;
        q=q->prox;
    }
    puts("");
        
    p=topicos; q=informacoes;
    while(p!=NULL && q!=NULL){ //itera sobre encadeadas para desalocar memoria anteriormente usada
        No* pAnt=p; No* qAnt=q;
        p=p->prox;
        q=q->prox;
        free(pAnt->nome);free(qAnt->nome);
        free(pAnt);free(qAnt);
    }
    fclose(arq);
}

#endif