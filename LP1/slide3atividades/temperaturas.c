# include <stdio.h>
int main(void){
    float media=0;
    int temps;
    printf("Quantas temperaturas você quer enviar?");
    scanf("%d",&temps);
    char temperaturas[temps];
    for (int i=0;i<temps;i++){
        scanf("%hhd",&temperaturas[i]);
        media+=temperaturas[i];
    }
    media= (float) media/temps;
    int acima=0;
    for (int i=0;i<temps;i++){
        if (temperaturas[i]>media){
            acima+=1;
        }
    }
    char maiores[acima];
    for (int i=0;i<acima;){
        for (int j=i;j<temps;j++){
            if (temperaturas[j]>media){
                maiores[i]=temperaturas[j];
                i++;
                if (i==acima){
                    break;
                }
            }
        }
    }
    printf("Media é %f, e numeros acima da média são %d\n", media,acima);
    for (int i=0;i<acima;i++){
        printf("%d\n",maiores[i]);
    }
    return 0;
}
