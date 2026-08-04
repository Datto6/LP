#include <stdio.h>
#include <string.h>
int main(void){
    char coisa[26];
    scanf("%s",coisa); //pega string de no maximo 25 caracteres 
    FILE* arquivo1=fopen("/home/ime/aula/primeiro.txt","w");
    int max=strlen(coisa); //como o strlen ignora o '\0', da o tamanho bruto ate o '\0'
    for(int i=0;i<max;i++){
        fputc(coisa[i],arquivo1);
    }
    fclose(arquivo1); //fecha o arquivo

    FILE* arquivo2=fopen("/home/ime/aula/primeiro.txt","r"); //abre ele p ler 
    char exibicao[26];
    for(int i=0;i<max;i++){
        int input=fgetc(arquivo2); //le arquivo caractere por caractere 
        if (input!=-1){ //se nao deu EOF
            exibicao[i]=(char)input; //bota dentro de exibicao
        }
    }
    exibicao[max]='\0'; //bota ele depois do ultimo char, pro "%s" dar certo
    printf("%s \n",exibicao);
    fclose(arquivo2);
    return 0; 
}
