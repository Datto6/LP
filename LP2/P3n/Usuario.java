package lp2g09.biblioteca;

public class Usuario extends Pessoa{
    private String endereco;
    private ArrayList<Emprest> hist;
    private int emprestados=0;
    public addLivroHist(LocalDate locacao,int codigo){
        Emprest emprestimo=new Emprest(locacao,codigo);
        hist.add(emprestimo);
        emprestados++;
    }
    private String StringHistorico(){
        //Apenas retorna o String do historico
        String saida=""
        for (int i=0;i<hist.size();i++){
            saida+="---------------\n";
            saida+= hist.get(i).toString()+"\n";
        }
        return saida;
    }
    public String toString(){
        //Retorna as informacoes em formato de String, inclusive o histórico
        String antigo=super.toString();
        String saida=antigo+String.format("""
        Endereço: %s
        Emprestados: %d
        Histórico: %s""",titulo,categoria.getName(),codigo,copias,emprestados,StringHistorico());
        return saida;
    }
}