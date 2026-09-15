public abstract class PessoaIMC extends Pessoa{
    protected float peso,altura;
    public static boolean isPeso(float peso){
        if (peso>0 && peso<=400){
            return true;
        }
        System.out.println("Peso inválido, inserir um peso entre 0.01 e 400.00 (no formato dd.dd)kg");
        return false; 
    }
    public static boolean isPeso(String peso){
        if(!peso.matches("\\d{1,3}[.]\\d{1,2}")){
            System.out.println("Peso inválido, inserir um peso entre 0.01 e 400.00 (no formato dd.dd)kg");
            return false;
        }
        float peso_num=Float.parseFloat(peso);
        return isPeso(peso_num);
    }
    public float getPeso(){
        return peso;
    }
    public boolean setPeso(float peso){
        if (peso>0 && peso<=400){
            this.peso=peso;
            return true;
        }
        else if (peso<=0){
            System.out.println("Erro, peso negativo ou zero.");
        }
        else if (peso>400){
            System.out.println("Erro, peso acima de 400 kg, tem certeza desse valor?");
        }
        return false; 
    }
    public static boolean isAltura(float altura){
        if (altura>0 && altura<=4){
            return true;
        }
        System.out.println("Altura inválida, inserir uma altura entre 0.01 e 4.0 metros(no formato d.dd)");
        return false; 
    }    
    public static boolean isAltura(String altura){
        if(!altura.matches("\\d{1}[.]\\d{1,2}")){
            System.out.println("Altura inválida, inserir uma altura entre 0.01 e 4.0 metros(no formato d.dd)");
            return false;
        }
        float alt_num=Float.parseFloat(altura);
        return isAltura(alt_num);
    }
    public float getAltura(){
        return altura;
    }
    
    public boolean setAltura(float altura){
        if (altura>0 && altura<=3){
            this.altura=altura;
            return true;
        }
        else if (altura<=0){
            System.out.println("Erro, altura negativa ou zero");
        }
        else if (altura>3){
            System.out.println("Erro, altura acima de 3 metros, tem certeza desse valor?");
        }
        return false;
    }
    protected float calculaIMC(float altura, float peso){
        float pesoquadr=peso*peso;
        float resultado=altura/pesoquadr;
        return resultado;
    }
    abstract String resultIMC();
    public String toString(){
        String anterior=super.toString(); //pega toString de Pessoa
        String saida=anterior+String.format("""
        Peso: %.2f
        Altura: %.2f""", peso,altura);
        return saida;
    }
    public PessoaIMC(String nome,String sobreNome, int dia, int mes, int ano){
        super(nome,sobreNome,dia,mes,ano);
    }
    public PessoaIMC(String nome,String sobreNome, int dia, int mes, int ano,String numCPF,float peso, float altura){
        this.peso=peso;
        this.altura=altura;
        super(nome,sobreNome,dia,mes,ano,numCPF);
    }
}