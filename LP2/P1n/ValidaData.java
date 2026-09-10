import java.time.LocalDate;
public class ValidaData{
    public static boolean isDia(int dia){
        if (dia<=0 || dia>31){
            return false;
        }
        return true;
    }
    public static boolean isDia(String dia){
        if(dia.matches("\\d{1,2}")){ //formato só pode ser 2 digitos
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
        if(mes.matches("\\d{1,2}")){ //formato só pode ser 2 digitos
            return isMes(Integer.parseInt(mes));
        }
        else if(mes.matches("[a-z]{4,9}")){
            for (Mes n: Mes.values()){ //itera sobre todos os valores
                if(mes.equals(n.name())){
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
            Mes considerado=Mes.values()[mes - 1]; //values retorna um array indexado por 0 dos meses, janeiro é 0
            if (mes == 2 && dia == 29) {
                return LocalDate.of(ano, 2, 1).isLeapYear();
            }
            if(considerado.get_Qntd_dias()<dia){ //considerar validade de dia dado o mes
                return false;
            }
            return true;
        }
        return false;
    }
    public static boolean isDataValida(String ano, String mes, String dia){
        if (isMes(mes) && isDia(dia) && isAno(ano)){ //os 3 tem que ser validos 
            int num_mes;
            Mes considerado;
            if (mes.matches("\\d{1,2}")) {
                num_mes = Integer.parseInt(mes);
                considerado = Mes.values()[num_mes - 1];
            }
            else {
                considerado = Mes.valueOf(mes); //pego um mes dado o nome dele usando o Enum
                num_mes=considerado.ordinal()+1;
            } 
            int num_dia=Integer.parseInt(dia);
            int ano_num=Integer.parseInt(ano);
            if (num_mes == 2 && num_dia == 29) {
                return LocalDate.of(ano_num, 2, 1).isLeapYear();
            }
            if(considerado.get_Qntd_dias()<num_dia){ //considerar validade de dia dado o mes
                return false;
            }
            return true;
        }
        return false;
    }
}