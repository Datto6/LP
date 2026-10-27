package lp2g09.biblioteca; import java.io.Serializable;

public class LivroNaoCadastradoEx extends Exception{
    private int cod;
    public LivroNaoCadastradoEx(int cod){
        this.cod=cod;
    }
}