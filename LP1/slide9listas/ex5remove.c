# include <stdio.h>
typedef struct Caixa{
    int valor;
    struct Caixa* prox;
}Caixa;

Caixa constroi(Caixa* prox,int x){ 
    Caixa saida;
    saida.prox=prox; //nao "aloca" proximo sozinho, precisa que o programador ja informe
    //scanf("%d",&saida.valor); pega valor com usuario
    saida.valor=x;
    return saida; //retorna variavel local, precisa ser atribuido a um externo fora da função
}
void exibe(Caixa* coisa){
    Caixa* p=coisa;
    while(p!=NULL){ //enquanto nao chegou ao final
        printf("%d",p->valor);
        p=p->prox;
        if (p!=NULL) printf(" ->"); 
    }
    printf("\n");
}
int contem(Caixa* coisa,int valor){
    Caixa* p=coisa;
    while(p!=NULL){
        if(p->valor==valor){
            return 1; //achou, logo contem e true
        }
        p=p->prox;
    }
    return 0; //nao achou, logo nao contem
}

Caixa* removeLista(Caixa** L,int valor){
    Caixa* p=*L;
    Caixa* pAnt=NULL;
    while(p!=NULL){
        if(p->valor==valor){
            if(pAnt==NULL){
                *L=p->prox;
            }
            else{
                pAnt->prox=p->prox;
            }
            break;
        }
        else{
            pAnt=p;
            p=p->prox;
        }

    }
    return *L;
}
int main(void){
    Caixa coisa1, coisa2, coisa3, coisa4, coisa5; //declaracoes de caixas
    Caixa* cabeca=&coisa1;
    coisa1=constroi(&coisa2,1);
    coisa2=constroi(&coisa3,3);
    coisa3=constroi(&coisa4,9);
    coisa4=constroi(&coisa5,7);
    coisa5=constroi(NULL,5); //NULL porque e o ultimo elemento da lista

    exibe(cabeca); //exibe antes
    printf("%d\n",contem(cabeca,9)); //deve retornar 1, pois 9 ainda ta la dentro
    cabeca=removeLista(&cabeca,9);
    exibe(cabeca); //exibe depois de remocao
    printf("%d\n",contem(cabeca,9)); //era para retornar 0, pois 9 foi removido
    coisa3.prox=cabeca; //coloca efetivamente o terceiro como o primeiro, seu prox e a atual cabeca
    cabeca=&coisa3; //atualiza cabeca
    exibe(cabeca);
    printf("%d\n",contem(cabeca,9));
    return 0;
}
