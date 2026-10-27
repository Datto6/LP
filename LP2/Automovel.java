public class Automovel{
    public String modelo;
    public int ano;
    private boolean ligado;
    //Instanciar novo automóvel
    public Automovel(String m, int a){
        modelo = m;
        ano = a;
        ligado = false;
    }
    //Ligar automóvel
    public void liga(){
        ligado = true;
    }
    //Desligar automóvel
    public void desliga(){
        ligado = false;
    }
    public static void main( String args[] ){
        //Instanciando novos objetos
        public Automovel carro1= MeuPrograma.carro1;
        public Motorista motorista1= MeuPrograma.motorista1;
        public Motorista motorista2= MeuPrograma.motorista2;
        carro1 = new Automovel("Chevette", 87);
        motorista1 = new Motorista("João", carro1);
        motorista2 = new Motorista("Pedro", carro1);
        //Imprimindo o nome dos motoristas
        System.out.println( motorista1.obterNome());
        System.out.println( motorista2.obterNome());
    }
}