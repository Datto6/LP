package lp2g09.biblioteca;

import java.util.HashTable;
public class Biblioteca{
    private HashTable<String,Usuario> usuarios;
    private HashTable<Integer,Livro> livros;
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
        if (geral instanceof HashTable<String,Usuario>){
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
    }
    public String imprimeLivros(){
        //retorna String com livros cadastrados ordenados por codigo de livro
    }
    public String imprimeUsuarios(){
        //retorna string com lista de usuarios ordenados por CPF
    }
    public Livro getLivro(int cod) throws LivroNaoCadastradoEx{
        //Retorna livro com esse codigo, caso registrado
    }
    public Usuario getUsuario(String CPF) throws UsuarioNaoCadastradoEx{
        //retorna Usuario com esse CPF
    }
    public Biblioteca(String usuarios, String livros){
        //ler coisas dos arquivos aqui
        self.usuarios=leArquivo(usuarios);
        self.livros=leArquivo(livros);
    }
    public Biblioteca(){
        //iniciar do 0 
        usuarios=new HashTable<String,Usuario
    }
}