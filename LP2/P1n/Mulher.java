public class Mulher extends Pessoa{
    public String toString(){
        String saida=super.toString();
        String output=String.format("""
        Idade: %s
        Gênero: Feminino
        CPF: %s
        Peso:%.2f kg
        Altura: %.2f m
        """,
        idade(),numCPF,peso,altura);
        return output;
    }
    public Mulher(String nome,String sobreNome, int dia, int mes, int ano){
        super(nome,sobreNome,dia,mes,ano);
    }
    public Mulher(String nome,String sobreNome, int dia, int mes, int ano,String numCPF,float peso, float altura){
        super(nome,sobreNome,dia,mes,ano,numCPF,peso,altura);
    }
}