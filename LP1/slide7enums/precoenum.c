# include <stdio.h> 
enum moeda {
    real,
    euro,
    dolar
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
        case real:
            printf("%d reais\n",coisa.real);
            break;
        case euro:
            printf("%d euros\n",coisa.euro);
            break;
        case dolar:
            printf("%d dolares\n",coisa.dolar);
            break;
    }
}
void altera(struct preco* coisa,int moeda){
    coisa->moeda=moeda;
}
int main (void){
    struct preco coisa;
    coisa.dolar=100;
    coisa.moeda=dolar;
    exibe(coisa);
    altera(&coisa,real);
    exibe(coisa);
    return 0;
}
