#include <stdio.h>
#include <string.h>

typedef struct Pessoa {
    int  idade;
    char nome[64];
    int  peso;
} Pessoa;

void preenchePessoa(int idade, char* nome, int peso, Pessoa* ptr){
    ptr->idade=idade;
    strncpy(ptr->nome,nome,64); //copia ate 64 caracteres dentro de ptr->nome, vindo de nome
    ptr->peso=peso;
}
void exibePessoa(Pessoa coisa){
    printf("%s",coisa.nome);
    printf(" Sua idade: %d",coisa.idade);
    printf(" Seu peso: %d \n",coisa.peso);
}
void escrevePessoa(Pessoa coisa,FILE* f){
    fwrite(&coisa.idade,sizeof(int),1,f);
    fwrite(coisa.nome,sizeof(char),64,f);
    fwrite(&coisa.peso,sizeof(int),1,f);
}
Pessoa lePessoa(FILE* f){
    Pessoa coisa;
    fread(&coisa.idade,sizeof(int),1,f);
    fread(coisa.nome,sizeof(char),64,f);
    fread(&coisa.peso,sizeof(int),1,f);
    return coisa;
}
int main(void){
    Pessoa vec[10];
    FILE* arquivo=fopen("pessoas.bin","rb+");
    int ler;
    printf("Voce quer escrever ou ler conteudo? 1 para escrever e 0 p ler");
    scanf("%d",&ler);
    if (ler){
        for (int i=0;i<3;i++){
            Pessoa coisa;
 //copia os dados de pessoa para o vetor 
            int idade;
            int peso;
            char nome[64];
            scanf("%d",&idade);
            scanf("%d",&peso);
            scanf("%s",nome); //nao preicsa do & porque nome ja eh um vetor, ja eh seu proprio L value
            preenchePessoa(idade,nome,peso,&coisa); //inicializa o coisa
            vec[i]=coisa; //copia o coisa no vec[i]
            escrevePessoa(vec[i],arquivo); //escreve o vec[i] no arquivo
        }
    }
    else{
        for (int i=0;i<3;i++){
            Pessoa coisa=lePessoa(arquivo); //le 3 unidades de pessoa no inicio do arquivo
            vec[i]=coisa;
            exibePessoa(vec[i]);
        }
    }

    fclose(arquivo);
    return 0;
}
