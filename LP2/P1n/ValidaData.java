public class ValidaData{
    public static boolean isDia(int dia){
        if (dia<=0 || dia>31){
            return false;
        }
        return true;
    }
    public static boolean isDia(String dia){
        if(dia.matches("\\d{2}")){ //formato só pode ser 2 digitos
            int num_dia=String.parseInt(dia);
            if (num_dia<=0 || num_dia>31){
                return false;
            }
            else{
                return true
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
            return isMes(String.parseInt(mes));
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
            return isAno(String.parseInt(ano)); //chamar funcao numérica
        }
        return false;
    }    
    public static boolean isDataValida(int data){ //qual é o sentido de uma data numérica?
        if (data<=0){
            return false;
        }
        int tamanho_numero = (int) (Math.log10(data) + 1); //acha quantos digitos tem o numero data
        if (tamanho_numero!=8){
            return false;
        }
        String data_str=Integer.toString(data); //agora data mm/dd/yyyy (só que sem yy)
        String mes=data_str.substring(0,2);
        String dia=data_str.substring(2,4);
        String ano=data_str.substring(4);
        if (isMes(mes) && isDia(dia) && isAno(ano)){ //os 3 tem que ser validos 
            Mes considerado=Mes.mes;
            int dia_numerico=Integer.parseInt(dia);
            if(considerado.get_Qntd_dias()<dia_numerico){ //considerar validade de dia dado o mes
                return false;
            }
            return true;
        }
        return false;

    }
    public static boolean isDataValida(String data){
        
    }

}