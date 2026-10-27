import lp2g09.biblioteca.*;
import java.util.Scanner;
import java.io.IOException;
public class P3nX{
    private static  void imprimirEspMenu(Scanner scanner, Biblioteca bib){
        System.out.println("Digite 1 para imprimir um livro, 0 para um imprimir um usuário específico");
        String opcao=scanner.nextLine();
        if (opcao.equals("1")){
            System.out.println("Digite o código do livro desejado.");
            String codigo=scanner.nextLine();
            int codigo_num=-1;
            while (true && !codigo.equals("")){
                try {
                    codigo_num=Integer.parseInt(codigo);
                    Livro livro=bib.getLivro(codigo_num);
                    Relatorio.imprimeLivro(livro);
                    break;
                }
                catch (NumberFormatException e){
                    System.out.println("Apenas dígitos entre 1 e 999");
                }
                catch (LivroNaoCadastradoEx e){
                    System.out.println(String.format("Livro de código %d não encontrado", codigo_num));
                }
                System.out.println("Digite outro código ou Enter para sair.");
                codigo = scanner.nextLine();
            }
        }
        if (opcao.equals("0")){
            System.out.print("Digite CPF de usuário que quer imprimir:");
            String CPF= scanner.nextLine();
            try {
                Usuario user=bib.getUsuario(CPF);
                Relatorio.imprimeUser(user);
            }
            catch (UsuarioNaoCadastradoEx e){
                System.out.println(String.format("Usuário com CPF %s não encontrado.",CPF));
            }
        }
    }
    private static void  menuRelatorio(Scanner scanner,Biblioteca bib){
        System.out.println("""
        O que deseja ver?
        1. Acervo de livros 
        2. Cadastro de usuários
        3. Usuário/Livro específico""");
        String opcao=scanner.nextLine();
        int opcao_num=-1;
        while(true && !opcao.equals("")){
            try{
                opcao_num=Integer.parseInt(opcao);
                if(opcao_num>=1 && opcao_num<=3){
                    break;
                }
            }
            catch (NumberFormatException e){
                System.out.println("Digitar apenas números.");
            }
            System.out.println("Digitar um número entre 1 e 3");
            opcao=scanner.nextLine();
        }
        switch (opcao_num){
            case 1: 
                Relatorio.acervoLivro(bib);
                break;
            case 2:
                Relatorio.cadastroUsuarios(bib);
                break;
            case 3:
                imprimirEspMenu(scanner,bib);
                break;
        }
    }
    public static void main(String[] args) {
        Biblioteca bib = null;
        Scanner scanner = new Scanner(System.in);
        String entrada;
        int acao = -1;

        // Menu inicial: escolher como iniciar a biblioteca
        System.out.println("""
            Como deseja iniciar a biblioteca?
            0. Começar do zero
            1. Ler os 2 arquivos da biblioteca
            """);

        while (true) {
            entrada = scanner.nextLine();

            try {
                acao = Integer.parseInt(entrada);

                if (acao == 0) {
                    bib = new Biblioteca();
                    break;
                } else if (acao == 1) {
                    bib = Manutencao.abrirArquivos(scanner);

                    if (bib != null) {
                        break;
                    }

                    System.out.println("""
                        Não foi possível abrir a biblioteca.
                        0. Começar do zero
                        1. Tentar ler os 2 arquivos novamente
                        """);
                } else {
                    System.out.println("Digite 0 ou 1.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite 0 ou 1.");
            }
        }

        // Menu principal
        entrada = "-1";

        while(acao!=6 && !entrada.equals("")){
            System.out.println("""
            O que deseja fazer?
            2. Salvar em um arquivo
            3. Cadastrar Livro ou Usuário
            4. Fazer um empréstimo ou devolução
            5. Fazer algum relatório
            6. Sair""");
            entrada=scanner.nextLine();
            while (true && !entrada.equals("")){
                try{
                    acao=Integer.parseInt(entrada);
                    switch (acao){
                        case 2:
                            Manutencao.gravar(scanner,bib);
                            break;
                        case 3:
                            Cadastro.Cadastra(scanner,bib);
                            break;
                        case 4:
                            System.out.print("Digite CPF de usuário que quer fazer a transação:");
                            String CPF= scanner.nextLine();
                            try {
                                Usuario user=bib.getUsuario(CPF);
                                Emprestimo.Operacao(user,bib,scanner);
                            }
                            catch (UsuarioNaoCadastradoEx e){
                                System.out.println(String.format("Usuário com CPF %s não encontrado.",CPF));
                            }
                            break;
                        case 5:
                            menuRelatorio(scanner,bib);
                            break;
                        case 6:
                            System.out.println("Encerrando o programa.");
                            break;
                    }
                    if (acao>=2 && acao<=6){
                        break;
                    }
                    System.out.println("Digitar apenas um número entre 0 e 5");
                    entrada=scanner.nextLine();
                }
                catch (NumberFormatException e){
                    System.out.println("Digitar apenas um número entre 0 e 5");
                    entrada=scanner.nextLine();
                }
            }
            
        }

    }
}