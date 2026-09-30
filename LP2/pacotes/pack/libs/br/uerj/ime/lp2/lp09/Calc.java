package br.uerj.ime.lp2.lp09;
import com.start.excp.*;
public class Calc implements CalcIntf // implementar a interface CalcIntf
{
	public  int soma(int a,int b){
		return a+b;
	}
	public  int sub(int a,int b){
		return a-b;
	}
	public  double mult(double a,double b){
		return a*b;
	}
	public  double div(double a,double b) throws Div0ex{
		if (b==0.0){
			throw new Div0ex("Erro, divisão por 0");
		}
		return a/b;
	}

	/* testa se o número de argumentos está ok e joga a exceção confirmada NumArgsEx caso contrário */
	public void TestaArgs(String[] args) throws NumArgsEx 
	{
		if (args.length!=2){
			throw new NumArgsEx("Numero de argumentos errado, erro");
		}
	}

    /* joga testa se o número de argumentos está correto e joga NumArgsEx caso contrário, e joga NaoNumEx se algum argumento não for convertível para inteiro */ 
	public int soma (String num1, String num2) throws NaoNumEx,NumArgsEx // completar
	{
	    int valor1=0, valor2 =0;
		if (num1==null || num2==null){
			throw new NumArgsEx("Numero insuficiente de argumentos");
		}
		try{
			valor1 = Integer.parseInt(num1);
			valor2 = Integer.parseInt(num2);
		}
		catch(Exception e){
			throw new NaoNumEx("Algum dos argumentos nao foi convertivel para inteiro");
		}
	    return soma(valor1,valor2);
	}

	
	/* pode jogar NumArgsEx, NaoNumEx, Div0ex */
	public double div (String num1, String num2) throws  NumArgsEx,NaoNumEx,Div0ex {
	    double valor1=0, valor2=0,resultado=0;
	   	if (num1==null || num2==null){
			throw new NumArgsEx("Numero insuficiente de argumentos");
		}
	    try
	    {
		  valor1 = Double.parseDouble(num1);
		  valor2 = Double.parseDouble(num2);
	    }
	    catch(Exception e)
	    {
		  throw new NaoNumEx("Letra passada como argumento: Nao eh possivel converter.");
	    }
		try {
			return  div(valor1,valor2);
		}
		catch(Div0ex e){
			throw new Div0ex("Erro, divisão por zero");
		}

	}
	public Calc(){

	}
}
