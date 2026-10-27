import lp2g09.biblioteca.*;
public class P3nX{
    public static void main(String[] args){
        Biblioteca bib;
        Scanner scanner=new Scanner(System.in);
        System.out.println(""" O que deseja fazer?
        0. Começar do 0
        1. Ler os 2 arquivos da biblioteca
        2. Salvar em um arquivo
        3. Cadastrar Livro ou Usuário
        4. Fazer um empréstimo ou devolução
        5. Fazer algum relatório
        """)
        String entrada=scanner.nextLine();
        while (true && !entrada.equals("")){
            try {
                int acao=Integer.parseInt(entrada);
                switch (acao){
                    case 0:
                        bib=new Biblioteca();
                    case 1:
                        bib= Manutencao.abrirArquivos(scanner);
                    case 2:
                        Manutencao.gravar()
                }
            }
            case (NumberFormatException e){
                System.out.println("Digitar apenas um número entre 1 e 5");
                entrada=scanner.nextLine();
            }
        }
    }
}