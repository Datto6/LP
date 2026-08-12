import java.time.LocalDate;
import java.time.Month;
import java.util.Random;
public class ExP1Teste{
    public static void main(String[] args){
        String [] BANCO_NOMES={
            "João","Pedro","Eduardo","Henrique","Leonardo","André",
            "Caio","Clara","Carolina","Leticia","Fernanda","Bianca","Natalia","Bruna",
            "Renata","Patricia","Vanessa","Daniela","Aline"};

        String[] BANCO_SOBRENOMES={
            "Silva","Santos","Oliveira","Souza","Pereira",
            "Costa","Rodrigues","Almeida","Nascimento","Lima","Araújo","Fernandes",
            "Carvalho","Gomes","Martins","Rocha","Ribeiro","Alves","Monteiro","Mendes",
            "Barbosa","Freitas"}; //copiei e colei de uma lista qualquer

        String[] BANCO_GENEROS={"Masculino","Feminino", "Não Binário"};
        int n= args.length;
        if (n<1){
            System.out.println("Argumento de número de pessoas esperado, não encontrado, por favor rodar de novo");
            System.exit(0);
        }
        Random rand=new Random();
        int num_pessoas=Integer.parseInt(args[0]);
        Pessoa[] pessoas= new Pessoa[num_pessoas];

        if (num_pessoas>=3){
            pessoas[0]=new Pessoa();
            pessoas[1]=new Pessoa("John Java");
            pessoas[2]=new Pessoa("Peter", "Java","Masculino",LocalDate.of(2002, Month.JANUARY, 8),75.67, 1.85,pessoas[1],pessoas[0]);
            System.out.println(pessoas[0].toString());
            System.out.println(pessoas[1].toString());
            System.out.println(pessoas[2].toString());
        }


        for(int i=0;i<num_pessoas-3;i++){ 
            //para nao sobre escrever os primeiros 3 usando os construtores difereentes, adicionamos 3 ao indice i quando 
            Pessoa generica=new Pessoa();

            int indice_nome=rand.nextInt(BANCO_NOMES.length); 
            int indice_sobrenome=rand.nextInt(BANCO_SOBRENOMES.length); //nome e sobrenome aleatorio
            
            boolean exc_nome=generica.set_nome(BANCO_NOMES[indice_nome]);
            boolean exc_sobrenome=generica.set_sobrenome(BANCO_SOBRENOMES[indice_sobrenome]); //nomes e sobrenome aleatorio pegos dum banco de constantes
            boolean exc_genero=generica.set_genero(BANCO_GENEROS[i%3]); //numero entre 0-2

            int dif_anos=rand.nextInt(100);
            int mes=(dif_anos%12)+1; //de 1 a 12
            int dia=(dif_anos%28)+1;//de 1 a 28, capado porque maiores que 28 possivelmente jogariam DateTimeException em meses como fevereiro
            boolean exc_data=generica.set_data_nascimento(LocalDate.of(2026-dif_anos,mes,dia));

            float peso_aleatorio=rand.nextFloat() *(500); //um float entre 0 e 500
            float altura_aleatoria=rand.nextFloat()*2; //um float entre 0 e 2
            //ambos podem gerar valores invalidos, isso é proposital, para testar a estrutura de tratá-los 
            boolean exc_peso=generica.set_peso(peso_aleatorio);
            boolean exc_altura=generica.set_altura(altura_aleatoria);

            boolean exc_pai=generica.set_pai(pessoas[i+2]);
            boolean exc_mae=generica.set_mae(pessoas[i+1]);
            System.out.println(generica.toString());
            pessoas[i+3]=generica;
            System.out.println(String.format("Pessoas feitas: %d\n",Pessoa.feitos()));
        }
    }
}