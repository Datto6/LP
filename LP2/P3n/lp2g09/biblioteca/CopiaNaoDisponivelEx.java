package lp2g09.biblioteca; 
public class CopiaNaoDisponivelEx extends Exception{
    private String msg;
    public CopiaNaoDisponivelEx(String msg){
        super();
        this.msg=msg;
    }
    public String toString(){
        return msg;
    }
}