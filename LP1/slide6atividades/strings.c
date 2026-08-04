# include <stdio.h>
int tamanho (char* str){
    int i=0;
    while(str[i]!='\0'){
        i++;
    }
    return i; //i nao contem o byte terminador, output eh igual ao strlen
}
void concatena (char* d, char* o1, char* o2){
    int t1=tamanho(d);
    int t2=tamanho(o1);
    int t3=tamanho(o2);
    int i=0;
    for (;i<t2+t3;i++){
        if (i<t2) {
            *(d+i)= *(o1+i); //adiciona char do string primeiro, do o1 
            //d[i]=o1[i]
        }
        else{
            *(d+i)= *(o2+(i-t2)); //adiciona char do segundo string, do o2
            //d[i]=o2[i-t2]
        }

    }
    //d[i]='\0'
    *(d+i)='\0';
}
int main(void){
    printf("%d\n",tamanho("coisa"));
    char teste[50];
    char seg[10]="coisa";
    char ter[10]="mais";
    concatena(teste,seg,ter);
    printf("%s\n",teste);
    printf("%d\n",tamanho(teste));
    return 0;
}
