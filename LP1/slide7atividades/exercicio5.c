# include <stdio.h>
struct Coordenada{
    int x;
    int y;
    int z;
};
void preencheB(struct Coordenada* ptr,int x,int y,int z){
    ptr->x=x;
    ptr->y=y;
    ptr->z=z;
}
int main(void){
    struct Coordenada v1;
    struct Coordenada v2;
    struct Coordenada v3;
    struct Coordenada v4[3];
    preencheB(&v1,1,0,5);
    preencheB(&v2,3,3,3);
    preencheB(&v3,0,10,0);
    printf("Coordenada y de v1 é %d \n",v1.y);
    printf("Coordenada y de v2 é %d \n",v2.y);
    printf("Coordenada y de v3 é %d \n",v3.y);
    v1.z+=10;
    v2.z+=10;
    v3.z+=10;
    printf("Coordenadas de v2: (%d,%d,%d)",v2.x,v2.y,v2.z);
    return 0;
}
