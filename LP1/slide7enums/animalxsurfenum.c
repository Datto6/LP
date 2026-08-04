# include <stdio.h>
#include <string.h>
enum Entidade{
    surfista,
    animal
};
enum Especie{ //0,1,2,3,4....
    anfibio, ave,
    mamifero, reptil
};
enum Afirmacao{
    nao,
    sim  
};
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
    char nomeesp[255]; //string de no maximo 254 caracteres
    char cor[255];
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
    };
};

void preenchebicho(struct Animal* ptr,int tipo, int arr[], char nomeesp[],char cor[]){ //funcao p preencher animal
    ptr->tipo=tipo;
    strncpy(ptr->nomeesp,nomeesp,255);
    strncpy(ptr->cor,cor,255);
    switch (ptr->tipo){
        case anfibio:
            ptr->anfibio.patas=arr[0];
            ptr->anfibio.espessura=arr[1];
            ptr->anfibio.cauda=arr[2];
            break;
        case ave:
            ptr->ave.cmbico=arr[0];
            ptr->ave.autonomia_voo=arr[1];
            ptr->ave.freqcanto=arr[2];
            break;
        case mamifero:
            ptr->mamifero.qnt_dentes=arr[0];
            ptr->mamifero.vol_cerebr=arr[1];
            ptr->mamifero.vel_terr=arr[2];
            break;
        case reptil:
            ptr->reptil.venenoso=arr[0];
            ptr->reptil.autonomia_agua=arr[1];
            ptr->reptil.espess_ovos=arr[2];
            break;
    }
}

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
    printf("%s \n",coisa.nomeesp);
    printf("%s\n",coisa.cor);
    switch (coisa.tipo){
        case anfibio: //anfibio
            printf("Numero de patas:%d \n",coisa.anfibio.patas);
            printf("Espessura da pele:%d \n",coisa.anfibio.espessura);
            printf("Cauda ? %d (1 significa sim, 0 nao)\n",coisa.anfibio.cauda);
            break;
        case ave: //ave
            printf("Cm de bico:%d \n",coisa.ave.cmbico);
            printf("Autonomia de voo:%d \n",coisa.ave.autonomia_voo);
            printf("Frequencia de canto:%d \n",coisa.ave.freqcanto);
            break;
        case mamifero: //mamifero
            printf("Qntd de dentes%d \n",coisa.mamifero.qnt_dentes);
            printf("Volume cerebral:%d \n",coisa.mamifero.vol_cerebr);
            printf("Velocidade terrestre:%d \n",coisa.mamifero.vel_terr);
            break;
        case reptil: //reptil
            printf("Venenoso escala%d \n",coisa.reptil.venenoso);
            printf("Autonomia na agua:%d \n",coisa.reptil.autonomia_agua);
            printf("Espessura dos ovos:%d \n",coisa.reptil.espess_ovos);
            break;
    }
}

void ExibeSurf(struct Surfista cara){
    printf("Seu surfe de borda eh nota %d\n", cara.borda);
    printf("Seus aereos sao nota %d\n", cara.aereo);
    printf("Seus tubos sao nota %d\n", cara.tubo);
    printf("Sua selecao de ondas eh %d\n", cara.tamanho_onda);
    if (cara.fraude){
        printf("Ele eh uma fraude\n");
    }
    else{
        printf("Ele nao eh uma fraude\n");
    }
    printf("seu nome eh %s\n", cara.nome);
}

void preencheEntidade(struct entidade* ptr, int classe,int arr[],char nome[],int tipo,char cor[]){
    ptr->classe=classe;
    if(ptr->classe==0){
        preencheSurf(&(ptr->surfista),arr,nome);
    }
    if (ptr->classe==1){
        preenchebicho(&(ptr->animal),tipo,arr,nome,cor);
    }
}
void ExibeEntidade(struct entidade coisa){
    if (coisa.classe){ //se classe for de animal, usar exibeanimal
        ExibeAnimal(coisa.animal);
    }
    else {
        ExibeSurf(coisa.surfista);
    }
}
int main(void){
    struct entidade teste;
    int classe=0;
    int arr[5]={1,2,3,4,nao};
    char nome[]="Medina";
    int tipo=0;
    char cor[]="Verde";
    preencheEntidade(&teste,surfista,arr,nome,tipo,nome);

    struct entidade sapoteste;
    int arrsapo[]={4,5,sim};
    char nomesapo[]="Sapinho";

    ExibeEntidade(teste);
    preencheEntidade(&sapoteste,animal,arrsapo,nomesapo,anfibio,cor);
    ExibeEntidade(sapoteste);
    return 0;

}
