#include <stdio.h>
#include <string.h>
int main(void){
    char vec[10][26];
    FILE* arquivo1=fopen("/home/ime/aula/terceiro.txt","w"); //abre um arquivo de txt no modo escrita
    for(int i=0;i<10;i++){
        scanf("%s",vec[i]); //escreve um string de ate 25 caracteres no vec[i], uma matriz de caracteres
    }

    for(int i=0;i<10;i++){
        int max=strlen(vec[i]); //pega tamanho do string em cada linha do vec
        for (int j=0;j<max;j++){
            fputc(vec[i][j],arquivo1); //escreve no arquivo
        }
        fputc('\n',arquivo1); //bota uma linha nova por fins esteticos
    }
    fclose(arquivo1);
    return 0; 
}
