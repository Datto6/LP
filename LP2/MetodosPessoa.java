public interface MetodosPessoa{
    public String get_nome();
    public boolean set_nome(String nome);

    public String get_sobrenome();
    public boolean set_sobrenome(String sobrenome);

    public String get_genero();
    public boolean set_genero(String genero);

    public LocalDate get_data_nascimento();
    public boolean set_data_nascimento(LocalDate data);

    public double get_peso();
    public boolean set_peso(double peso);

    public double get_altura();
    public boolean set_altura(double altura);

    public Pessoa get_pai();
    public boolean set_pai(Pessoa pai);

    public Pessoa get_mae();
    public boolean get_mae(Pessoa mae);

    private int idade();
    public void status();
    public static int feitos();
    private void aicionar_criado();
}