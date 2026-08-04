#include <stdio.h>
#include <math.h>

struct caba { //pontos (x,y)
    int id;
    int x;
    int y;
};

void preencheCaba(struct caba* ptr,int id, int x,int y){ //funcao p preencher ponto (x,y)
    ptr->id=id;
    ptr->x=x;
    ptr->y=y;
}
void vetorpontos(struct caba* lista,int tam){  //funcao q preenche lista de pontos 
    for (int i=0;i<tam;i++){
        struct caba coisa;
        preencheCaba(&coisa,50-i,i,tam-i);
        lista[i]=coisa;
    }
}

struct caba distmax(struct caba p1, struct caba p2){  //funcao q retorna caba com distancia max de (0,0)
    float dist1=sqrt(pow(p1.x,2)+pow(p1.y,2));
    float dist2=sqrt(pow(p2.x,2)+pow(p2.y,2));
    if (dist1>dist2){
        return p1;
    }
    if (dist2>dist1){
        return p2;
    }
    else {
        return p1;
    }
}

void escreverbonito(struct caba* lista,int quantos,int xmax,int ymax){   //funcao que da display de personagens colocando seu ID
    printf("   ");
    for (int i=0;i<=xmax;i++){  //linha das coordenadas x 
        printf(" %2d ",i);
    }
    printf("\n");
    for (int i=0;i<=ymax;i++){ //linha de cada y 
        printf("%2d ",i);
        for(int j=0;j<=xmax;j++){
            printf(" ");
            int printed=0;
            for (int k=0;k<quantos;k++){ //itera pelos personagens 
                if (lista[k].x==j && lista[k].y==i){
                    printf("%2d ",lista[k].id); //2 depois do % garante que tamanho de digito seja 2
                    lista[k]=lista[quantos-1]; //remove de lista  linear sequencial desordenada
                    --quantos;
                    printed=1;
                    break;
                }
            }
            if (!printed){
                printf(" . ");  //caso seja vazio, garante espacamento
            }
        }
        printf("\n");
    }
}
void mostracoord(struct caba* listazona,int num){
    printf("%d %d %d\n",listazona[num].id,listazona[num].x,listazona[num].y);
}
int main(void){
    struct caba listazona[10];
    vetorpontos(listazona,10);
    mostracoord(listazona,9);
    escreverbonito(listazona,10,10,10);
}
