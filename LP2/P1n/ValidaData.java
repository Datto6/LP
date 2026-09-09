public class ValidaData{
    public static boolean isDia(int dia){
        if (dia<=0 || dia>31){
            return false;
        }
        return true;
    }
    public static boolean isDia(String dia){
        if(dia.matches("\\d{2}")){ //formato só pode ser 2 digitos
            int num_dia=Integer.parseInt(dia);
            if (num_dia<=0 || num_dia>31){
                return false;
            }
            else{
                return true;
            }
        }
        return false;
    }
    public static boolean isMes(int mes){
        if (mes<=0 || mes>12){
            return false;
        }
        return true;
    }
    public static boolean isMes(String mes){
        if(mes.matches("\\d{2}")){ //formato só pode ser 2 digitos
            return isMes(Integer.parseInt(mes));
        }
        else if(mes.matches("[a-z]{4,9}")){
            for (Mes n: Mes.values()){ //itera sobre todos os valores
                if(mes.equals(n)){
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    public static boolean isAno(int ano){
        LocalDate hoje= LocalDate.now();
        int ano_atual=hoje.getYear();
        if (ano<(ano_atual-120) || ano>ano_atual){ //se está no range atual
            return false;
        }
        return true;
    }
    public static boolean isAno(String ano){
        if (ano.matches("\\d{4}")){ //se são 4 digitos
            return isAno(Integer.parseInt(ano)); //chamar funcao numérica
        }
        return false;
    }    
    public static boolean isDataValida(int ano, int mes, int dia){ //qual é o sentido de uma data numérica?
        if (isMes(mes) && isDia(dia) && isAno(ano)){ //os 3 tem que ser validos 
            Mes considerado=Mes.mes; //uso de Enum
            if(considerado.get_Qntd_dias()<dia){ //considerar validade de dia dado o mes
                return false;
            }
            return true;  //checar se é ano bissexto?
        }
        return false;

    }
    public static boolean isDataValida(String data){
        return false;
    }

}