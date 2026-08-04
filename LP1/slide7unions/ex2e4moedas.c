# include <stdio.h> 
union pessoa {  //exercicio 2 condensado
    int CPF;
    int RG;
    char nome[255];
};
struct  preco{
    int moeda;

    union{
        int real; //0
        int euro; //1
        int dolar; //2
    };
};

void exibe(struct preco coisa){
    switch (coisa.moeda){
        case 0:
            printf("%d reais\n",coisa.real);
            break;
        case 1:
            printf("%d euros\n",coisa.euro);
            break;
        case 2:
            printf("%d dolares\n",coisa.dolar);
            break;
    }
}
void altera(struct preco* coisa,int moeda){
    coisa->moeda=moeda;
    printf("%d\n",coisa->moeda); //isso aqui foi so p testar, releva.
}
int main (void){
    struct preco coisa;
    coisa.dolar=100;
    coisa.moeda=2;
    exibe(coisa);
    altera(&coisa,1);
    exibe(coisa);
    return 0;
}
