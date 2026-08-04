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
Caixa* concatena (struct Caixa* l1, struct Caixa* l2) { //concatena duas listas encadeadas
	Caixa* p=l1;
	Caixa* retorno=NULL;
	while (p->prox!=NULL){
		p=p->prox;
	}
	p->prox=l2;
	return l1;
}

int main(void){
    Caixa coisa1, coisa2, coisa3, coisa4, coisa5; //declaracoes de caixas
    Caixa* cabeca=&coisa1;
    coisa1=constroi(&coisa2,1);
    coisa2=constroi(&coisa3,3);
    coisa3=constroi(&coisa4,9);
    coisa4=constroi(&coisa5,7);
    coisa5=constroi(NULL,5); //NULL porque e o ultimo elemento da lista

    Caixa coisa6, coisa7, coisa8;
    coisa6=constroi(&coisa7,10);
    coisa7=constroi(&coisa8,12);
    coisa8=constroi(NULL,18);
    Caixa* cabeca2=&coisa6;
    exibe(cabeca); //exibe antes
    exibe(cabeca2);
    cabeca=concatena(cabeca,cabeca2);
    exibe(cabeca); //exibe depois de concatenacao
    return 0;
}
