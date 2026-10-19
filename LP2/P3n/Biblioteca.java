package lp2g09.biblioteca;
import java.util.HashTable;
public class Biblioteca{
    //Atributos
    private HashTable<String,Usuario> usuarios;
    private HashTable<Integer,Livro> livros;

    //Métodos
    public void cadastraUsuario(Usuario user) throws CPFDuplicadoEx{
        //Cadastrar um usuario no hashtable de livros
        String CPF=user.getCPF();
        if (usuarios.containsKey(CPF)){
            throw CPFDuplicadoEx(String.format("CPF %s já encontrado, usuário duplicado",CPF))
        }
        usuarios[user.getCPF()]=user;
    }

    public void cadastraLivro(Livro livro) throws LivroDuplicadoEx{
        //Cadastrar um livro no hashtable de livros
        Integer codigo= Integer.valueOf(Livro.getCodigo());
        if(livros.containsKey(codigo)){
            throw LivroDuplicadoEx(String.format("Código de livro %d já cadastrado, livro duplicado ",codigo))
        }
        livros[codigo]=livro;
    }

    public void salvaArquivo(HashTable tabela, String nome){
        // salvar com o nome especificado
        ObjectOutputStream saida=new ObjectOutputStream(new FileOutputStream(nome));
        saida.writeObject(tabela);
    }

    public void leArquivo(String arquivo){
        //ler o arquivo
        ObjectInputStream entrada= new ObjectInputStream(new FileInputStream(arquivo));
        Object geral=entrada.readObject();
        if (geral instanceof HashTable<String,Usuario>){ //Uso de genericos para garantir que estou mudando atributo certo
            usuarios=(HashTable<String,Usuario>) geral;
        }
        else if (geral instanceof HashTable<Integer,Livro>){
            livros=(HashTable<Integer,Livro>) geral;
        }
    }

    public void emprestaLivro(Usuario user, Livro livro){
        //Emprestar o livro pro cara
        try {
            livro.empresta();
        }
        except (CopiaNaoDisponivelEx e){
            System.out.println("Livro não disponível para ser emprestado");
            return; //termina execucao aqui
        }
        livro.addUsuarioHist(LocalDate.now(),null,user.getCPF()); //so executa isso se bloco except nao rodar
    }
    public void devolveLivro(Usuario user, Livro livro){
        //Devolve o livro que o cara tinha
        try {
            livro.devolve();
        }
        except(NenhumaCopiaEmprestadaEx e){
            System.out.println("Nenhum livro foi emprestado, nem se aplica");
            return;
        }
        devolucao_Real(user.getCPF()); //Só executa isso se bloco except nao rodar
    }
    public Comparator<Livro> livroC = new Comparator<Livro> () {
        @Override
        public int compare(Livro p1, Livro p2){
            int cod1, cod2;
            cod1 = p1.getCodigo();
            cod2 = p2.getCodigo();
            return Integer.compare(cod1,cod2) //Usa função de comparacao de inteiros
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
        ArrayList<Livros> lista_livros= new ArrayList<Livros>(livros.values());
        lista_livros.sort(livroC);
        String saida=""
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
        String saida=""
        for (int i=0;i<lista_usuarios.size();i++){
            saida+="---------------\n";
            saida+= lista_usuarios.get(i).toString()+"\n";
        }
        return saida;
    }
    public Livro getLivro(int cod) throws LivroNaoCadastradoEx{
        //Retorna livro com esse codigo, caso registrado
        Livro saida=livros.get(Integer.valueOf(cod));
        if (saida==null){
            throw LivroNaoCadastradoEx("Livro não encontrado no banco de dados");
        }
        return saida;
    }
    public Usuario getUsuario(String CPF) throws UsuarioNaoCadastradoEx{
        //retorna Usuario com esse CPF
        if (CPF==null){ //Isso quase que é um outro tipo de excecao
            throw UsuarioNaoCadastradoEx("Usuário NULL não cadastrado, nem consta.");
        }
        Usuario saida=usuarios.get(CPF);
        if (saida==null){
            throw UsuarioNaoCadastradoEx(String.format("Usuário não cadastrado, CPF: %s",CPF));
        }
        return saida;
    }
    public Biblioteca(String usuarios, String livros){
        //ler coisas dos arquivos aqui
        self.usuarios=leArquivo(usuarios);
        self.livros=leArquivo(livros);
    }
    public Biblioteca(){
        //iniciar do 0 
        usuarios=new HashTable<String,Usuario>;
        livros=new HashTable<Integer,Livro>;
    }
}