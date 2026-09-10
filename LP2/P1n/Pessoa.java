import java.time.LocalDate;
import java.time.Month;
import java.util.Random;
import java.time.Period;
public class Pessoa{
    private String nome,sobreNome,numCPF;
    private LocalDate dataNasc;
    private float peso,altura;
    private static int criados=0;
    private static int preenchidos=0;
    public static boolean isNome(String nome){
        boolean retorno=nome.matches("(?i)\\p{L}{1,50}"); //quaisquer letras, maiuscula ou minuscula
        if(!retorno){
            System.out.println("Nome inválido, por favor inserir apenas letras, com o máximo de 50 caracteres. Sem espaço. ");
        }
        return retorno; //deve ser entre 1 e 50 letras, apenas
    }
    public String get_nome(){
        return nome; //pode retornar nulo ou mal definido se ainda nao foi inicializado
    }
    public boolean set_nome(String nome){
        //retorna  true se foi executada com sucesso, falso caso contrário
        if (nome!=null && isNome(nome)){
            this.nome=nome;
            return true;
        }
        return false;
    }
    public static boolean isSobreNome(String sobreNome){
        boolean retorno=sobreNome.matches("(?i)\\p{L}{1,50}");
        if(!retorno){// se for falso, entra nesse if
            System.out.println("Parâmetro sobrenome inválido, por favor inserir apenas letras, com o máximo de 50 caracteres. Sem espaço. ");
        }
        return retorno; //deve ser entre 1 e 50 letras, apenas
    }
    public String get_sobreNome(){
        return sobreNome; //pode retornar nulo ou mal definido se ainda nao foi inicializado
    }
    public boolean set_sobreNome(String sobreNome){
        //retorna  true se foi executada com sucesso, falso caso contrário
        if (sobreNome!=null && isSobreNome(sobreNome)){
            this.sobreNome=sobreNome;
            return true;
        }
        return false;
    }

    public String get_numCPF(){
        return numCPF; //pode retornar nulo ou mal definido se ainda nao foi inicializado
    }

    public boolean set_numCPF(String numCPF){
        //retorna  true se foi executada com sucesso, falso caso contrário
        boolean valido=ValidaCPF.isCPF(numCPF);
        if (valido){
            this.numCPF=numCPF;
            return valido;
        }
        return valido;
    }

    public LocalDate get_dataNasc(){
        return this.dataNasc;
    }
    public boolean set_dataNasc(int ano, int mes, int dia){ 
        //retorna  true se foi executada com sucesso, falso caso contrário
        this.dataNasc=LocalDate.of(ano,mes,dia);
        return ValidaData.isDataValida(ano,mes,dia); //se chegou aqui, um dos 3 erros aconteceu
    }
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
    public float get_peso(){
        return peso;
    }
    public boolean set_peso(float peso){
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
    public float get_altura(){
        return altura;
    }
    
    public boolean set_altura(float altura){
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
    protected int idade(){
        LocalDate hoje=LocalDate.now();
        if (dataNasc==null){
            return -1;
        }
        Period tempo_vida = Period.between(dataNasc, hoje);
        int anos = tempo_vida.getYears();
        return anos;
    }
    public String toString(){
        String output=String.format("""
        Nome da Pessoa: %s
        Sobrenome:%s
        CPF: %s
        Peso:%.2f kg
        Altura: %.2f m
        """, //o resto dos atributos do toString estão no toString de Homem e Mulher
        //Só fiz isso para botar o "genero" no meio do toString, como está explicitado nas saídas válidas
        nome,sobreNome,numCPF,peso,altura);
        return output;
    }

    //Metodos de checar quantos objetos foram criados
    private void adicionar_criado(){
        Pessoa.criados++;
    }
    public static int feitos(){
        return Pessoa.criados;
    }
    private void adicionar_preenchido(){
        Pessoa.preenchidos++;
    }
    public static int preenchidos(){
        return Pessoa.preenchidos;
    }
    //Construtores
    public Pessoa(){
        //quando faço array= new Pessoa(), ele chama esse construtor, então tenho que diferenciar a contagem de objetos vazios com a de preenchidos
        adicionar_criado(); 
    }
    public Pessoa(String nome,String sobreNome, int dia, int mes, int ano){
        adicionar_criado(); //como o programa não aceita objetos com dados faltantes, tenho que adicionar contador de objetos
        this.nome=nome;
        this.sobreNome=sobreNome;
        this.dataNasc=LocalDate.of(ano,mes,dia);
    }
    public Pessoa(String nome,String sobreNome, int dia, int mes, int ano,String numCPF,float peso, float altura){
        adicionar_criado();
        adicionar_preenchido(); //contador de quantos objetos vou iterar no array de mostrar input
        this.nome=nome;
        this.sobreNome=sobreNome;
        this.dataNasc=LocalDate.of(ano,mes,dia); //tem que validar entrada antes de passar pra cá pra evitar exception
        this.numCPF=numCPF;
        this.peso=peso;
        this.altura=altura;
    }
}