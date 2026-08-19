import java.time.LocalDate;
import java.time.Month;
import java.util.Random;
import java.time.Period;
public class Pessoa implements MetodosPessoa {
    private String nome,sobreNome;
    private LocalDate dataNasc;
    private float peso,altura;
    private Pessoa pai, mae; //posso fazer essa abreviacao
    private static int criados=0;
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
        else if(sobrenome==null){
            System.out.println("Erro, nome nulo dado");

        }
        else{
            System.out.println("Erro, excedeu limite de caracteres");
            return false;
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
        }
        else if (peso>400){
            System.out.println("Erro, peso acima de 400 kg, tem certeza desse valor?");
        }
        return false; 
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
        }
        else if (altura>3){
            System.out.println("Erro, altura acima de 3 metros, tem certeza desse valor?");
        }
        return false;
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
    public boolean set_mae(Pessoa mae){
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
        if (data==null){
            return -1;
        }
        Period tempo_vida = Period.between(data, hoje);
        int anos = tempo_vida.getYears();
        return anos;
    }
    public String toString(){
        String nome_str=(get_nome()==null) ? "Vazio" : get_nome();
        String sobrenome_str=(get_sobrenome()==null) ? "Vazio" : get_sobrenome();
        String gen_str=(get_genero()==null) ? "Vazio" : get_genero();

        Pessoa pai_curr=get_pai();
        String nome_pai=null; //inicializar vazio
        String sobrenome_pai=null;

        if (pai_curr!=null){
            nome_pai=pai_curr.get_nome(); //poderia fazer new String aqui, mas é seguro pois strings são imutáveis
            sobrenome_pai=pai_curr.get_sobrenome();
        }
        nome_pai=(nome_pai==null) ? "Vazio" : nome_pai;
        sobrenome_pai=(sobrenome_pai==null) ? "Vazio" : sobrenome_pai;

        Pessoa mae_curr=get_mae();
        String nome_mae=null; //inicializar vazio
        String sobrenome_mae=null;

        if(mae_curr!=null){
            nome_mae=mae_curr.get_nome();
            sobrenome_mae=mae_curr.get_sobrenome();
        }
        nome_mae=(nome_mae==null) ? "Vazio" : nome_mae;
        sobrenome_mae=(sobrenome_mae==null) ? "Vazio" : sobrenome_mae; //caso algum for nulo, substituir por "vazio"

        String peso_str=(peso==0.0) ? "Vazio/Inválido" : String.format("%.2f",peso); //convertendo em string
        String altura_str=(altura==0.0) ? "Vazio/Inválido" :  String.format("%.2f",altura);
        int idade=idade();
        String idade_str=(idade==-1) ? "Sem data de nascimento registrada" : Integer.toString(idade);
        String output=String.format("""
        Nome da Pessoa: %s, Sobrenome:%s
        Genero: %s
        Idade: %s
        Peso:%s kg, Altura: %s m
        Nome e Sobrenome do Pai: %s, %s
        Nome e Sobrenome da Mãe: %s, %s
        Status: %s
        """,
        nome_str,sobrenome_str,gen_str,idade_str,peso_str,altura_str,nome_pai,sobrenome_pai,nome_mae,sobrenome_mae,status());
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
        set_nome(nome);
        set_sobrenome(sobrenome);
        set_genero(genero);
        set_data_nascimento(data);
        set_peso(peso);
        set_altura(altura);
        set_pai(pai);
        set_mae(mae); 
    }

}