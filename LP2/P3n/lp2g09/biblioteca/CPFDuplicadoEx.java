package lp2g09.biblioteca;  import java.io.Serializable;
public class CPFDuplicadoEx extends Exception implements Serializable{
    private String CPF;
    public CPFDuplicadoEx(String CPF){
        this.CPF=CPF;
    }
}