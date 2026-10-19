package lp2g09.biblioteca;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Livro{
    //Campos 
    private int codigo;
    private String titulo;
    private Categoria categoria;
    private int copias;
    private int emprestados;
    private ArrayList<EmprestPara> hist;
    //Métodos getter
    public int getCodigo(){
        return codigo;
    }
    public String getTitulo(){
        return titulo;
    }
    public int getCopias(){
        return copias;
    }
    public Categoria getCategoria(){
        return categoria;
    }
    public int getEmprestados(){
        return emprestados
    }
    public ArrayList<EmprestPara> getHist(){
        return hist;
    }
    //Métodos de comportamento
    public void empresta() throws CopiaNaoDisponivelEx{
        if (copias>emprestados){
            emprestados++;
        }
        else{
            throw CopiaNaoDisponivelEx("Número de emprestados acima de copias disponiveis");
        }
    }

    public void devolve() throws NenhumaCopiaEmprestadaEx{
        if (emprestados>0){
            emprestados--;
        }
        else{
            throw NenhumaCopiaEmprestadaEx("Nenhum livro para devolver");
        }
    }

    public addUsuarioHist(LocalDate locacao,LocalDate devolucao, String CPF){
        EmprestPara novo=new EmprestPara(locacao,devolucao,CPF);
        hist.add(novo); //Equivalente a uma operação de append no ArrayList
    }
    
    public int devolucao_Real(String CPF){ 
        //Atualiza histórico e faz calculo de atraso e etc com multa
        LocalDate hora_devolucao=LocalDate.now();
        long atraso=0;
        for(int i=0;i<hist.size();i++){
            if (hist[i].getCPF()==CPF){
                hist[i].setDevolucao(hora_devolucao);
                atraso=Math.max(atraso,ChronoUnit.DAYS.between(hist[i].getEmprestimo()));
            }
        }
        if (atraso>90){ //Atraso maior de 90 dias acarreta 5 reais por dia de multa
            int diff=atraso-90;
            return diff*5;
        }

        return 0;
    }

    //Construtor
    public Livro(int codigo, String titulo, Categoria categoria, int copias, int emprestados){
        self.codigo=codigo;
        self.titulo=titulo;
        self.categoria=categoria;
        self.copias=copias;
        self.emprestados=emprestados;
    }
}