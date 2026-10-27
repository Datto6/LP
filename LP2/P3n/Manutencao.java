import lp2g09.biblioteca.*;
public class Manutencao{
    public static void gravar(Scanner scanner,Biblioteca bib){
        // salvar com o nome especificado
        if (bib==null){
            System.out.println("Biblioteca nula, primeiro abrir um objeto biblioteca antes de salvá-la.");
        }
        System.out.print("Digitar nome do arquivo de usuários: ")
        String usuarios=scanner.nextLine();
        System.out.print("Digitar nome do arquivo de livros: ")
        String livros=scanner.nextLine();
        try{
            HashTable<String,Usuario> tabela_user=bib.getTabelaUsers();
            HashTable<Integer,Livro> tabela_livro=bib.getTabelaLivros();
            bib.salvaArquivo(tabela_user,usuarios);
            bib.salvaArquivo(tabela_livro,livros)
        }
        case (FileNotFoundException e){
            System.out.println(String.format("O arquivo %s não foi encontrado, checar diretório",e.getArq()));
            return;
        }
        case (IOException e){
            System.out.println(String.format("Erro na escrita,término de execução no arquivo %s ",e.getArq()));
            return;
        }
    }
    public static Biblioteca abrirArquivos(Scanner scanner){
        //ler o arquivo
        System.out.print("Digitar nome do arquivo de usuários: ")
        String usuarios=scanner.nextLine();
        System.out.print("Digitar nome do arquivo de livros: ")
        String livros=scanner.nextLine();
        try{
            Biblioteca bib=new Biblioteca(usuarios,livros);
        }
        case (FileNotFoundException e){
            System.out.println(String.format("O arquivo %s não foi encontrado, checar diretório",e.getArq()));
            return null;
        }
        case (IOException e){
            System.out.println(String.format("Erro na leitura,checar integridade de arquivo %s ",e.getArq()));
            return null;
        }
        return bib;
    }
}