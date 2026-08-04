#include <stdio.h>
#include <string.h>

typedef struct Pessoa {
    int  idade;
    char nome[64];
    int  peso;
} Pessoa;

void preenchePessoa(int idade, char* nome, int peso, Pessoa* ptr){ //preenche um struct pessoa, usando o ptr
    ptr->idade=idade;
    strncpy(ptr->nome,nome,64);
    ptr->peso=peso;
}
void exibePessoa(Pessoa coisa){
    printf("%s",coisa.nome);
    printf(" Sua idade: %d",coisa.idade);
    printf(" Seu peso: %d \n",coisa.peso);
}
//o tamanho do arquivo, em grosso modo, era definido pelos 64 chars de 1 Byte (o resto apenas 8 bytes total)
//usando str len e tamanho  quando o nome eh "rafa" por exemplo, via de 64 Bytes para 4, economiza 60
void escrevePessoa(Pessoa coisa,FILE* f){
    int tamanho=strlen(coisa.nome);
    fwrite(&coisa.idade,sizeof(int),1,f);
    fwrite(&tamanho,sizeof(int),1,f); //armazena tamanho logo depois da idade, para determinar quanto eu leio
    fwrite(coisa.nome,sizeof(char),tamanho,f); //sem isso, ele ia ler 64 chars mesmo se o string fosse 8 chars
    fwrite(&coisa.peso,sizeof(int),1,f); 
}
Pessoa lePessoa(FILE* f){
    Pessoa coisa;
    int tamanho; //limita o numero de char que le de string
    fread(&coisa.idade,sizeof(int),1,f);
    fread(&tamanho,sizeof(int),1,f);
    fread(coisa.nome,sizeof(char),tamanho,f); //le um char tamanho vezes 
    fread(&coisa.peso,sizeof(int),1,f);
    coisa.nome[tamanho]='\0'; //se nao o "%s" da ruim, tem que colocar no ultimo ponto
    return coisa;
}
int main(void){
    Pessoa vec[10];
    FILE* arquivo=fopen("C:\\LP1\\pessoas.bin","rb+");
    int ler;
    printf("Voce quer escrever ou ler conteudo? 1 para escrever e 0 p ler");
    scanf("%d",&ler);
    if (ler){
        for (int i=0;i<3;i++){
            Pessoa coisa;
            int idade;
            int peso;
            char nome[64];
            scanf("%d",&idade);
            scanf("%d",&peso);
            scanf("%s",nome);
            preenchePessoa(idade,nome,peso,&coisa); //preenche o coisa
            vec[i]=coisa; //copia o coisa no vec[i]
            escrevePessoa(vec[i],arquivo); //escreve ele no arquivo
        }
    }
    else{
        for (int i=0;i<3;i++){
            Pessoa coisa=lePessoa(arquivo);
            vec[i]=coisa;
            exibePessoa(vec[i]);
        }
    }

    fclose(arquivo);
    return 0;
}
