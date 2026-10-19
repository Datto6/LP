package lp2g09.biblioteca;
import java.time.LocalDate;
public class EmprestPara{
    //Indica qual usuario pegou o livro x emprestado
    private LocalDate emprestimo;
    private LocalDate devolucao;
    private String CPF;
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
    }
    public EmprestPara(LocalDate emprestimo, LocalDate devolucao, String CPF){
        //Construtor que preenche atributos
        self.emprestimo=emprestimo;
        self.devolucao=devolucao;
        self.CPF=CPF;
    }
}