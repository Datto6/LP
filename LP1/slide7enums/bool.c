# include <stdio.h>

enum bool{
    false,
    true
};

int main(void){
    if (true){
        printf("True é verdadeiro\n");
    }
    if (!false){
        printf("O contrario de falso é verdadeiro também\n");
    }
    return 0;
}
