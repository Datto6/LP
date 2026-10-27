package lp2g09.biblioteca; 
public class UsuarioNaoCadastradoEx extends Exception{
    private String CPF;
    public UsuarioNaoCadastradoEx(String CPF){
        this.CPF=CPF;
    }
}