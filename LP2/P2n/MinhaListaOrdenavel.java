import java.util.ArrayList;
public class MinhaListaOrdenavel{
    private ArrayList lista_interna;
    public ArrayList get_lista(){
        return lista_interna;
    }
    void add(PessoaIMC p){
        lista_interna.add(p);
    }
    public PessoaIMC get(int i){
        Object objeto=Lista_interna.get(i);
        if (objeto instanceof PessoaIMC){
            return (PessoaIMC) objeto;
        }
    }
    public Comparator<PessoaIMC> nomeC = new Comparator<PessoaIMC> () {
        @Override
        public int compare(PessoaIMC p1, PessoaIMC p2){
            String nome1, nome2;
            nome1 = p1.get_nome();
            nome2 = p2.get_nome();
            return String.compare(nome1, nome2);
        }
    };

    public Comparator<PessoaIMC> pesoC = new Comparator<PessoaIMC> () {
        @Override
        public int compare(PessoaIMC p1, PessoaIMC p2){
            float peso1, peso2;
            peso1 = p1.get_peso();
            peso2 = p2.get_peso();
            return Float.compare(peso1, peso2);
        }
    };
    public Comparator<PessoaIMC> alturaC = new Comparator<PessoaIMC> () {
        @Override
        public int compare(PessoaIMC p1, PessoaIMC p2){
            float altura1, altura2;
            altura1 = p1.get_peso();
            altura2 = p2.get_peso();
            return Float.compare(altura1, altura2);
        }
    };
    public Comparator<PessoaIMC> IMCC = new Comparator<PessoaIMC> () {
        @Override
        public int compare(PessoaIMC p1, PessoaIMC p2){
            float imc1, imc2;
            imc1 = p1.calculaIMC();
            imc2 = p2.calculaIMC();
            return Float.compare(imc1, imc2);
        }
    };
    public Comparator<PessoaIMC> generoC = new Comparator<PessoaIMC> () {
        @Override
        public int compare(PessoaIMC p1, PessoaIMC p2){
            if (p1 instanceof Homem && p2 instanceof Mulher ){
                return -1; //homens primeiro default, homens<mulher
            }
            if (p1 instanceof Homem && p2 instanceof Homem){
                return 0; //igual posição
            }
            if (p1 instanceof Mulher && p2 instanceof Mulher){
                return 0; //igual posição
            }
            return 1; //ultimo caso que sobrou é p1= mulher e p2= homem, como mulher>homem, retornar 1(valor positivo)
        }
    };
    public Comparator<PessoaIMC> idadeC = new Comparator<PessoaIMC> () {
        @Override
        public int compare(PessoaIMC p1, PessoaIMC p2){
            int idade1,idade2;
            idade1 = p1.idade();
            idade2 = p2.idade();
            return Integer.compare(idade1, idade2);
        }
    };
    public Comparator<PessoaIMC> data_nascC = new Comparator<PessoaIMC> () {
        @Override
        public int compare(PessoaIMC p1, PessoaIMC p2){
            LocalDate dataNasc1,dataNasc2;
            dataNasc1 = p1.get_dataNasc();
            dataNasc2 = p2.get_dataNasc();
            return dataNasc1.compareTo(dataNasc2); //ordem cronologica
        }
    };
    public Comparator<PessoaIMC> CPFC = new Comparator<PessoaIMC> () {
        @Override
        public int compare(PessoaIMC p1, PessoaIMC p2){
            String CPF1,CPF2;
            CPF1 = p1.get_numCPF();
            CPF2 = p2.get_numCPF();
            return String.compare(CPF1,CPF2); //Usando comparador de Strings
        }
    };
    public ArrayList ordena(int criterio){
        Criterio enum_crit=Criterio.values()[criterio]
        switch (enum_crit){
            case NOME:
                return this.lista_interna.sort(nomeC);
                break;
            case NOME_REVERSE:
                return this.lista_interna.sort(nomeC.reversed());
                break;
            case PESO:
                return this.lista_interna.sort(pesoC);
                break;
            case PESO_REVERSE:
                return this.lista_interna.sort(pesoC.reversed());
                break;
            case ALTURA:
                return this.lista_interna.sort(alturaC);
                break;
            case ALTURA_REVERSE:
                return this.lista_interna.sort(alturaC.reversed());
                break;
            case IMC:
                return this.lista_interna.sort(IMCC);
                break;
            case IMC_REVERSE:
                return this.lista_interna.sort(IMCC.reversed());
                break;
            case GENERO:
                return this.lista_interna.sort(generoC);
                break;
            case GENERO_REVERSE:
                return this.lista_interna.sort(generoC.reversed())
                break;
            case IDADE:
                return this.lista_interna.sort(idadeC);
                break;
            case IDADE_REVERSE:
                return this.lista_interna.sort(idadeC.reversed());
                break;
            case DATA_NASC:
                return this.lista_interna.sort(data_nascC);
                break;
            case DATA_NASC_REVERSE:
                return this.lista_interna.sort(data_nascC.reversed());
                break;
            case CPF:
                return this.lista_interna.sort(CPFC);
                break;
            case CPF_REVERSE:
                return this.lista_interna.sort(CPFC.reversed());
                break;
        }
    }
    public MinhaListaOrdenavel(){
        this.lista_interna=new ArrayList();
    }
}