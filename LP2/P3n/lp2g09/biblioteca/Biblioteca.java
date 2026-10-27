package lp2g09.biblioteca;
import java.util.Hashtable; import java.io.IOException;
import java.util.Comparator;import java.util.ArrayList;
import java.time.LocalDate; import java.io.ObjectOutputStream;
import java.io.FileOutputStream; import java.io.FileInputStream;
import java.io.ObjectInputStream; import java.io.Serializable;
public class Biblioteca implements Serializable{
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
        //Cadastrar um usuario no Hashtable de usuarios
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
    public void salvaUsuarios(String nome) throws IOException {
        //Esse try já fecha a stream do arquivo no final do bloco
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nome))) {
            out.writeObject(usuarios);
        }
    }
    public void salvaLivros(String nome) throws IOException {
        //Esse try já fecha a stream do arquivo no final do bloco
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nome))) {
            out.writeObject(livros);
        }
    }

    @SuppressWarnings("unchecked")
    public void leUsuarios(String nome) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nome))) {
            Object obj=in.readObject();
            if (!(obj instanceof Hashtable)) throw new IOException("Arquivo inválido.");
            Hashtable<?,?> t = (Hashtable<?,?>) obj;
            for (java.util.Map.Entry<?,?> e : t.entrySet()) {
                if (!(e.getKey() instanceof String) || !(e.getValue() instanceof Usuario)) //Checar tipagem
                    throw new IOException("Este arquivo não contém usuários.");
            }
            usuarios = (Hashtable<String,Usuario>) t;
        }
    }
    @SuppressWarnings("unchecked")
    public void leLivros(String nome) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nome))) {
            Object obj=in.readObject();
            if (!(obj instanceof Hashtable)) throw new IOException("Arquivo inválido.");
            Hashtable<?,?> t = (Hashtable<?,?>) obj;
            for (java.util.Map.Entry<?,?> e : t.entrySet()) {
                if (!(e.getKey() instanceof Integer) || !(e.getValue() instanceof Livro)) //Checar tipagem
                    throw new IOException("Este arquivo não contém usuários.");
            }
            livros = (Hashtable<String,Usuario>) t;
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
        LocalDate hoje=LocalDate.now();
        livro.addUsuarioHist(hoje,null,user.getCPF()); //so executa isso se bloco except nao rodar
        user.addLivroHist(hoje,livro.getCodigo());
    }
    public int devolveLivro(Usuario user, Livro livro) throws NenhumaCopiaEmprestadaEx{
        livro.devolve();                      // Não preciso de try catch, já botei no throws 
        int multa = livro.devolucao_Real(user);
        if (multa == -1) {
            try {
                livro.empresta();             // Desfazer a devolução 
            } catch (CopiaNaoDisponivelEx e) {
                throw new IllegalStateException("Falha ao desfazer devolução", e); // Impossível 
            }
            throw new NenhumaCopiaEmprestadaEx("Este usuário não tem este livro emprestado");
        }
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
            CPF1 = p1.getCPF();
            CPF2 = p2.getCPF();
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

    public Biblioteca(String arqUsuarios, String arqLivros) throws IOException, ClassNotFoundException {
        leUsuarios(arqUsuarios);
        leLivros(arqLivros);
    }
    public Biblioteca(){
        //iniciar do 0 
        usuarios=new Hashtable<String,Usuario>();
        livros=new Hashtable<Integer,Livro>();
    }
}