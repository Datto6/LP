#include <stdio.h>
union Ponto{
    int vec[3];
    struct{
        int x;
        int y; //x y e z tem que ser declarados na mesma ordem, se não dá ruim
        int z; 
    };
};


int main(void){
    
    union Ponto pt;
    pt.vec[0] = 10;
    pt.vec[1] = 20;
    pt.vec[2] = 30;
    printf("(%d,%d,%d)\n", pt.x, pt.y, pt.z); //eu to acessando o vec, mas como x y z do struct ficam no mesmo lugar da bom
    printf("(%d,%d,%d)\n", pt.vec[0], pt.vec[1], pt.vec[2]);
    return 0;
}
