public class Homem extends PessoaIMC{
    protected String resultIMC(){
        float IMC=calculaIMC(altura,peso);
        if (IMC<20.7){
            return "Abaixo do peso ideal";
        }
        if (IMC<=26.4){
            return "Peso ideal";
        }
        return "Acima do peso ideal";
    }
    public String toString(){
        String anterior=super.toString();
        String output=anterior+String.format("""

        %s (IMC de %.2f)
        Idade: %d
        Gênero: Masculino
        """,
        resultIMC(),calculaIMC(altura,peso),idade());
        return output;
    }
    public Homem(String nome,String sobreNome, int dia, int mes, int ano){
        super(nome,sobreNome,dia,mes,ano);
    }
    public Homem(String nome,String sobreNome, int dia, int mes, int ano,String numCPF,float peso, float altura){
        super(nome,sobreNome,dia,mes,ano,numCPF,peso,altura);
    }
}