package lp2g09.biblioteca;
public class Relatorio{
    public static acervoLivro(Biblioteca bib){
        bib.imprimeLivros();
    }
    public static cadastroUsuarios(Biblioteca bib){
        bib.imprimeUsuarios();

    }
    public static imprimeUser(Usuario user){
        System.out.println(user.toString());
    }
    public static imprimeLivro(Livro livro){
        System.out.println(livro.toString());
    }
}