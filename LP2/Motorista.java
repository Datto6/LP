public class Motorista{
    private String nome;
    private Automovel carro;
    //Instancia novo Motorista
    public Motorista( String n, Automovel a){
        nome = n;
        carro = a;
    }
    //Obter o nome do motorista
    public String obterNome(){
        return nome;
    }
    //Obter o carro do motorista
    public Automovel obterCarro(){
        return carro;
    }
}