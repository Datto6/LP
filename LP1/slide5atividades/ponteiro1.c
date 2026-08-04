# include <stdio.h>
int main(void){
    int a;
    int b;
    int* ponteiro;
    scanf("%d %d",&a,&b);
    printf("%d %d\n",a,b);
    if (a>b){
        ponteiro=&a;
    }
    else {
        ponteiro=&b;
    }
    *ponteiro= *ponteiro-50;
    printf("%d %d\n",a,b);
    return 0;
}
