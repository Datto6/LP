public class Mulher extends Pessoa{
    public String toString(){
        String output=String.format("""
        Nome da Pessoa: %s
        Sobrenome:%s
        Idade: %s
        Gênero: Feminino
        CPF: %s
        Peso:%.2f kg
        Altura: %.2f m
        """,
        get_nome(),get_sobreNome(),idade(),get_numCPF(),get_peso(),get_altura());
        return output;
    }
    public Mulher(String nome,String sobreNome, int dia, int mes, int ano){
        super(nome,sobreNome,dia,mes,ano);
    }
    public Mulher(String nome,String sobreNome, int dia, int mes, int ano,String numCPF,float peso, float altura){
        super(nome,sobreNome,dia,mes,ano,numCPF,peso,altura);
    }
}