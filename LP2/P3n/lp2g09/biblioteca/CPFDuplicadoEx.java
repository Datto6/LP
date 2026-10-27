package lp2g09.biblioteca; 
public class CPFDuplicadoEx extends Exception{
    private String CPF;
    public CPFDuplicadoEx(String CPF){
        this.CPF=CPF;
    }
}