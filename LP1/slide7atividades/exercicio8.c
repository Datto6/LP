#include <stdio.h>
#include <math.h>

struct r2 {
    int x;
    int y;
};

void preencheR2(struct r2* ptr,int x,int y){ //funcao p preencher ponto (x,y)
    ptr->x=x;
    ptr->y=y;
}
void vetorpontos(struct r2* lista,int tam){  //funcao q preenche lista de pontos 
    for (int i=0;i<tam;i++){
        struct r2 coisa;
        preencheR2(&coisa,i,tam-i-1);
        lista[i]=coisa;
    }
}

struct r2 distmax(struct r2 p1, struct r2 p2){  //funcao q retorna ponto com distancia max de (0,0)
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

void escreverbonito(struct r2* lista,int quantos,int xmax,int ymax){   //funcao p display de pontos (x,y)
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
            for (int k=0;k<quantos;k++){ //itera pelos pontos
                if (lista[k].x==j && lista[k].y==i){
                    printf(" ! "); 
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
int main(void){
    struct r2 listazona[10];
    vetorpontos(listazona,10);
    struct r2 ponto1;
    struct r2 ponto2;
    preencheR2(&ponto1,3,4);
    preencheR2(&ponto2,19,15);
    escreverbonito(listazona,10,10,10);
    printf("%d\n",distmax(ponto1,ponto2).x);
}
