#include <stdio.h>
#include <assert.h>
int main(void){
    int linha;
    scanf("%d",&linha);
    FILE* arq=fopen("ex1.txt","r");
    fseek(arq,23*(linha-1)+9,SEEK_SET); //pegar idade
    int estado[2]; char estadovisivel[3];
    int idade[3]; char idadevisivel[4];

    estadovisivel[2]='\0';
    for(int i=0;i<3;i++){
        idade[i]=fgetc(arq);
        if (idade[i]==EOF){
            printf("Registro nao encontrado\n");
            assert(0);
        }
        
        idadevisivel[i]=(char) idade[i]; //copm retorno de fgetc eh um int, tenho que transformar para um caractere de novo com esse typecast
    }
    idadevisivel[3]='\0'; //byte terminador de string

    fseek(arq,23*(linha-1)+19,SEEK_SET);
    for(int i=0;i<2;i++){
        estado[i]=fgetc(arq);
        if (estado[i]==EOF){
            printf("Registro nao encontrado\n"); 
            assert(0); //como isso sempre da falso, se ele chegar aqui ja da pau no programa
        }
        estadovisivel[i]=(char) estado[i];
    }
    printf("%s\n",idadevisivel);
    printf("%s\n",estadovisivel); //%s pois ja botei o '\0'
    fclose(arq);
    return 0;
}
