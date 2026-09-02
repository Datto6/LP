public class Homem extends Pessoa{
    public String toString(){
        String str_pessoa=super.toString();
        String output=str_pessoa+String.format("""
        Idade: %s
        Gênero: Masculino
        CPF: %s
        Peso:%.2f kg
        Altura: %.2f m
        """,
        idade(),get_numCPF(),get_peso(),get_altura());
        return output;
    }
    public Homem(String nome,String sobreNome, int dia, int mes, int ano){
        super(nome,sobreNome,dia,mes,ano);
    }
    public Homem(String nome,String sobreNome, int dia, int mes, int ano,String numCPF,float peso, float altura){
        super(nome,sobreNome,dia,mes,ano,numCPF,peso,altura);
    }
}