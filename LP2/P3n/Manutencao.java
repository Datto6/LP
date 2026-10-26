package lp2g09.biblioteca; 
public class Manutencao{
    public static void gravar(String arquivo, Object entrada) throws IOException{
        // salvar com o nome especificado
        ObjectOutputStream saida=new ObjectOutputStream(new FileOutputStream(arquivo));
        saida.writeObject(entrada);
    }
    public static Object abrirArquivo(String arquivo) throws IOException{
        //ler o arquivo
        ObjectInputStream entrada= new ObjectInputStream(new FileInputStream(arquivo));
        Object geral=entrada.readObject();
        return geral;
    }
}