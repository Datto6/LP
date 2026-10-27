import java.util.regex.*;
import java.util.Scanner;

class Auxiliar {
    public Pattern pattern;
    public Matcher matcher;
    
    public void compilar(Scanner input) {
        System.out.print("Digite sua regex: ");
        pattern = Pattern.compile(input.nextLine());
        
        System.out.print("Digite sua string para procurar: ");
        matcher = pattern.matcher(input.nextLine());
        
    }
}

// ...


public class TesteRegex {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Auxiliar aux = new Auxiliar();
 		while (true) {
            aux.compilar(input);
            boolean found = false;
            while (aux.matcher.find()) {
                System.out.printf("Eu encontrei o texto \"%s\" começando"
                                 + " no índice %d e terminando no"
                                 + " índice %d.\n\n",aux.matcher.group(), 
                                 aux.matcher.start(), aux.matcher.end());
                found = true;
            }
            if(!found){
                System.out.println("Nenhuma correspondência.\n");
            }
         }
     }
  }


