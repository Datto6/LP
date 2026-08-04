# include <stdio.h>
struct Personagem{
    int forca;
    int energia;
    int experiencia;
};



int main(void){
    struct Personagem p1;
    p1.forca=10;
    p1.energia=50;
    p1.experiencia=30;
    struct Personagem p2={18,20,25};
  
    printf("As forcas do p1 e p2 respectivamente: %d %d\n",p1.forca, p2.forca);
    printf("As energias do p1 e p2 respectivamente: %d %d\n",p1.energia, p2.energia);
    printf("As experiencias do p1 e p2 respectivamente: %d %d\n",p1.experiencia, p2.experiencia);
    return 0;
}
