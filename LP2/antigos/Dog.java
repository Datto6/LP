import java.util.Scanner;
public class Dog {
    protected int paws = 0;
    protected String name;
    public String color;
    private int treats=0;
    
    protected void changePaws() {
        System.out.println("How many paws do you want this dog to have? He currently has " +paws+ " paws");
        Scanner scanner = new Scanner(System.in); 
        int myInt = scanner.nextInt();
        paws=myInt;
    }

    protected void bark() {
        System.out.println("WOOF");
    }

    public void giveTreat(int increment) {
        treats+=increment;  
    }

    public void Hit() {
        System.out.println("You just got bitten");
    }

    protected void printStates() {
         System.out.println("paws:" +
             paws + " name:" + 
             name + " color:" + color+ " treats:" + treats );
    }
    public Dog(String name,String color){
        name=name;
        color=color;
        paws=4;
    }
    public Dog(){}
}