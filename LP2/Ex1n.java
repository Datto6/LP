import java.util.Scanner;
public class Ex1n{
    public static void main(String[] args){
        Scanner entrada=new Scanner(System.in);
        String line; 
        line = entrada.nextLine(); // Le uma linha por vez
        int location; char letter;	
        int index;
        int[] letterCount=new int[26];
        while (!line.isEmpty()){ // Enquando houver linhas a serem lidas
            for (location=0; location<line.length(); location++){ 
                letter = line.charAt(location);
                if ((letter  >= 'A' && letter <= 'Z') || (letter  >= 'a' && letter <= 'z')){ 
                // 2o truque
                    index = (int)Character.toUpperCase(letter) - (int) 'A';	
                    letterCount[index]++;
                }
            }
            line = entrada.nextLine(); // Lê a próxima linha
        }

        for (index = 0; index < letterCount.length; index++){
            System.out.println("The total number of " 
                + (char) (index + (int) 'A')
                + "'s is " 
                + letterCount[index]);
        }
    }

}

