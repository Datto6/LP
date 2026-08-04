# include <stdio.h>

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
void array(int* arr, int x, int y, int z){
    arr[0]=x;
    arr[1]=y;
    arr[2]=z;
}
void exibe(struct Animal coisa){
    switch (coisa.tipo){
        case 0: //anfibio
            printf("Numero de patas:%d \n",coisa.especie.anfibio.patas);
            printf("Espessura da pele:%d \n",coisa.especie.anfibio.espessura);
            printf("Cauda ? %d (1 significa sim, 0 nao)\n",coisa.especie.anfibio.cauda);
            break;
        case 1: //ave
            printf("Cm de bico :%d \n",coisa.especie.ave.cmbico);
            printf("Nota de autonomia de voo:%d \n",coisa.especie.ave.autonomia_voo);
            printf("Frequencia do canto:%d \n",coisa.especie.ave.freqcanto);
            break;
        case 2: //mamifero
            printf("Qntd de dentes:%d \n",coisa.especie.mamifero.qnt_dentes);
            printf("Volume do cerebro:%d \n",coisa.especie.mamifero.vol_cerebr);
            printf("Velocidade terrestre:%d \n",coisa.especie.mamifero.vel_terr);
            break;
        case 3: //reptil
            printf("Venenoso?:%d \n",coisa.especie.reptil.venenoso);
            printf("Nota de autonomia na agua:%d \n",coisa.especie.reptil.autonomia_agua);
            printf("Espessura dos ovos:%d \n",coisa.especie.reptil.espess_ovos);
            break;

    }
}
int main(void){
    struct Animal bicho1; //sapo
    struct Animal bicho2; //macaco
    struct Animal bicho3;  //gorila
    struct Animal bicho4;  //cobra
    struct Animal bicho5;  //tartaruga
    struct Animal bicho6;  //aguia
    int arrayteste[3];
    array(arrayteste,5,5,5);

    preenchebicho(&bicho1,0,arrayteste);
    array(arrayteste,5,15,1);

    preenchebicho(&bicho2,2,arrayteste);
    array(arrayteste,50,512,15);

    preenchebicho(&bicho3,2,arrayteste);
    array(arrayteste,03,52,54);

    preenchebicho(&bicho4,3,arrayteste);
    array(arrayteste,9,5,432);

    preenchebicho(&bicho5,0,arrayteste);
    array(arrayteste,553,35,1);

    preenchebicho(&bicho6,1,arrayteste);
    array(arrayteste,1,0,23);

    exibe(bicho1);
    exibe(bicho2);
    exibe(bicho3);
    exibe(bicho4);
    exibe(bicho5);
    exibe(bicho6);
}
