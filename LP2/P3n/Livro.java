package lp2g09.biblioteca;
import java.time.LocalDate;
public class Livro{
    private int codigo;
    private String titulo;
    private Categoria categoria;
    private int copias;
    private int emprestados;
    private ArrayList<EmprestPara> hist;
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
        hist.add(novo);
    }
    public devolucao_Real(String CPF){ 
        //Atualiza histórico e faz calculo de atraso e etc com multa e por ai vai
        LocalDate hora_devolucao=LocalDate.now();
        for(int i=0;i<hist.size();i++){
            if (hist[i].getCPF()==CPF){

            }
        }
    }
    public Livro(int codigo, String titulo, Categoria categoria, int copias, int emprestados){
        self.codigo=codigo;
        self.titulo=titulo;
        self.categoria=categoria;
        self.copias=copias;
        self.emprestados=emprestados;
    }
}