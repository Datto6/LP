package lp2g09.biblioteca;
import java.util.Hashtable; import java.io.IOException;
import java.util.Comparator;import java.util.ArrayList;
import java.time.LocalDate; import java.io.ObjectOutputStream;
import java.io.FileOutputStream; import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class Biblioteca{
    //Atributos
    private Hashtable<String,Usuario> usuarios;
    private Hashtable<Integer,Livro> livros;
    //Métodos

    //Getters
    public Livro getLivro(int cod) throws LivroNaoCadastradoEx{
        //Retorna livro com esse codigo, caso registrado
        Livro saida=livros.get(Integer.valueOf(cod));
        if (saida==null){
            throw new LivroNaoCadastradoEx(cod);
        }
        return saida;
    }
    public Usuario getUsuario(String CPF) throws UsuarioNaoCadastradoEx{
        //retorna Usuario com esse CPF
        if (CPF==null){ //Isso quase que é um outro tipo de excecao
            throw new UsuarioNaoCadastradoEx(null);
        }
        Usuario saida=usuarios.get(CPF);
        if (saida==null){
            throw new UsuarioNaoCadastradoEx(CPF);
        }
        return saida;
    }
    public Hashtable<String,Usuario> getTabelaUsers(){
        return usuarios;
    }
    public Hashtable <Integer,Livro> getTabelaLivros(){
        return livros;
    }
    //Métodos para cadastrar objetos
    public void cadastraUsuario(Usuario user) throws CPFDuplicadoEx{
        //Cadastrar um usuario no Hashtable de livros
        String CPF=user.getCPF();
        if (usuarios.containsKey(CPF)){
            throw new CPFDuplicadoEx(CPF);
        }
        usuarios.put(user.getCPF(),user);
    }

    public void cadastraLivro(Livro livro) throws LivroDuplicadoEx{
        //Cadastrar um livro no Hashtable de livros
        Integer codigo= Integer.valueOf(livro.getCodigo());
        if(livros.containsKey(codigo)){
            throw new LivroDuplicadoEx(codigo);
        }
        livros.put(codigo,livro);
    }
    //Métodos que mexem com arquivos
    public void salvaArquivo(Hashtable<?,?> tabela, String nome) throws IOException{ //Uso de genéricos para não repetir o mesmo método pros dois Hashtables
        // salvar com o nome especificado
        ObjectOutputStream saida=new ObjectOutputStream(new FileOutputStream(nome));
        saida.writeObject(tabela);
    }

    public void leArquivo(String arquivo) throws IOException, ClassNotFoundException{
        //ler o arquivo
        ObjectInputStream entrada= new ObjectInputStream(new FileInputStream(arquivo));
        Object geral=entrada.readObject();

        if (!(geral instanceof Hashtable<?, ?>)) {
            throw new IOException("O objeto não é uma Hashtable.");
        }
        Hashtable tabela= (Hashtable) geral;
        if (tabela.isEmpty()) {
            throw new IOException("Não é possível identificar uma tabela vazia.");
        }
        Object chave = tabela.keys().nextElement();
        Object valor = tabela.get(chave);

        if (chave instanceof String && valor instanceof Usuario) {
            usuarios = (Hashtable<String, Usuario>) tabela;
        } else if (chave instanceof Integer && valor instanceof Livro) {
            livros = (Hashtable<Integer, Livro>) tabela;
        } else {
            throw new IOException("Tipo de tabela desconhecido.");
        }

    }

    public void emprestaLivro(Usuario user, Livro livro) throws CopiaNaoDisponivelEx{
        //Emprestar o livro pro cara
        try {
            livro.empresta();
        }
        catch (CopiaNaoDisponivelEx e){
            throw e; // Lanço de novo porque quero pegar isso no módulo Emprestimo
        }
        livro.addUsuarioHist(LocalDate.now(),null,user.getCPF()); //so executa isso se bloco except nao rodar
    }
    public int devolveLivro(Usuario user, Livro livro) throws NenhumaCopiaEmprestadaEx{
        //Devolve o livro que o cara tinha
        try {
            livro.devolve();
        }
        catch (NenhumaCopiaEmprestadaEx e){
            throw e; // Lanço de novo porque quero pegar isso no módulo Emprestimo
        }
        int multa=livro.devolucao_Real(user); //Só executa isso se bloco except nao rodar
        return multa;
    }
    public Comparator<Livro> livroC = new Comparator<Livro> () {
        @Override
        public int compare(Livro p1, Livro p2){
            int cod1, cod2;
            cod1 = p1.getCodigo();
            cod2 = p2.getCodigo();
            return Integer.compare(cod1,cod2); //Usa função de comparacao de inteiros
        }
    };
    public Comparator<Usuario> CPFC = new Comparator<Usuario> () {
        @Override
        public int compare(Usuario p1, Usuario p2){
            String CPF1,CPF2;
            CPF1 = p1.get_numCPF();
            CPF2 = p2.get_numCPF();
            return CPF1.compareTo(CPF2); //Usando comparador de Strings
        }
    };
    public String imprimeLivros(){
        //retorna String com livros cadastrados ordenados por codigo de livro
        ArrayList<Livro> lista_livros= new ArrayList<Livro>(livros.values());
        lista_livros.sort(livroC);
        String saida="";
        for (int i=0;i<lista_livros.size();i++){
            saida+="---------------\n";
            saida+= lista_livros.get(i).toString()+"\n";
        }
        return saida;
    }
    public String imprimeUsuarios(){
        //retorna string com lista de usuarios ordenados por CPF
        ArrayList<Usuario> lista_usuarios=new ArrayList<Usuario>(usuarios.values());
        lista_usuarios.sort(CPFC);
        String saida="";
        for (int i=0;i<lista_usuarios.size();i++){
            saida+="---------------\n";
            saida+= lista_usuarios.get(i).toString()+"\n";
        }
        return saida;
    }

    public Biblioteca(String usuarios, String livros) throws IOException,ClassNotFoundException{
        //ler coisas dos arquivos aqui
        leArquivo(usuarios);
        leArquivo(livros);
    }
    public Biblioteca(){
        //iniciar do 0 
        usuarios=new Hashtable<String,Usuario>();
        livros=new Hashtable<Integer,Livro>();
    }
}