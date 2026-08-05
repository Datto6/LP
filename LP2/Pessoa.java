import java.time;

public class Pessoa implements MetodosPessoa {
    private String nome,sobrenome;
    private String genero;
    private LocalDate data;
    private double peso,altura;
    private Pessoa pai, mae; //posso fazer essa abreviacao
    public static int criados;
    public String get_nome(){
        return nome; //pode retornar nulo ou mal definido se ainda nao foi inicializado
    }
    public boolean set_nome(String nome){
        if (nome!=null && nome.length()<=50){
            this.nome=nome;
            return true;
        }
        else if{nome==null}{
            System.out.println("Erro, nome nulo vazio dado");
            return false;
        }
        else if(nome.length()>50){
            System.out.println("Erro, excedeu limite de caracteres");
            return false;
        }
    }

    public String get_sobrenome(){
        return sobrenome; //pode retornar nulo ou mal definido se ainda nao foi inicializado
    }
    public boolean set_sobrenome(String sobrenome){
        if (sobrenome!=null && sobrenome.length()<=50){
            this.sobrenome=sobrenome;
            return true;
        }
        else if{sobrenome==null}{
            System.out.println("Erro, nome nulo dado");
            return false;
        }
        else if(sobrenome.length()>50){
            System.out.println("Erro, excedeu limite de caracteres");
            return false;
        }
    }

    public String get_genero(){
        return genero; //pode retornar nulo ou mal definido se ainda nao foi inicializado
    }
    public boolean set_genero(String genero){ //Boolean da se executou com sucesso ou nao
        if (genero!=null && genero.length()<=50){
            this.genero=genero;
        }
        else if{genero==null}{
            System.out.println("Erro, nome nulo dado.");
            return false;
        }
        else if(genero.length()>50){
            System.out.println("Erro, excedeu limite de caracteres");
            return false;
        }
    }

    public LocalDate get_data_nascimento(){

    }
    public boolean set_data_nascimento(LocalDate data){
        if (data!=null && data.){
            this.data=data;
            return true;
        }
        else{
            System.out.println("Erro, valor nulo dado");
            return false;
        }
    }

    public double get_peso();
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

    public double get_altura();
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

    public Pessoa get_pai();
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

    public Pessoa get_mae();
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

    }
    public Pessoa(){
        Pessoa.criados++;
    }
    public Pessoa(String nome){
        this.nome=nome;
        Pessoa.criados++;
    }
    public Pessoa(String nome, String sobrenome, String genero,LocalDate data,double peso, double altura, Pessoa pai, Pessoa mae){
        this.nome=nome;
        this.sobrenome=sobrenome;
        this.genero=genero; 
        this.data=data;  //todos esses passam por endereco, mas como sao imutaveis nao eh problema
        this.peso=peso;
        this.altura=altura;
        this.pai=pai;
        this.mae=mae;
        Pessoa.criados++;
    }

}