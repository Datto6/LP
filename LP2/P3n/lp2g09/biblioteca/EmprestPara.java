package lp2g09.biblioteca;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter; import java.io.Serializable;
public class EmprestPara implements Serializable {
    //Indica qual usuario pegou o livro x emprestado
    private LocalDate emprestimo;
    private LocalDate devolucao;
    private String CPF;
    //Getters
    public String getCPF(){
        return CPF;
    }
    public LocalDate getEmprestimo(){
        return emprestimo;
    }
    public LocalDate getDevolucao(){
        return devolucao;
    }
    //Setters
    public void setDevolucao(LocalDate devolucao){
        this.devolucao=devolucao;
    }
    public String toString(){
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data_emprestimo=emprestimo.format(formato);
        String data_devolucao="Pendente";
        if (devolucao!=null){
            data_devolucao=devolucao.format(formato);
        }
        String saida=String.format("""
        CPF do Usuário: %s
        Data de empréstimo: %s 
        Data de devolução: %s 
        """,CPF,data_emprestimo,data_devolucao);
        return saida;
    }
    public EmprestPara(LocalDate emprestimo, LocalDate devolucao, String CPF){
        //Construtor que preenche atributos
        this.emprestimo=emprestimo;
        this.devolucao=devolucao;
        this.CPF=CPF;
    }
}