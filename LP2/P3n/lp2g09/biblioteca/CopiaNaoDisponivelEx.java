package lp2g09.biblioteca; 
public class CopiaNaoDisponivelEx extends Exception{
    private String msg;
    public UsuarioNaoCadastradoEx(String msg){
        super();
        this.msg=msg;
    }
    public toString(){
        return msg;
    }
}