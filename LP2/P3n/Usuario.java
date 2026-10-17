package lp2g09.biblioteca;

public class Usuario extends Pessoa{
    private String endereco;
    private ArrayList<Emprest> hist;
    private int emprestados=0;
    public addLivroHist(LocalDate locacao,int codigo){
        Emprest emprestimo=new Emprest(locacao,codigo);
        hist.add(emprestimo);
    }
}