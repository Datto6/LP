import java.util.Scanner;
public class P1nX{
    public static void pegaInput(Pessoa[] Arr, int numero,Scanner scanner){
        for (int i=0;i<numero;i++){
            System.out.print("Insira o nome: ");
            String nome=scanner.nextLine();
            while(!nome.equals("") && !Pessoa.isNome(nome) ){
                nome=scanner.nextLine();
            }
            if(nome.equals("")){
                break;
            }
            System.out.print("Insira o sobrenome: ");
            String sobrenome=scanner.nextLine();
            while(!sobrenome.equals("") && !Pessoa.isSobreNome(sobrenome)){
                sobrenome=scanner.nextLine();
            }
            if (sobrenome.equals("")){
                break;
            }
            System.out.print("Dia de nascimento: ");
            String dia=scanner.nextLine();
            while(!dia.equals("") && !ValidaData.isDia(dia)){
                System.out.println("Dia inválido, escolher valor entre 1 e 31");
                dia=scanner.nextLine();
            }
            if (dia.equals("")){
                break;
            }
            System.out.print("Mês de nascimento: ");
            String mes=scanner.nextLine();
            while(!mes.equals("") && !ValidaData.isMes(mes)){
                System.out.println("Mês inválido, escolher valor entre 1 e 12 ou janeiro fevereiro marco .... dezembro ");
                mes=scanner.nextLine();
            }
            if (mes.equals("")){
                break;
            }
            System.out.print("Ano de nascimento: ");
            String ano=scanner.nextLine();
            while(!ano.equals("") && !ValidaData.isAno(ano)){
                System.out.println("Ano inválido, inserir um número de 4 dígitos entre o ano atual e 120 anos atrás");
                ano=scanner.nextLine();
            }
            if (ano.equals("")){
                break;
            }
            System.out.print("Insira o CPF: ");
            String CPF=scanner.nextLine();
            while( !CPF.equals("") && !ValidaCPF.isCPF(CPF)){
                System.out.println("CPF inválido, digite um válido nos 3 possíveis formatos:12345678901, 123.456.789-01, 123.456.789/01 ");
                CPF=scanner.nextLine();
            }
            if (CPF.equals("")){
                break;
            }
            System.out.print("Insira o peso: ");
            String peso=scanner.nextLine();
            while(!peso.equals("") && !Pessoa.isPeso(peso)){
                peso=scanner.nextLine();
            }
            if (peso.equals("")){
                break;
            }
            System.out.print("Insira a altura: ");
            String altura=scanner.nextLine();
            while(!altura.equals("") && !Pessoa.isAltura(altura)){
                altura=scanner.nextLine();
            }
            if (altura.equals("")){
                break;
            }
            System.out.print("Essa pessoa é de gênero masculino ou feminino: ");
            String genero=scanner.nextLine();
            while((!genero.equals("") && !genero.equals("m") && !genero.equals("f"))){
                System.out.println("Gênero inválido, por favor inserir f para feminino ou m para masculino");
                genero=scanner.nextLine();
            }
            if (genero.equals("")){
                break;
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
            if (dia.equals("") || mes.equals("")){
                break;
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
            float peso_num=Float.parseFloat(peso);
            float altura_num=Float.parseFloat(altura); //a esse ponto, todas as entradas foram validadas, então não tem problema fazer isso
            if (genero.equals("m")){
                Arr[i]=new Homem(nome,sobrenome, dia_num, mes_num, ano_num,CPF, peso_num, altura_num);
            }
            else{
                Arr[i]=new Mulher(nome,sobrenome, dia_num, mes_num, ano_num,CPF, peso_num, altura_num);
            }
            System.out.println();
        }
    }
    public static void MostrarInput(Pessoa[] Arr, Pessoa inicial){
        int num_pessoas=Pessoa.preenchidos()-1; // Ja vou ter criado um default por input inicial
        int mulheres=0;
        int homens=0;
        for(int i=0;i<num_pessoas;i++){
            System.out.println(Arr[i].toString());
            if(Arr[i] instanceof Homem){
                homens++;
            }
            else if (Arr[i] instanceof Mulher) {
                mulheres++;
            }
        }
        if (inicial instanceof Homem){
            homens++;
        }
        else{
            mulheres++;
        }
        System.out.println(String.format("Foram criados: %d Homens e %d Mulheres ", homens, mulheres));
        System.out.println("Programa encerrado.");
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String[] argumentos;
        if (args.length<9 || args.length>9){
            System.out.println("Número invalido de argumentos, por favor entrar argumentos usando o template abaixo");
            System.out.println("<genero> <nome> <sobrenome> <dia> <mes> <ano> <CPF> <peso> <altura>");
            System.out.println("Inputtar argumentos:");
            String linha=scanner.nextLine();
            argumentos=linha.split(" ");
            while(argumentos.length!=9){
                System.out.println("Número invalido de argumentos, por favor entrar argumentos usando o template abaixo");
                System.out.println("<genero> <nome> <sobre> <dia> <mes> ano> <CPF> <peso> <altura>");
                System.out.println("Inputtar argumentos:");
                linha=scanner.nextLine();
                argumentos=linha.split(" "); //muda referencia de argumentos, cada linha.split(" ") gera um novo array de strings separados pelo " "
            }
        }
        else{
            argumentos=args;
        }
        //argumentos agora é um array de strings com os argumentos do inicio 
        while(!argumentos[0].equals("m") && !argumentos[0].equals("f")){
            System.out.println("Gênero inválido, por favor inserir f para feminino ou m para masculino");
            argumentos[0]=scanner.nextLine();
        }
        while(!Pessoa.isNome(argumentos[1])){
            argumentos[1]=scanner.nextLine();
        }
        while(!Pessoa.isSobreNome(argumentos[2])){
            argumentos[2]=scanner.nextLine();
        }
        while(!ValidaData.isDia(argumentos[3])){
            System.out.println("Dia inválido, inserir um dia entre 1 e 31");
            argumentos[3]=scanner.nextLine();
        }
        while(!ValidaData.isMes(argumentos[4])){
            System.out.println("Mês inválido, inserir um mês entre 1 e 12");
            argumentos[4]=scanner.nextLine();
        }
        while(!ValidaData.isAno(argumentos[5])){
            System.out.println("Ano inválido, inserir um número de 4 dígitos entre o ano atual e 120 anos atrás");
            argumentos[5]=scanner.nextLine();
        }
        while(!ValidaCPF.isCPF(argumentos[6])){
            System.out.println("CPF inválido, digite um válido nos 3 possíveis formatos:12345678901, 123.456.789-01, 123.456.789/01 ");
            argumentos[6]=scanner.nextLine();
        }
        while(!Pessoa.isPeso(argumentos[7])){
            System.out.println("Peso inválido, inserir um peso entre 0.01 e 400 kg");
            argumentos[7]=scanner.nextLine();
        }
        while(!Pessoa.isAltura(argumentos[8])){
            System.out.println("Altura inválida, inserir uma altura entre 0.01 e 4 metros");
            argumentos[8]=scanner.nextLine();
        }
        while(!ValidaData.isDataValida(argumentos[5],argumentos[4],argumentos[3])){ //Pegar uma data válida
            System.out.println("Data inválida, escolher mês e dias compatíveis");
            System.out.print("Inserir dia");
            argumentos[3]=scanner.nextLine();

            System.out.print("Inserir mês");
            argumentos[4]=scanner.nextLine();
            while(!ValidaData.isDia(argumentos[3])){
                System.out.println("Dia inválido, inserir um dia entre 1 e 31");
                argumentos[3]=scanner.nextLine();
            }
            while(!ValidaData.isMes(argumentos[4])){
                System.out.println("Mês inválido, inserir um mês entre 1 e 12 ou janeiro marco fevereiro... dezembro");
                argumentos[4]=scanner.nextLine();
            }
        }
        Pessoa generico_input;
        int mes_num;

        if (argumentos[4].matches("\\d{1,2}")) {
            mes_num = Integer.parseInt(argumentos[4]);
        } else {
            Mes considerado = Mes.valueOf(argumentos[4]);
            mes_num = considerado.ordinal() + 1;
        }
        int dia_num=Integer.parseInt(argumentos[3]);
        int ano_num=Integer.parseInt(argumentos[5]);
        float peso_num=Float.parseFloat(argumentos[7]);
        float altura_num=Float.parseFloat(argumentos[8]); //a esse ponto, todas as entradas foram validadas, então não tem problema fazer isso
        if(argumentos[0].equals("m")){
            generico_input=new Homem(argumentos[1],argumentos[2], dia_num, mes_num, ano_num, argumentos[6], peso_num, altura_num);
        }
        else{
            generico_input=new Mulher(argumentos[1],argumentos[2], dia_num, mes_num, ano_num, argumentos[6], peso_num, altura_num);
        }
        int pessoas;
        System.out.print("Quantas pessoas a mais deseja inserir?");
        String input =scanner.nextLine();
        if(input.matches("\\d{1,5}")){
            pessoas=Integer.parseInt(input);
        }
        else{
            while(!input.matches("\\d{1,5}")){
                System.out.println("Entrada deve ser numérica apenas. Tente de novo");
                input=scanner.nextLine();
            }
            pessoas=Integer.parseInt(input);
        }
        Pessoa[] arrPrinc=new Pessoa[pessoas];
        P1nX.pegaInput(arrPrinc,pessoas,scanner);
        System.out.println("--------------"); //uma linha de espaçamento
        System.out.println(generico_input);
        P1nX.MostrarInput(arrPrinc,generico_input);
    }
}