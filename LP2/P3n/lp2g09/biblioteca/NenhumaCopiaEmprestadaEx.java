package lp2g09.biblioteca; 
public class NenhumaCopiaEmprestadaEx extends Exception{
    private String msg;
    public NenhumaCopiaEmprestadaEx(String msg){
        super();
        this.msg=msg;
    }
    public String toString(){
        return msg;
    }
}