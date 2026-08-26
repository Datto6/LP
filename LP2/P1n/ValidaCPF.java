public class ValidaCPF{
    public static Boolean isCPF(String CPF) {
        // considera-se erro CPF"s formados por uma sequencia de numeros iguais
        int dig10,dig11;
        int num,sum
        if CPF.matches("\\d{11}"){ //formato de 11 digitos bruto
            dig10=Character.getNumericValue(CPF.charAt(9)); //numeros reais
            dig11=Character.getNumericValue(CPF.charAt(10));
            num;
            peso=10;
            sm=0;
            for (i=0; i<9; i++) {
                num =Character.getNumericValue(CPF.charAt(i)); //converte char i em numero
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            int r=11-(sm%11); //digito de verificacao numero 1 
            if (r==10 || r==11){
                r=0;
            }
            if (r!=dig10){
                return false;
            }
            sm=0
            peso=11;
            for (i=0; i<10; i++) {
                num =Character.getNumericValue(CPF.charAt(i)); //convert char i em numero
                sm = sm + (num * peso);
                peso = peso - 1; //decrementa peso
            }
            int r2=11-(sm%11);
            if (r2==10 || r2==11){
                r2=0;
            }
            if (r2!=dig11){
                return false;
            }
            return true;
        }
        if CPF.matches("\\d{3}[.]\\d{3}[.]\\d{3}([-]|[/])\\d{2})"){ //ddd.ddd.ddd(- ou /)dd
            dig10=Character.getNumericValue(CPF.charAt(12)); //numeros reais do string 
            dig11=Character.getNumericValue(CPF.charAt(13));
            num;
            peso=10;
            sm=0;
            for (i=0; i<12; i++) {
                if(CPF.charAt(i)!='.' && CPF.charAt(i)!='/' && CPF.charAt(i)!='-'){
                num =Character.getNumericValue(CPF.charAt(i));
                sm = sm + (num * peso);
                peso = peso - 1;
                }
            }
            int r=11-(sm%11); //digito de verificacao numero 1 
            if (r==10 || r==11){
                r=0;
            }
            if (r!=dig10){
                return false;
            }
            sm=0;
            peso=11;
            for (i=0; i<13; i++) {
                if(CPF.charAt(i)!='.' && CPF.charAt(i)!='/' && CPF.charAt(i)!='-'){
                num =Character.getNumericValue(CPF.charAt(i));
                sm = sm + (num * peso);
                peso = peso - 1;
                }
            }
            int r2=11-(sm%11);
            if (r2==10 || r2==11){
                r2=0;
            }
            if (r2!=dig11){
                return false;
            }
            return true;
        }
        return false;
    }
}