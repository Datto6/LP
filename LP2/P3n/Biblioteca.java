package lp2g09.biblioteca;

import java.util.HashTable;
public class Biblioteca{
    private HashTable usuarios;
    private HashTable livros;
    public void cadastraUsuario(Usuario user){
        usuarios[user.getCPF()]=user;
    }
    public void cadastraLivro(Livro livro){
        //Completar
    }
    public void salvaArquivo(HashTable tabela, String nome){
        // salvar com o nome especificado
    }
    public void leArquivo(String arquivo){
        //ler o arquivo
    }
    public void emprestaLivro(Usuario user, Livro livro){
        //Emprestar o livro pro cara
    }
    public void devolveLivro(Usuario user, Livro livro){
        //Devolve o livro que o cara tinha
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
    }
    public Biblioteca(){
        //iniciar do 0 
    }
}