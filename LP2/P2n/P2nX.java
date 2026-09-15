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
        return saida;
    }
    public static boolean ImprimirLista(Scanner scanner, MinhaListaOrdenavel pessoas){
        System.out.println("""Escolha seu modo de ordenação
        1.Alfabética(A-Z)
        2.Alfabética (Z-A)
        3.Peso(crescente)
        4.Peso(descendente)
        5.Altura(crescente)
        6.Altura(descendente)
        7.IMC(crescente)
        8.IMC(descendente)
        9.Gênero(Homens antes de mulheres)
        10.Gênero(contrário)
        11.Idade(crescente)
        12.Idade(descendente)
        13.Data de Nascimento(crescente)
        14.Data de nascimento(descendente)
        15.CPF(Crescente)
        16.CPF(Descendente)
        17.Nenhum, imprimir como está""")
        String entrada=scanner.nextLine();
        int forma=16;
        while(!entrada.matches("\\d{1,2}") || forma<0 || forma>16){
            if(entrada.equals("")){ //valor de quebra, se o usuario desistir, isso equivale a um enter
                return true;
            }
            System.out.println("Formato inadequado, resposta deve ser número entre 1 e 17");
            System.out.print("Tentar de novo");
            entrada=scanner.nextLine();
            if(entrada.matches("\\d{1,2}")){ //converto em numerico se possivel, checo se valor numerico ta certo
                forma=Integer.parseInt(entrada)-1;
            }

        }
        ArrayList to_display;
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
        pessoas.add(new Mulher("Ana", "Silva", 15, 3, 2000, "12345678901", 55.0f, 1.65f)); //sem o f eles são tratados como double, dá ruim
        pessoas.add(new Mulher("Beatriz", "Santos", 22, 7, 1998, "23456789012", 62.0f, 1.68f));
        pessoas.add(new Mulher("Carolina", "Oliveira", 10, 11, 2002, "34567890123", 70.0f, 1.72f));
        pessoas.add(new Mulher("Daniela", "Costa", 5, 1, 1995, "45678901234", 80.0f, 1.70f));
        pessoas.add(new Mulher("Fernanda", "Pereira", 30, 9, 2001, "56789012345", 48.0f, 1.60f));

        // 5 Homens
        pessoas.add(new Homem("João", "Souza", 12, 5, 1999, "67890123456", 75.0f, 1.80f));
        pessoas.add(new Homem("Pedro", "Lima", 8, 8, 1997, "78901234567", 90.0f, 1.85f));
        pessoas.add(new Homem("Lucas", "Rocha", 20, 2, 2003, "89012345678", 65.0f, 1.75f));
        pessoas.add(new Homem("Marcos", "Almeida", 17, 6, 1990, "90123456789", 105.0f, 1.82f));
        pessoas.add(new Homem("Gabriel", "Martins", 25, 12, 2000, "01234567890", 58.0f, 1.70f));
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