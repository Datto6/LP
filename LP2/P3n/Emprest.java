package lp2g09.biblioteca;

public class Emprest {
    private LocalDate emprestimo;
    private LocalDate devolucao;
    private int codigo_Livro;
    public Emprest(LocalDate emprestimo, int codigo){
        self.emprestimo=emprestimo;
        self.codigo_Livro=codigo;
    }
}