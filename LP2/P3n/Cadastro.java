package lp2g09.biblioteca;
public class Cadastro{
    //Cadastra livro ou usuario, podendo salvar ou nap
    private static PegarNomeArquivo(Scanner scanner){
        //Rotina de dados de entrada para nome de arquivo de saída
    }
    private static Usuario PegarUsuario(Scanner scanner){
        //Rotina de entrada para preencher um objeto Usuario
    }
    private static Livro PegarLivro(Scanner scanner){
        //Rotina de entrada para preencher um objeto Livro
    }
    public static Object PegarEntrada(Scanner scanner){
        //Rotina de entrada de dados, retorna um objeto Livro ou objeto Usuario
        int tipo =tipoEntrada(scanner);
        switch (tipo){
            case 0:
                return PegarUsuario(scanner);
            case 1:
                return PegarLivro(scanner);
            default:
                break;
        }
    }
    public static void Cadastra(Biblioteca bib){
        Scanner scanner=new Scanner(System.in);
        Object entrada=PegarEntrada(scanner);
        String arquivo=PegarNomeArquivo(scanner);
        if (entrada instanceof Usuario){
            Usuario novo= (Usuario) entrada;
            bib.cadastraUsuario(novo);
        }
        if (entrada instanceof Livro){
            Livro novo =(Livro) entrada;
            bib.cadastraLivro(novo);
        }
        if (salvar){ //Fazer uma lógica real aqui para salvar
            Manutencao.gravar(entrada,entrada);
        }

    }
}