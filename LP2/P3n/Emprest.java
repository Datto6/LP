package lp2g09.biblioteca;
import java.time.LocalDate;
public class Emprest {
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
    } 
    //Construtor
    public Emprest(LocalDate emprestimo, int codigo){
        self.emprestimo=emprestimo;
        self.codigo_Livro=codigo;
    }
}