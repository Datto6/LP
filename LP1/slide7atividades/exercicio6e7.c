# include <stdio.h>

struct Surfista{
    int borda;
    int aereo;
    int tubo;
    int tamanho_onda;
    int fraude;
    char nome[255];
};

void Exibir(struct Surfista cara){
    printf("Seu surfe de borda é nota %d\n", cara.borda);
    printf("Seus aéreos são nota %d\n", cara.aereo);
    printf("Seus tubos são nota %d\n", cara.tubo);
    printf("Sua seleção de ondas é %d\n", cara.tamanho_onda);
    if (cara.fraude){
        printf("Ele é uma fraude\n");
    }
    else{
        printf("Ele não é uma fraude\n");
    }
    printf("seu nome é %s\n", cara.nome);
}
void preencheB(struct Surfista* ptr){
    scanf("%d",&ptr->borda);
    scanf("%d",&ptr->aereo);
    scanf("%d",&ptr->tubo);
    scanf("%d",&ptr->tamanho_onda);
    scanf("%d",&ptr->fraude);
    scanf("%s",ptr->nome);
}
int main(void){
    struct Surfista medina={10,10,10,10,0,"Medina"};
    struct Surfista toledo={10,8,3,6,0,"Filipe Toledo"};
    struct Surfista griffin={6,3,4,5,1,"Griffin Colapinto"};
    Exibir(medina);
    Exibir(toledo);
    Exibir(griffin);
    return 0;
}



