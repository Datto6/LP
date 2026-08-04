void preenche (int* arr, int l, int c){ // da erro de incompatible pointer type, int**, mas nao vimos array ainda entao pulei
    for (int i=0;i<l;i++){
        for (int j=0;j<c;j++){
            scanf("%d",(arr+j*l+j));
        }
    }
}

float media (int* arr, int l, int c){ //aqui tambem, mesma coisa
    long int soma=0;
    for (int i=0;i<l;i++){
        for (int j=0;j<c;j++){
            soma+= *(arr+j*l+j);
        }
    }
    int divisor=l*c;
    float retorno=(float) soma/divisor;
    return retorno;
}
