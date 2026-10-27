import lp2g09.biblioteca.*;
import java.util.Scanner;
import java.io.IOException;
public class Relatorio{
    public static void  acervoLivro(Biblioteca bib){
        String s = bib.imprimeLivros();
        System.out.println(s.isEmpty() ? "Nenhum livro cadastrado." : s);
    }
    public static void cadastroUsuarios(Biblioteca bib){
        String s = bib.imprimeUsuarios();
        System.out.println(s.isEmpty() ? "Nenhum usuário cadastrado." : s);
    }
    public static void imprimeUser(Usuario user){
        System.out.println(user.toString());
    }
    public static void imprimeLivro(Livro livro){
        System.out.println(livro.toString());
    }
}