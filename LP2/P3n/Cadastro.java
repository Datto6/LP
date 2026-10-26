package lp2g09.biblioteca;
public class Cadastro{
    //Cadastra livro ou usuario, podendo salvar ou nap
    private static  String PegarNomeArquivo(Scanner scanner){
        //Rotina de dados de entrada para nome de arquivo de saída
        String entrada=scanner.nextLine();
        while (true && !entrada.equals("")){
            if (entrada.matches("[^\\s/\\\\]{1,20}")){
                return entrada;
            }
        }
    }
    private static Usuario PegarUsuario(Scanner scanner){
        //Rotina de entrada para preencher um objeto Usuario, muito herdado da P1n
        System.out.print("Insira o nome: ");
        String nome=scanner.nextLine();
        while(!nome.equals("") && !Pessoa.isNome(nome) ){
            nome=scanner.nextLine();
        }

        System.out.print("Insira o sobrenome: ");
        String sobrenome=scanner.nextLine();
        while(!sobrenome.equals("") && !Pessoa.isSobreNome(sobrenome)){
            sobrenome=scanner.nextLine();
        }

        System.out.print("Dia de nascimento: ");
        String dia=scanner.nextLine();
        while(!dia.equals("") && !ValidaData.isDia(dia)){
            System.out.println("Dia inválido, escolher valor entre 1 e 31");
            dia=scanner.nextLine();
        }

        System.out.print("Mês de nascimento: ");
        String mes=scanner.nextLine();
        while(!mes.equals("") && !ValidaData.isMes(mes)){
            System.out.println("Mês inválido, escolher valor entre 1 e 12 ou janeiro fevereiro marco .... dezembro ");
            mes=scanner.nextLine();
        }
        System.out.print("Ano de nascimento: ");
        String ano=scanner.nextLine();
        while(!ano.equals("") && !ValidaData.isAno(ano)){
            System.out.println("Ano inválido, inserir um número de 4 dígitos entre o ano atual e 120 anos atrás");
            ano=scanner.nextLine();
        }
        System.out.print("Insira o CPF: ");
        String CPF=scanner.nextLine();
        while( !CPF.equals("") && !ValidaCPF.isCPF(CPF)){
            System.out.println("CPF inválido, digite um válido nos 3 possíveis formatos:12345678901, 123.456.789-01, 123.456.789/01 ");
            CPF=scanner.nextLine();
        }

        while(!ValidaData.isDataValida(ano,mes,dia)){ //Pegar uma data válida
            System.out.println("Data inválida, escolher mês e dias compatíveis");
    
            System.out.print("Inserir dia: ");
            dia=scanner.nextLine();

            System.out.print("Inserir mês: ");
            mes=scanner.nextLine();

            while(!dia.equals("") &&  !ValidaData.isDia(dia)){
                System.out.println("Dia inválido, inserir um dia entre 1 e 31");
                dia=scanner.nextLine();
            }
            if (dia.equals("")){ //usuário pode desistir de botar uma data valida pro dado ano
                break;
            }
            while(!mes.equals("") && !ValidaData.isMes(mes)){
                System.out.println("Mês inválido, inserir um mês entre 1 e 12 ou janeiro marco fevereiro... dezembro");
                mes=scanner.nextLine();
            }
            if (mes.equals("")){
                break;
            }
        }
        int dia_num=Integer.parseInt(dia);
        int mes_num;
        if (mes.matches("\\d{1,2}")) {
            mes_num = Integer.parseInt(mes);
            }
        else {
            Mes considerado = Mes.valueOf(mes);
            mes_num=considerado.ordinal()+1; //pego um mes dado o nome dele usando o Enum, pego a posição numérica, adiciono 1 porque começa no 0.
        } 
        int ano_num=Integer.parseInt(ano);
        System.out.print("Insira o endereço: ");
        String endereco= scanner.nextLine();
        while(!endereco.equals("") && !entrada.matches(".{1,30}")){
            endereco=scanner.nextLine();
        }
        Usuario novo=new Usuario(nome,sobrenome,dia_num,mes_num,ano_num,numCPF,endereco);
        System.out.println();
        return novo;
    }

    private static Livro PegarLivro(Scanner scanner){
        //Rotina de entrada para preencher um objeto Livro
        System.out.print("Insira o código: ");
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

        System.out.print("Insira o título: ");
        String titulo=scanner.nextLine();
        while(!titulo.equals("") && !titulo.matches(".{1,30}")){ //Qualquer coisa com até 30 caracteres
            System.out.println("Título inválido, qualquer coisa de 1 até 30 caracteres")
            System.out.print("Insira o título: "); 
            titulo=scanner.nextLine();
        }

        System.out.print("Categoria: ");
        String categoria=scanner.nextLine();
        while(!dia.equals("") && !Livro.isCategoria(categoria)){
            System.out.println("Categoria inválida, escolher número entre 0 e 5");
            System.out.println("Ou uma delas por extenso e no mesmo formato: fantasia,suspense,romance,cientifico,biografias,infantil");
            categoria=scanner.nextLine();
        }

        System.out.print("Insira o número de cópias disponíveis: ");
        String copias=scanner.nextLine();
        int copias_num;
        while (true && !copias.equals("")){
            try {
                copias_num=Integer.parseInt(codigo);
                if (copias_num>=0){
                    break;
                }
                System.out.println("Digite um número maior ou igual que 0");
            }
            case (NumberFormatException e){
                System.out.println("Digite um número maior ou igual que 0");
                System.out.print("Insira o número de cópias disponíveis: ");
                copias=scanner.nextLine();
            }
        }
    
        System.out.print("Insira o número de já emprestados: ");
        String emprestados=scanner.nextLine();
        int emprestados_num;
        while (true && !emprestados.equals("")){
            try {
                emprestados_num=Integer.parseInt(codigo);
                if (emprestados_num>=0 && emprestados <=copias_num){
                    break;
                }
                System.out.println("Digite um número maior ou igual que 0 e menor ou igual que o número de copias");
            }
            case (NumberFormatException e){
                System.out.println("Digite um número maior ou igual que 0 e menor ou igual que o número de copias");
                System.out.print("Insira o número de cópias disponíveis: ");
                emprestados=scanner.nextLine();
            }
        }
        Livro novo=new Livro(codigo_num,titulo, categoria, int copias, int emprestados);
        System.out.println();
        return novo;
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