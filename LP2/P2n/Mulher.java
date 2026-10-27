public class Mulher extends PessoaIMC{
    protected String resultIMC(){
        float IMC=calculaIMC(altura,peso);
        if(IMC<19){
            return "Abaixo do peso ideal";
        }
        if (IMC<=25.8){
            return "Peso ideal";
        }
        return "Acima do peso ideal";
    }
    public String toString(){
        String anterior=super.toString(); //pega toString de PessoaIMC
        String output=anterior+String.format("""

        %s (IMC de %.2f)
        Idade: %s
        Gênero: Feminino
        """,
        resultIMC(),calculaIMC(altura,peso),idade());
        return output;
    }
    public Mulher(String nome,String sobreNome, int dia, int mes, int ano){
        super(nome,sobreNome,dia,mes,ano);
    }
    public Mulher(String nome,String sobreNome, int dia, int mes, int ano,String numCPF,float peso, float altura){
        super(nome,sobreNome,dia,mes,ano,numCPF,peso,altura);
    }
}