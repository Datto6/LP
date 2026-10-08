import java.util.ArrayList;
import java.util.Comparator;
import java.time.LocalDate;
public class MinhaListaOrdenavel{
    private ArrayList<PessoaIMC> lista_interna;
    public ArrayList<PessoaIMC> get_lista(){
        return lista_interna;
    }
    void add(PessoaIMC p){
        lista_interna.add(p);
    }
    public PessoaIMC get(int i){
        return lista_interna.get(i); //usamos genericos para garantir que objeto que sai será um objeto PessoaIMC
    }
    public Comparator<PessoaIMC> nomeC = new Comparator<PessoaIMC> () {
        @Override
        public int compare(PessoaIMC p1, PessoaIMC p2){
            String nome1, nome2;
            nome1 = p1.get_nome();
            nome2 = p2.get_nome();
            return p1.get_nome().compareToIgnoreCase(p2.get_nome()); //Usa função de comparação de string ignorando maiusculas
        }
    };

    public Comparator<PessoaIMC> pesoC = new Comparator<PessoaIMC> () {
        @Override
        public int compare(PessoaIMC p1, PessoaIMC p2){
            float peso1, peso2;
            peso1 = p1.getPeso();
            peso2 = p2.getPeso();
            return Float.compare(peso1, peso2);//Usa função de comparação de float
        }
    };
    public Comparator<PessoaIMC> IMCC = new Comparator<PessoaIMC> () {
        @Override
        public int compare(PessoaIMC p1, PessoaIMC p2){
            float imc1, imc2;
            imc1 = p1.calculaIMC(p1.getAltura(),p1.getPeso());
            imc2 = p2.calculaIMC(p2.getAltura(),p2.getPeso());
            return Float.compare(imc1, imc2);//Usa função de comparação de float
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
            return Integer.compare(idade1, idade2); //Usa funcao de comparacao de inteiros
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
            return CPF1.compareTo(CPF2); //Usando comparador de Strings
        }
    };
    public ArrayList<PessoaIMC> ordena(int criterio){
        Criterio enum_crit=Criterio.values()[criterio]; //acessa enum equivalente ao criterio, usando seu valor ordinal
        switch (enum_crit){
            case NOME:
                this.lista_interna.sort(nomeC);
                break;
            case NOME_REVERSE:
                this.lista_interna.sort(nomeC.reversed());
                break;
            case PESO:
                this.lista_interna.sort(pesoC);
                break;
            case PESO_REVERSE:
                this.lista_interna.sort(pesoC.reversed());
                break;
            case IMC:
                this.lista_interna.sort(IMCC);
                break;
            case IMC_REVERSE:
                this.lista_interna.sort(IMCC.reversed());
                break;
            case GENERO:
                this.lista_interna.sort(generoC);
                break;
            case GENERO_REVERSE:
                this.lista_interna.sort(generoC.reversed());
                break;
            case IDADE:
                this.lista_interna.sort(idadeC);
                break;
            case IDADE_REVERSE:
                this.lista_interna.sort(idadeC.reversed());
                break;
            case DATA_NASC:
                this.lista_interna.sort(data_nascC);
                break;
            case DATA_NASC_REVERSE:
                this.lista_interna.sort(data_nascC.reversed());
                break;
            case CPF:
                this.lista_interna.sort(CPFC);
                break;
            case CPF_REVERSE:
                this.lista_interna.sort(CPFC.reversed());
                break;
        }
        return this.lista_interna; //retorna lista agora ordenada
    }
    public MinhaListaOrdenavel(){
        this.lista_interna=new ArrayList<PessoaIMC>();
    }
}