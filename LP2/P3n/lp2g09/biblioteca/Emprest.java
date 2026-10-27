package lp2g09.biblioteca;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter; import java.io.Serializable;
public class Emprest implements Serializable {
    private LocalDate emprestimo;
    private LocalDate devolucao;
    private int codigo_Livro;
    //Getters
    public LocalDate getEmprestimo(){
        return emprestimo;
    }
    public int getCodigo(){
        return codigo_Livro;
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
        Código de Livro: %d
        Data de empréstimo: %s 
        Data de devolução: %s 
        """,codigo_Livro,data_emprestimo,data_devolucao);
        return saida;
    } 
    //Construtor
    public Emprest(LocalDate emprestimo, int codigo){
        this.emprestimo=emprestimo;
        this.codigo_Livro=codigo;
    }
}