import java.util.Scanner;
public class P1nX{
    public static void pegaInput(Pessoa[] Arr, int numero,Scanner scanner){
        for (int i=0;i<numero;i++){
            System.out.print("Insira o nome:");
            String nome=scanner.nextLine();
            while(!Pessoa.isNome(nome) && !nome.equals("\n")){
                System.out.println("Nome inválido, por favor inserir apenas letras, com o máximo de 50 caracteres. Sem espaço. ");
                nome=scanner.nextLine();
            }
            if(nome.equals("\n")){
                break;
            }
            System.out.print("Insira o sobrenome:");
            String sobrenome=scanner.nextLine();
            while(!Pessoa.isSobreNome(sobrenome)){
                System.out.println("Sobrenome inválido, por favor inserir apenas letras, com o máximo de 50 caracteres. Sem espaço. ");
                sobrenome=scanner.nextLine();
            }
            if (sobrenome.equals("\n")){
                break;
            }
            System.out.print("Dia de nascimento:");
            String dia=scanner.nextLine();
            while(!ValidaData.isDia(dia) && !dia.equals("\n")){
                System.out.println("Dia inválido, escolher valor entre 1 e 31");
                dia=scanner.nextLine();
            }
            if (dia.equals("\n")){
                break;
            }
            System.out.print("Mês de nascimento:");
            String mes=scanner.nextLine();
            while(!ValidaData.isMes(mes) && !mes.equals("\n")){
                System.out.println("Mês inválido, escolher valor entre 1 e 12 ou janeiro fevereiro marco .... dezembro ");
                mes=scanner.nextLine();
            }
            if (mes.equals("\n")){
                break;
            }
            System.out.print("Ano de nascimento:");
            String ano=scanner.nextLine();
            while(!ValidaData.isAno(ano) && !ano.equals("\n")){
                System.out.println("Ano inválido, inserir um número de 4 dígitos entre o ano atual e 120 anos atrás");
                ano=scanner.nextLine();
            }
            if (ano.equals("\n")){
                break;
            }
            System.out.print("Insira o CPF:");
            String CPF=scanner.nextLine();
            while(!ValidaCPF.isCPF(CPF) && !CPF.equals("\n")){
                System.out.println("CPF inválido, digite um válido nos 3 possíveis formatos:12345678901, 123.456.789-01, 123.456.789/01 ");
                CPF=scanner.nextLine();
            }
            if (CPF.equals("\n")){
                break;
            }
            System.out.print("Insira o peso:");
            String peso=scanner.nextLine();
            while(!Pessoa.isPeso(peso) && !peso.equals("\n")){
                System.out.println("Peso inválido, inserir um peso entre 0.01 e 400 kg");
                peso=scanner.nextLine();
            }
            if (peso.equals("\n")){
                break;
            }
            System.out.print("Insira a altura:");
            String altura=scanner.nextLine();
            while(!Pessoa.isAltura(altura)){
                System.out.println("Altura inválido, inserir uma altura entre 0.01 e 4 metros");
                altura=scanner.nextLine();
            }
            if (altura.equals("\n")){
                break;
            }
            System.out.print("Essa pessoa é de gênero masculino ou feminino:");
            String genero=scanner.nextLine();
            while((!genero.equals("m") || !genero.equals("f")) && !genero.equals("\n")){
                System.out.println("Gênero inválido, por favor inserir f para feminino ou m para masculino");
                genero=scanner.nextLine();
            }
            if (genero.equals("\n")){
                break;
            }
            int dia_num=Integer.parseInt(dia);
            int mes_num=Integer.parseInt(mes);
            int ano_num=Integer.parseInt(ano);
            float peso_num=Float.parseFloat(peso);
            float altura_num=Float.parseFloat(altura); //a esse ponto, todas as entradas foram validadas, então não tem problema fazer isso
            if (genero.equals("m")){
                Arr[i]=new Homem(nome,sobrenome, dia_num, mes_num, ano_num,CPF, peso_num, altura_num);
            }
            else{
                Arr[i]=new Mulher(nome,sobrenome, dia_num, mes_num, ano_num,CPF, peso_num, altura_num);
            }
        }
    }
    public static void MostrarInput(Pessoa[] Arr){
        int num_pessoas=Pessoa.feitos();
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
        System.out.println(String.format("Foram criados: %d Homens e %d Mulheres ", homens, mulheres));
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
        while(!argumentos[0].equals("m") || !argumentos[0].equals("f")){
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
        while(!ValidaData.isMes(argumentos[8])){
            System.out.println("Altura inválido, inserir uma altura entre 0.01 e 4 metros");
            argumentos[8]=scanner.nextLine();
        }
        while(!ValidaData.isDataValida(argumentos[5],argumentos[4],argumentos[3])){ //Pegar uma data válida
            System.out.println("Data inválida, escolher mês e dias compatíveis");
            argumentos[3]=scanner.nextLine();
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
        int pessoas;
        System.out.print("Quantas pessoas a mais deseja inserir?");
        String input =scanner.nextLine();
        if(input.matches("\\d+")){
            pessoas=Integer.parseInt(input);
        }
        else{
            while(!input.matches("\\d+")){
                System.out.println("Entrada deve ser numérica apenas. Tente de novo");
                input=scanner.nextLine();
            }
            pessoas=Integer.parseInt(input);
        }
        Pessoa[] arrPrinc=new Pessoa[pessoas];
        P1nX.pegaInput(arrPrinc,pessoas,scanner);
    }
}