import java.util.Scanner;
public class P1nX{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        // String[] argumentos;
        // if (args.length!=9){
        //     System.out.println("Número invalido de argumentos, por favor entrar argumentos usando o template abaixo");
        //     System.out.println("<genero> <nome> <sobre> <dia> <mes> <ano> <CPF> <peso> <altura>");
        //     System.out.println("Inputtar argumentos:");
        //     String linha=scanner.nextLine();
        //     argumentos=linha.split(" ");
        //     while(argumentos.length!=9){
        //         System.out.println("Número invalido de argumentos, por favor entrar argumentos usando o template abaixo");
        //         System.out.println("<genero> <nome> <sobre> <dia> <mes> ano> <CPF> <peso> <altura>");
        //         System.out.println("Inputtar argumentos:");
        //         linha=scanner.nextLine();
        //         argumentos=linha.split(" "); //muda referencia de argumentos, cada linha.split(" ") gera um novo array de strings separados pelo " "
        //     }
        // }
        // else{
        //     argumentos=args.split(" ");
        // }
        // //argumentos agora é um array de strings com os argumentos do inicio 
        // while(argumentos[0]!="m" || argumentos[0]!="f"){
        //     System.out.println("Parâmetro gênero inválido, por favor inserir f para feminino ou m para masculino");
        //     argumentos[0]=scanner.nextLine();
        // }
        Homem teste= new Homem("Rafael","Carvalho",16, 3, 2006,"13261939702",73, (float) 1.83);
        Pessoa t2=new Pessoa("Rafaela","Carvalho",16, 3, 2006,"13261939702",73, (float) 1.83);
        System.out.println(teste);
        Pessoa t1= teste;
        System.out.println(t1);
        System.out.println(t1 instanceof Homem); //deu true

        System.out.println(t2);
        System.out.println(t2 instanceof Homem); //deu false
    }
}