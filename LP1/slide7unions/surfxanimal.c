# include <stdio.h>
#include <string.h>
struct Surfista{
    int borda;
    int aereo;
    int tubo;
    int tamanho_onda;
    int fraude;
    char nome[255];
};

struct Animal{
    int tipo; 
    union {
        struct anfibio{ //tipo=0
            int patas;
            int espessura;
            int cauda;
        } anfibio;
        struct ave{  //tipo =1
            int cmbico;
            int autonomia_voo;
            int freqcanto;
        } ave; //nome do atributo da union
        struct mamifero{ //tipo ==2
            int qnt_dentes;
            int vol_cerebr;
            int vel_terr;
        } mamifero;
        struct Reptil{  //tipo ==3
            int venenoso;
            int autonomia_agua;
            int espess_ovos;
        } reptil;
    } especie; //especia e nome do atributo union da struct animal
};

void preenchebicho(struct Animal* ptr,int tipo, int arr[]){ //funcao p preencher animal
    ptr->tipo=tipo;
    switch (ptr->tipo){
        case 0:
            ptr->especie.anfibio.patas=arr[0];
            ptr->especie.anfibio.espessura=arr[1];
            ptr->especie.anfibio.cauda=arr[2];
            break;
        case 1:
            ptr->especie.ave.cmbico=arr[0];
            ptr->especie.ave.autonomia_voo=arr[1];
            ptr->especie.ave.freqcanto=arr[2];
            break;
        case 2:
            ptr->especie.mamifero.qnt_dentes=arr[0];
            ptr->especie.mamifero.vol_cerebr=arr[1];
            ptr->especie.mamifero.vel_terr=arr[2];
            break;
        case 3:
            ptr->especie.reptil.venenoso=arr[0];
            ptr->especie.reptil.autonomia_agua=arr[1];
            ptr->especie.reptil.espess_ovos=arr[2];
            break;
    }
}

// void preencheB(struct Surfista* ptr){
//     scanf("%d",&ptr->borda);
//     scanf("%d",&ptr->aereo);
//     scanf("%d",&ptr->tubo);
//     scanf("%d",&ptr->tamanho_onda);
//     scanf("%d",&ptr->fraude);
//     scanf("%s",ptr->nome);
// }
void preencheSurf(struct Surfista* ptr, int* arr,char nome[]){
    ptr->borda=arr[0];
    ptr->aereo=arr[1];
    ptr->tubo=arr[2];
    ptr->tamanho_onda=arr[3];
    ptr->fraude=arr[4];
    strncpy(ptr->nome,nome,7);
}

struct entidade{
    int classe;
    union{
        struct Surfista surfista; //classe 0
        struct Animal animal;  //classe 1
    };
};

void ExibeAnimal(struct Animal coisa){ //nao terminei ainda, falta reptil e pormenores do printf p testar
    switch (coisa.tipo){
        case 0: //anfibio
            printf("Numero de patas:%d \n",coisa.especie.anfibio.patas);
            printf("Espessura da pele:%d \n",coisa.especie.anfibio.espessura);
            printf("Cauda ? %d (1 significa sim, 0 nao)\n",coisa.especie.anfibio.cauda);
            break;
        case 1: //ave
            printf("Cm de bico:%d \n",coisa.especie.ave.cmbico);
            printf("Autonomia de voo:%d \n",coisa.especie.ave.autonomia_voo);
            printf("Frequencia de canto:%d \n",coisa.especie.ave.freqcanto);
            break;
        case 2: //mamifero
            printf("Qntd de dentes%d \n",coisa.especie.mamifero.qnt_dentes);
            printf("Volume cerebral:%d \n",coisa.especie.mamifero.vol_cerebr);
            printf("Velocidade terrestre:%d \n",coisa.especie.mamifero.vel_terr);
            break;
        case 3: //reptil
            printf("Venenoso escala%d \n",coisa.especie.reptil.venenoso);
            printf("Autonomia na agua:%d \n",coisa.especie.reptil.autonomia_agua);
            printf("Espessura dos ovos:%d \n",coisa.especie.reptil.espess_ovos);
            break;
    }
}

void ExibeSurf(struct Surfista cara){
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

void preencheEntidade(struct entidade* ptr, int classe,int arr[],char nome[],int tipo){
    ptr->classe=classe;
    if(ptr->classe==0){
        preencheSurf(&(ptr->surfista),arr,nome);
    }
    if (ptr->classe==1){
        preenchebicho(&(ptr->animal),tipo,arr);
    }
}
void ExibeEntidade(struct entidade coisa){
    if (coisa.classe){
        ExibeAnimal(coisa.animal);
    }
    else {
        ExibeSurf(coisa.surfista);
    }
}
int main(void){
    struct entidade teste;
    int classe=0;
    int arr[5]={1,2,3,4,0};
    char nome[]="Medina";
    int tipo=0;
    preencheEntidade(&teste,classe,arr,nome,tipo);
    ExibeEntidade(teste);
    return 0;
}
