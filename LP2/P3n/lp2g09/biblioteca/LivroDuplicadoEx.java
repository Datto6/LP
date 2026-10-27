package lp2g09.biblioteca; 
public class LivroDuplicadoEx extends Exception{
    private int cod;
    public LivroDuplicadoEx(int cod){
        this.cod=cod;
    }
}