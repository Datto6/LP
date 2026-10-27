package lp2g09.biblioteca;  import java.io.Serializable;
public class CopiaNaoDisponivelEx extends Exception implements Serializable{
    private String msg;
    public CopiaNaoDisponivelEx(String msg){
        super();
        this.msg=msg;
    }
    public String toString(){
        return msg;
    }
}