package lp2g09.biblioteca;  import java.io.Serializable;

public class LivroDuplicadoEx extends Exception implements Serializable{
    private int cod;
    public LivroDuplicadoEx(int cod){
        this.cod=cod;
    }
}