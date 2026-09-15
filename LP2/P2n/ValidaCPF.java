public class ValidaCPF{
    public static String formatCPF(String CPF){
        if (CPF.matches("\\d{11}")){ //formato de 11 digitos bruto
            return CPF;
        }
        if(CPF.matches("\\d{3}[.]\\d{3}[.]\\d{3}([-]|[/])\\d{2}")){ //ddd.ddd.ddd(- ou /)dd 
            String saida=CPF.substring(0,3)+CPF.substring(4,7)+CPF.substring(8,11)+CPF.substring(12); //tira pontuacao
            return saida;
        }
        return ""; //entrada inválida, isso é equivalente a nada ou nulo
    }
    public static boolean isCPF(String CPF) {
        // considera-se erro CPF"s formados por uma sequencia de numeros iguais
        int dig10,dig11;
        int num,sm;
        String formatted=formatCPF(CPF);
        if (formatted.equals("") || formatted.equals("00000000000") ||formatted.equals("11111111111") || //"" é formato inválido
                formatted.equals("22222222222") || formatted.equals("33333333333") || //O resto são formas que passam pelo teste matematico
                formatted.equals("44444444444") || formatted.equals("55555555555") ||
                formatted.equals("66666666666") || formatted.equals("77777777777") ||
                formatted.equals("88888888888") || formatted.equals("99999999999")){
            return false;
            }
        dig10=Character.getNumericValue(formatted.charAt(9)); //numeros reais
        dig11=Character.getNumericValue(formatted.charAt(10));
        int peso=10;
        sm=0;
        for (int i=0; i<9; i++) {
            num =Character.getNumericValue(formatted.charAt(i)); //converte char i em numero
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
        sm=0;
        peso=11;
        for (int i=0; i<10; i++) {
            num =Character.getNumericValue(formatted.charAt(i)); //convert char i em numero
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
        return true; //se passou por isso tudo, é verdadeiro
    }
}