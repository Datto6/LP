#include <stdio.h>
enum Dia{
    Dom,
    Seg,
    Ter,
    Qua,
    Qui,
    Sex,
    Sab
};

char * nome(enum Dia dia){
    switch (dia){
        case Dom:
            return "Domingo";
            break;
        case Seg:
            return "Segunda";
            break;
        case Ter:
            return "Terca";
            break;
        case Qua:  
            return "Quarta";
            break;
        case Qui:
            return "Quinta";
            break;
        case Sex:
            return "Sexta";
            break;
        case Sab:
            return "Sabado";
            break;
    }
}
int main(void){
    printf("%s\n", nome(Ter));
    return 0;
}
