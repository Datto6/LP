package lp2g09.biblioteca;  import java.io.Serializable;
public class NenhumaCopiaEmprestadaEx extends Exception implements Serializable{
    private String msg;
    public NenhumaCopiaEmprestadaEx(String msg){
        super();
        this.msg=msg;
    }
    public String toString(){
        return msg;
    }
}