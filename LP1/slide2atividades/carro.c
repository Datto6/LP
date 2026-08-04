# include <stdio.h>
int main(void){
    double milhas;
    double kph;
    scanf("%lf",&milhas);
    kph=milhas*1.6;
    if (kph<80){
        printf("ACELERE\n");
    }
    else if (kph>=80 && kph<=100){
        printf("MANTENHA\n");
    }
    else{
        printf("DESACELERE\n");
    }
    return 0;
}
