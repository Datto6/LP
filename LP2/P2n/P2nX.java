import java.util.Scanner;
import java.util.ArrayList;
public class P2nX{
    public static int inputInicial(Scanner scanner){
        System.out.println(""" 
        1.Imprimir Lista
        2. Sair""");
        System.out.print("Digite sua opção: ");
        String entrada=scanner.nextLine();
        while(!entrada.equals("1") && !entrada.equals("2")){
            if (entrada.equals("")){
                return 0; //saida manual
            }
            System.out.println("Entrada errada, apenas 1 e 2 são aceitos. Tente de novo");
            entrada=scanner.nextLine();
        }
        int saida=Integer.parseInt(entrada);
        System.out.println();
        return saida;
    }
    public static boolean ImprimirLista(Scanner scanner, MinhaListaOrdenavel pessoas){
        System.out.println("""
        Escolha seu modo de ordenação
        1.Alfabética(A-Z)
        2.Alfabética (Z-A)
        3.Peso(crescente)
        4.Peso(descendente)
        5.IMC(crescente)
        6.IMC(descendente)
        7.Gênero(Homens antes de mulheres)
        8.Gênero(contrário)
        9.Idade(crescente)
        10.Idade(descendente)
        11.Data de Nascimento(crescente)
        12.Data de nascimento(descendente)
        13.CPF(Crescente)
        14.CPF(Descendente)
        15.Nenhum, imprimir como está""");
        String entrada = scanner.nextLine();

        if (entrada.equals("")) {
            return true;
        }

        while (!entrada.matches("\\d{1,2}")) {
            System.out.println("Formato inadequado, resposta deve ser número entre 1 e 15");
            System.out.print("Tentar de novo: ");
            entrada = scanner.nextLine();

            if (entrada.equals("")) {
                return true;
            }
        }

        int forma = Integer.parseInt(entrada) - 1;

        while (forma < 0 || forma > 14) {
            System.out.println("Número inválido. Digite uma opção entre 1 e 15:");
            entrada = scanner.nextLine();

            if (entrada.equals("")) {
                return true;
            }

            if (entrada.matches("\\d{1,2}")) {
                forma = Integer.parseInt(entrada) - 1;
            }
        }
        ArrayList<PessoaIMC> to_display;
        if (forma==14){
            to_display=pessoas.get_lista();
        }
        else{
            to_display=pessoas.ordena(forma);
        }
        for (int i=0;i<10;i++){
            System.out.println("---------------");
            System.out.println(String.format("Pessoa número %d",i+1));
            System.out.println(to_display.get(i).toString());
        }
        return false;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        MinhaListaOrdenavel pessoas= new MinhaListaOrdenavel();
        // 5 Mulheres
        pessoas.add(new Mulher("Ana", "Silva", 15, 3, 2000, "123.456.789-09", 55.0f, 1.65f)); //sem o f eles são tratados como double, dá ruim
        pessoas.add(new Mulher("Beatriz", "Santos", 22, 7, 1998, "234.567.890-92", 62.0f, 1.68f));
        pessoas.add(new Mulher("Carolina", "Oliveira", 10, 11, 2002, "345.678.901-75", 70.0f, 1.72f));
        pessoas.add(new Mulher("Daniela", "Costa", 5, 1, 1995, "456.789.012-49", 80.0f, 1.70f));
        pessoas.add(new Mulher("Fernanda", "Pereira", 30, 9, 2001, "567.890.123-03", 48.0f, 1.60f));

        // 5 Homens
        pessoas.add(new Homem("João", "Souza", 12, 5, 1999, "012.345.678-90", 75.0f, 1.80f));
        pessoas.add(new Homem("Pedro", "Lima", 8, 8, 1997, "678.901.234-69", 90.0f, 1.85f));
        pessoas.add(new Homem("Lucas", "Rocha", 20, 2, 2003, "789.012.345-05", 65.0f, 1.75f));
        pessoas.add(new Homem("Marcos", "Almeida", 17, 6, 1990, "890.123.456-42", 105.0f, 1.82f));
        pessoas.add(new Homem("Gabriel", "Martins", 25, 12, 2000, "901.234.567-70", 58.0f, 1.70f));
        int entrada=P2nX.inputInicial(scanner);
        while(entrada!=0 && entrada!=2){ // 0 e 2 valores de quebra
            boolean sair =P2nX.ImprimirLista(scanner,pessoas);
            if(sair){
                break;
            }
            entrada=P2nX.inputInicial(scanner);
        }
    }
}