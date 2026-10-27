import lp2g09.biblioteca.*;
public class Emprestimo{
    //Módulo de transações(emprestimo e devolução)

    public static void Operacao(Usuario user, Biblioteca bib,Scanner scanner){
        //Função geral
        int tipo=menu(bib);
        switch (tipo){
            case 0:
                Relatorio.acervoLivro(bib);
            case 1:
                DevolveLivro(user,bib,scanner);
            case 2:
                EmprestaLivro(user,bib,scanner);
            break;
        }
    }

    private static int menu(Scanner scanner){
        //Menu de entrada principal 
        System.out.print("Digite 0 para ver o acervo de livros, 1 para devolver um livro, e 2 para emprestar um");
        String tipo=scanner.nextLine();
        int saida=-1;
        while (true && !tipo.equals("")){ //Loop infinito enquanto ele não apertar enter para desistir
            try {
                saida=Integer.parseInt(tipo);
                if (saida>=0 && saida<=2){
                    return saida;
                }
            }
            except (NumberFormatException e){
                System.out.println("Entrada inválida.");
                System.out.print("Digite 0 para ver o acervo de livros, 1 para devolver um livro, e 2 para emprestar um");
            }
            String tipo=scanner.nextLine();
        }
        return saida;
    }

    private static void DevolveLivro(Usuario user, Biblioteca bib,Scanner scanner){
        //Devolve um livro de um usuário
        System.out.print("Inserir Código de livro que quer devolver: ");
        String codigo=scanner.nextLine();
        int codigo_num;
        while (true && !codigo.equals("")){
            try {
                codigo_num=Integer.parseInt(codigo);
                if (codigo_num>=1 && codigo_num<=999){
                    break;
                }
                System.out.println("Código inválido, apenas digite um número entre 1 e 999");
            }
            case (NumberFormatException e){
                System.out.println("Código inválido, apenas digite um número entre 1 e 999");
                System.out.print("Insira o código: ");
                codigo=scanner.nextLine();
            }
        }
        try {
            Livro livro=bib.getLivro(codigo_num);
        }
        case (LivroNaoCadastradoEx e){
            System.println("Livro não cadastrado, deseja tentar de novo? Digite 1 se for o caso.");
            codigo=scanner.nextLine();
            if(codigo.equals("1")){ //Porque só tem uma opção, não vou fazer OUTRO bloco try catch para pegar o parseInt ou fazer o regex de novo
                DevolveLivro(user,bib,scanner);
            }
        }
        try{
            int multa=bib.devolveLivro(user,livro);
        }
        case (NenhumaCopiaEmprestadaEx e){
            System.out.println("Nenhuma copia emprestada, devolução não feita.");
            return;
        }
        System.out.println("Recibo da devolução: ");
        System.out.println(String.format("""

        Usuário:
        %s
        Livro Devolvido:
        %s""",user.toString(),livro.toString()))
    }

    private static void EmprestaLivro(Usuario user, Biblioteca bib,Scanner scanner){
        System.out.print("Inserir Código de livro que quer emprestar: ");
        String codigo=scanner.nextLine();
        int codigo_num;
        while (true && !codigo.equals("")){
            try {
                codigo_num=Integer.parseInt(codigo);
                if (codigo_num>=1 && codigo_num<=999){
                    break;
                }
                System.out.println("Código inválido, apenas digite um número entre 1 e 999");
            }
            case (NumberFormatException e){
                System.out.println("Código inválido, apenas digite um número entre 1 e 999");
                System.out.print("Insira o código: ");
                codigo=scanner.nextLine();
            }
        }
        try {
            Livro livro=bib.getLivro(codigo_num);
        }
        case (LivroNaoCadastradoEx e){
            System.out.println("Livro não cadastrado, deseja tentar de novo? Digite 1 se for o caso.");
            codigo=scanner.nextLine();
            if(codigo.equals("1")){ //Porque só tem uma opção, não vou fazer OUTRO bloco try catch para pegar o parseInt ou fazer o regex de novo
                EmprestaLivro(user,bib,scanner);
            }
        }
        try {
            bib.emprestaLivro(user,livro);
        }
        catch (CopiaNaoDisponivelEx e){
            System.out.println("Copia não disponível, empréstimo não concluído.");
            return;
        }
        System.out.println("Recibo de empréstimo: ");
        System.out.println(String.format("""
        Usuário:
        %s
        Livro Emprestado:
        %s""",user.toString(),livro.toString()))
    }
}