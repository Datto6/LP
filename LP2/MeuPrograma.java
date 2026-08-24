class MeuPrograma{
    private static Automovel carro1;
    private static Motorista motorista1,motorista2;
    //Entry point do programa
    public static void main( String args[] ){
        //Instanciando novos objetos
        carro1 = new Automovel("Chevette", 87);
        motorista1 = new Motorista("João", carro1);
        motorista2 = new Motorista("Pedro", carro1);
        //Imprimindo o nome dos motoristas
        System.out.println( motorista1.obterNome());
        System.out.println( motorista2.obterNome());
    }
}