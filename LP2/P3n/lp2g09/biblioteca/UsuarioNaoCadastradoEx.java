package lp2g09.biblioteca;  import java.io.Serializable;

public class UsuarioNaoCadastradoEx extends Exception implements Serializable{
    private String CPF;
    public UsuarioNaoCadastradoEx(String CPF){
        this.CPF=CPF;
    }
}