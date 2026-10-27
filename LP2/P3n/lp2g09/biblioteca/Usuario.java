package lp2g09.biblioteca;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
public class Usuario extends Pessoa{
    private String endereco;
    private ArrayList<Emprest> hist;
    private int emprestados=0;
    //Getters
    public String getEndereco(){
        return endereco;
    }
    public ArrayList<Emprest> getHist(){
        return hist;
    }
    public int getEmprestados(){
        return emprestados;
    }
    public String getCPF(){
        return super.get_numCPF();
    }
    //Setters(apenas os que penso que podem ser modificados)
    public void setEmprestados(int num){
        emprestados=num;
    }
    public void setEndereco(String newEndereco){
        endereco=newEndereco;
    }
    //Métodos obrigatórios
    public void addLivroHist(LocalDate locacao,int codigo){
        Emprest emprestimo=new Emprest(locacao,codigo);
        hist.add(emprestimo);
        emprestados++;
    }
    private String StringHistorico(){
        //Apenas retorna o String do historico
        String saida="";
        for (int i=0;i<hist.size();i++){
            saida+="---------------\n";
            saida+= hist.get(i).toString()+"\n";
        }
        return saida;
    }
    public String toString(){
        //Retorna as informacoes em formato de String, inclusive o histórico
        String antigo=super.toString();
        String saida=antigo+String.format("""
        Endereço: %s
        Emprestados: %d
        Histórico: %s""",endereco,emprestados,StringHistorico());
        return saida;
    }
    //Construtores
    public Usuario(String nome,String sobreNome, int dia, int mes, int ano){
        super(nome,sobreNome,dia,mes,ano);
    }
    public Usuario(String nome,String sobreNome, int dia, int mes, int ano,String numCPF, String endereco){
        super(nome,sobreNome,dia,mes,ano,numCPF);
        this.endereco=endereco;
        this.hist=new ArrayList<Emprest>();
    }
    public Usuario(String nome,String sobreNome, int dia, int mes, int ano,String numCPF, String endereco, ArrayList<Emprest> hist){
        super(nome,sobreNome,dia,mes,ano,numCPF);
        this.endereco=endereco;
        this.hist=hist;
    }
}