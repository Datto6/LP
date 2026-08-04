import java.time;
interface MetodosPessoa{
    public String get_nome();
    public void set_nome(String nome);

    public String get_sobrenome();
    public void set_sobrenome(String sobrenome);

    public String get_genero();
    public void set_genero(String genero);

    public LocalDate get_data_nascimento();
    public void set_data_nascimento(LocalDate data);

    public double get_peso();
    public void set_peso(double peso);

    public double get_altura();
    public void set_altura(double altura);

    public Pessoa get_pai();
    public void set_pai(Pessoa pai);

    public Pessoa get_mae();
    public void get_mae(Pessoa mae);

    private int idade();
}

public class Pessoa implements MetodosPessoa {
    private String nome;
    private String sobrenome;
    private String genero;
    private LocalDate data-nascimento;
    private double peso;
    private double altura;
    private Pessoa pai;
    private Pessoa mae;
    public String get_nome();
}