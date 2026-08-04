# include <stdio.h>

int main(void){
    float dollars;
    scanf("%f",&dollars);
    if (dollars*3.17<=1000){ //conversao de dolar do input para real multiplicando pelo preco de cambio dado no enunciado
        printf("BOM NEGOCIO\n");
    }
    else{
        printf("MAU NEGOCIO\n");
    }
    return 0;
}
