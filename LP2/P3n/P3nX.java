import lp2g09.biblioteca.*;
public class P3nX{
    private static  void imprimirEspMenu(Scanner scanner, Biblioteca bib){
        System.out.println("Digite 1 para imprimir um livro, 0 para um imprimir um usuário específico");
        String opcao=scanner.nextLine();
        if (opcao.equals("1")){
            System.out.println("Digite o código do livro desejado.");
            String codigo=scanner.nextLine();
            while (true && !codigo.equals("")){
                try {
                    int codigo_num=Integer.parseInt(codigo);
                    Livro livro=bib.getLivro(codigo_num);
                    break;
                }
                catch (NumberFormatException e){
                    System.out.println("Apenas dígitos entre 1 e 999");
                    codigo=scanner.nextLine();
                }
                catch (LivroNaoCadastradoEx e){
                    System.out.println(String.format("Livro de código %d não encontrado", codigo_num))
                }
            }
        }
        if (opcao.equals("0")){
            System.out.print("Digite CPF de usuário que quer fazer a transação:");
            String CPF= scanner.nextLine();
            try {
                Usuario user=bib.getUsuario(CPF);
                Emprestimo.Operacao(user,bib,scanner);
            }
            catch (UsuarioNaoCadastradoEx e){
                System.out.println(String.format("Usuário com CPF %s não encontrado.",CPF));
            }
        }
    }
    private static void  menuRelatorio(Scanner scanner,Biblioteca bib){
        System.out.println("""O que deseja ver?
        1. Acervo de livros 
        2. Cadastro de usuários
        3. Usuário específico
        4. Livro específico """);
        String opcao=scanner.nextLine();
        while(true && !opcao.equals("")){
            try{
                int opcao_num=Integer.parseInt(opcao);
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Digitar apenas um número entre 1 e 4");
                opcao=scanner.nextLine();
            }
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
    public static void main(String[] args){
        Biblioteca bib;
        Scanner scanner=new Scanner(System.in);
        String entrada="-1";
        int acao=-1;
        while(acao!=6 && !entrada.equals("")){
            System.out.println(""" O que deseja fazer?
            0. Começar do 0
            1. Ler os 2 arquivos da biblioteca
            2. Salvar em um arquivo
            3. Cadastrar Livro ou Usuário
            4. Fazer um empréstimo ou devolução
            5. Fazer algum relatório
            6. Sair""")
            entrada=scanner.nextLine();
            while (true && !entrada.equals("")){
                try{
                    acao=Integer.parseInt(entrada);
                    switch (acao){
                        case 0:
                            bib=new Biblioteca();
                        case 1:
                            bib=Manutencao.abrirArquivos(scanner);
                        case 2:
                            Manutencao.gravar(scanner,bib);
                        case 3:
                            Cadastro.Cadastra(scanner,bib);
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
                        case 5:
                            menuRelatorio(scanner,bib);
                    }
                    if (acao>=0 && acao<=6){
                        break;
                    }
                    System.out.println("Digitar apenas um número entre 0 e 5");
                }
                catch (NumberFormatException e){
                    System.out.println("Digitar apenas um número entre 0 e 5");
                    entrada=scanner.nextLine();
                }
            }
            
        }

    }
}