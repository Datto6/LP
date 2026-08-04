#include <stdio.h>
# include <string.h>
struct Time{
        char nome[3];
        int vitorias;
        int derrotas;
        int empates;
        int pontos;
    };
int main(void){
    struct Time lista_times[20]; //OBS, apenas testei usando listas de 3 times (absurdo escrever 100 pts de dado)
    for (int i=1;i<=20;i++){     
        struct Time time_novo;
        scanf("%s",time_novo.nome); //no meu PC funcionou usando o operador &, mas em outro nao, nao sei porque. 
        scanf("%d",&time_novo.vitorias);
        scanf("%d",&time_novo.derrotas);
        scanf("%d",&time_novo.empates);
        time_novo.pontos=time_novo.vitorias*3+time_novo.empates; //calculo de pontos
        lista_times[i]=time_novo;
    }
    int min=50000;
    int max=-1;
    char nome_max[4]; // um a mais pelo bit nulo no final de cada string, se nao ele acaba concatenando com proximo
    char nome_min[4];
    for (int i =1;i<=20;i++){

        if (lista_times[i].pontos>max){
            max=lista_times[i].pontos;
            strcpy(nome_max,lista_times[i].nome);
        }
        if (lista_times[i].pontos<min){
            min=lista_times[i].pontos;
            strcpy(nome_min,lista_times[i].nome);
        }
        
    }
    printf("%d e o maximo de pontos do time %s \n",max,nome_max);
    printf("%d e o minimo do time %s \n",min,nome_min);
    return 0;
}
