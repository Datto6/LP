import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Random;
public class Pessoa implements MetodosPessoa {
    private String nome,sobrenome;
    private String genero;
    private LocalDate data;
    private double peso,altura;
    private Pessoa pai, mae; //posso fazer essa abreviacao
    public static int criados=0;
    private Random rand=new Random();
    private String[] ATIVIDADES={"Comendo","Dormindo", "Jogando", "Lendo", "Estudando", "Vagabundando"};
    public String get_nome(){
        return nome; //pode retornar nulo ou mal definido se ainda nao foi inicializado
    }
    public boolean set_nome(String nome){
        //retorna  true se foi executada com sucesso, falso caso contrário
        if (nome!=null && nome.length()<=50){
            this.nome=nome;
            return true;
        }
        else if(nome==null){
            System.out.println("Erro, nome nulo vazio dado");
        }
        else{
            System.out.println("Erro, excedeu limite de caracteres");
        }
        return false;
    }

    public String get_sobrenome(){
        return sobrenome; //pode retornar nulo ou mal definido se ainda nao foi inicializado
    }
    public boolean set_sobrenome(String sobrenome){
        //retorna  true se foi executada com sucesso, falso caso contrário
        if (sobrenome!=null && sobrenome.length()<=50){
            this.sobrenome=sobrenome;
            return true;
        }
        else if{sobrenome==null}{
            System.out.println("Erro, nome nulo dado");

        }
        else{
            System.out.println("Erro, excedeu limite de caracteres");
            return false;
        }
        return false;
    }

    public String get_genero(){
        return genero; //pode retornar nulo ou mal definido se ainda nao foi inicializado
    }
    public boolean set_genero(String genero){ //Boolean da se executou com sucesso ou nao
        if (genero!=null && genero.length()<=50){
            this.genero=genero;
            return true;
        }
        else if{genero==null}{
            System.out.println("Erro, nome nulo dado.");
        }
        else{
            System.out.println("Erro, excedeu limite de caracteres");
        }
        return false;
    }

    public LocalDate get_data_nascimento(){
        return this.data;
    }
    public boolean set_data_nascimento(LocalDate data){ 
        //retorna  true se foi executada com sucesso, falso caso contrário
        LocalDate hoje=LocalDate.now();
        if (data!=null && data.getYear()>=1900 && data.isBefore(hoje.plusDays(1))){ //Depois de 1900 e no maximo hoje
            this.data=data;
            return true;
        }
        else if(data==null){
            System.out.println("Erro, valor nulo dado");
        }
        else if (data.getYear()<1900){
            System.out.println("Erro, pessoa antes de 1900.");
        }
        else if(!data.isBefore(hoje.plusDays(1))){
            System.out.println("Erro, pessoa que ainda não nasceu(data de nascimento no futuro)");
        }
        return false; //se chegou aqui, um dos 3 erros aconteceu
    }

    public double get_peso(){
        return peso;
    }
    public boolean set_peso(double peso){
        if (peso>0 && peso<=400){
            this.peso=peso;
            return true;
        }
        else if (peso<=0){
            System.out.println("Erro, peso negativo ou zero.");
            return false;
        }
        else if (peso>400){
            System.out.println("Erro, peso acima de 400 kg, tem certeza desse valor?");
            return false;
        }
    }

    public double get_altura(){
        return altura;
    }
    public boolean set_altura(double altura){
        if (altura>0 && altura<=3){
            this.altura=altura;
            return true;
        }
        else if (altura<=0){
            System.out.println("Erro, altura negativa ou zero");
            return false;
        }
        else if (altura>3){
            System.out.println("Erro, altura acima de 3 metros, tem certeza desse valor?");
            return false;
        }
    }

    public Pessoa get_pai(){
        return pai;
    };
    public boolean set_pai(Pessoa pai){
        if (pai!=null){
            this.pai=pai;
            return true;
        }
        else{
            System.out.println("Erro, valor nulo dado");
            return false;
        }
    }

    public Pessoa get_mae(){
        return mae;
    }
    public boolean get_mae(Pessoa mae){
        if (mae!=null){
            this.mae=mae;
            return true;
        }
        else{
            System.out.println("Erro, valor nulo dado");
            return false;
        }
    }
    private int idade(){
        LocalDate hoje=LocalDate.now();
        Duration tempo_vida=Duration.between(data,hoje);
        long dias=tempo_vida.toDays();
        int anos=(int) dias/365;
        return anos;
    }
    String toString(){
        String nome_usado=(get_nome()==null) ? "Vazio" : get_nome();
        String sobrenome_curr=(get_sobrenome()==null) ? "Vazio" : get_sobrenome();
        String gen_usado=(get_genero()==null) ? "Vazio" : get_genero();
        Pessoa pai_curr=get_pai()
        String nome_pai, sobrenome_pai;

        if (pai_curr!=null){
            nome_pai=pai_curr.get_nome(); //poderia fazer new String aqui, mas é seguro pois strings são imutáveis
            sobrenome_pai=pai_curr.get_sobrenome();
        }

        Pessoa mae_curr=get_mae();
        String nome_mae, sobrenome_mae;

        if(mae_curr!=null){
            String nome_mae=mae_curr.get_nome();
            String sobrenome_mae=mae_curr.get_sobrenome();
        }

        String output=String.format("""
        Nome da Pessoa: %s , Sobrenome:%s
        Genero: %s
        Idade: %d
        Peso:%.2f, Altura: %.2f
        Nome e Sobrenome do Pai: %s %s
        Nome e Sobrenome da Mãe: %s %s
        OBS: 0.0 implica valores não inicializados 
        """,
        nome_usado,sobrenome_curr,gen_usado,idade(),get_peso(),get_altura(),nome_pai,sobrenome_pai,nome_mae,sobrenome_mae)
        return output;
    }
    //Metodos de checar quantos objetos foram criados
    private void adicionar_criado(){
        Pessoa.criados++;
    }
    public static int feitos(){
        return Pessoa.criados;
    }
    public String status(){
        int indice=rand.nextInt(6); //indice aleatorio de 0 a 5
        return ATIVIDADES[indice]; //atividade aleatoria
    }
    //Construtores
    public Pessoa(){
        adicionar_criado();
    }
    public Pessoa(String nome){
        adicionar_criado();
        this.nome=nome;
    }
    public Pessoa(String nome, String sobrenome, String genero,LocalDate data,double peso, double altura, Pessoa pai, Pessoa mae){
        adicionar_criado();
        this.nome=nome;
        this.sobrenome=sobrenome;
        this.genero=genero; 
        this.data=data;  //todos esses passam por endereco, mas como sao imutaveis nao eh problema
        this.peso=peso;
        this.altura=altura;
        this.pai=pai;
        this.mae=mae;
    }

}