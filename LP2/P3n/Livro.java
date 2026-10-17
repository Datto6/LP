package lp2g09.biblioteca;
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
        EmprestPara novo=new EmprestPara()
    }
    public Livro(int codigo, String titulo, Categoria categoria, int copias, int emprestados){

    }
}