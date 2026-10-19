package lp2g09.biblioteca; 
public class Manutencao{
    public static void gravar(String arquivo, Object entrada){
        // salvar com o nome especificado
        ObjectOutputStream saida=new ObjectOutputStream(new FileOutputStream(nome));
        saida.writeObject(tabela);
    }
    public static Object abrirArquivo(String arquivo){
        //ler o arquivo
        ObjectInputStream entrada= new ObjectInputStream(new FileInputStream(arquivo));
        Object geral=entrada.readObject();
        return geral;
    }
}