#include <stdio.h>
#include <string.h>

void escreva_string (FILE* f, char* str) { //porque colocar fopen e fclose dentro vai dar ruim?
    int max=strlen(str);
    fwrite(str,sizeof(char),strlen(str),f); //fwrite da para incluir o for loop de antes dentro da propria chamada
}

int main(void){
    char coisa[26];
    scanf("%s",coisa);
    FILE* arquivo1=fopen("C:\\LP1\\teste.txt","wb"); //isso aqui dentro da funcao da seg fault so quando uso vec
    int max=strlen(coisa);
    escreva_string(arquivo1,coisa);

    char vec[10][26];
    for(int i=0;i<10;i++){
        scanf("%s",vec[i]);
    }

    for(int i=0;i<10;i++){
        escreva_string(arquivo1,vec[i]);
        char coisa='\n';
        fwrite(&coisa,sizeof(char),1,arquivo1); //so para separar de linha, formatacao 
    }
    fclose(arquivo1);
    return 0; 
}
