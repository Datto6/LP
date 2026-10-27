import lp2g09.biblioteca.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.Hashtable;
import java.io.FileNotFoundException;
public class Manutencao{
    public static void gravar(Scanner scanner,Biblioteca bib){
        // salvar com o nome especificado
        if (bib==null){
            System.out.println("Biblioteca nula, primeiro abrir um objeto biblioteca antes de salvá-la.");
        }
        System.out.print("Digitar nome do arquivo de usuários: ");
        String usuarios=scanner.nextLine();
        System.out.print("Digitar nome do arquivo de livros: ");
        String livros=scanner.nextLine();
        try{
            Hashtable<String,Usuario> tabela_user=bib.getTabelaUsers();
            Hashtable<Integer,Livro> tabela_livro=bib.getTabelaLivros();
            bib.salvaArquivo(tabela_user,usuarios);
            bib.salvaArquivo(tabela_livro,livros);
        }
        catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado: " + e.getMessage());
            return;
        }
        catch (IOException e){
            System.out.println("Erro na escrita,término de execução no arquivo"+ e.getMessage());
            return;
        }
    }
    public static Biblioteca abrirArquivos(Scanner scanner){
        //ler o arquivo
        System.out.print("Digitar nome do arquivo de usuários: ");
        String usuarios=scanner.nextLine();
        System.out.print("Digitar nome do arquivo de livros: ");
        String livros=scanner.nextLine();
        Biblioteca bib=null;
        try{
            bib=new Biblioteca(usuarios,livros);
        }
        catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado: " + e.getMessage());
            bib=null;
        }
        catch  (IOException e){
            System.out.println("Erro na leitura,término de execução no arquivo"+ e.getMessage());
            bib=null;
        }
        catch (Exception e){
            System.out.println("Erro desconhecido(provavelmente tipagem errada)" +e.getMessage());
        }
        return bib;
    }
}