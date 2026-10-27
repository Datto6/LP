package lp2g09.biblioteca;
public class Emprestimo{
    public static void Operacao(Usuario user, Biblioteca bib,Scanner scanner){
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
    private static void DevolveLivro(Usuario user, Biblioteca bib,Scanner scanner){
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
        bib.devolveLivro(user,livro);
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
            System.println("Livro não cadastrado, deseja tentar de novo? Digite 1 se for o caso.");
            codigo=scanner.nextLine();
            if(codigo.equals("1")){ //Porque só tem uma opção, não vou fazer OUTRO bloco try catch para pegar o parseInt ou fazer o regex de novo
                EmprestaLivro(user,bib,scanner);
            }
        }
        bib.emprestaLivro(user,livro);
    }
    private static int menu(Scanner scanner){
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
}