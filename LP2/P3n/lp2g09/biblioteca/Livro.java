package lp2g09.biblioteca;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList; import java.io.Serializable;
public class Livro implements Serializable {
    //Campos 
    private int codigo;
    private String titulo;
    private Categoria categoria;
    private int copias;
    private int emprestados;
    private ArrayList<EmprestPara> hist;
    //Métodos getter (não vou incluir os setters porque não quero que haja acesso direto)
    public int getCodigo(){
        return codigo;
    }
    public String getTitulo(){
        return titulo;
    }
    public int getCopias(){
        return copias;
    }
    public Categoria getCategoria(){
        return categoria;
    }
    public int getEmprestados(){
        return emprestados;
    }
    public ArrayList<EmprestPara> getHist(){
        return hist;
    }
    //Métodos de classe para entrada de dados 
    public static boolean isCategoria(int categoria){
        if (categoria<=0 || categoria>6){
            return false;
        }
        return true;
    }
    public static boolean isCategoria(String categoria){
        if(categoria.matches("\\d{1,2}")){ //formato só pode ser 2 digitos
            return isCategoria(Integer.parseInt(categoria));
        }
        else if(categoria.matches("[a-z]{4,9}")){
            for (Categoria n: Categoria.values()){ //itera sobre todos os valores
                if(categoria.equals(n.name())){
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    //Métodos de comportamento
    public void empresta() throws CopiaNaoDisponivelEx{
        if (copias>emprestados){
            emprestados++;
        }
        else{
            throw new CopiaNaoDisponivelEx("Número de emprestados acima de copias disponiveis");
        }
    }

    public void devolve() throws NenhumaCopiaEmprestadaEx{
        if (emprestados>0){
            emprestados--;
        }
        else{
            throw new NenhumaCopiaEmprestadaEx("Nenhum livro para devolver");
        }
    }

    public void addUsuarioHist(LocalDate locacao,LocalDate devolucao, String CPF){
        EmprestPara novo=new EmprestPara(locacao,devolucao,CPF);
        hist.add(novo); //Equivalente a uma operação de append no ArrayList
    }
    
    public int devolucao_Real(Usuario user){ 
        //Atualiza histórico e faz calculo de atraso e etc com multa
        String CPF=user.getCPF();
        LocalDate hora_devolucao=LocalDate.now();
        long atraso=0;
        boolean achou=false;
        for(int i=0;i<hist.size();i++){
            if (hist.get(i).getCPF().equals(CPF) && hist.get(i).getDevolucao()==null){ //Primeira ocorrencia de usuario procurado que ainda nao devolveu
                hist.get(i).setDevolucao(hora_devolucao);
                atraso=Math.max(atraso,ChronoUnit.DAYS.between(hist.get(i).getEmprestimo(),hora_devolucao));
                achou=true;
                break;
            }
        }
        ArrayList<Emprest> historico_user=user.getHist();
        for(int i=0;i<historico_user.size();i++){
            if (historico_user.get(i).getCodigo()==codigo && historico_user.get(i).getDevolucao()==null){ //Se for igual ao codigo desse livro
                historico_user.get(i).setDevolucao(hora_devolucao);
                atraso=Math.max(atraso,ChronoUnit.DAYS.between(historico_user.get(i).getEmprestimo(),hora_devolucao));
                achou=true;
                break;
            }
        }
        if (atraso>90){ //Atraso maior de 90 dias acarreta 5 reais por dia de multa
            int convertido=(int) atraso;
            int diff=convertido -90;
            return diff*5;
        }
        if (achou){
            return 0;
        }
        return -1; //Retorna -1 se não achou o 
    }
    private String StringHistorico(){
        //Apenas retorna o String do Histórico
        String saida="";
        for (int i=0;i<hist.size();i++){
            saida+="---------------\n";
            saida+= hist.get(i).toString()+"\n";
        }
        return saida;
    }
    public String toString(){
        //Retorna as informacoes em formato de String, inclusive o histórico
        String saida=String.format("""
        Título: %s
        Categoria: %s
        Código: %d
        Cópias: %d 
        Emprestados: %d
        Histórico: %s""",titulo,categoria.name(),codigo,copias,emprestados,StringHistorico());
        return saida;
    }
    //Construtor
    public Livro(int codigo, String titulo, Categoria categoria, int copias, int emprestados){
        this.codigo=codigo;
        this.titulo=titulo;
        this.categoria=categoria;
        this.copias=copias;
        this.emprestados=emprestados;
        this.hist=new ArrayList<EmprestPara>();
    }
}