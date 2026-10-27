import lp2g09.biblioteca.*;
import java.util.Scanner;
import java.io.IOException;
public class Relatorio{
    public static void  acervoLivro(Biblioteca bib){
        bib.imprimeLivros();
    }
    public static void cadastroUsuarios(Biblioteca bib){
        bib.imprimeUsuarios();

    }
    public static void imprimeUser(Usuario user){
        System.out.println(user.toString());
    }
    public static void imprimeLivro(Livro livro){
        System.out.println(livro.toString());
    }
}