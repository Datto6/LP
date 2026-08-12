public class ExP1Teste{
    public static main(String[] args){
        String [] BANCO_NOMES={};
        String[] BANCO_GENEROS={};
        int n= args.length;
        if (n<1){
            System.out.println("Argumento de número de pessoas esperado, não encontrado, por favor rodar de novo");
            System.exit(0);
        }
        int num_pessoas=args[0];
        Pessoa[] pessoas= new Pessoa[num_pessoas];
        if (num_pessoas>3){
            pessoas[0]=Pessoa();
            pessoas[1]=Pessoa("John Java");
            pessoas[2]=Pessoa("Peter", "Java","Masculino",LocalDate.of(2002, Month.JANUARY, 8);,75.67, 1.85,pessoas[1],pessoas[0]);
        }
        for(int i=3;i<n;i++){
            Pessoa generica=Pessoa();
                public String get_nome();
                public boolean set_nome(String nome);

                public String get_sobrenome();
                public boolean set_sobrenome(String sobrenome);

                public String get_genero();
                public boolean set_genero(String genero);

                public LocalDate get_data_nascimento();
                public boolean set_data_nascimento(LocalDate data);

                public double get_peso();
                public boolean set_peso(double peso);

                public double get_altura();
                public boolean set_altura(double altura);

                public Pessoa get_pai();
                public boolean set_pai(Pessoa pai);

                public Pessoa get_mae();
                public boolean get_mae(Pessoa mae);
                private int idade();
                public void status();
                public static int feitos();
                private void adicionar_criado();
            System.out.println(generica.toString());
            pessoas[i]=generica;
            System.out.println(String.format("Pessoas feitas: %d",Pessoa.feitos()))
        }
    }
}