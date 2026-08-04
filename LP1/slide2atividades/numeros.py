
numero1=int(input())    
numero2=int(input())
linha=""
for i in range(numero2-numero1+1):
    linha+=str(numero1+i)+" "
print(linha)
