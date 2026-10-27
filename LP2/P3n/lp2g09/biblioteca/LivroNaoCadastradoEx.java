package lp2g09.biblioteca; 
public class LivroNaoCadastradoEx extends Exception{
    private int cod;
    public LivroNaoCadastradoEx(int cod){
        this.cod=cod;
    }
}