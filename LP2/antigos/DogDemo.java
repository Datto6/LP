public class DogDemo{
        public static void main(String[] args) {

        // Create two different 
        // Bicycle objects
        Dog dog1 = new Dog();
        Malinois dog2 = new Malinois();

        // Invoke methods on 
        // those objects
        dog1.changePaws();
        // dog1.bark();
        dog1.giveTreat(7);
        dog1.Hit();
        dog1.name="Coisito";
        dog1.printStates();

        dog2.changePaws();
        dog2.bark();
        dog2.giveTreat(7);
        dog2.Hit();
        dog2.name="Malinonho";
        dog2.printStates();
    }
}